package br.com.up.zap.adapter;

import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import br.com.up.zap.adapter.MessageAdapter;
//import br.com.up.zap.model.Message;

public class MessageAdapter extends
        RecyclerView.Adapter<MessageAdapter.MessageViewHolder>{

    private ArrayList<Message> messages;

    public MessageAdapter(ArrayList<Message> messages){
        this.messages = messages;
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View layout = inflater.inflate(R.layout.view_item_message, parent, false);
        return new MessageViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder,
                                 int position) {

        Message message = messages.get(position);

        TextView textViewMensagem = holder.itemView.findViewById(R.id.text_mensagem);
        TextView textViewNumero = holder.itemView.findViewById(R.id.text_numero);
        TextView textViewAnexo = holder.itemView.findViewById(R.id.text_anexo);

        textViewMensagem.setText(message.mensagem());
        textViewNumero.setText(message.numero());
        textViewAnexo.setText(message.getAnexo());

    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public static class MessageViewHolder
            extends RecyclerView.ViewHolder{

        public MessageViewHolder(View view){
            super(view);
        }
    }
}
