package com.nazirov.recyclerview5.model;

import java.util.List;

public class Member {
    private String firstName;
    private String lastName;
   private List<MemberSub> memberSubs;


    public Member(String firstName, String lastName, MemberSub memberSub) {
        this.firstName = firstName;
        this.lastName=lastName;
        this.memberSubs=memberSubs ;

    }
    public Member() {

    }



    public List<MemberSub> isAvailable(){return memberSubs;}

    public void setAvailable(List<MemberSub> memberSubs) {this.memberSubs=memberSubs;}

    public String getFirstName (){return firstName;}

    public void setFirstName(String firstName) {this.firstName = firstName; }

    public void setLastName(String lastName) {this.lastName = lastName; }

    public String getLastName (){return lastName;}

    public List<MemberSub> getMemberSubs() {
        return memberSubs;
    }
}

