package pt.ipbeja.diogopm.aula10;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

import pt.ipbeja.diogopm.aula10.data.Note;
import pt.ipbeja.diogopm.aula10.data.NoteDatabase;

public class NotesApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseFirestore instance = FirebaseFirestore.getInstance();
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setPersistenceEnabled(false)
                .build();
        instance.setFirestoreSettings(settings);


        SharedPreferences prefs = getSharedPreferences("app_prefs", Context.MODE_PRIVATE);
        boolean firstTime = prefs.getBoolean("firstTime", true);
        if(firstTime){
            prefs.edit().putBoolean("firstTime", false).apply();


            FirebaseFirestore.getInstance()
                    .collection("notes")
                    .get()
                    .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                        @Override
                        public void onSuccess(QuerySnapshot snap) {
                           final List<Note> notes = snap.toObjects(Note.class);
                            new Thread(){

                            }.start();
                        }
                    });
        }

    }


}
