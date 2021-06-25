package com.example.simplilearn.flyaway.modules.user.domain;


public class Group {

    public static String getGroupName(int groupId) {

      switch (groupId) {
          case 1:
              return "admin";
          case 2:
              return "user";
          default:
              return "GROUP NOT DEFINED";
      }

    }

}
