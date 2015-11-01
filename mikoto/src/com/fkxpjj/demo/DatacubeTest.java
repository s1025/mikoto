package com.fkxpjj.demo;

import com.s1025.mikoto.Mikoto;
import com.s1025.mikoto.model.App;

public class DatacubeTest {
	public static void main(String[] args){
		Mikoto.app = new App("wxebc1d9dbfbd550d4", "81b03e6d76ea40f946881e9353c9cb78");
		String s = Mikoto.api.datacube.getarticlesummary("2015-10-01", "2015-10-01");
		System.out.println(s);
	}
}
