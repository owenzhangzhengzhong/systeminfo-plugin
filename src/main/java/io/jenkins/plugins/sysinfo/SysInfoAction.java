/*
 * The MIT License
 *
 * Copyright 2022 ozhang.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package io.jenkins.plugins.sysinfo;

import hudson.model.Computer;
import hudson.model.Action;

/**
 *
 * @author ozhang
 */
public class SysInfoAction implements Action {
    public Computer computerObj;
    public String[] descriptionArray;
    
    public SysInfoAction(Computer comp) {
        this.computerObj = comp;
    }

    public String getName() {
        return this.computerObj.getName();
    }
    
    public String getDescription() {
        String desc;
        
        try{
            desc = this.computerObj.getNode().getNodeDescription();
            this.descriptionArray = desc.split("  ");
        }
        catch (NullPointerException e){
            desc = "";
        }

        return desc;
    }
    
    public String[] getDescriptionArray() {
        return this.descriptionArray;
    }
    
    @Override
    public String getIconFileName() {
        return "document.png"; 
    }

    @Override
    public String getDisplayName() {
        return "System Details";
    }

    @Override
    public String getUrlName() {
        return "sysdetail";
    }    

}
