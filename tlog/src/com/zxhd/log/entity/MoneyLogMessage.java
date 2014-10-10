package com.zxhd.log.entity;
import com.zxhd.log.core.ILogCodec;
import com.zxhd.log.file.LogNameUtil;
import com.zxhd.log.util.LogFileUtil;
import com.zxhd.log.util.IoBufferUtil;
import org.apache.mina.common.ByteBuffer;
import java.util.List;
import java.util.ArrayList;
/**
  * 金钱日志
  *	@author VIC
  * 此类用工具生成，不可修改
  */
public class MoneyLogMessage implements ILogCodec{
	
	public MoneyLogMessage(){}
	
	public MoneyLogMessage(int serverId,int iUserId,String vAccount,int iUserLv,String vEquipType,int iMoneyBefore,int iChangeNum,int iMoneyAfter,int iActionReason,String dActionTime){
					this.serverId = serverId;
					this.iUserId = iUserId;
					this.vAccount = vAccount;
					this.iUserLv = iUserLv;
					this.vEquipType = vEquipType;
					this.iMoneyBefore = iMoneyBefore;
					this.iChangeNum = iChangeNum;
					this.iMoneyAfter = iMoneyAfter;
					this.iActionReason = iActionReason;
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
			// 用户等级
		private int iUserLv;
			// 设备类型
		private String vEquipType;
			// 变化前金额
		private int iMoneyBefore;
			// 变化金额
		private int iChangeNum;
			// 变化后金额
		private int iMoneyAfter;
			// 变化原因：按功能模块，哪个模块获得，哪个模块消耗
		private int iActionReason;
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
			public void setVEquipType(String vEquipType){
			this.vEquipType = vEquipType;
		}
		public String getVEquipType(){
			return this.vEquipType;
		}
			public void setIMoneyBefore(int iMoneyBefore){
			this.iMoneyBefore = iMoneyBefore;
		}
		public int getIMoneyBefore(){
			return this.iMoneyBefore;
		}
			public void setIChangeNum(int iChangeNum){
			this.iChangeNum = iChangeNum;
		}
		public int getIChangeNum(){
			return this.iChangeNum;
		}
			public void setIMoneyAfter(int iMoneyAfter){
			this.iMoneyAfter = iMoneyAfter;
		}
		public int getIMoneyAfter(){
			return this.iMoneyAfter;
		}
			public void setIActionReason(int iActionReason){
			this.iActionReason = iActionReason;
		}
		public int getIActionReason(){
			return this.iActionReason;
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
			 								   IoBufferUtil.putString(buffer, vEquipType);
			 								   buffer.putInt(iMoneyBefore);
			 								   buffer.putInt(iChangeNum);
			 								   buffer.putInt(iMoneyAfter);
			 								   buffer.putInt(iActionReason);
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
				   this.vEquipType = IoBufferUtil.getString(buffer);
				}
			 									if(buffer.hasRemaining()){
				   this.iMoneyBefore = buffer.getInt();
				}
			 									if(buffer.hasRemaining()){
				   this.iChangeNum = buffer.getInt();
				}
			 									if(buffer.hasRemaining()){
				   this.iMoneyAfter = buffer.getInt();
				}
			 									if(buffer.hasRemaining()){
				   this.iActionReason = buffer.getInt();
				}
			 									if(buffer.hasRemaining()){
				   this.dActionTime = IoBufferUtil.getString(buffer);
				}
			 			}
	
	//@Override
	public int getType() {
		
		return 10007;
	}

	//@Override
	public String getFileName() {
		return LogNameUtil.getLogName(this.getClass().getSimpleName());
	}

	//@Override
	public String getUpdateSql() {
		return "insert into moneyLog values(" + iEventId + "," + serverId+","+iUserId+","+"'" + vAccount+ "'"+","+iUserLv+","+"'" + vEquipType+ "'"+","+iMoneyBefore+","+iChangeNum+","+iMoneyAfter+","+iActionReason+","+"'" + dActionTime+ "'" + ")";
	}

	//@Override
	public String getCreateTableSql() {
		return "create table moneyLog (iEventId bigint(20) comment '事件id', serverId int(11) comment'服务器id',iUserId int(11) comment'用户id',vAccount varchar(45) comment'帐号',iUserLv int(11) comment'用户等级',vEquipType varchar(45) comment'设备类型',iMoneyBefore int(11) comment'变化前金额',iChangeNum int(11) comment'变化金额',iMoneyAfter int(11) comment'变化后金额',iActionReason int(2) comment'变化原因：按功能模块，哪个模块获得，哪个模块消耗',dActionTime timestamp comment'发生时间',primary key(iUserId, serverId, iEventId))ENGINE=MyISAM DEFAULT CHARSET=utf8;" ;
	}

	//@Override
	public String getFileContent() {
		return LogFileUtil.convertObjects2String(serverId,iUserId,vAccount,iUserLv,vEquipType,iMoneyBefore,iChangeNum,iMoneyAfter,iActionReason,dActionTime);
	}
	
	public List<Object> list(){
		List<Object> list = new ArrayList<Object>();
		list.add(iEventId);
					list.add(serverId);
					list.add(iUserId);
					list.add(vAccount);
					list.add(iUserLv);
					list.add(vEquipType);
					list.add(iMoneyBefore);
					list.add(iChangeNum);
					list.add(iMoneyAfter);
					list.add(iActionReason);
					list.add(dActionTime);
				return list;
	}
	
}