import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Friend {
	private Collection<Friend> friends;
	private String email;

	public Friend(String email) {
		this.email = email;
		this.friends = new ArrayList<Friend>();
	}

	public String getEmail() {
		return email;
	}

	public Collection<Friend> getFriends() {
		return friends;
	}

	public void addFriendship(Friend friend) {
		friends.add(friend);
		friend.getFriends().add(this);
	}

	public boolean canBeConnected(Friend friend) {
		Queue<Friend> connectedFriends = new LinkedList<>();
		Set<Friend> confirmedFriend = new HashSet<>();
		for (Friend f : friends) {
			if (f == friend)
				return true;
			connectedFriends.add(f);
			confirmedFriend.add(f);
		}
		while (!connectedFriends.isEmpty()) {
			if (furtherFriend(connectedFriends, confirmedFriend, friend))
				return true;
		}
		return false;
	}

	private boolean furtherFriend(Queue<Friend> connectedFriends, Set<Friend> confirmedFriend, Friend friend) {
		Friend first = connectedFriends.poll();
		for (Friend f : first.getFriends()) {
			if (f == friend)
				return true;
			if (!confirmedFriend.contains(f)) {
				connectedFriends.add(f);
				confirmedFriend.add(f);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Friend a = new Friend("A");
		Friend b = new Friend("B");
		Friend c = new Friend("C");

		a.addFriendship(b);
		b.addFriendship(c);

		System.out.println(a.canBeConnected(c));
	}
}