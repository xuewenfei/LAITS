/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package amt.data;

/**
 *
 * @author helenchavez
 */
public class DecisionTreeNode {
  private String label;
  private String answer;

  public DecisionTreeNode(){
    label="";
    answer="";
  }

  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  @Override
  public String toString(){
    return this.label;
  }
}
