package com.zxhd.log.entity;
import com.zxhd.log.core.ILogCodec;
import com.zxhd.log.file.LogNameUtil;
import com.zxhd.log.util.LogFileUtil;
import com.zxhd.log.util.IoBufferUtil;
import org.apache.mina.common.ByteBuffer;
import java.util.List;
import java.util.ArrayList;
/**
  * 钻石日志
  *	@author VIC
  * 此类用工具生成，不可修改
  */
public class DiamondLogMessage implements ILogCodec{
	
	public DiamondLogMessage(){}
	
	public DiamondLogMessage(int serverId,int iUserId,String vAccount,int iUserLv,int actionType,String dActionTime,int actionway,int iDiamondBefore,int iChangeNum,int iDiamondAfter){
					this.serverId = serverId;
					this.iUserId = iUserId;
					this.vAccount = vAccount;
					this.iUserLv = iUserLv;
					this.actionType = actionType;
					this.dActionTime = dActionTime;
					this.actionway = actionway;
					this.iDiamondBefore = iDiamondBefore;
					this.iChangeNum = iChangeNum;
					this.iDiamondAfter = iDiamondAfter;
			}
	// 事件id
	private long iEventId;
			// 服务器id
		private int serverId;
			// 用户id
		private int iUserId;
			// 帐号
		private String vAccount;
			// 用户等级
		private int iUserLv;
			// 1为产出，2为消耗
		private int actionType;
			// 发生时间
		private String dActionTime;
			// 变化原因：按功能模块，哪个模块获得，哪个模块消耗
		private int actionway;
			// 变化前数量
		private int iDiamondBefore;
			// 变化数量
		private int iChangeNum;
			// 变化后数量
		private int iDiamondAfter;
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
			public void setActionType(int actionType){
			this.actionType = actionType;
		}
		public int getActionType(){
			return this.actionType;
		}
			public void setDActionTime(String dActionTime){
			this.dActionTime = dActionTime;
		}
		public String getDActionTime(){
			return this.dActionTime;
		}
			public void setActionway(int actionway){
			this.actionway = actionway;
		}
		public int getActionway(){
			return this.actionway;
		}
			public void setIDiamondBefore(int iDiamondBefore){
			this.iDiamondBefore = iDiamondBefore;
		}
		public int getIDiamondBefore(){
			return this.iDiamondBefore;
		}
			public void setIChangeNum(int iChangeNum){
			this.iChangeNum = iChangeNum;
		}
		public int getIChangeNum(){
			return this.iChangeNum;
		}
			public void setIDiamondAfter(int iDiamondAfter){
			this.iDiamondAfter = iDiamondAfter;
		}
		public int getIDiamondAfter(){
			return this.iDiamondAfter;
		}
		//@Override
	public void encode(ByteBuffer buffer){
		buffer.putLong(iEventId);
								   buffer.putInt(serverId);
			 								   buffer.putInt(iUserId);
			 								   IoBufferUtil.putString(buffer, vAccount);
			 								   buffer.putInt(iUserLv);
			 								   buffer.putInt(actionType);
			 								   IoBufferUtil.putString(buffer, dActionTime);
			 								   buffer.putInt(actionway);
			 								   buffer.putInt(iDiamondBefore);
			 								   buffer.putInt(iChangeNum);
			 								   buffer.putInt(iDiamondAfter);
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
				   this.actionType = buffer.getInt();
				}
			 									if(buffer.hasRemaining()){
				   this.dActionTime = IoBufferUtil.getString(buffer);
				}
			 									if(buffer.hasRemaining()){
				   this.actionway = buffer.getInt();
				}
			 									if(buffer.hasRemaining()){
				   this.iDiamondBefore = buffer.getInt();
				}
			 									if(buffer.hasRemaining()){
				   this.iChangeNum = buffer.getInt();
				}
			 									if(buffer.hasRemaining()){
				   this.iDiamondAfter = buffer.getInt();
				}
			 			}
	
	//@Override
	public int getType() {
		
		return 10011;
	}

	//@Override
	public String getFileName() {
		return LogNameUtil.getLogName(this.getClass().getSimpleName());
	}

	//@Override
	public String getUpdateSql() {
		return "insert into diamondLog values(" + iEventId + "," + serverId+","+iUserId+","+"'" + vAccount+ "'"+","+iUserLv+","+actionType+","+"'" + dActionTime+ "'"+","+actionway+","+iDiamondBefore+","+iChangeNum+","+iDiamondAfter + ")";
	}

	//@Override
	public String getCreateTableSql() {
		return "create table diamondLog (iEventId bigint(20) comment '事件id', serverId int(11) comment'服务器id',iUserId int(11) comment'用户id',vAccount varchar(45) comment'帐号',iUserLv int(11) comment'用户等级',actionType int(11) comment'1为产出，2为消耗',dActionTime timestamp comment'发生时间',actionway int(11) comment'变化原因：按功能模块，哪个模块获得，哪个模块消耗',iDiamondBefore int(11) comment'变化前数量',iChangeNum int(11) comment'变化数量',iDiamondAfter int(11) comment'变化后数量',primary key(iUserId, serverId, iEventId))ENGINE=MyISAM DEFAULT CHARSET=utf8;" ;
	}

	//@Override
	public String getFileContent() {
		return LogFileUtil.convertObjects2String(serverId,iUserId,vAccount,iUserLv,actionType,dActionTime,actionway,iDiamondBefore,iChangeNum,iDiamondAfter);
	}
	
	public List<Object> list(){
		List<Object> list = new ArrayList<Object>();
		list.add(iEventId);
					list.add(serverId);
					list.add(iUserId);
					list.add(vAccount);
					list.add(iUserLv);
					list.add(actionType);
					list.add(dActionTime);
					list.add(actionway);
					list.add(iDiamondBefore);
					list.add(iChangeNum);
					list.add(iDiamondAfter);
				return list;
	}
	
}