package com.hp.onlinexam.service.teacher;

import java.util.List;

import com.hp.onlinexam.dao.teacher.IPapersDao;
import com.hp.onlinexam.dao.teacher.PapersDao;
import com.hp.onlinexam.po.Paper;

public class PaperService implements IPaperService{
	private IPapersDao pd = new PapersDao();

	@Override
	public int save(Paper paper) {
		// TODO Auto-generated method stub
		pd.save(paper);
		return 0;
	}

	@Override
	public List getPaperByStudentId(int studentId, int testId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getPaperByStudentId(int studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getPaperCompare(int teaId) {
		// TODO Auto-generated method stub
		return null;
	}

}
