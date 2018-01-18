/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blok.AbstractFactory;
/**
 *
 * @author aluno
 */
public interface IThemeFactory {
    public IBackGround createBackGround();
    public IGround createGround();
    public IBrick createBrick();
    public ISound createSound();  
    public IPlayer createPlayer();
}