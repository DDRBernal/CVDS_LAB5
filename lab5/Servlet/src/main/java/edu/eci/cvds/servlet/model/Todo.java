/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.servlet.model;

public class Todo {
    private String userId,id,title,completed;
    
    public String getUserId(){
        return userId;             
    }
    public String getId(){
        return id;             
    }
    public String getTitle(){
        return title;             
    }
    public String getCompleted(){
        return completed;             
    }
    
    public void setUserId(String userId){
        this.userId = userId ;             
    }
    public void setId(String id){
        this.id = id ;             
    }
    public void setTitle(String title){
        this.title = title ;             
    }
    public void setCompleted(String completed){
        this.completed = completed ;             
    }
}
