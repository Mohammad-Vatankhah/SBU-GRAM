package Common;

import java.io.Serializable;

public enum Command implements Serializable {
    LOGIN , SIGNUP , LOGOUT , USERNAME_UNIQUE ,
    ADD_COMMENT , LIKE , DISLIKE , REPOST , UPDATE_PROFILE ,
    GET_POSTS , FOLLOW , UNFOLLOW , PUBLISH_POST ,
    GET_INFO , GET_PASSWORD , GET_USER , GET_COMMENTS , CHANGE_PASS ,
    CHANGE_PHOTO
}
