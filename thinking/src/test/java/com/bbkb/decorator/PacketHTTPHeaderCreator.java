package com.bbkb.decorator;

/**
 * 项目名称:car
 * 功能说明:
 * 系统版本:v1.0
 * JDK版本:JDK 1.7
 * 开发人员:sujj@bababus.com<br>
 * 开发时间:2016/11/22<br>
 */
public class PacketHTTPHeaderCreator extends PacketDecorator{
    public PacketHTTPHeaderCreator(IPacketCreator packetCreator) {
        super(packetCreator);
    }

    @Override
    public String handleContent() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Cache-Control:no-cache\n");
        stringBuffer.append("Date:Mon,31Dec201204:25:57GMT\n");
        stringBuffer.append(packetCreator.handleContent());
        return stringBuffer.toString();
    }
}
