package ro.sapi.retrofitstudents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tv = (TextView)findViewById(R.id.textView);
        final TextView program_id = (TextView)findViewById(R.id.program_id);
        final TextView name = (TextView)findViewById(R.id.name);
        final TextView email = (TextView)findViewById(R.id.email);
        final TextView status = (TextView)findViewById(R.id.status);
        final EditText editID   = (EditText)findViewById(R.id.editText);
        final EditText editName   = (EditText)findViewById(R.id.editName);
        final EditText editProgram   = (EditText)findViewById(R.id.editProgram);
        final EditText editEmail   = (EditText)findViewById(R.id.editEmail);

        final Button getButton = (Button)findViewById(R.id.buttonGet);
        final Button deleteButton = (Button) findViewById(R.id.buttonDelete);
        final Button addButton = (Button) findViewById(R.id.addStudent);


        final APIService service = RetrofitClient.getRetrofitInstance().create(APIService.class);


        getButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<Student> call = service.getStudent(Integer.parseInt(editID.getText().toString()));
                call.enqueue(new Callback<Student>() {
                    @Override
                    public void onResponse(Call<Student> call, Response<Student> response) {
                        Student std = response.body();
                        name.setText(std.getName());
                        email.setText(std.getEmail());
                        Log.d("student", std.getName());
                    }

                    @Override
                    public void onFailure(Call<Student> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Call<Student> call = service.deleteStudentWithID(Integer.parseInt(editID.getText().toString()));
              call.enqueue(new Callback<Student>() {
                  @Override
                  public void onResponse(Call<Student> call, Response<Student> response) {
                      Toast.makeText(MainActivity.this, "Sikeres torles!", Toast.LENGTH_SHORT).show();
                  }

                  @Override
                  public void onFailure(Call<Student> call, Throwable t) {

                  }
              });
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Call<Student> call = service.createStudent(editName.getText().toString(), editEmail.getText().toString());
            call.enqueue(new Callback<Student>() {
                @Override
                public void onResponse(Call<Student> call, Response<Student> response) {

                }

                @Override
                public void onFailure(Call<Student> call, Throwable t) {

                }
            });
            }
        });
    }
}
