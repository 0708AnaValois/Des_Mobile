package br.com.up.zap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import br.com.up.listapresentesprof.R;
import br.com.up.zap.model.Message;
import br.com.up.zap.repository.MessageRepository;

public class AddMessageActivity extends AppCompatActivity {

    private TextInputLayout inputLayoutNumero;
    private TextInputLayout inputLayoutMensagem;
    private TextInputLayout inputLayoutAnexo;

    private TextInputEditText inputTextNumero;
    private TextInputEditText inputTextMensagem;
    private TextInputEditText inputTextAnexo;

    private Button buttonAddMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_message);

        inputLayoutNumero = findViewById(R.id.input_layout_numero);
        inputLayoutMensagem = findViewById(R.id.input_layout_mensagem);
        inputLayoutAnexo = findViewById(R.id.input_layout_anexo);

        inputTextNumero = findViewById(R.id.input_text_numero);
        inputTextMensagem = findViewById(R.id.input_text_mensagem);
        inputTextAnexo = findViewById(R.id.input_text_anexo);

        buttonAddMessage = findViewById(R.id.button_add_message);

        buttonAddMessage.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveMessage();
            }
        });
    }

    private void saveMessage(){

        String giftName = inputTextNumero.getText().toString();
        String name = inputTextMensagem.getText().toString();
        String description = inputTextAnexo.getText().toString();

        if(giftName.isEmpty()){
            inputLayoutNumero
                    .setError("Favor inserir o número");
            return;
        }

        if(name.isEmpty()){
            inputLayoutMensagem
                    .setError("Favor inserir a mensagem");
            return;
        }

        Message gift = new Message(
                mensagem,
                numero,
                anexo
        );

        MessageRepository.getInstance().save(gift);

        onBackPressed();
    }
}