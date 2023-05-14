db.createUser(
        {
            roles: [
                {
                    role: "readWrite",
                    db: "to-do-db"
                }
            ]
        }
);