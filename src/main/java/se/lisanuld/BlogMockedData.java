package se.lisanuld;

import com.lisanuldewan.Blog;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class BlogMockedData {
    //list of blog post, of type Blog!!! Defined in Blog class in Blog.java
    private List<Blog> blogs;

    //creating a Singelton class, i.e. you can only have one instance of
    // that class throughout the application lifecycle
    private static BlogMockedData instance = null;
    public static BlogMockedData getInstance(){
        if(instance == null){
            instance = new BlogMockedData();
        }
        return instance;
    }

    public BlogMockedData(){
        blogs = new ArrayList<Blog>();

        //Date dt = new Date();
        //String publishdate = new SimpleDateFormat("yyyy-mm-dd").format(dt);

        blogs.add(new Blog(101, "Go up, up and away with your Google Assistant",
                "With holiday travel coming up, and 2018 just around the corner, " +
                        "you may be already thinking about getaways for next year. Consider " +
                        "the Google Assistant your new travel buddy, ready at the drop of a hat—or a passport",
                new SimpleDateFormat("yyyy-mm-dd").format(new Date()))); //using this one liner instead of 2 lines as commented above

        blogs.add(new Blog(102, "Get local help with your Google Assistant",
                "2nd blog. With holiday travel coming up, and 2018 just around the corner, " +
                        "you may be already thinking about getaways for next year. Consider " +
                        "the Google Assistant your new travel buddy, ready at the drop of a hat—or a passport",
                new SimpleDateFormat("yyyy-mm-dd").format(new Date()))); //using this one liner instead of 2 lines as commented above

        blogs.add(new Blog(103, "The new maker toolkit: IoT, AI and Google Cloud Platform",
                "3rd blog. With holiday travel coming up, and 2018 just around the corner, " +
                        "you may be already thinking about getaways for next year. Consider " +
                        "the Google Assistant your new travel buddy, ready at the drop of a hat—or a passport",
                new SimpleDateFormat("yyyy-mm-dd").format(new Date()))); //using this one liner instead of 2 lines as commented above


    }

    //return all blogs
    //Request type = GET; Endpoint = <url>/blog
    public List<Blog> fetchBlogs(){
        return blogs;
    }

    //returns blog by id
    //request type = GET; Endpoint = <url>/{id}
    public Blog getBlogById(int id){
        for(Blog b: blogs){
            if (id == b.getId()){
                return b;
            }
        }
        return null;
    }

    /*
    * Let's assume array is defined to be an array of String
    * for (int i=0; i < array.length; i++) {
        System.out.println("Element: " + array[i]);
      }
      is same to the newer form
      for (String element : array) {
        System.out.println("Element: " + element);
      }
    *
    * */
    //search blog by text
    //request type = POST; Endpoint = <url>/blog/searchtext
    public List<Blog> searchBlogs(String searchText){
        List<Blog> searchResultBlogs = new ArrayList<Blog>();
        for(Blog b: blogs){
            if(b.getTitle().toLowerCase().contains(searchText.toLowerCase()) ||
               b.getContent().toLowerCase().contains(searchText.toLowerCase())){
                searchResultBlogs.add(b);
            }
        }
        return searchResultBlogs;
    }

    //create blog
    public Blog createBlog(int id, String title, String content, String publishdt){
        Blog newBlog = new Blog(id, title, content, publishdt);
        blogs.add(newBlog);
        return newBlog;
    }

    //update blog
    public Blog updateBlog(int id, String title, String content, String publishdt){
        //Blog updtBlog = new Blog(id, title, content, publishdt);
        //updtBlog.setId();
        for(Blog b: blogs){ //the enhanced for loop loops through the list of blogs and updates the blog which matching id!!
            if(b.getId() == id){
                int blogIndex = blogs.indexOf(b);
                b.setTitle(title);
                b.setContent(content);
                b.setPublishdate(publishdt);
                return b;
            }
            System.out.println("the id not found ==============");
        }
        return null;
    }

    //delete blog by id
    public boolean delete(int id){
        int blogIndex = -1;
        for(Blog b: blogs){
            if(b.getId() == id){
                blogIndex = blogs.indexOf(b);
                System.out.println("blogIndex = " + blogIndex);
                continue;
            }
            System.out.println("blog id doesnt exists!");
        }
        if(blogIndex > -1){
            blogs.remove(blogIndex);
        }
        return true;
    }

}
