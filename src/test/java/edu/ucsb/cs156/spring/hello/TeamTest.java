package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_returns_correct_values() {
        assertEquals(true, team.equals(team)); //test if object is equal to itself
        assertEquals(false, team.equals(1)); //test if object is equal to different class type
        Team other_team = new Team("test-team");
        assertEquals(true, team.equals(other_team)); // test if object is equal to other identical object
        other_team.setName("other-team");
        assertEquals(false, team.equals(other_team)); // test if object is equal to identical object with different name
        other_team.setName("test-team");
        ArrayList<String> members = new ArrayList<>();
        members.add("Joe");
        other_team.setMembers(members);
        assertEquals(false, team.equals(other_team)); // test if object is equal to identical object with different members
        other_team.setName("other-team");
        assertEquals(false, team.equals(other_team)); // test if object is equal to other object with different name and members
    }

    @Test
    public void hashCode_returns_correct_values() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());

        Team t = new Team();
        int result = t.hashCode();
        assertEquals(1, result);
    }
}
