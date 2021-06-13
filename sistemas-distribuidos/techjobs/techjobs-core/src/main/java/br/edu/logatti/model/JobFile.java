package br.edu.logatti.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

@Getter
@ToString
@EqualsAndHashCode
public class JobFile implements Serializable {
    private static final long serialVersionUID = 6604465265016149853L;
    private final UUID id;
    private final String fileName;
    private final byte[] fileContent;

    public JobFile(final MultipartFile file) throws IOException {
        if ("xlsx".equals(fileExtension(file))) {
            final var csvFile = convertXlsToCsv(file);
            this.fileContent = csvFile.readAllBytes();
        } else {
            this.fileContent = file.getInputStream().readAllBytes();
        }
        this.id = UUID.randomUUID();
        this.fileName = file.getOriginalFilename();
    }

    public static String fileExtension(final MultipartFile file) {
        final String originalFilename = file.getOriginalFilename();
        assert originalFilename != null;
        final String[] fileNameSplit = originalFilename.split("\\.");
        return fileNameSplit[fileNameSplit.length - 1];
    }

    private InputStream convertXlsToCsv(final MultipartFile file) throws IOException {
        final var inputStream = file.getInputStream();
        try (var wb = WorkbookFactory.create(inputStream)) {
            return csvConverter(wb.getSheetAt(0));
        }
    }

    private InputStream csvConverter(Sheet sheet) {
        Row row;
        var str = new StringBuilder();
        for (var i = 0; i < sheet.getLastRowNum() + 1; i++) {
            row = sheet.getRow(i);
            var rowString = new StringBuilder();
            for (var j = 0; j < 3; j++) {
                if (row.getCell(j) == null) {
                    rowString.append(" ").append(";");
                } else {
                    rowString.append(row.getCell(j)).append(";");
                }
            }
            str.append(rowString.substring(0, rowString.length() - 1)).append("\n");
        }
        return new ByteArrayInputStream(str.toString().getBytes(StandardCharsets.UTF_8));
    }
}
