package game.players;

import static game.players.Generals.Gender.FEMALE;
import static game.players.Generals.Gender.MALE;
import static game.players.Generals.Nationality.*;

/**
 * Created by Ashsandra on 12/20/17.
 */
public abstract class Generals {
  Integer maxHp;
  Gender gender;
  Nationality nationality;

  enum Nationality {
    WEI,
    SHU,
    WU,
    QUN
  }

  enum Gender {
    FEMALE,
    MALE
  }

  Generals (int maxHp, Gender gender, Nationality nationality){
    this.maxHp = maxHp;
    this.gender = gender;
    this.nationality = nationality;
  }



}

class yueYing extends Generals {
  public yueYing () {
    super(3, FEMALE,SHU);
  }
}

class guanYu extends Generals {
  public guanYu () {
    super(4,MALE,SHU);
  }
}

class zhangFei extends Generals {
  public zhangFei () {
    super (4,MALE,SHU);
  }

}

class zhugeLiang extends Generals {
  public zhugeLiang () {
    super (3, MALE, SHU);
  }
}

class liuBei extends Generals {
  public liuBei () {
    super (4, MALE,SHU);
  }

}

class maChao extends Generals {
  public maChao () {
    super(4,MALE,SHU);
  }
}

class zhaoYun extends Generals {
  public zhaoYun (){
    super (4, MALE,SHU);
  }
}

class sunQuan extends Generals {
  public sunQuan () {
    super(4,MALE,WU);
  }
}

class sunShangXiang extends Generals {
  public sunShangXiang(){
    super(3,FEMALE,WU);
  }
}

class ganNing extends Generals {
  public ganNing () {
    super(4,MALE,WU);
  }

}

class huangGai extends Generals {
  public huangGai () {
    super(4,MALE,WU);
  }
}

class luXun extends Generals {
  public luXun () {
    super(4,MALE,WU);
  }
}

class lvMeng extends Generals {
  public lvMeng () {
    super(4,MALE,WU);
  }
}

class zhouYu extends Generals {
  public zhouYu () {
    super(3,MALE,WU);
  }
}

class guoJia extends Generals {
  public guoJia () {
    super(3,MALE,WEI);
  }

}

class zhenJi extends Generals {
  public zhenJi () {
    super(3,FEMALE,WEI);
  }
}

class caoCao extends Generals {
  public caoCao () {
    super (4,MALE,WEI);
  }

}

class siMaYi extends Generals {
  public siMaYi() {
    super(3,MALE,WEI);
  }
}

class xiaHouDun extends Generals {
  public xiaHouDun() {
    super(4,MALE,WEI);
  }

}

class zhangLiao extends Generals {
  public zhangLiao(){
    super(4,MALE,WEI);
  }
}

class xuChu extends Generals {
  public xuChu(){
    super(4,MALE,WEI);
  }

}

class lvBu extends Generals {
  public lvBu(){
    super(4,MALE,QUN);
  }
}

class diaoChan extends Generals {
  public diaoChan(){
    super(3,FEMALE,QUN);
  }
}