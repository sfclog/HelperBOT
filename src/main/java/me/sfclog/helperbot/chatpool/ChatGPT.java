package me.sfclog.helperbot.chatpool;


import com.plexpt.chatgpt.entity.chat.ChatCompletion;
import com.plexpt.chatgpt.entity.chat.ChatCompletionResponse;
import com.plexpt.chatgpt.entity.chat.Message;
import me.sfclog.helperbot.Main;
import me.sfclog.helperbot.trainer.TrainerGPT;


import java.util.ArrayList;
import java.util.List;

public class ChatGPT {

    public static String send_msg(List<Message> data) {
        List<Message> cache = new ArrayList<>();
        //huán luyện trả lời
        cache.addAll(TrainerGPT.getAll());
        //tin nhắn
        cache.addAll(data);
        ChatCompletion chatCompletion = ChatCompletion.builder()
                .model(ChatCompletion.Model.GPT_3_5_TURBO.getName())
                .messages(cache)
                .temperature(0.9)
                .build();
        ChatCompletionResponse response = Main.chatGPT.chatCompletion(chatCompletion);
        Message res = response.getChoices().get(0).getMessage();
        return res.getContent();

    }


}