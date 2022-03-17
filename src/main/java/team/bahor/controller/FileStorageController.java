package team.bahor.controller;


import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import team.bahor.dto.file.FileStorageCreateDto;
import team.bahor.services.FileStorageService;

import java.nio.file.Path;
import java.util.stream.Stream;

@RestController
@RequestMapping(value = "/file/")
public class FileStorageController extends AbstractController<FileStorageService> {

    public FileStorageController(FileStorageService service) {
        super(service);
    }

    @PostMapping(value = "upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public void store(@RequestBody FileStorageCreateDto dto) {

        String path = service.upload(dto);

        System.out.print(path);
    }

    @GetMapping(value = "load/{filename:.+}")
    public ResponseEntity<Path> getFile(@PathVariable String filename) {
        Path path = service.load(filename);
        return ResponseEntity.ok(path);
    }

    @GetMapping(value = "loadAsResource/{filename:.+}")
    public ResponseEntity<Resource> getFileAsResource(@PathVariable String filename) {
        Resource file = service.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @GetMapping(value = "loadAll")
    public ResponseEntity<Stream<Path>> getAllFile() {
        return ResponseEntity.ok(service.loadAll());
    }

    @GetMapping(value = "loadAllAsResource")
    public ResponseEntity<Stream<Resource>> getAllFileAsResource() {
        return ResponseEntity.ok(service.loadAllAsResource());
    }

    @DeleteMapping(value = "deleteAll")
    public void deleteAll() {
        service.deleteAll();
    }

}
