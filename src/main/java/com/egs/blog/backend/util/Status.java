/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egs.blog.backend.util;

/**
 *
 * @author eduardm
 */
public enum Status {
    DRAFT(0),PUBLISHED(1),DISABLED(2);
    
    private int status;
    
    Status(int s)
    {
        this.status = s;
    }
    
    public int getStatus()
    {
        return this.status;
    }
}
