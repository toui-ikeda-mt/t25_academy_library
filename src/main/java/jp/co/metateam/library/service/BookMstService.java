package jp.co.metateam.library.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import io.micrometer.common.util.StringUtils;
import jp.co.metateam.library.model.Account;
import jp.co.metateam.library.model.AccountDto;
import jp.co.metateam.library.model.BookMst;
import jp.co.metateam.library.model.BookMstDto;
import jp.co.metateam.library.repository.BookMstRepository;

@Service
public class BookMstService {

    private final BookMstRepository bookMstRepository;

    @Autowired
    public BookMstService(BookMstRepository bookMstRepository) {
        this.bookMstRepository = bookMstRepository;
    }

    // 在庫がある書籍一覧を取得
    public List<BookMst> findAvailableWithStockCount() {
        return this.bookMstRepository.findLimitedBook();
    }

    // ISBNで1冊の書籍を取得（見つからなければnull）
    public BookMst selectByIsbn(String isbn) {
        return this.bookMstRepository.findByIsbn(isbn).orElse(null);
    }

    
    // DTOを受け取って保存
    @Transactional
    public void save(BookMstDto bookMstDto) {
        BookMst book = new BookMst();
        book.setTitle(bookMstDto.getTitle());
        book.setIsbn(bookMstDto.getIsbn());

        this.bookMstRepository.save(book);
    }
}
