package jp.co.metateam.library.model;

import java.security.Timestamp;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 * 書籍マスタDTO
 */
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Getter
@Setter
public class BookMstDto {

    private Long id;

    @NotBlank(message = "ISBNは必須です")
    @Pattern(regexp = "\\d{13}", message = "ISBNは13桁の半角数字で入力してください")
    private String isbn;

    @NotBlank(message = "書籍名は必須です")
    @Size(max = 256, message = "書籍名は256文字以内で入力してください")
    private String title;

    private Timestamp deletedAt;

    private BookMst bookMst;
}
