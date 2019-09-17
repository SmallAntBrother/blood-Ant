package com.hwk.leetCode;


import java.text.DecimalFormat;

import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.FileSystem;
import org.hyperic.sigar.FileSystemUsage;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.Swap;


public class CPUAndMemory {
	public static void main(String[] args) throws Exception {
		CPUAndMemory s = new CPUAndMemory();
		s.testFileSystemInfo();
		s.getPhysicalMemory();
		while( true ){
			System.out.println("-------------------");
			s.testCpuPerc();
		}
	}
	
	/**
	 * 1.CPU的用户使用量、系统使用剩余量、总的剩余量、总的使用占用量等（单位：100%）
	 */
	public void testCpuPerc() {
		Sigar sigar = new Sigar();
		// 主要是针对一块CPU的情况
		CpuPerc cpu;
		try {
			cpu = sigar.getCpuPerc();
			printCpuPerc(cpu);
		} catch (SigarException e) {
			e.printStackTrace();
		}
		// 不管是单块CPU还是多CPU都适用
		CpuPerc cpuList[] = null;
		try {
			cpuList = sigar.getCpuPercList();
		} catch (SigarException e) {
			e.printStackTrace();
			return;
		}
		for (int i = 0; i < cpuList.length; i++) {
			printCpuPerc(cpuList[i]);
		}
	}

	private void printCpuPerc(CpuPerc cpu) {
		System.out.println("用户使用率:" + CpuPerc.format(cpu.getUser()));// 用户使用率
		System.out.println("系统使用率:" + CpuPerc.format(cpu.getSys()));// 系统使用率
		System.out.println("当前等待率:" + CpuPerc.format(cpu.getWait()));// 当前等待率
		System.out.println("总的使用率:" + CpuPerc.format(cpu.getCombined()));// 总的使用率
		System.out.println("**************");
	}
	
	/**
	 * 2.内存资源信息
	 */
	public void getPhysicalMemory() {
		// a)物理内存信息
		DecimalFormat df = new DecimalFormat("#0.00");
		Sigar sigar = new Sigar();
		Mem mem;
		try {
			mem = sigar.getMem();
			// 内存总量
			System.out.println("内存总量：" + df.format((float) mem.getTotal() / 1024 / 1024 / 1024) + "G");
			// 当前内存使用量
			System.out.println("当前内存使用量：" + df.format((float) mem.getUsed() / 1024 / 1024 / 1024) + "G");
			// 当前内存剩余量
			System.out.println("当前内存剩余量：" + df.format((float) mem.getFree() / 1024 / 1024 / 1024) + "G");
			// b)系统页面文件交换区信息
			Swap swap = sigar.getSwap();
			// 交换区总量
			System.out.println("交换区总量：" + df.format((float) swap.getTotal() / 1024 / 1024 / 1024) + "G");
			// 当前交换区使用量
			System.out.println("当前交换区使用量：" + df.format((float) swap.getUsed() / 1024 / 1024 / 1024) + "G");
			// 当前交换区剩余量
			System.out.println("当前交换区剩余量：" + df.format((float) swap.getFree() / 1024 / 1024 / 1024) + "G");
		} catch (SigarException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 4.资源信息（主要是硬盘）
	 * a)取硬盘已有的分区及其详细信息（通过sigar.getFileSystemList()来获得FileSystem列表对象，然后对其进行编历）：
	 */
	public void testFileSystemInfo() throws Exception {
		Sigar sigar = new Sigar();
		FileSystem fslist[] = sigar.getFileSystemList();
		DecimalFormat df = new DecimalFormat("#0.00");
		// String dir = System.getProperty("user.home");// 当前用户文件夹路径
		for (int i = 0; i < fslist.length; i++) {
			System.out.println("\n~~~~~~~~~~" + i + "~~~~~~~~~~");
			FileSystem fs = fslist[i];
			// 分区的盘符名称
			System.out.println("fs.getDevName() = " + fs.getDevName());
			// 分区的盘符名称
			System.out.println("fs.getDirName() = " + fs.getDirName());
			System.out.println("fs.getFlags() = " + fs.getFlags());//
			// 文件系统类型，比如 FAT32、NTFS
			System.out.println("fs.getSysTypeName() = " + fs.getSysTypeName());
			// 文件系统类型名，比如本地硬盘、光驱、网络文件系统等
			System.out.println("fs.getTypeName() = " + fs.getTypeName());
			// 文件系统类型
			System.out.println("fs.getType() = " + fs.getType());
			FileSystemUsage usage = null;
			try {
				usage = sigar.getFileSystemUsage(fs.getDirName());
			} catch (SigarException e) {
				if (fs.getType() == 2)
					throw e;
				continue;
			}
			switch (fs.getType()) {
			case 0: // TYPE_UNKNOWN ：未知
				break;
			case 1: // TYPE_NONE
				break;
			case 2: // TYPE_LOCAL_DISK : 本地硬盘
				// 文件系统总大小
				System.out.println(" Total = " + df.format((float) usage.getTotal() / 1024 / 1024) + "G");
				// 文件系统剩余大小
				System.out.println(" Free = " + df.format((float) usage.getFree() / 1024 / 1024) + "G");
				// 文件系统可用大小
				System.out.println(" Avail = " + df.format((float) usage.getAvail() / 1024 / 1024) + "G");
				// 文件系统已经使用量
				System.out.println(" Used = " + df.format((float) usage.getUsed() / 1024 / 1024) + "G");
				double usePercent = usage.getUsePercent() * 100D;
				// 文件系统资源的利用率
				System.out.println(" Usage = " + df.format(usePercent) + "%");
				break;
			case 3:// TYPE_NETWORK ：网络
				break;
			case 4:// TYPE_RAM_DISK ：闪存
				break;
			case 5:// TYPE_CDROM ：光驱
				break;
			case 6:// TYPE_SWAP ：页面交换
				break;
			}
			System.out.println(" DiskReads = " + usage.getDiskReads());
			System.out.println(" DiskWrites = " + usage.getDiskWrites());
		}
		return;
	}

}
