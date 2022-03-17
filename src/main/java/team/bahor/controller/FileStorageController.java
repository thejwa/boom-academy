package team.bahor.controller;


import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
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
    public void store(@RequestParam(name = "file") MultipartFile multipartFile) {

        String path = service.upload(multipartFile);

        System.out.print(path);
    }

    @GetMapping(value = "load/{filename:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = service.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @GetMapping(value = "loadAll")
    public ResponseEntity<Stream<Path>> getAllFile() {
        return ResponseEntity.ok(service.loadAll());
    }

    @DeleteMapping(value = "deleteAll")
    public void deleteAll() {
        service.deleteAll();
    }

}
