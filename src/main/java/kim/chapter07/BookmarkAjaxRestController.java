package kim.controller.Ch07;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookmarkAjaxRestController {
    private List<BookMark> bookmarks = new ArrayList<>();


    @RequestMapping(method = RequestMethod.POST, path = "/bookmark")
    public String registerBookmark(@RequestBody BookMark bookmark) {
        bookmarks.add(bookmark);
        return "registerBookmark";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/bookmarks")
    public List<BookMark> getBookmarks() {
return bookmarks;
    }
}


