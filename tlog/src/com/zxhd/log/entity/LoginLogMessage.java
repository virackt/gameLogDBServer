package com.zxhd.log.entity;

import com.zxhd.log.core.ILogCodec;
import com.zxhd.log.file.LogNameUtil;
import com.zxhd.log.util.LogFileUtil;
import com.zxhd.log.util.IoBufferUtil;
import org.apache.mina.common.ByteBuffer;
import java.util.List;
import java.util.ArrayList;

/**
 * 登录日志
 * 
 * @author VIC 此类用工具生成，不可修改
 */
public class LoginLogMessage implements ILogCodec {

	public LoginLogMessage() {
	}

	public LoginLogMessage(int serverId, int iUserId, String vAccount,
			int iUserLv, String vUUid, String vClientIp, String vEquipType,
			String dActionTime) {
		this.serverId = serverId;
		this.iUserId = iUserId;
		this.vAccount = vAccount;
		this.iUserLv = iUserLv;
		this.vUUid = vUUid;
		this.vClientIp = vClientIp;
		this.vEquipType = vEquipType;
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
	// 设备id
	private String vUUid;
	// ip地址
	private String vClientIp;
	// 设备类型
	private String vEquipType;
	// 发生时间
	private String dActionTime;

	public void setIEventId(long iEventId) {
		this.iEventId = iEventId;
	}

	public long getIEventId() {
		return this.iEventId;
	}

	public void setServerId(int serverId) {
		this.serverId = serverId;
	}

	public int getServerId() {
		return this.serverId;
	}

	public void setIUserId(int iUserId) {
		this.iUserId = iUserId;
	}

	public int getIUserId() {
		return this.iUserId;
	}

	public void setVAccount(String vAccount) {
		this.vAccount = vAccount;
	}

	public String getVAccount() {
		return this.vAccount;
	}

	public void setIUserLv(int iUserLv) {
		this.iUserLv = iUserLv;
	}

	public int getIUserLv() {
		return this.iUserLv;
	}

	public void setVUUid(String vUUid) {
		this.vUUid = vUUid;
	}

	public String getVUUid() {
		return this.vUUid;
	}

	public void setVClientIp(String vClientIp) {
		this.vClientIp = vClientIp;
	}

	public String getVClientIp() {
		return this.vClientIp;
	}

	public void setVEquipType(String vEquipType) {
		this.vEquipType = vEquipType;
	}

	public String getVEquipType() {
		return this.vEquipType;
	}

	public void setDActionTime(String dActionTime) {
		this.dActionTime = dActionTime;
	}

	public String getDActionTime() {
		return this.dActionTime;
	}

	// @Override
	public void encode(ByteBuffer buffer) {
		buffer.putLong(iEventId);
		buffer.putInt(serverId);
		buffer.putInt(iUserId);
		IoBufferUtil.putString(buffer, vAccount);
		buffer.putInt(iUserLv);
		IoBufferUtil.putString(buffer, vUUid);
		IoBufferUtil.putString(buffer, vClientIp);
		IoBufferUtil.putString(buffer, vEquipType);
		IoBufferUtil.putString(buffer, dActionTime);
	}

	// @Override
	public void decode(ByteBuffer buffer) {
		if (buffer.hasRemaining()) {
			this.iEventId = buffer.getLong();
		}
		if (buffer.hasRemaining()) {
			this.serverId = buffer.getInt();
		}
		if (buffer.hasRemaining()) {
			this.iUserId = buffer.getInt();
		}
		if (buffer.hasRemaining()) {
			this.vAccount = IoBufferUtil.getString(buffer);
		}
		if (buffer.hasRemaining()) {
			this.iUserLv = buffer.getInt();
		}
		if (buffer.hasRemaining()) {
			this.vUUid = IoBufferUtil.getString(buffer);
		}
		if (buffer.hasRemaining()) {
			this.vClientIp = IoBufferUtil.getString(buffer);
		}
		if (buffer.hasRemaining()) {
			this.vEquipType = IoBufferUtil.getString(buffer);
		}
		if (buffer.hasRemaining()) {
			this.dActionTime = IoBufferUtil.getString(buffer);
		}
	}

	// @Override
	public int getType() {

		return 10008;
	}

	// @Override
	public String getFileName() {
		return LogNameUtil.getLogName(this.getClass().getSimpleName());
	}

	// @Override
	public String getUpdateSql() {
		return "insert into loginLog values(" + iEventId + "," + serverId + ","
				+ iUserId + "," + "'" + vAccount + "'" + "," + iUserLv + ","
				+ "'" + vUUid + "'" + "," + "'" + vClientIp + "'" + "," + "'"
				+ vEquipType + "'" + "," + "'" + dActionTime + "'" + ")";
	}

	// @Override
	public String getCreateTableSql() {
		return "create table loginLog (iEventId bigint(20) comment '事件id', serverId int(11) comment'服务器id',iUserId int(11) comment'用户id',vAccount varchar(45) comment'帐号',iUserLv int(11) comment'用户等级',vUUid varchar(45) comment'设备id',vClientIp varchar(45) comment'ip地址',vEquipType varchar(45) comment'设备类型',dActionTime timestamp comment'发生时间',primary key(iUserId, serverId, iEventId))ENGINE=MyISAM DEFAULT CHARSET=utf8;";
	}

	// @Override
	public String getFileContent() {
		return LogFileUtil.convertObjects2String(serverId, iUserId, vAccount,
				iUserLv, vUUid, vClientIp, vEquipType, dActionTime);
	}

	public List<Object> list() {
		List<Object> list = new ArrayList<Object>();
		list.add(iEventId);
		list.add(serverId);
		list.add(iUserId);
		list.add(vAccount);
		list.add(iUserLv);
		list.add(vUUid);
		list.add(vClientIp);
		list.add(vEquipType);
		list.add(dActionTime);
		return list;
	}

}