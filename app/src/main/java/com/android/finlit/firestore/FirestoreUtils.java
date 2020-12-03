package com.android.finlit.firestore;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class FirestoreUtils {
    FirebaseFirestore db;

    public FirestoreUtils(){
        db =  FirebaseFirestore.getInstance();
    }

    public Task uploadUserData(FirebaseUser firebaseUser){
        Map<String,Object> user = new HashMap<>();

        user.put("UID",String.valueOf(firebaseUser.getUid()));
        user.put("full name",firebaseUser.getDisplayName());
        user.put("phone number",firebaseUser.getPhoneNumber());
        user.put("profile url",firebaseUser.getPhotoUrl().toString());
        user.put("email",firebaseUser.getEmail());

        Task uploadTask = db.collection("users").document(firebaseUser.getUid())
                .set(user);

        return uploadTask;

    }

}
