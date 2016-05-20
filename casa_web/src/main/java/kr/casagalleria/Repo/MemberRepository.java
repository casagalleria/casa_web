package kr.casagalleria.Repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import kr.casagalleria.DTO.casa_member;

@Repository
public interface MemberRepository extends JpaRepository<casa_member,Integer>{
	public casa_member findById(String id);
	
	@Query(value = "SELECT getusrno()", nativeQuery=true)
	public String getUsrNo();
	
}
