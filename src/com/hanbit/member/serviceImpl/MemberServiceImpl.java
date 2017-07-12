package com.hanbit.member.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.hanbit.member.domain.MemberBean;
import com.hanbit.member.service.MemberService;

public class MemberServiceImpl implements MemberService{
	List<MemberBean> list;
	int count;//count를 instance variable로 만드는 곳
	MemberBean member;
	public MemberServiceImpl() {
		list=new ArrayList<MemberBean>();//아래의 count와 다르다 그냥 문자 x,d,count 등등
		count=0;//count를 초기화한다
	}
	@Override
	public void addMember(MemberBean bean) {
			//list=bean;//list에 bean을 넣어준다
		list.add(bean);
	}
	@Override
	public List<MemberBean> list() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override//수정중
	public List<MemberBean> findByName(String name) {
		List<MemberBean> temp=new ArrayList<MemberBean>();
		int count=0;
		for(MemberBean mem:list){
			if(name.equals(mem.getName())){
				count++;//방 수를 늘리는 것
			}
		}
		int j=0;
		for(MemberBean memb:list){
			if(name.equals(memb.getName())){
				temp.add(memb);//getName으로 가져온 모든것을 담는다
				if(count==temp.size());
				break;
			}
		}
		return temp;
	}

	@Override
	public MemberBean findById(String id) {
		for(MemberBean mem:list){
			if(id.equals(mem.getId())){
				member = mem;
			}
		}
		return member;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return list.size();//회원수를 한번에 count 해주는것
	}

	@Override
	public void update(MemberBean bean) {
		findById(bean.getId()).setName(bean.getName());//아이디로 받아서 이름을 바꿔준다
		findById(bean.getId()).setSsn(bean.getSsn());//아이디로 받아서 주민번호를 바꿔준다
		findById(bean.getId()).setPassWord(bean.getPassWord());//아이디로 받아서 비밀번호를 바꿔준다
	}

	@Override
	public void delete(String id) {
		for(MemberBean mem:list){
			if(id.equals(mem.getId())){
				list.remove(mem);
			}
		}
	}
}
