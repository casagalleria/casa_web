package kr.casagalleria.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.casagalleria.DTO.casa_member;
import kr.casagalleria.Repo.MemberRepository;
import kr.casagalleria.util.JsonUtil;

@RestController
public class MemberController {
	@Autowired
	private MemberRepository memberRepo;

	@RequestMapping("/api/member/login.do")
	public Map<String, Object> doLogin(@RequestParam("id") String strId
									, @RequestParam("pw") String strPw
									, HttpServletRequest request) {
		Map<String, Object> reqMap = new HashMap<String, Object>();
		
		casa_member cm = memberRepo.findById(strId);
		if(cm == null )
			return JsonUtil.putFailJsonContainer("ERR_LOGIN_0001", "아이디와 비밀번호를 확인해주세요.");
		
		if(!cm.getPw().equals(strPw))
			return JsonUtil.putFailJsonContainer("ERR_LOGIN_0001", "아이디와 비밀번호를 확인해주세요.");
		
		System.out.println("test1");
		cm.setPw(null);
		System.out.println("test2");
		request.setAttribute("userInfo", cm);
		System.out.println("test3");
		reqMap.put("usr", cm);
		System.out.println("test4");
		return JsonUtil.putSuccessJsonContainer(reqMap);
		
	}
	
	@RequestMapping("/api/member/join.do")
	public Map<String, Object> saveMember(@RequestParam(value="id", required=false) String strId
										, @RequestParam("name") String strName
										, @RequestParam("pw") String strPw
										, @RequestParam("type") int intType
										, @RequestParam(value="uuid", required=false) String strUuid){
		Map<String, Object> resData = new HashMap<String, Object>();
		
		String strUsrNo = memberRepo.getUsrNo();
		
		//Type=1 -> email
		if(intType==1) {
			if(strId == null || "".equals(strId))
				return JsonUtil.putFailJsonContainer("ERR_MEMBER_0001", "아이디를 입력해주세요.");
			
			if(memberRepo.findById(strId) != null)
				return JsonUtil.putFailJsonContainer("ERR_MEMBER_0002", "이미 존재하는 아이디입니다.");
		}
		//Type=2,3 -> kakaotalk, 페이스북
		else if(intType==2 || intType==3) {
			if(strUuid==null || "".equals(strUuid))
				return JsonUtil.putFailJsonContainer("ERR_MEMBER_0001", "사용자 인증키가 없습니다. ");
		}

		
		casa_member cm = new casa_member();
		cm.setNo(strUsrNo);
		cm.setId(strId);
		cm.setName(strName);
		cm.setPw(strPw);
		cm.setType(intType);
		cm.setUuid(strUuid);
		cm.setUpdate(new Date());
		cm.setInsertdate(new Date());
		
		resData.put("rslt", memberRepo.save(cm));
		
		return JsonUtil.putSuccessJsonContainer(resData);
	}
	
	
}
