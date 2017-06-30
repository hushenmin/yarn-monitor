package org.monitor.yarn.util;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017/6/15.
 */
public class NodeParseUtils {
    private    String current;
    public NodeParseUtils(){
    }

    /**
     * 判断一个节点是不是一个节点的父节点
     * @param current
     */
    public NodeParseUtils(String current){
        this.current = current;
    }


    public  Boolean isParent(String leaf){
        String str = leaf.substring(0,leaf.lastIndexOf("."));
        if (this.current.trim().equals(str)){
            return true;
        }else {
            return  false;
        }
    }
  public  Boolean isChild(String parent){
      String str = current.substring(0,current.lastIndexOf("."));
      if(parent.trim().equals(str)) {
          return true;
      }else {
          return false;
      }
  }

    public  Boolean isBrother(String brother){
        if (current.trim().equals(brother.trim())){
            return true;
        }else {
            return false;
        }
    }
    public  Boolean isRoot(){

        if(current.trim().split("\\.").length ==1){
            return  true;
        }
        return  false;
    }

    public  Boolean hasChild(HashSet set){
        Iterator<String> iterator = set.iterator();
        Boolean  flag = false;
        while (iterator.hasNext()){
            String itr = iterator.next();
            if (itr.contains(".") && current.trim().equals(itr.substring(0,itr.lastIndexOf(".")))){
                flag =  true;
            }
       }
        return flag;
    }

    public  Boolean hasParent(HashSet set) {
        Iterator<String> iterator = set.iterator();
        Boolean flag = false;
        while (iterator.hasNext()) {
            String itr = iterator.next();
            if (current.contains(".") && current.substring(0, current.lastIndexOf(".")).equals(itr)) {
                flag = true;
            }

        }
        return flag;
    }
}
