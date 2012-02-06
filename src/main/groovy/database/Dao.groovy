package database

import groovy.sql.Sql

class Dao {
    Sql db
    
    List findAll() {
        db.rows("select name from languages")
    }
}
