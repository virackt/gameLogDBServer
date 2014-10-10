package com.zxhd.log.entity;
import com.zxhd.log.core.ILogCodec;
import com.zxhd.log.file.LogNameUtil;
import com.zxhd.log.util.LogFileUtil;
import com.zxhd.log.util.IoBufferUtil;
import org.apache.mina.common.ByteBuffer;
import java.util.List;
import java.util.ArrayList;
/**
  * 美人魂魄日志
  *	@author VIC
  * 此类用工具生成，不可修改
  */
public class BeautySoulLogMessage implements ILogCodec{
	
	public BeautySoulLogMessage(){}
	
	public BeautySoulLogMessage(int serverId,int iUserId,String vAccount,int iUserLv,int beautySoulType,int beautySoulNum,int beautySoulAction,String dActionTime){
					this.serverId = serverId;
					this.iUserId = iUserId;
					this.vAccount = vAccount;
					this.iUserLv = iUserLv;
					this.beautySoulType = beautySoulType;
					this.beautySoulNum = beautySoulNum;
					this.beautySoulAction = beautySoulAction;
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
			// 魂魄ID
		private int beautySoulType;
			// 该类型美人魂魄数量
		private int beautySoulNum;
			// 2为直接通过招魂台获得，4为副本掉落获得，5为合成后消失，6为普通合成获得，7为秘方合成获得，8为普通活动副本，9为王者试炼；0为其他类型
		private int beautySoulAction;
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
			public void setBeautySoulType(int beautySoulType){
			this.beautySoulType = beautySoulType;
		}
		public int getBeautySoulType(){
			return this.beautySoulType;
		}
			public void setBeautySoulNum(int beautySoulNum){
			this.beautySoulNum = beautySoulNum;
		}
		public int getBeautySoulNum(){
			return this.beautySoulNum;
		}
			public void setBeautySoulAction(int beautySoulAction){
			this.beautySoulAction = beautySoulAction;
		}
		public int getBeautySoulAction(){
			return this.beautySoulAction;
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
			 								   buffer.putInt(beautySoulType);
			 								   buffer.putInt(beautySoulNum);
			 								   buffer.putInt(beautySoulAction);
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
				   this.beautySoulType = buffer.getInt();
				}
			 									if(buffer.hasRemaining()){
				   this.beautySoulNum = buffer.getInt();
				}
			 									if(buffer.hasRemaining()){
				   this.beautySoulAction = buffer.getInt();
				}
			 									if(buffer.hasRemaining()){
				   this.dActionTime = IoBufferUtil.getString(buffer);
				}
			 			}
	
	//@Override
	public int getType() {
		
		return 10002;
	}

	//@Override
	public String getFileName() {
		return LogNameUtil.getLogName(this.getClass().getSimpleName());
	}

	//@Override
	public String getUpdateSql() {
		return "insert into beautySoulLog values(" + iEventId + "," + serverId+","+iUserId+","+"'" + vAccount+ "'"+","+iUserLv+","+beautySoulType+","+beautySoulNum+","+beautySoulAction+","+"'" + dActionTime+ "'" + ")";
	}

	//@Override
	public String getCreateTableSql() {
		return "create table beautySoulLog (iEventId bigint(20) comment '事件id', serverId int(11) comment'服务器id',iUserId int(11) comment'用户id',vAccount varchar(45) comment'帐号',iUserLv int(11) comment'战队等级',beautySoulType int(11) comment'魂魄ID',beautySoulNum int(11) comment'该类型美人魂魄数量',beautySoulAction int(11) comment'2为直接通过招魂台获得，4为副本掉落获得，5为合成后消失，6为普通合成获得，7为秘方合成获得，8为普通活动副本，9为王者试炼；0为其他类型',dActionTime timestamp comment'发生时间',primary key(iUserId, serverId, iEventId))ENGINE=MyISAM DEFAULT CHARSET=utf8;" ;
	}

	//@Override
	public String getFileContent() {
		return LogFileUtil.convertObjects2String(serverId,iUserId,vAccount,iUserLv,beautySoulType,beautySoulNum,beautySoulAction,dActionTime);
	}
	
	public List<Object> list(){
		List<Object> list = new ArrayList<Object>();
		list.add(iEventId);
					list.add(serverId);
					list.add(iUserId);
					list.add(vAccount);
					list.add(iUserLv);
					list.add(beautySoulType);
					list.add(beautySoulNum);
					list.add(beautySoulAction);
					list.add(dActionTime);
				return list;
	}
	
}