package com.s1025.kuroko.plugin.router;

import java.util.ArrayList;
import java.util.List;

public class Rule {
	private List<Key> keys = new ArrayList<Key>();              //�ؼ����б�
	private List<Reply> replys = new ArrayList<Reply>();        //�ظ��б�
	private boolean respAll;                                    //�ظ�ȫ����
	private int pri;                                            //���ȼ�
	private boolean now;                                        //�����ظ���
	private boolean end;                                        //����������
}
