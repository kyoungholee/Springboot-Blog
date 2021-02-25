package auth;

import java.util.ArrayList; 
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cos.blog.model.User;

import lombok.Getter;



@Getter
public class PrincipalDetail implements UserDetails {
	private User user; //콤포지션
	
	public PrincipalDetail(User user) {
		this.user = user;
	}

	
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	//계정이 만료되지 않았는지 리턴한다.
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	//계정이 잠겨있지 않았는지 리턴한다. (true : 잠기지 않음) 
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	//계정이 활성화(사용가능)인지 리턴한다 true :활성화
	@Override
	public boolean isEnabled() {
		return true;
	}
	//계정 권한을 리턴 
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Collection<GrantedAuthority> collectors = new ArrayList<>();
		collectors.add(()->{ return "ROLE_"+user.getRole();});
		
		
		return collectors;
	}

	
	
	
	

}
