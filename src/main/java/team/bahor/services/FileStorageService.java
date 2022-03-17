package team.bahor.services;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import team.bahor.dto.file.FileStorageCreateDto;
import team.bahor.entity.lesson.Lesson;
import team.bahor.exeptions.fileStore.FileStorageException;
import team.bahor.exeptions.fileStore.StorageFileNotFoundException;
import team.bahor.property.FileStorageProperties;
import team.bahor.repositories.LessonRepository;
import team.bahor.services.base.BaseGenericService;
import team.bahor.validators.LessonValidator;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;


@Service
public class FileStorageService implements BaseGenericService {

    private final Path rootLocation;

    public FileStorageService(FileStorageProperties properties) {
        this.rootLocation = Paths.get(properties.getLocation());
    }

    public String upload(MultipartFile file) {
        String format = StringUtils.getFilenameExtension(file.getOriginalFilename());
        String filePath = rootLocation.toString() + "/" + UUID.randomUUID().toString().replace("-", "") + "." + format;
        Path path = Paths.get(filePath);
        try {
            Files.copy(file.getInputStream(), path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filePath;
    }

    public Stream<Path>loadAll() {
        try {
            return Files.walk(this.rootLocation)
                    .filter(path -> !path.equals(this.rootLocation))
                    .map(path -> this.rootLocation.relativize(path));
        } catch (IOException e) {
            throw new FileStorageException("Failed to read stored files", e);
        }
    }

    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }

    public Stream<Resource> loadAllAsResource() {
        List<Resource> resources = new ArrayList<>();
        Stream<Path> pathStream = loadAll();
        pathStream.forEach(path -> {
            try {
                Resource resource = new UrlResource(path.toUri());
                resources.add(resource);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        });

        return resources.stream();

    }

    public Resource loadAsResource(String filename) {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new StorageFileNotFoundException("Could not read file: " + filename);

            }
        } catch (MalformedURLException e) {
            throw new StorageFileNotFoundException("Could not read file: " + filename, e);
        }
    }

    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
        init();
    }

    public void init() {
        try {
            Files.createDirectory(rootLocation);
        } catch (IOException e) {
            throw new FileStorageException("Could not initialize storage", e);
        }
    }
}
