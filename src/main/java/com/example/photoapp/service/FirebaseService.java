package com.example.photoapp.service;

import com.example.photoapp.exceptions.InvalidTokenException;
import com.example.photoapp.model.FirebaseUser;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Service;


import java.io.FileInputStream;
import java.io.IOException;

@Service
public class FirebaseService {

    public FirebaseApp initializeFirebase() throws IOException{

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource resource = resolver.getResource("");

        FileInputStream serviceAccount = new FileInputStream(resource.getFile());

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("")
                .build();

        return FirebaseApp.initializeApp(options);
    }

    public FirebaseUser authenticate(String idToken) throws IOException, InvalidTokenException, FirebaseAuthException {

        String uid = FirebaseAuth.getInstance().verifyIdToken(idToken).getUid();
        String name = FirebaseAuth.getInstance().verifyIdToken(idToken).getName();
        String email = FirebaseAuth.getInstance().verifyIdToken(idToken).getEmail();

        return new FirebaseUser(uid, name, email);
    }
}
