/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.servlet.model;

public class Todo {
    private String userId,id,title,completed;
    
	
	//set
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
	//get
    public String getUserId(){
        return this.userId;             
    }
    public String getId(){
        return this.id;             
    }
    public String getTitle(){
        return this.title;             
    }
    public String getCompleted(){
        return this.completed;             
    }
    
    
}
