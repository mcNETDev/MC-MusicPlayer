package de.tisan.mcoref.communication;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import io.netty.buffer.ByteBuf;
import net.minecraft.nbt.NBTTagCompound;

public class ClientToServerMessage implements IMessage {
	private NBTTagCompound tag;

	public ClientToServerMessage() {

	}

	public ClientToServerMessage(NBTTagCompound tag) {
		this.tag = tag;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		tag = ByteBufUtils.readTag(buf);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeTag(buf, tag);
	}

	public NBTTagCompound getTag() {
		return tag;
	}

}
