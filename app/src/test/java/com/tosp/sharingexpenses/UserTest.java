package com.tosp.sharingexpenses;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class UserTest {
    private User s3dany;
    private User s3dany_Friend;

    @Before
    public void setUp() throws Exception {
        s3dany = new User("s3dany", "s3dany@share.com","ssssss3", 5000.0, new ArrayList<User>(), new ArrayList<FriendRequest>(),new ArrayList<FriendRequest>());
        s3dany_Friend =  new User("s3dany's Friend", "s3dany_friend@share.com","ssssss3ffff",7000.0,new ArrayList<User>(), new ArrayList<FriendRequest>(),new ArrayList<FriendRequest>());
    }



    @Test
    public void addFriend() {
        s3dany.addFriend(s3dany_Friend);
        assertTrue(s3dany.getFriends().size() == 1);
        assertTrue(s3dany.getFriends().contains(s3dany_Friend));
    }

    @Test
    public void changeBalance() {
        s3dany.changeBalance(100.0);
        assertTrue(s3dany.getBalance()==5100.0);
        s3dany.changeBalance(-100.0);
        assertTrue(s3dany.getBalance()==5000.0);
    }

    @Test
    public void payTo() {
        s3dany.payTo(s3dany_Friend, 500.0);
        assertTrue(s3dany.getBalance()==4500.0);
        assertTrue(s3dany_Friend.getBalance()==7500.0);
    }

    @Test
    public void send_friend_request() {
        FriendRequest request = s3dany.send_friend_request(s3dany_Friend);
        assertTrue(s3dany_Friend.getReceivedRequests().size()==1);
        assertTrue(s3dany.getSentRequests().size()==1);
        assertTrue(s3dany_Friend.getReceivedRequests().contains(request));
        assertTrue(s3dany.getSentRequests().contains(request));

    }

    @Test
    public void accept_friend_request() {
        FriendRequest request = s3dany.send_friend_request(s3dany_Friend);
        s3dany.accept_friend_request(request);
        assertTrue(s3dany_Friend.getReceivedRequests().size()==0);
        assertTrue(s3dany.getSentRequests().size()==0);
        assertFalse(s3dany_Friend.getReceivedRequests().contains(request));
        assertFalse(s3dany.getSentRequests().contains(request));
        assertTrue(s3dany.getFriends().size() == 1);
        assertTrue(s3dany.getFriends().contains(s3dany_Friend));

    }

    @Test
    public void decline_friend_request() {
        FriendRequest request = s3dany.send_friend_request(s3dany_Friend);
        s3dany.decline_friend_request(request);
        assertTrue(s3dany_Friend.getReceivedRequests().size()==0);
        assertTrue(s3dany.getSentRequests().size()==0);
        assertFalse(s3dany_Friend.getReceivedRequests().contains(request));
        assertFalse(s3dany.getSentRequests().contains(request));
        assertTrue(s3dany.getFriends().size() == 0);
        assertFalse(s3dany.getFriends().contains(s3dany_Friend));
    }
}