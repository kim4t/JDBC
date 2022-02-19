package com.app.console;

import com.app.entity.Post;
import com.app.service.PostService;

import java.sql.SQLException;
import java.util.Scanner;

public class PostConsole {
    PostService postService;

    public PostConsole() {
        this.postService = new PostService();
    }

    public void printDashBoard() throws SQLException {
        int count = postService.getCount();
        System.out.println("------------------------------------");
        System.out.printf("<Dash Board> Total # post: %d\n",count);
        System.out.println("------------------------------------");
        System.out.printf("Id\tDateTime\t\t\tName\tMessage\n");
        postService.getList().stream().forEach(d->{
            System.out.printf("%d\t%s\t%s\t%s\n",d.getId(),d.getDateTime(),d.getName(),d.getMessage());
        });
        System.out.println("------------------------------------");
    }

    public void insert(Post post) throws SQLException {
        if(postService.insert(post)==1);
            System.out.println("Insert completed.");
    }

    public void update(Post post) throws SQLException{
        if(postService.update(post) == 1)
            System.out.println("Update completed.");
    }

    public void delete(int id) throws SQLException {
        if(postService.delete(id) == 1)
            System.out.println("Delete completed.");
    }

    public int inputMenu() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}
