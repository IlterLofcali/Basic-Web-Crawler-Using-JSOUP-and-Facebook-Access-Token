package com.ilter.main;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.Page;
import com.restfb.types.User;

public class Facebook {

	public static void main(String[] args) {
		String content = null;
		String accessToken = "EAACEdEose0cBAL2Szu1n121hcwDGZCXqtYABIwKeE5XfZAuIuLlFjHAexc1Ijaofk3ZByt6NmSAY0lf7CZBZAAq4ZBbGQHeZBMK9IMqXmPZBKvzSEfpzbtDzUUC5J1XIjWm4f71LkjZCe0EH7ZCtbDP1M9YjvpAAby4p7ZCMsYzELU40rsGMpXCIISoSidurRf0BMvGIL6p1THmqv54sZCVMOzkavtZBl7YA7ol7VUZArXvDujaAZDZD";
		@SuppressWarnings("deprecation")
		FacebookClient fbclient = new DefaultFacebookClient(accessToken);
		User me = fbclient.fetchObject("me", User.class, Parameter.with("fields", "email,first_name,last_name,gender"));
//		Page page = fbclient.fetchObject("cocacola", Page.class, Parameter.with("fields", "likes"));
		Connection<User> myFriends = fbclient.fetchConnection("me/friends", User.class);
		for (User friend : myFriends.getData()) {
			Connection<Page> myMovies = fbclient.fetchConnection(friend.getId() + "/movies", Page.class);

			content = content + "Name: " + friend.getName();
			for (Page page : myMovies.getData()) {
				content = content + "\n" + "Movies: " + page.getName() + "\n";
			}
			System.out.println(content);
		}

		// System.out.println("Page likes: " + page.getLikes());
//		System.out.println(me.getEmail());
		System.out.println(me.getName());
//		System.out.println(me.getGender());
//		System.out.println(me.getFavoriteTeams());

	}

}
