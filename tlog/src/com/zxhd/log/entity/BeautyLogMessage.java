package com.zxhd.log.entity;
import com.zxhd.log.core.ILogCodec;
import com.zxhd.log.file.LogNameUtil;
import com.zxhd.log.util.LogFileUtil;
import com.zxhd.log.util.IoBufferUtil;
import org.apache.mina.common.ByteBuffer;
import java.util.List;
import java.util.ArrayList;
/**
  * 美人日志
  *	@author VIC
  * 此类用工具生成，不可修改
  */
public class BeautyLogMessage implements ILogCodec{
	
	public BeautyLogMessage(){}
	
	public BeautyLogMessage(int serverId,int iUserId,String vAccount,int iUserLv,int beautyType,int beautyNum,int beautyAction,int beautyLv,int beautyClass,String dActionTime){
					this.serverId = serverId;
					this.iUserId = iUserId;
					this.vAccount = vAccount;
					this.iUserLv = iUserLv;
					this.beautyType = beautyType;
					this.beautyNum = beautyNum;
					this.beautyAction = beautyAction;
					this.beautyLv = beautyLv;
					this.beautyClass = beautyClass;
					this.dActionTime = dActionTime;
			}
	// 事件id
	private long iEventId;
			// 服务器id
		private int serverId;
			// 用户id
		private int iUserId;
			// 帐号
		private String vAccount;
			// 战队等级
		private int iUserLv;
			// 60种美人ID
		private int beautyType;
			// 该类型美人数量，0或1
		private int beautyNum;
			// 1为召唤获得，2为直接通过招魂台获得，4为副本掉落获得，5为消失，6为普通活动副本，7为王者试炼；0为其他类型
		private int beautyAction;
			// 美人等级
		private int beautyLv;
			// 美人阶数
		private int beautyClass;
			// 发生时间
		private String dActionTime;
		public void setIEventId(long iEventId){
		this.iEventId = iEventId;
	}
	public long getIEventId(){
		return this.iEventId;
	}
			public void setServerId(int serverId){
			this.serverId = serverId;
		}
		public int getServerId(){
			return this.serverId;
		}
			public void setIUserId(int iUserId){
			this.iUserId = iUserId;
		}
		public int getIUserId(){
			return this.iUserId;
		}
			public void setVAccount(String vAccount){
			this.vAccount = vAccount;
		}
		public String getVAccount(){
			return this.vAccount;
		}
			public void setIUserLv(int iUserLv){
			this.iUserLv = iUserLv;
		}
		public int getIUserLv(){
			return this.iUserLv;
		}
			public void setBeautyType(int beautyType){
			this.beautyType = beautyType;
		}
		public int getBeautyType(){
			return this.beautyType;
		}
			public void setBeautyNum(int beautyNum){
			this.beautyNum = beautyNum;
		}
		public int getBeautyNum(){
			return this.beautyNum;
		}
			public void setBeautyAction(int beautyAction){
			this.beautyAction = beautyAction;
		}
		public int getBeautyAction(){
			return this.beautyAction;
		}
			public void setBeautyLv(int beautyLv){
			this.beautyLv = beautyLv;
		}
		public int getBeautyLv(){
			return this.beautyLv;
		}
			public void setBeautyClass(int beautyClass){
			this.beautyClass = beautyClass;
		}
		public int getBeautyClass(){
			return this.beautyClass;
		}
			public void setDActionTime(String dActionTime){
			this.dActionTime = dActionTime;
		}
		public String getDActionTime(){
			return this.dActionTime;
		}
		//@Override
	public void encode(ByteBuffer buffer){
		buffer.putLong(iEventId);
								   buffer.putInt(serverId);
			 								   buffer.putInt(iUserId);
			 								   IoBufferUtil.putString(buffer, vAccount);
			 								   buffer.putInt(iUserLv);
			 								   buffer.putInt(beautyType);
			 								   buffer.putInt(beautyNum);
			 								   buffer.putInt(beautyAction);
			 								   buffer.putInt(beautyLv);
			 								   buffer.putInt(beautyClass);
			 								   IoBufferUtil.putString(buffer, dActionTime);
			 			}
	//@Override
	public void decode(ByteBuffer buffer){
		if(buffer.hasRemaining()){
			this.iEventId = buffer.getLong();
		}
									if(buffer.hasRemaining()){
				   this.serverId = buffer.getInt();
				}
			 									if(buffer.hasRemaining()){
				   this.iUserId = buffer.getInt();
				}
			 									if(buffer.hasRemaining()){
				   this.vAccount = IoBufferUtil.getString(buffer);
				}
			 									if(buffer.hasRemaining()){
				   this.iUserLv = buffer.getInt();
				}
			 									if(buffer.hasRemaining()){
				   this.beautyType = buffer.getInt();
				}
			 									if(buffer.hasRemaining()){
				   this.beautyNum = buffer.getInt();
				}
			 									if(buffer.hasRemaining()){
				   this.beautyAction = buffer.getInt();
				}
			 									if(buffer.hasRemaining()){
				   this.beautyLv = buffer.getInt();
				}
			 									if(buffer.hasRemaining()){
				   this.beautyClass = buffer.getInt();
				}
			 									if(buffer.hasRemaining()){
				   this.dActionTime = IoBufferUtil.getString(buffer);
				}
			 			}
	
	//@Override
	public int getType() {
		
		return 10001;
	}

	//@Override
	public String getFileName() {
		return LogNameUtil.getLogName(this.getClass().getSimpleName());
	}

	//@Override
	public String getUpdateSql() {
		return "insert into beautyLog values(" + iEventId + "," + serverId+","+iUserId+","+"'" + vAccount+ "'"+","+iUserLv+","+beautyType+","+beautyNum+","+beautyAction+","+beautyLv+","+beautyClass+","+"'" + dActionTime+ "'" + ")";
	}

	//@Override
	public String getCreateTableSql() {
		return "create table beautyLog (iEventId bigint(20) comment '事件id', serverId int(11) comment'服务器id',iUserId int(11) comment'用户id',vAccount varchar(45) comment'帐号',iUserLv int(11) comment'战队等级',beautyType int(11) comment'60种美人ID',beautyNum int(11) comment'该类型美人数量，0或1',beautyAction int(11) comment'1为召唤获得，2为直接通过招魂台获得，4为副本掉落获得，5为消失，6为普通活动副本，7为王者试炼；0为其他类型',beautyLv int(11) comment'美人等级',beautyClass int(11) comment'美人阶数',dActionTime timestamp comment'发生时间',primary key(iUserId, serverId, iEventId))ENGINE=MyISAM DEFAULT CHARSET=utf8;" ;
	}

	//@Override
	public String getFileContent() {
		return LogFileUtil.convertObjects2String(serverId,iUserId,vAccount,iUserLv,beautyType,beautyNum,beautyAction,beautyLv,beautyClass,dActionTime);
	}
	
	public List<Object> list(){
		List<Object> list = new ArrayList<Object>();
		list.add(iEventId);
					list.add(serverId);
					list.add(iUserId);
					list.add(vAccount);
					list.add(iUserLv);
					list.add(beautyType);
					list.add(beautyNum);
					list.add(beautyAction);
					list.add(beautyLv);
					list.add(beautyClass);
					list.add(dActionTime);
				return list;
	}
	
}