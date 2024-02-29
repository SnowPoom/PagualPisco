/*
|-------------------------------------|
| © 2024 EPN-FIS, All rights reserved |
| christian.pisco@epn.edu.ec          |
|-------------------------------------|
Autor: Christian Pisco
Fecha: 17 - 02 - 2024
Script: Interfaz Data Access Object
*/

package DataAccess;

import java.util.List;

public interface IDAO<T> {
    public boolean create(T entity)   throws Exception;
    public List<T> readAll()          throws Exception;
    public T readBy(Integer id)       throws Exception;
    public boolean update(T entity)   throws Exception;
    public boolean delete(Integer id) throws Exception;
    public int getMaxId()             throws Exception;
}
