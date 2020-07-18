package com.example.getmehiredsocial.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="FileStorages")
public class FileStorage {
    private String key;
    private String bucket;
    private String status;
    private int downloaded;
    private int viewed;
}
