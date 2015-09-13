package com.s1025.kuroko.plugin.router;

import java.util.ArrayList;
import java.util.List;

public class Rule {
	private List<Key> keys = new ArrayList<Key>();              //关键字列表
	private List<Reply> replys = new ArrayList<Reply>();        //回复列表
	private boolean respAll;                                    //回复全部吗？
	private int pri;                                            //优先级
	private boolean now;                                        //立即回复吗？
	private boolean end;                                        //立即结束吗？
}
