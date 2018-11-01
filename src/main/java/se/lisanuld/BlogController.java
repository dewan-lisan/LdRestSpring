package se.lisanuld;

import com.lisanuldewan.Blog;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class BlogController {
    /*@RequestMapping("/")
    public String index(){
        return "Congratulations from BlogController.java";
    }
    */

    //BlogMOckedData is a singleton instance
    BlogMockedData blogMockedData = BlogMockedData.getInstance();

    @GetMapping("/blog")
    public List<Blog> index(){
        return blogMockedData.fetchBlogs();
    }

    @GetMapping("/blog/{id}")
    public Blog show(@PathVariable String id){
        int blogId = Integer.parseInt(id);
        return blogMockedData.getBlogById(blogId);
    }

    @PostMapping("/blog/search")
    public List<Blog> search(@RequestBody Map<String, String> body){
        String searchTxt = body.get("text");
        //System.out.println(searchTxt);
        return blogMockedData.searchBlogs(searchTxt);
    }

    @PostMapping("/blog")
    public Blog create(@RequestBody Map<String, String> body){
        int id = Integer.parseInt(body.get("id"));
        String title = body.get("title");
        String content = body.get("content");
        String publishDt = body.get("publishDt");
        return blogMockedData.createBlog(id, title, content, publishDt);
    }

}
