package com.mail;

import org.assertj.core.util.Lists;

public class SenderTest {

    public static void main(String args[]) {
        Sender sender = new Sender();

        SenderDto dto = SenderDto.builder()
                .from("hyojinpark.world@gmail.com")
                .to(Lists.newArrayList("d8003062@gmail.com"))
                .subject("테스트")
                .content("안녕하세요")
                .build();


        sender.send(dto);
    }
}
