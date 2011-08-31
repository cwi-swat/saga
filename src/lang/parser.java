package org.rascalmpl.java.parser.object;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.eclipse.imp.pdb.facts.type.TypeFactory;
import org.eclipse.imp.pdb.facts.IConstructor;
import org.eclipse.imp.pdb.facts.IValue;
import org.eclipse.imp.pdb.facts.exceptions.FactTypeUseException;
import org.eclipse.imp.pdb.facts.io.StandardTextReader;
import org.rascalmpl.parser.gtd.stack.*;
import org.rascalmpl.parser.gtd.stack.filter.*;
import org.rascalmpl.parser.gtd.stack.filter.follow.*;
import org.rascalmpl.parser.gtd.stack.filter.match.*;
import org.rascalmpl.parser.gtd.stack.filter.precede.*;
import org.rascalmpl.parser.gtd.util.IntegerKeyedHashMap;
import org.rascalmpl.parser.gtd.util.IntegerList;
import org.rascalmpl.parser.gtd.util.IntegerMap;
import org.rascalmpl.values.uptr.Factory;

public class Generator extends org.rascalmpl.library.lang.rascal.syntax.RascalRascal {
  
  private static final IntegerMap _resultStoreIdMappings;
  private static final IntegerKeyedHashMap<IntegerList> _dontNest;
	
  protected static void _putDontNest(IntegerKeyedHashMap<IntegerList> result, int parentId, int childId) {
    IntegerList donts = result.get(childId);
    if (donts == null) {
      donts = new IntegerList();
      result.put(childId, donts);
    }
    donts.add(parentId);
  }
    
  protected int getResultStoreId(int parentId) {
    return _resultStoreIdMappings.get(parentId);
  }
    
  protected static IntegerKeyedHashMap<IntegerList> _initDontNest() {
    IntegerKeyedHashMap<IntegerList> result = org.rascalmpl.library.lang.rascal.syntax.RascalRascal._initDontNest(); 
    
    
    _putDontNest(result, 738, 1008);
    _putDontNest(result, 888, 748);
    _putDontNest(result, 880, 868);
    _putDontNest(result, 910, 918);
    _putDontNest(result, 930, 938);
    _putDontNest(result, 918, 958);
    _putDontNest(result, 970, 978);
    _putDontNest(result, 830, 806);
    _putDontNest(result, 978, 1018);
    _putDontNest(result, 928, 948);
    _putDontNest(result, 920, 908);
    _putDontNest(result, 968, 988);
    _putDontNest(result, 870, 878);
    _putDontNest(result, 784, 772);
    _putDontNest(result, 918, 1028);
    _putDontNest(result, 736, 998);
    _putDontNest(result, 754, 1008);
    _putDontNest(result, 890, 754);
    _putDontNest(result, 838, 766);
    _putDontNest(result, 878, 742);
    _putDontNest(result, 940, 928);
    _putDontNest(result, 1020, 1008);
    _putDontNest(result, 980, 968);
    _putDontNest(result, 860, 848);
    _putDontNest(result, 900, 1030);
    _putDontNest(result, 720, 998);
    _putDontNest(result, 898, 938);
    _putDontNest(result, 1010, 1018);
    _putDontNest(result, 838, 878);
    _putDontNest(result, 1000, 988);
    _putDontNest(result, 848, 868);
    _putDontNest(result, 950, 958);
    _putDontNest(result, 990, 998);
    _putDontNest(result, 948, 1030);
    _putDontNest(result, 950, 1028);
    _putDontNest(result, 1028, 806);
    _putDontNest(result, 868, 760);
    _putDontNest(result, 840, 748);
    _putDontNest(result, 858, 754);
    _putDontNest(result, 870, 766);
    _putDontNest(result, 908, 928);
    _putDontNest(result, 938, 898);
    _putDontNest(result, 988, 1008);
    _putDontNest(result, 828, 784);
    _putDontNest(result, 878, 838);
    _putDontNest(result, 868, 888);
    _putDontNest(result, 1018, 978);
    _putDontNest(result, 754, 928);
    _putDontNest(result, 830, 742);
    _putDontNest(result, 900, 968);
    _putDontNest(result, 940, 1008);
    _putDontNest(result, 1020, 928);
    _putDontNest(result, 848, 772);
    _putDontNest(result, 806, 878);
    _putDontNest(result, 980, 1030);
    _putDontNest(result, 1028, 838);
    _putDontNest(result, 738, 928);
    _putDontNest(result, 720, 918);
    _putDontNest(result, 766, 948);
    _putDontNest(result, 772, 760);
    _putDontNest(result, 860, 784);
    _putDontNest(result, 1010, 938);
    _putDontNest(result, 888, 828);
    _putDontNest(result, 990, 918);
    _putDontNest(result, 968, 908);
    _putDontNest(result, 920, 988);
    _putDontNest(result, 1008, 948);
    _putDontNest(result, 898, 1018);
    _putDontNest(result, 970, 898);
    _putDontNest(result, 850, 778);
    _putDontNest(result, 772, 888);
    _putDontNest(result, 878, 806);
    _putDontNest(result, 1028, 754);
    _putDontNest(result, 736, 918);
    _putDontNest(result, 760, 958);
    _putDontNest(result, 778, 754);
    _putDontNest(result, 784, 868);
    _putDontNest(result, 960, 948);
    _putDontNest(result, 1018, 898);
    _putDontNest(result, 830, 838);
    _putDontNest(result, 938, 978);
    _putDontNest(result, 908, 1008);
    _putDontNest(result, 850, 858);
    _putDontNest(result, 988, 928);
    _putDontNest(result, 840, 828);
    _putDontNest(result, 880, 772);
    _putDontNest(result, 744, 958);
    _putDontNest(result, 698, 968);
    _putDontNest(result, 806, 766);
    _putDontNest(result, 1000, 908);
    _putDontNest(result, 828, 848);
    _putDontNest(result, 930, 1018);
    _putDontNest(result, 998, 958);
    _putDontNest(result, 948, 968);
    _putDontNest(result, 978, 938);
    _putDontNest(result, 910, 998);
    _putDontNest(result, 998, 1028);
    _putDontNest(result, 1028, 918);
    _putDontNest(result, 1008, 742);
    _putDontNest(result, 766, 868);
    _putDontNest(result, 720, 838);
    _putDontNest(result, 744, 878);
    _putDontNest(result, 760, 748);
    _putDontNest(result, 766, 742);
    _putDontNest(result, 908, 784);
    _putDontNest(result, 980, 888);
    _putDontNest(result, 898, 778);
    _putDontNest(result, 990, 838);
    _putDontNest(result, 840, 988);
    _putDontNest(result, 998, 878);
    _putDontNest(result, 828, 928);
    _putDontNest(result, 1008, 868);
    _putDontNest(result, 850, 1018);
    _putDontNest(result, 784, 1028);
    _putDontNest(result, 970, 760);
    _putDontNest(result, 998, 748);
    _putDontNest(result, 968, 766);
    _putDontNest(result, 760, 878);
    _putDontNest(result, 744, 748);
    _putDontNest(result, 858, 978);
    _putDontNest(result, 930, 858);
    _putDontNest(result, 988, 848);
    _putDontNest(result, 778, 898);
    _putDontNest(result, 878, 998);
    _putDontNest(result, 1018, 760);
    _putDontNest(result, 738, 848);
    _putDontNest(result, 930, 778);
    _putDontNest(result, 940, 784);
    _putDontNest(result, 868, 968);
    _putDontNest(result, 1000, 766);
    _putDontNest(result, 980, 754);
    _putDontNest(result, 960, 742);
    _putDontNest(result, 736, 838);
    _putDontNest(result, 754, 848);
    _putDontNest(result, 928, 772);
    _putDontNest(result, 960, 868);
    _putDontNest(result, 910, 806);
    _putDontNest(result, 830, 918);
    _putDontNest(result, 784, 948);
    _putDontNest(result, 860, 1008);
    _putDontNest(result, 1020, 848);
    _putDontNest(result, 898, 858);
    _putDontNest(result, 920, 828);
    _putDontNest(result, 888, 988);
    _putDontNest(result, 890, 978);
    _putDontNest(result, 806, 958);
    _putDontNest(result, 950, 748);
    _putDontNest(result, 920, 766);
    _putDontNest(result, 778, 978);
    _putDontNest(result, 858, 898);
    _putDontNest(result, 1010, 858);
    _putDontNest(result, 908, 848);
    _putDontNest(result, 772, 968);
    _putDontNest(result, 830, 998);
    _putDontNest(result, 1000, 828);
    _putDontNest(result, 850, 1030);
    _putDontNest(result, 848, 1028);
    _putDontNest(result, 948, 754);
    _putDontNest(result, 928, 742);
    _putDontNest(result, 736, 806);
    _putDontNest(result, 698, 754);
    _putDontNest(result, 828, 1008);
    _putDontNest(result, 928, 868);
    _putDontNest(result, 910, 838);
    _putDontNest(result, 880, 948);
    _putDontNest(result, 840, 908);
    _putDontNest(result, 838, 958);
    _putDontNest(result, 950, 878);
    _putDontNest(result, 900, 888);
    _putDontNest(result, 960, 772);
    _putDontNest(result, 988, 784);
    _putDontNest(result, 978, 778);
    _putDontNest(result, 918, 748);
    _putDontNest(result, 900, 754);
    _putDontNest(result, 766, 772);
    _putDontNest(result, 698, 888);
    _putDontNest(result, 720, 806);
    _putDontNest(result, 738, 784);
    _putDontNest(result, 878, 918);
    _putDontNest(result, 990, 806);
    _putDontNest(result, 940, 848);
    _putDontNest(result, 860, 928);
    _putDontNest(result, 888, 908);
    _putDontNest(result, 890, 898);
    _putDontNest(result, 948, 888);
    _putDontNest(result, 968, 828);
    _putDontNest(result, 1008, 772);
    _putDontNest(result, 978, 858);
    _putDontNest(result, 880, 1028);
    _putDontNest(result, 1028, 998);
    _putDontNest(result, 938, 760);
    _putDontNest(result, 754, 784);
    _putDontNest(result, 1020, 784);
    _putDontNest(result, 1010, 778);
    _putDontNest(result, 848, 948);
    _putDontNest(result, 870, 958);
    _putDontNest(result, 850, 938);
    _putDontNest(result, 918, 878);
    _putDontNest(result, 1028, 784);
    _putDontNest(result, 754, 998);
    _putDontNest(result, 736, 1008);
    _putDontNest(result, 880, 742);
    _putDontNest(result, 868, 754);
    _putDontNest(result, 858, 760);
    _putDontNest(result, 1008, 998);
    _putDontNest(result, 806, 828);
    _putDontNest(result, 848, 838);
    _putDontNest(result, 988, 1018);
    _putDontNest(result, 828, 858);
    _putDontNest(result, 858, 888);
    _putDontNest(result, 920, 958);
    _putDontNest(result, 918, 908);
    _putDontNest(result, 940, 938);
    _putDontNest(result, 970, 968);
    _putDontNest(result, 738, 998);
    _putDontNest(result, 870, 748);
    _putDontNest(result, 840, 766);
    _putDontNest(result, 930, 928);
    _putDontNest(result, 878, 868);
    _putDontNest(result, 850, 848);
    _putDontNest(result, 1010, 1008);
    _putDontNest(result, 888, 878);
    _putDontNest(result, 900, 898);
    _putDontNest(result, 980, 978);
    _putDontNest(result, 898, 1030);
    _putDontNest(result, 698, 958);
    _putDontNest(result, 744, 968);
    _putDontNest(result, 766, 1018);
    _putDontNest(result, 888, 766);
    _putDontNest(result, 848, 742);
    _putDontNest(result, 890, 760);
    _putDontNest(result, 948, 898);
    _putDontNest(result, 1020, 1018);
    _putDontNest(result, 910, 948);
    _putDontNest(result, 840, 878);
    _putDontNest(result, 830, 772);
    _putDontNest(result, 890, 888);
    _putDontNest(result, 998, 988);
    _putDontNest(result, 908, 938);
    _putDontNest(result, 950, 908);
    _putDontNest(result, 784, 806);
    _putDontNest(result, 928, 918);
    _putDontNest(result, 880, 838);
    _putDontNest(result, 720, 1008);
    _putDontNest(result, 760, 968);
    _putDontNest(result, 838, 748);
    _putDontNest(result, 1018, 968);
    _putDontNest(result, 978, 1008);
    _putDontNest(result, 828, 778);
    _putDontNest(result, 960, 998);
    _putDontNest(result, 898, 928);
    _putDontNest(result, 930, 1030);
    _putDontNest(result, 928, 1028);
    _putDontNest(result, 1028, 848);
    _putDontNest(result, 960, 918);
    _putDontNest(result, 870, 828);
    _putDontNest(result, 930, 1008);
    _putDontNest(result, 830, 868);
    _putDontNest(result, 784, 838);
    _putDontNest(result, 980, 898);
    _putDontNest(result, 1010, 928);
    _putDontNest(result, 900, 978);
    _putDontNest(result, 880, 806);
    _putDontNest(result, 978, 1030);
    _putDontNest(result, 736, 928);
    _putDontNest(result, 766, 938);
    _putDontNest(result, 806, 748);
    _putDontNest(result, 778, 760);
    _putDontNest(result, 860, 778);
    _putDontNest(result, 968, 958);
    _putDontNest(result, 908, 1018);
    _putDontNest(result, 918, 988);
    _putDontNest(result, 1020, 938);
    _putDontNest(result, 850, 784);
    _putDontNest(result, 778, 888);
    _putDontNest(result, 928, 998);
    _putDontNest(result, 960, 1028);
    _putDontNest(result, 738, 918);
    _putDontNest(result, 720, 928);
    _putDontNest(result, 772, 754);
    _putDontNest(result, 784, 742);
    _putDontNest(result, 838, 828);
    _putDontNest(result, 978, 928);
    _putDontNest(result, 938, 968);
    _putDontNest(result, 898, 1008);
    _putDontNest(result, 848, 806);
    _putDontNest(result, 860, 858);
    _putDontNest(result, 1010, 1030);
    _putDontNest(result, 1008, 1028);
    _putDontNest(result, 1028, 748);
    _putDontNest(result, 754, 918);
    _putDontNest(result, 1000, 958);
    _putDontNest(result, 988, 938);
    _putDontNest(result, 948, 978);
    _putDontNest(result, 878, 772);
    _putDontNest(result, 950, 988);
    _putDontNest(result, 1008, 918);
    _putDontNest(result, 998, 908);
    _putDontNest(result, 990, 948);
    _putDontNest(result, 940, 1018);
    _putDontNest(result, 998, 754);
    _putDontNest(result, 1010, 742);
    _putDontNest(result, 1000, 878);
    _putDontNest(result, 880, 998);
    _putDontNest(result, 908, 778);
    _putDontNest(result, 898, 784);
    _putDontNest(result, 838, 988);
    _putDontNest(result, 860, 1018);
    _putDontNest(result, 784, 1030);
    _putDontNest(result, 968, 760);
    _putDontNest(result, 970, 766);
    _putDontNest(result, 720, 848);
    _putDontNest(result, 736, 742);
    _putDontNest(result, 828, 938);
    _putDontNest(result, 960, 838);
    _putDontNest(result, 910, 772);
    _putDontNest(result, 830, 948);
    _putDontNest(result, 784, 918);
    _putDontNest(result, 928, 806);
    _putDontNest(result, 970, 888);
    _putDontNest(result, 978, 848);
    _putDontNest(result, 940, 858);
    _putDontNest(result, 858, 968);
    _putDontNest(result, 772, 898);
    _putDontNest(result, 950, 828);
    _putDontNest(result, 1028, 1028);
    _putDontNest(result, 978, 742);
    _putDontNest(result, 1018, 766);
    _putDontNest(result, 980, 748);
    _putDontNest(result, 736, 848);
    _putDontNest(result, 754, 838);
    _putDontNest(result, 760, 888);
    _putDontNest(result, 720, 742);
    _putDontNest(result, 760, 766);
    _putDontNest(result, 1018, 888);
    _putDontNest(result, 990, 868);
    _putDontNest(result, 930, 784);
    _putDontNest(result, 868, 978);
    _putDontNest(result, 1008, 838);
    _putDontNest(result, 940, 778);
    _putDontNest(result, 870, 988);
    _putDontNest(result, 968, 878);
    _putDontNest(result, 848, 998);
    _putDontNest(result, 1028, 928);
    _putDontNest(result, 1000, 760);
    _putDontNest(result, 738, 838);
    _putDontNest(result, 744, 888);
    _putDontNest(result, 744, 766);
    _putDontNest(result, 908, 858);
    _putDontNest(result, 890, 968);
    _putDontNest(result, 918, 828);
    _putDontNest(result, 806, 908);
    _putDontNest(result, 850, 1008);
    _putDontNest(result, 1010, 848);
    _putDontNest(result, 948, 748);
    _putDontNest(result, 920, 760);
    _putDontNest(result, 754, 806);
    _putDontNest(result, 766, 858);
    _putDontNest(result, 990, 772);
    _putDontNest(result, 778, 968);
    _putDontNest(result, 898, 848);
    _putDontNest(result, 1008, 806);
    _putDontNest(result, 878, 948);
    _putDontNest(result, 998, 828);
    _putDontNest(result, 1020, 858);
    _putDontNest(result, 772, 978);
    _putDontNest(result, 848, 1030);
    _putDontNest(result, 850, 1028);
    _putDontNest(result, 950, 754);
    _putDontNest(result, 930, 742);
    _putDontNest(result, 698, 878);
    _putDontNest(result, 738, 806);
    _putDontNest(result, 720, 784);
    _putDontNest(result, 840, 958);
    _putDontNest(result, 988, 778);
    _putDontNest(result, 978, 784);
    _putDontNest(result, 848, 918);
    _putDontNest(result, 838, 908);
    _putDontNest(result, 1028, 1008);
    _putDontNest(result, 736, 784);
    _putDontNest(result, 698, 760);
    _putDontNest(result, 850, 928);
    _putDontNest(result, 806, 988);
    _putDontNest(result, 828, 1018);
    _putDontNest(result, 988, 858);
    _putDontNest(result, 930, 848);
    _putDontNest(result, 888, 958);
    _putDontNest(result, 784, 998);
    _putDontNest(result, 880, 1030);
    _putDontNest(result, 938, 766);
    _putDontNest(result, 918, 754);
    _putDontNest(result, 898, 742);
    _putDontNest(result, 900, 748);
    _putDontNest(result, 766, 778);
    _putDontNest(result, 960, 806);
    _putDontNest(result, 928, 838);
    _putDontNest(result, 910, 868);
    _putDontNest(result, 868, 898);
    _putDontNest(result, 1020, 778);
    _putDontNest(result, 1010, 784);
    _putDontNest(result, 920, 878);
    _putDontNest(result, 870, 908);
    _putDontNest(result, 938, 888);
    _putDontNest(result, 860, 938);
    _putDontNest(result, 880, 918);
    _putDontNest(result, 858, 766);
    _putDontNest(result, 870, 754);
    _putDontNest(result, 850, 838);
    _putDontNest(result, 918, 898);
    _putDontNest(result, 898, 918);
    _putDontNest(result, 990, 1018);
    _putDontNest(result, 940, 948);
    _putDontNest(result, 968, 968);
    _putDontNest(result, 830, 858);
    _putDontNest(result, 1010, 998);
    _putDontNest(result, 1028, 778);
    _putDontNest(result, 698, 948);
    _putDontNest(result, 720, 978);
    _putDontNest(result, 840, 760);
    _putDontNest(result, 868, 748);
    _putDontNest(result, 840, 888);
    _putDontNest(result, 1008, 1008);
    _putDontNest(result, 928, 928);
    _putDontNest(result, 890, 878);
    _putDontNest(result, 980, 988);
    _putDontNest(result, 848, 848);
    _putDontNest(result, 900, 908);
    _putDontNest(result, 784, 784);
    _putDontNest(result, 898, 1028);
    _putDontNest(result, 738, 988);
    _putDontNest(result, 736, 978);
    _putDontNest(result, 760, 1018);
    _putDontNest(result, 850, 742);
    _putDontNest(result, 890, 766);
    _putDontNest(result, 888, 760);
    _putDontNest(result, 838, 754);
    _putDontNest(result, 908, 948);
    _putDontNest(result, 960, 1008);
    _putDontNest(result, 888, 888);
    _putDontNest(result, 998, 978);
    _putDontNest(result, 772, 828);
    _putDontNest(result, 860, 868);
    _putDontNest(result, 828, 772);
    _putDontNest(result, 978, 998);
    _putDontNest(result, 948, 908);
    _putDontNest(result, 910, 938);
    _putDontNest(result, 930, 918);
    _putDontNest(result, 1000, 968);
    _putDontNest(result, 950, 898);
    _putDontNest(result, 744, 1018);
    _putDontNest(result, 754, 988);
    _putDontNest(result, 766, 968);
    _putDontNest(result, 938, 958);
    _putDontNest(result, 858, 878);
    _putDontNest(result, 880, 848);
    _putDontNest(result, 830, 778);
    _putDontNest(result, 928, 1030);
    _putDontNest(result, 930, 1028);
    _putDontNest(result, 1028, 858);
    _putDontNest(result, 720, 898);
    _putDontNest(result, 744, 938);
    _putDontNest(result, 806, 754);
    _putDontNest(result, 860, 772);
    _putDontNest(result, 900, 988);
    _putDontNest(result, 928, 1008);
    _putDontNest(result, 1008, 928);
    _putDontNest(result, 980, 908);
    _putDontNest(result, 828, 868);
    _putDontNest(result, 868, 828);
    _putDontNest(result, 978, 1028);
    _putDontNest(result, 720, 1028);
    _putDontNest(result, 760, 938);
    _putDontNest(result, 778, 766);
    _putDontNest(result, 878, 858);
    _putDontNest(result, 970, 958);
    _putDontNest(result, 920, 968);
    _putDontNest(result, 784, 848);
    _putDontNest(result, 930, 998);
    _putDontNest(result, 978, 918);
    _putDontNest(result, 848, 784);
    _putDontNest(result, 1020, 948);
    _putDontNest(result, 910, 1018);
    _putDontNest(result, 918, 978);
    _putDontNest(result, 960, 1030);
    _putDontNest(result, 754, 908);
    _putDontNest(result, 850, 806);
    _putDontNest(result, 1018, 958);
    _putDontNest(result, 778, 878);
    _putDontNest(result, 878, 778);
    _putDontNest(result, 1008, 1030);
    _putDontNest(result, 1010, 1028);
    _putDontNest(result, 754, 1030);
    _putDontNest(result, 1028, 742);
    _putDontNest(result, 738, 908);
    _putDontNest(result, 736, 898);
    _putDontNest(result, 772, 748);
    _putDontNest(result, 950, 978);
    _putDontNest(result, 988, 948);
    _putDontNest(result, 960, 928);
    _putDontNest(result, 880, 784);
    _putDontNest(result, 898, 998);
    _putDontNest(result, 948, 988);
    _putDontNest(result, 998, 898);
    _putDontNest(result, 990, 938);
    _putDontNest(result, 1010, 918);
    _putDontNest(result, 738, 1030);
    _putDontNest(result, 736, 1028);
    _putDontNest(result, 988, 766);
    _putDontNest(result, 990, 760);
    _putDontNest(result, 1010, 748);
    _putDontNest(result, 754, 742);
    _putDontNest(result, 838, 978);
    _putDontNest(result, 978, 838);
    _putDontNest(result, 960, 848);
    _putDontNest(result, 840, 968);
    _putDontNest(result, 910, 778);
    _putDontNest(result, 1020, 868);
    _putDontNest(result, 1008, 754);
    _putDontNest(result, 738, 742);
    _putDontNest(result, 772, 908);
    _putDontNest(result, 880, 1008);
    _putDontNest(result, 908, 772);
    _putDontNest(result, 1018, 878);
    _putDontNest(result, 830, 938);
    _putDontNest(result, 930, 806);
    _putDontNest(result, 948, 828);
    _putDontNest(result, 968, 888);
    _putDontNest(result, 828, 948);
    _putDontNest(result, 778, 958);
    _putDontNest(result, 1028, 1030);
    _putDontNest(result, 960, 754);
    _putDontNest(result, 978, 748);
    _putDontNest(result, 980, 742);
    _putDontNest(result, 1020, 766);
    _putDontNest(result, 766, 888);
    _putDontNest(result, 698, 772);
    _putDontNest(result, 760, 760);
    _putDontNest(result, 970, 878);
    _putDontNest(result, 900, 828);
    _putDontNest(result, 784, 928);
    _putDontNest(result, 870, 978);
    _putDontNest(result, 928, 784);
    _putDontNest(result, 850, 998);
    _putDontNest(result, 1010, 838);
    _putDontNest(result, 868, 988);
    _putDontNest(result, 988, 868);
    _putDontNest(result, 830, 1030);
    _putDontNest(result, 828, 1028);
    _putDontNest(result, 1028, 938);
    _putDontNest(result, 744, 760);
    _putDontNest(result, 1000, 888);
    _putDontNest(result, 806, 898);
    _putDontNest(result, 888, 968);
    _putDontNest(result, 848, 1008);
    _putDontNest(result, 940, 772);
    _putDontNest(result, 898, 806);
    _putDontNest(result, 910, 858);
    _putDontNest(result, 1008, 848);
    _putDontNest(result, 878, 1018);
    _putDontNest(result, 928, 754);
    _putDontNest(result, 948, 742);
    _putDontNest(result, 760, 858);
    _putDontNest(result, 698, 868);
    _putDontNest(result, 738, 828);
    _putDontNest(result, 988, 772);
    _putDontNest(result, 858, 958);
    _putDontNest(result, 938, 878);
    _putDontNest(result, 960, 784);
    _putDontNest(result, 878, 938);
    _putDontNest(result, 880, 928);
    _putDontNest(result, 920, 888);
    _putDontNest(result, 772, 988);
    _putDontNest(result, 1010, 806);
    _putDontNest(result, 860, 1028);
    _putDontNest(result, 910, 760);
    _putDontNest(result, 908, 766);
    _putDontNest(result, 930, 748);
    _putDontNest(result, 744, 858);
    _putDontNest(result, 754, 828);
    _putDontNest(result, 898, 838);
    _putDontNest(result, 850, 918);
    _putDontNest(result, 838, 898);
    _putDontNest(result, 940, 868);
    _putDontNest(result, 990, 778);
    _putDontNest(result, 1028, 1018);
    _putDontNest(result, 744, 778);
    _putDontNest(result, 698, 766);
    _putDontNest(result, 830, 1018);
    _putDontNest(result, 806, 978);
    _putDontNest(result, 890, 958);
    _putDontNest(result, 928, 848);
    _putDontNest(result, 848, 928);
    _putDontNest(result, 978, 806);
    _putDontNest(result, 990, 858);
    _putDontNest(result, 1020, 772);
    _putDontNest(result, 898, 748);
    _putDontNest(result, 940, 766);
    _putDontNest(result, 900, 742);
    _putDontNest(result, 760, 778);
    _putDontNest(result, 868, 908);
    _putDontNest(result, 860, 948);
    _putDontNest(result, 908, 868);
    _putDontNest(result, 784, 1008);
    _putDontNest(result, 980, 828);
    _putDontNest(result, 1008, 784);
    _putDontNest(result, 930, 838);
    _putDontNest(result, 870, 898);
    _putDontNest(result, 878, 1030);
    _putDontNest(result, 860, 766);
    _putDontNest(result, 998, 1008);
    _putDontNest(result, 950, 928);
    _putDontNest(result, 938, 948);
    _putDontNest(result, 890, 868);
    _putDontNest(result, 960, 978);
    _putDontNest(result, 838, 848);
    _putDontNest(result, 900, 918);
    _putDontNest(result, 698, 938);
    _putDontNest(result, 720, 988);
    _putDontNest(result, 868, 742);
    _putDontNest(result, 880, 754);
    _putDontNest(result, 990, 968);
    _putDontNest(result, 898, 908);
    _putDontNest(result, 778, 772);
    _putDontNest(result, 908, 958);
    _putDontNest(result, 968, 1018);
    _putDontNest(result, 978, 988);
    _putDontNest(result, 908, 1028);
    _putDontNest(result, 910, 1030);
    _putDontNest(result, 1028, 772);
    _putDontNest(result, 738, 978);
    _putDontNest(result, 736, 988);
    _putDontNest(result, 850, 748);
    _putDontNest(result, 806, 784);
    _putDontNest(result, 870, 848);
    _putDontNest(result, 918, 928);
    _putDontNest(result, 858, 868);
    _putDontNest(result, 980, 998);
    _putDontNest(result, 754, 978);
    _putDontNest(result, 848, 754);
    _putDontNest(result, 878, 760);
    _putDontNest(result, 878, 888);
    _putDontNest(result, 1010, 988);
    _putDontNest(result, 928, 898);
    _putDontNest(result, 868, 838);
    _putDontNest(result, 948, 918);
    _putDontNest(result, 1008, 978);
    _putDontNest(result, 772, 806);
    _putDontNest(result, 860, 878);
    _putDontNest(result, 920, 938);
    _putDontNest(result, 940, 958);
    _putDontNest(result, 930, 908);
    _putDontNest(result, 1000, 1018);
    _putDontNest(result, 940, 1028);
    _putDontNest(result, 720, 908);
    _putDontNest(result, 744, 948);
    _putDontNest(result, 988, 958);
    _putDontNest(result, 888, 858);
    _putDontNest(result, 858, 772);
    _putDontNest(result, 978, 908);
    _putDontNest(result, 838, 784);
    _putDontNest(result, 1000, 938);
    _putDontNest(result, 898, 988);
    _putDontNest(result, 920, 1018);
    _putDontNest(result, 840, 778);
    _putDontNest(result, 910, 968);
    _putDontNest(result, 948, 998);
    _putDontNest(result, 990, 1030);
    _putDontNest(result, 988, 1028);
    _putDontNest(result, 720, 1030);
    _putDontNest(result, 760, 948);
    _putDontNest(result, 772, 838);
    _putDontNest(result, 998, 928);
    _putDontNest(result, 1018, 948);
    _putDontNest(result, 960, 898);
    _putDontNest(result, 950, 1008);
    _putDontNest(result, 868, 806);
    _putDontNest(result, 980, 918);
    _putDontNest(result, 828, 878);
    _putDontNest(result, 766, 958);
    _putDontNest(result, 698, 1018);
    _putDontNest(result, 754, 898);
    _putDontNest(result, 830, 760);
    _putDontNest(result, 828, 766);
    _putDontNest(result, 1020, 958);
    _putDontNest(result, 830, 888);
    _putDontNest(result, 970, 948);
    _putDontNest(result, 930, 988);
    _putDontNest(result, 1008, 898);
    _putDontNest(result, 806, 848);
    _putDontNest(result, 928, 978);
    _putDontNest(result, 1010, 908);
    _putDontNest(result, 968, 938);
    _putDontNest(result, 890, 772);
    _putDontNest(result, 870, 784);
    _putDontNest(result, 1020, 1028);
    _putDontNest(result, 754, 1028);
    _putDontNest(result, 738, 898);
    _putDontNest(result, 736, 908);
    _putDontNest(result, 772, 742);
    _putDontNest(result, 784, 754);
    _putDontNest(result, 888, 778);
    _putDontNest(result, 918, 1008);
    _putDontNest(result, 840, 858);
    _putDontNest(result, 900, 998);
    _putDontNest(result, 850, 828);
    _putDontNest(result, 778, 868);
    _putDontNest(result, 736, 1030);
    _putDontNest(result, 738, 1028);
    _putDontNest(result, 1028, 868);
    _putDontNest(result, 988, 760);
    _putDontNest(result, 1008, 748);
    _putDontNest(result, 990, 766);
    _putDontNest(result, 698, 858);
    _putDontNest(result, 760, 868);
    _putDontNest(result, 754, 748);
    _putDontNest(result, 736, 754);
    _putDontNest(result, 784, 898);
    _putDontNest(result, 990, 888);
    _putDontNest(result, 948, 806);
    _putDontNest(result, 930, 828);
    _putDontNest(result, 870, 1008);
    _putDontNest(result, 1018, 868);
    _putDontNest(result, 772, 918);
    _putDontNest(result, 980, 838);
    _putDontNest(result, 1010, 754);
    _putDontNest(result, 998, 742);
    _putDontNest(result, 766, 878);
    _putDontNest(result, 744, 868);
    _putDontNest(result, 738, 748);
    _putDontNest(result, 918, 784);
    _putDontNest(result, 868, 998);
    _putDontNest(result, 840, 1018);
    _putDontNest(result, 848, 978);
    _putDontNest(result, 850, 988);
    _putDontNest(result, 920, 778);
    _putDontNest(result, 806, 928);
    _putDontNest(result, 1020, 878);
    _putDontNest(result, 1020, 760);
    _putDontNest(result, 766, 760);
    _putDontNest(result, 998, 848);
    _putDontNest(result, 888, 1018);
    _putDontNest(result, 838, 1008);
    _putDontNest(result, 898, 828);
    _putDontNest(result, 828, 958);
    _putDontNest(result, 778, 948);
    _putDontNest(result, 920, 858);
    _putDontNest(result, 878, 968);
    _putDontNest(result, 828, 1030);
    _putDontNest(result, 830, 1028);
    _putDontNest(result, 1028, 948);
    _putDontNest(result, 960, 748);
    _putDontNest(result, 978, 754);
    _putDontNest(result, 698, 778);
    _putDontNest(result, 720, 754);
    _putDontNest(result, 900, 806);
    _putDontNest(result, 938, 772);
    _putDontNest(result, 988, 878);
    _putDontNest(result, 970, 868);
    _putDontNest(result, 950, 784);
    _putDontNest(result, 880, 978);
    _putDontNest(result, 930, 754);
    _putDontNest(result, 950, 742);
    _putDontNest(result, 736, 828);
    _putDontNest(result, 860, 958);
    _putDontNest(result, 850, 908);
    _putDontNest(result, 848, 898);
    _putDontNest(result, 940, 878);
    _putDontNest(result, 806, 1008);
    _putDontNest(result, 968, 778);
    _putDontNest(result, 860, 1030);
    _putDontNest(result, 928, 748);
    _putDontNest(result, 908, 760);
    _putDontNest(result, 910, 766);
    _putDontNest(result, 918, 848);
    _putDontNest(result, 1000, 858);
    _putDontNest(result, 890, 948);
    _putDontNest(result, 870, 928);
    _putDontNest(result, 970, 772);
    _putDontNest(result, 888, 938);
    _putDontNest(result, 938, 868);
    _putDontNest(result, 910, 888);
    _putDontNest(result, 1010, 828);
    _putDontNest(result, 900, 838);
    _putDontNest(result, 784, 978);
    _putDontNest(result, 898, 754);
    _putDontNest(result, 918, 742);
    _putDontNest(result, 760, 772);
    _putDontNest(result, 948, 838);
    _putDontNest(result, 908, 878);
    _putDontNest(result, 998, 784);
    _putDontNest(result, 880, 898);
    _putDontNest(result, 840, 938);
    _putDontNest(result, 1018, 772);
    _putDontNest(result, 980, 806);
    _putDontNest(result, 868, 918);
    _putDontNest(result, 1000, 778);
    _putDontNest(result, 940, 760);
    _putDontNest(result, 744, 772);
    _putDontNest(result, 720, 828);
    _putDontNest(result, 950, 848);
    _putDontNest(result, 838, 928);
    _putDontNest(result, 978, 828);
    _putDontNest(result, 830, 968);
    _putDontNest(result, 968, 858);
    _putDontNest(result, 858, 948);
    _putDontNest(result, 772, 998);
    _putDontNest(result, 878, 1028);
    _putDontNest(result, 860, 760);
    _putDontNest(result, 880, 748);
    _putDontNest(result, 860, 888);
    _putDontNest(result, 938, 938);
    _putDontNest(result, 948, 928);
    _putDontNest(result, 772, 784);
    _putDontNest(result, 960, 988);
    _putDontNest(result, 878, 878);
    _putDontNest(result, 778, 778);
    _putDontNest(result, 888, 868);
    _putDontNest(result, 698, 928);
    _putDontNest(result, 760, 998);
    _putDontNest(result, 870, 742);
    _putDontNest(result, 918, 918);
    _putDontNest(result, 898, 898);
    _putDontNest(result, 838, 838);
    _putDontNest(result, 978, 978);
    _putDontNest(result, 806, 806);
    _putDontNest(result, 988, 968);
    _putDontNest(result, 970, 1018);
    _putDontNest(result, 998, 998);
    _putDontNest(result, 910, 958);
    _putDontNest(result, 910, 1028);
    _putDontNest(result, 908, 1030);
    _putDontNest(result, 744, 998);
    _putDontNest(result, 848, 748);
    _putDontNest(result, 1018, 1018);
    _putDontNest(result, 868, 848);
    _putDontNest(result, 738, 968);
    _putDontNest(result, 838, 742);
    _putDontNest(result, 878, 766);
    _putDontNest(result, 850, 754);
    _putDontNest(result, 840, 868);
    _putDontNest(result, 1020, 968);
    _putDontNest(result, 980, 1008);
    _putDontNest(result, 778, 858);
    _putDontNest(result, 930, 898);
    _putDontNest(result, 1008, 988);
    _putDontNest(result, 870, 838);
    _putDontNest(result, 920, 948);
    _putDontNest(result, 784, 828);
    _putDontNest(result, 928, 908);
    _putDontNest(result, 1010, 978);
    _putDontNest(result, 950, 918);
    _putDontNest(result, 900, 928);
    _putDontNest(result, 940, 1030);
    _putDontNest(result, 766, 988);
    _putDontNest(result, 754, 968);
    _putDontNest(result, 1000, 948);
    _putDontNest(result, 908, 968);
    _putDontNest(result, 890, 858);
    _putDontNest(result, 772, 848);
    _putDontNest(result, 978, 898);
    _putDontNest(result, 898, 978);
    _putDontNest(result, 950, 998);
    _putDontNest(result, 990, 958);
    _putDontNest(result, 990, 1028);
    _putDontNest(result, 988, 1030);
    _putDontNest(result, 720, 958);
    _putDontNest(result, 806, 742);
    _putDontNest(result, 880, 828);
    _putDontNest(result, 960, 908);
    _putDontNest(result, 870, 806);
    _putDontNest(result, 830, 878);
    _putDontNest(result, 948, 1008);
    _putDontNest(result, 1018, 938);
    _putDontNest(result, 858, 778);
    _putDontNest(result, 840, 772);
    _putDontNest(result, 698, 1008);
    _putDontNest(result, 830, 766);
    _putDontNest(result, 784, 748);
    _putDontNest(result, 828, 760);
    _putDontNest(result, 900, 1008);
    _putDontNest(result, 968, 948);
    _putDontNest(result, 970, 938);
    _putDontNest(result, 980, 928);
    _putDontNest(result, 1010, 898);
    _putDontNest(result, 998, 918);
    _putDontNest(result, 928, 988);
    _putDontNest(result, 940, 968);
    _putDontNest(result, 858, 858);
    _putDontNest(result, 828, 888);
    _putDontNest(result, 888, 772);
    _putDontNest(result, 918, 998);
    _putDontNest(result, 868, 784);
    _putDontNest(result, 930, 978);
    _putDontNest(result, 1008, 908);
    _putDontNest(result, 1020, 1030);
    _putDontNest(result, 766, 1030);
    _putDontNest(result, 1028, 878);
    _putDontNest(result, 766, 908);
    _putDontNest(result, 744, 918);
    _putDontNest(result, 890, 778);
    _putDontNest(result, 848, 828);
    _putDontNest(result, 938, 1018);
    _putDontNest(result, 806, 838);
    _putDontNest(result, 838, 806);
    _putDontNest(result, 736, 958);
    _putDontNest(result, 760, 918);
    _putDontNest(result, 738, 754);
    _putDontNest(result, 868, 1008);
    _putDontNest(result, 920, 772);
    _putDontNest(result, 784, 908);
    _putDontNest(result, 950, 806);
    _putDontNest(result, 900, 784);
    _putDontNest(result, 988, 888);
    _putDontNest(result, 858, 1018);
    _putDontNest(result, 928, 828);
    _putDontNest(result, 978, 760);
    _putDontNest(result, 736, 878);
    _putDontNest(result, 754, 754);
    _putDontNest(result, 736, 748);
    _putDontNest(result, 870, 998);
    _putDontNest(result, 850, 978);
    _putDontNest(result, 1000, 868);
    _putDontNest(result, 848, 988);
    _putDontNest(result, 938, 858);
    _putDontNest(result, 860, 968);
    _putDontNest(result, 980, 848);
    _putDontNest(result, 778, 1030);
    _putDontNest(result, 1028, 958);
    _putDontNest(result, 1020, 754);
    _putDontNest(result, 1000, 742);
    _putDontNest(result, 960, 766);
    _putDontNest(result, 720, 748);
    _putDontNest(result, 766, 766);
    _putDontNest(result, 778, 938);
    _putDontNest(result, 1020, 888);
    _putDontNest(result, 918, 806);
    _putDontNest(result, 830, 958);
    _putDontNest(result, 890, 1018);
    _putDontNest(result, 938, 778);
    _putDontNest(result, 806, 918);
    _putDontNest(result, 1008, 766);
    _putDontNest(result, 990, 748);
    _putDontNest(result, 1010, 760);
    _putDontNest(result, 754, 888);
    _putDontNest(result, 760, 838);
    _putDontNest(result, 990, 878);
    _putDontNest(result, 838, 998);
    _putDontNest(result, 772, 928);
    _putDontNest(result, 948, 784);
    _putDontNest(result, 968, 868);
    _putDontNest(result, 998, 838);
    _putDontNest(result, 880, 988);
    _putDontNest(result, 988, 754);
    _putDontNest(result, 968, 742);
    _putDontNest(result, 744, 838);
    _putDontNest(result, 698, 784);
    _putDontNest(result, 720, 878);
    _putDontNest(result, 738, 888);
    _putDontNest(result, 900, 848);
    _putDontNest(result, 918, 838);
    _putDontNest(result, 970, 778);
    _putDontNest(result, 838, 918);
    _putDontNest(result, 850, 898);
    _putDontNest(result, 1018, 858);
    _putDontNest(result, 848, 908);
    _putDontNest(result, 858, 1030);
    _putDontNest(result, 940, 754);
    _putDontNest(result, 760, 806);
    _putDontNest(result, 778, 1018);
    _putDontNest(result, 784, 988);
    _putDontNest(result, 806, 998);
    _putDontNest(result, 908, 888);
    _putDontNest(result, 1008, 828);
    _putDontNest(result, 890, 938);
    _putDontNest(result, 980, 784);
    _putDontNest(result, 888, 948);
    _putDontNest(result, 868, 928);
    _putDontNest(result, 968, 772);
    _putDontNest(result, 998, 806);
    _putDontNest(result, 840, 1028);
    _putDontNest(result, 898, 760);
    _putDontNest(result, 766, 828);
    _putDontNest(result, 744, 806);
    _putDontNest(result, 910, 878);
    _putDontNest(result, 870, 918);
    _putDontNest(result, 920, 868);
    _putDontNest(result, 840, 948);
    _putDontNest(result, 950, 838);
    _putDontNest(result, 772, 1008);
    _putDontNest(result, 880, 908);
    _putDontNest(result, 960, 828);
    _putDontNest(result, 888, 1028);
    _putDontNest(result, 890, 1030);
    _putDontNest(result, 908, 754);
    _putDontNest(result, 920, 742);
    _putDontNest(result, 1000, 772);
    _putDontNest(result, 858, 938);
    _putDontNest(result, 1018, 778);
    _putDontNest(result, 828, 968);
    _putDontNest(result, 948, 848);
    _putDontNest(result, 878, 958);
    _putDontNest(result, 970, 858);
    _putDontNest(result, 940, 888);
    _putDontNest(result, 928, 766);
    _putDontNest(result, 910, 748);
    _putDontNest(result, 930, 760);
    _putDontNest(result, 698, 848);
    _putDontNest(result, 920, 1028);
    _putDontNest(result, 744, 1008);
    _putDontNest(result, 848, 766);
    _putDontNest(result, 850, 760);
    _putDontNest(result, 888, 742);
    _putDontNest(result, 980, 1018);
    _putDontNest(result, 778, 784);
    _putDontNest(result, 772, 778);
    _putDontNest(result, 850, 888);
    _putDontNest(result, 720, 968);
    _putDontNest(result, 760, 1008);
    _putDontNest(result, 878, 748);
    _putDontNest(result, 990, 988);
    _putDontNest(result, 1018, 1008);
    _putDontNest(result, 880, 878);
    _putDontNest(result, 948, 938);
    _putDontNest(result, 950, 948);
    _putDontNest(result, 920, 918);
    _putDontNest(result, 858, 848);
    _putDontNest(result, 840, 838);
    _putDontNest(result, 988, 978);
    _putDontNest(result, 910, 908);
    _putDontNest(result, 978, 968);
    _putDontNest(result, 908, 898);
    _putDontNest(result, 830, 828);
    _putDontNest(result, 938, 928);
    _putDontNest(result, 1000, 998);
    _putDontNest(result, 870, 868);
    _putDontNest(result, 736, 968);
    _putDontNest(result, 880, 766);
    _putDontNest(result, 900, 938);
    _putDontNest(result, 888, 838);
    _putDontNest(result, 970, 1008);
    _putDontNest(result, 938, 1030);
    _putDontNest(result, 698, 918);
    _putDontNest(result, 766, 978);
    _putDontNest(result, 840, 742);
    _putDontNest(result, 860, 754);
    _putDontNest(result, 848, 878);
    _putDontNest(result, 968, 998);
    _putDontNest(result, 772, 858);
    _putDontNest(result, 890, 848);
    _putDontNest(result, 940, 898);
    _putDontNest(result, 918, 948);
    _putDontNest(result, 1010, 968);
    _putDontNest(result, 806, 772);
    _putDontNest(result, 1020, 978);
    _putDontNest(result, 838, 868);
    _putDontNest(result, 928, 958);
    _putDontNest(result, 760, 928);
    _putDontNest(result, 698, 998);
    _putDontNest(result, 784, 766);
    _putDontNest(result, 830, 748);
    _putDontNest(result, 988, 898);
    _putDontNest(result, 910, 988);
    _putDontNest(result, 888, 806);
    _putDontNest(result, 898, 968);
    _putDontNest(result, 778, 848);
    _putDontNest(result, 938, 1008);
    _putDontNest(result, 990, 908);
    _putDontNest(result, 998, 948);
    _putDontNest(result, 1018, 928);
    _putDontNest(result, 968, 918);
    _putDontNest(result, 908, 978);
    _putDontNest(result, 878, 828);
    _putDontNest(result, 970, 1030);
    _putDontNest(result, 968, 1028);
    _putDontNest(result, 1028, 888);
    _putDontNest(result, 744, 928);
    _putDontNest(result, 828, 754);
    _putDontNest(result, 858, 784);
    _putDontNest(result, 960, 958);
    _putDontNest(result, 900, 1018);
    _putDontNest(result, 868, 858);
    _putDontNest(result, 806, 868);
    _putDontNest(result, 838, 772);
    _putDontNest(result, 1018, 1030);
    _putDontNest(result, 766, 1028);
    _putDontNest(result, 766, 898);
    _putDontNest(result, 754, 958);
    _putDontNest(result, 940, 978);
    _putDontNest(result, 1008, 958);
    _putDontNest(result, 920, 998);
    _putDontNest(result, 1000, 918);
    _putDontNest(result, 948, 1018);
    _putDontNest(result, 930, 968);
    _putDontNest(result, 1020, 898);
    _putDontNest(result, 868, 778);
    _putDontNest(result, 1000, 1028);
    _putDontNest(result, 738, 958);
    _putDontNest(result, 890, 784);
    _putDontNest(result, 970, 928);
    _putDontNest(result, 980, 938);
    _putDontNest(result, 870, 772);
    _putDontNest(result, 784, 878);
    _putDontNest(result, 840, 806);
    _putDontNest(result, 978, 766);
    _putDontNest(result, 1018, 742);
    _putDontNest(result, 1020, 748);
    _putDontNest(result, 720, 888);
    _putDontNest(result, 698, 806);
    _putDontNest(result, 738, 878);
    _putDontNest(result, 720, 766);
    _putDontNest(result, 766, 748);
    _putDontNest(result, 760, 742);
    _putDontNest(result, 784, 958);
    _putDontNest(result, 888, 998);
    _putDontNest(result, 918, 772);
    _putDontNest(result, 948, 858);
    _putDontNest(result, 900, 778);
    _putDontNest(result, 806, 948);
    _putDontNest(result, 978, 888);
    _putDontNest(result, 970, 848);
    _putDontNest(result, 778, 1028);
    _putDontNest(result, 960, 760);
    _putDontNest(result, 754, 878);
    _putDontNest(result, 744, 742);
    _putDontNest(result, 860, 978);
    _putDontNest(result, 890, 1008);
    _putDontNest(result, 998, 868);
    _putDontNest(result, 968, 838);
    _putDontNest(result, 1008, 878);
    _putDontNest(result, 850, 968);
    _putDontNest(result, 1010, 766);
    _putDontNest(result, 1008, 760);
    _putDontNest(result, 988, 748);
    _putDontNest(result, 744, 848);
    _putDontNest(result, 754, 760);
    _putDontNest(result, 878, 988);
    _putDontNest(result, 960, 878);
    _putDontNest(result, 772, 938);
    _putDontNest(result, 830, 908);
    _putDontNest(result, 920, 806);
    _putDontNest(result, 1010, 888);
    _putDontNest(result, 828, 898);
    _putDontNest(result, 938, 784);
    _putDontNest(result, 910, 828);
    _putDontNest(result, 950, 772);
    _putDontNest(result, 970, 742);
    _putDontNest(result, 990, 754);
    _putDontNest(result, 760, 848);
    _putDontNest(result, 736, 888);
    _putDontNest(result, 738, 760);
    _putDontNest(result, 736, 766);
    _putDontNest(result, 778, 928);
    _putDontNest(result, 1018, 848);
    _putDontNest(result, 900, 858);
    _putDontNest(result, 858, 1008);
    _putDontNest(result, 948, 778);
    _putDontNest(result, 1000, 838);
    _putDontNest(result, 840, 998);
    _putDontNest(result, 868, 1018);
    _putDontNest(result, 858, 1028);
    _putDontNest(result, 1028, 968);
    _putDontNest(result, 890, 928);
    _putDontNest(result, 848, 958);
    _putDontNest(result, 950, 868);
    _putDontNest(result, 920, 838);
    _putDontNest(result, 970, 784);
    _putDontNest(result, 840, 918);
    _putDontNest(result, 928, 878);
    _putDontNest(result, 868, 938);
    _putDontNest(result, 860, 898);
    _putDontNest(result, 870, 948);
    _putDontNest(result, 840, 1030);
    _putDontNest(result, 940, 748);
    _putDontNest(result, 898, 766);
    _putDontNest(result, 938, 742);
    _putDontNest(result, 772, 1018);
    _putDontNest(result, 980, 778);
    _putDontNest(result, 1000, 806);
    _putDontNest(result, 898, 888);
    _putDontNest(result, 888, 1030);
    _putDontNest(result, 890, 1028);
    _putDontNest(result, 910, 754);
    _putDontNest(result, 744, 784);
    _putDontNest(result, 698, 838);
    _putDontNest(result, 858, 928);
    _putDontNest(result, 980, 858);
    _putDontNest(result, 918, 868);
    _putDontNest(result, 938, 848);
    _putDontNest(result, 880, 958);
    _putDontNest(result, 838, 948);
    _putDontNest(result, 778, 1008);
    _putDontNest(result, 908, 748);
    _putDontNest(result, 928, 760);
    _putDontNest(result, 930, 766);
    _putDontNest(result, 760, 784);
    _putDontNest(result, 1018, 784);
    _putDontNest(result, 990, 828);
    _putDontNest(result, 930, 888);
    _putDontNest(result, 998, 772);
    _putDontNest(result, 828, 978);
    _putDontNest(result, 878, 908);
    _putDontNest(result, 830, 988);
    _putDontNest(result, 968, 806);
    _putDontNest(result, 888, 918);
    _putDontNest(result, 920, 1030);
    _putDontNest(result, 720, 1018);
    _putDontNest(result, 848, 760);
    _putDontNest(result, 878, 754);
    _putDontNest(result, 850, 766);
    _putDontNest(result, 890, 742);
    _putDontNest(result, 1018, 998);
    _putDontNest(result, 840, 848);
    _putDontNest(result, 1000, 1008);
    _putDontNest(result, 848, 888);
    _putDontNest(result, 858, 838);
    _putDontNest(result, 960, 968);
    _putDontNest(result, 766, 1008);
    _putDontNest(result, 828, 828);
    _putDontNest(result, 868, 868);
    _putDontNest(result, 950, 938);
    _putDontNest(result, 990, 978);
    _putDontNest(result, 772, 772);
    _putDontNest(result, 908, 908);
    _putDontNest(result, 988, 988);
    _putDontNest(result, 910, 898);
    _putDontNest(result, 948, 948);
    _putDontNest(result, 898, 958);
    _putDontNest(result, 806, 858);
    _putDontNest(result, 698, 1030);
    _putDontNest(result, 698, 908);
    _putDontNest(result, 744, 978);
    _putDontNest(result, 860, 748);
    _putDontNest(result, 858, 742);
    _putDontNest(result, 880, 760);
    _putDontNest(result, 920, 928);
    _putDontNest(result, 968, 1008);
    _putDontNest(result, 880, 888);
    _putDontNest(result, 938, 918);
    _putDontNest(result, 900, 948);
    _putDontNest(result, 890, 838);
    _putDontNest(result, 806, 778);
    _putDontNest(result, 938, 1028);
    _putDontNest(result, 760, 978);
    _putDontNest(result, 736, 1018);
    _putDontNest(result, 888, 848);
    _putDontNest(result, 1008, 968);
    _putDontNest(result, 930, 958);
    _putDontNest(result, 778, 806);
    _putDontNest(result, 1020, 988);
    _putDontNest(result, 918, 938);
    _putDontNest(result, 850, 878);
    _putDontNest(result, 998, 1018);
    _putDontNest(result, 970, 998);
    _putDontNest(result, 940, 908);
    _putDontNest(result, 736, 938);
    _putDontNest(result, 766, 928);
    _putDontNest(result, 738, 948);
    _putDontNest(result, 784, 760);
    _putDontNest(result, 828, 748);
    _putDontNest(result, 970, 918);
    _putDontNest(result, 840, 784);
    _putDontNest(result, 918, 1018);
    _putDontNest(result, 988, 908);
    _putDontNest(result, 910, 978);
    _putDontNest(result, 908, 988);
    _putDontNest(result, 978, 958);
    _putDontNest(result, 998, 938);
    _putDontNest(result, 838, 778);
    _putDontNest(result, 990, 898);
    _putDontNest(result, 890, 806);
    _putDontNest(result, 784, 888);
    _putDontNest(result, 970, 1028);
    _putDontNest(result, 968, 1030);
    _putDontNest(result, 1028, 766);
    _putDontNest(result, 754, 948);
    _putDontNest(result, 830, 754);
    _putDontNest(result, 938, 998);
    _putDontNest(result, 1000, 928);
    _putDontNest(result, 870, 858);
    _putDontNest(result, 778, 838);
    _putDontNest(result, 1018, 1028);
    _putDontNest(result, 760, 1028);
    _putDontNest(result, 760, 898);
    _putDontNest(result, 1010, 958);
    _putDontNest(result, 940, 988);
    _putDontNest(result, 870, 778);
    _putDontNest(result, 858, 806);
    _putDontNest(result, 928, 968);
    _putDontNest(result, 1020, 908);
    _putDontNest(result, 950, 1018);
    _putDontNest(result, 1000, 1030);
    _putDontNest(result, 744, 1028);
    _putDontNest(result, 698, 988);
    _putDontNest(result, 744, 898);
    _putDontNest(result, 720, 938);
    _putDontNest(result, 778, 742);
    _putDontNest(result, 1018, 918);
    _putDontNest(result, 980, 948);
    _putDontNest(result, 772, 868);
    _putDontNest(result, 860, 828);
    _putDontNest(result, 838, 858);
    _putDontNest(result, 920, 1008);
    _putDontNest(result, 868, 772);
    _putDontNest(result, 968, 928);
    _putDontNest(result, 888, 784);
    _putDontNest(result, 980, 766);
    _putDontNest(result, 1000, 754);
    _putDontNest(result, 1020, 742);
    _putDontNest(result, 1018, 748);
    _putDontNest(result, 754, 868);
    _putDontNest(result, 720, 760);
    _putDontNest(result, 950, 858);
    _putDontNest(result, 806, 938);
    _putDontNest(result, 940, 828);
    _putDontNest(result, 890, 998);
    _putDontNest(result, 968, 848);
    _putDontNest(result, 778, 918);
    _putDontNest(result, 1028, 898);
    _putDontNest(result, 698, 828);
    _putDontNest(result, 738, 868);
    _putDontNest(result, 766, 754);
    _putDontNest(result, 848, 968);
    _putDontNest(result, 918, 778);
    _putDontNest(result, 1010, 878);
    _putDontNest(result, 970, 838);
    _putDontNest(result, 938, 806);
    _putDontNest(result, 960, 888);
    _putDontNest(result, 900, 772);
    _putDontNest(result, 920, 784);
    _putDontNest(result, 860, 988);
    _putDontNest(result, 888, 1008);
    _putDontNest(result, 838, 1018);
    _putDontNest(result, 772, 1028);
    _putDontNest(result, 988, 742);
    _putDontNest(result, 968, 754);
    _putDontNest(result, 754, 766);
    _putDontNest(result, 830, 898);
    _putDontNest(result, 878, 978);
    _putDontNest(result, 948, 772);
    _putDontNest(result, 1018, 838);
    _putDontNest(result, 908, 828);
    _putDontNest(result, 980, 868);
    _putDontNest(result, 1000, 848);
    _putDontNest(result, 840, 1008);
    _putDontNest(result, 1008, 888);
    _putDontNest(result, 772, 948);
    _putDontNest(result, 858, 998);
    _putDontNest(result, 828, 908);
    _putDontNest(result, 918, 858);
    _putDontNest(result, 970, 748);
    _putDontNest(result, 998, 760);
    _putDontNest(result, 766, 848);
    _putDontNest(result, 736, 760);
    _putDontNest(result, 738, 766);
    _putDontNest(result, 950, 778);
    _putDontNest(result, 880, 968);
    _putDontNest(result, 870, 1018);
    _putDontNest(result, 978, 878);
    _putDontNest(result, 806, 1030);
    _putDontNest(result, 1028, 978);
    _putDontNest(result, 918, 760);
    _putDontNest(result, 698, 742);
    _putDontNest(result, 1018, 806);
    _putDontNest(result, 948, 868);
    _putDontNest(result, 860, 908);
    _putDontNest(result, 930, 878);
    _putDontNest(result, 868, 948);
    _putDontNest(result, 968, 784);
    _putDontNest(result, 870, 938);
    _putDontNest(result, 980, 772);
    _putDontNest(result, 888, 928);
    _putDontNest(result, 850, 958);
    _putDontNest(result, 940, 742);
    _putDontNest(result, 900, 766);
    _putDontNest(result, 938, 748);
    _putDontNest(result, 720, 778);
    _putDontNest(result, 736, 858);
    _putDontNest(result, 998, 858);
    _putDontNest(result, 1020, 828);
    _putDontNest(result, 920, 848);
    _putDontNest(result, 858, 918);
    _putDontNest(result, 784, 968);
    _putDontNest(result, 838, 1030);
    _putDontNest(result, 948, 766);
    _putDontNest(result, 950, 760);
    _putDontNest(result, 720, 858);
    _putDontNest(result, 736, 778);
    _putDontNest(result, 754, 772);
    _putDontNest(result, 1000, 784);
    _putDontNest(result, 998, 778);
    _putDontNest(result, 898, 878);
    _putDontNest(result, 838, 938);
    _putDontNest(result, 920, 754);
    _putDontNest(result, 908, 742);
    _putDontNest(result, 738, 772);
    _putDontNest(result, 766, 784);
    _putDontNest(result, 938, 838);
    _putDontNest(result, 840, 928);
    _putDontNest(result, 828, 988);
    _putDontNest(result, 988, 828);
    _putDontNest(result, 928, 888);
    _putDontNest(result, 878, 898);
    _putDontNest(result, 890, 918);
    _putDontNest(result, 778, 998);
    _putDontNest(result, 900, 868);
    _putDontNest(result, 830, 978);
    _putDontNest(result, 806, 1018);
    _putDontNest(result, 970, 806);
    _putDontNest(result, 868, 1028);
    _putDontNest(result, 870, 1030);
    _putDontNest(result, 766, 998);
    _putDontNest(result, 890, 748);
    _putDontNest(result, 828, 806);
    _putDontNest(result, 928, 938);
    _putDontNest(result, 968, 978);
    _putDontNest(result, 1020, 998);
    _putDontNest(result, 908, 918);
    _putDontNest(result, 930, 948);
    _putDontNest(result, 860, 838);
    _putDontNest(result, 970, 988);
    _putDontNest(result, 868, 878);
    _putDontNest(result, 920, 898);
    _putDontNest(result, 918, 1030);
    _putDontNest(result, 888, 754);
    _putDontNest(result, 838, 760);
    _putDontNest(result, 784, 778);
    _putDontNest(result, 900, 958);
    _putDontNest(result, 960, 1018);
    _putDontNest(result, 838, 888);
    _putDontNest(result, 900, 1028);
    _putDontNest(result, 698, 1028);
    _putDontNest(result, 1028, 828);
    _putDontNest(result, 744, 988);
    _putDontNest(result, 754, 1018);
    _putDontNest(result, 698, 898);
    _putDontNest(result, 858, 748);
    _putDontNest(result, 860, 742);
    _putDontNest(result, 840, 754);
    _putDontNest(result, 940, 918);
    _putDontNest(result, 948, 958);
    _putDontNest(result, 1000, 978);
    _putDontNest(result, 778, 828);
    _putDontNest(result, 898, 948);
    _putDontNest(result, 988, 998);
    _putDontNest(result, 850, 868);
    _putDontNest(result, 1008, 1018);
    _putDontNest(result, 784, 858);
    _putDontNest(result, 998, 968);
    _putDontNest(result, 878, 848);
    _putDontNest(result, 948, 1028);
    _putDontNest(result, 950, 1030);
    _putDontNest(result, 760, 988);
    _putDontNest(result, 738, 1018);
    _putDontNest(result, 868, 766);
    _putDontNest(result, 870, 760);
    _putDontNest(result, 938, 908);
    _putDontNest(result, 910, 928);
    _putDontNest(result, 870, 888);
    _putDontNest(result, 990, 1008);
    _putDontNest(result, 830, 784);
    _putDontNest(result, 1018, 988);
    _putDontNest(result, 736, 948);
    _putDontNest(result, 738, 938);
    _putDontNest(result, 828, 742);
    _putDontNest(result, 980, 958);
    _putDontNest(result, 880, 858);
    _putDontNest(result, 850, 772);
    _putDontNest(result, 980, 1028);
    _putDontNest(result, 1028, 760);
    _putDontNest(result, 754, 938);
    _putDontNest(result, 772, 766);
    _putDontNest(result, 1010, 948);
    _putDontNest(result, 970, 908);
    _putDontNest(result, 920, 978);
    _putDontNest(result, 968, 898);
    _putDontNest(result, 988, 918);
    _putDontNest(result, 890, 828);
    _putDontNest(result, 848, 778);
    _putDontNest(result, 918, 968);
    _putDontNest(result, 940, 998);
    _putDontNest(result, 1008, 938);
    _putDontNest(result, 760, 1030);
    _putDontNest(result, 760, 908);
    _putDontNest(result, 878, 784);
    _putDontNest(result, 1018, 908);
    _putDontNest(result, 990, 928);
    _putDontNest(result, 860, 806);
    _putDontNest(result, 938, 988);
    _putDontNest(result, 772, 878);
    _putDontNest(result, 910, 1008);
    _putDontNest(result, 828, 838);
    _putDontNest(result, 848, 858);
    _putDontNest(result, 960, 938);
    _putDontNest(result, 744, 1030);
    _putDontNest(result, 766, 918);
    _putDontNest(result, 720, 948);
    _putDontNest(result, 698, 978);
    _putDontNest(result, 744, 908);
    _putDontNest(result, 778, 748);
    _putDontNest(result, 806, 760);
    _putDontNest(result, 806, 888);
    _putDontNest(result, 1000, 898);
    _putDontNest(result, 880, 778);
    _putDontNest(result, 1020, 918);
    _putDontNest(result, 830, 848);
    _putDontNest(result, 928, 1018);
    _putDontNest(result, 908, 998);
    _putDontNest(result, 858, 828);
    _putDontNest(result, 950, 968);
    _putDontNest(result, 978, 948);
    _putDontNest(result, 998, 1030);
    _putDontNest(result, 980, 760);
    _putDontNest(result, 744, 754);
    _putDontNest(result, 1010, 868);
    _putDontNest(result, 988, 838);
    _putDontNest(result, 830, 928);
    _putDontNest(result, 938, 828);
    _putDontNest(result, 910, 784);
    _putDontNest(result, 848, 1018);
    _putDontNest(result, 878, 1008);
    _putDontNest(result, 840, 978);
    _putDontNest(result, 838, 968);
    _putDontNest(result, 1028, 908);
    _putDontNest(result, 1000, 748);
    _putDontNest(result, 1018, 754);
    _putDontNest(result, 736, 868);
    _putDontNest(result, 760, 754);
    _putDontNest(result, 898, 772);
    _putDontNest(result, 778, 908);
    _putDontNest(result, 772, 958);
    _putDontNest(result, 858, 988);
    _putDontNest(result, 990, 848);
    _putDontNest(result, 940, 806);
    _putDontNest(result, 928, 858);
    _putDontNest(result, 772, 1030);
    _putDontNest(result, 970, 754);
    _putDontNest(result, 990, 742);
    _putDontNest(result, 766, 838);
    _putDontNest(result, 720, 868);
    _putDontNest(result, 870, 968);
    _putDontNest(result, 928, 778);
    _putDontNest(result, 1020, 838);
    _putDontNest(result, 880, 1018);
    _putDontNest(result, 978, 868);
    _putDontNest(result, 860, 998);
    _putDontNest(result, 998, 766);
    _putDontNest(result, 968, 748);
    _putDontNest(result, 828, 918);
    _putDontNest(result, 908, 806);
    _putDontNest(result, 980, 878);
    _putDontNest(result, 890, 988);
    _putDontNest(result, 784, 938);
    _putDontNest(result, 930, 772);
    _putDontNest(result, 998, 888);
    _putDontNest(result, 888, 978);
    _putDontNest(result, 806, 1028);
    _putDontNest(result, 1028, 988);
    _putDontNest(result, 938, 754);
    _putDontNest(result, 918, 766);
    _putDontNest(result, 720, 772);
    _putDontNest(result, 744, 828);
    _putDontNest(result, 766, 806);
    _putDontNest(result, 754, 858);
    _putDontNest(result, 698, 748);
    _putDontNest(result, 918, 888);
    _putDontNest(result, 784, 1018);
    _putDontNest(result, 828, 998);
    _putDontNest(result, 910, 848);
    _putDontNest(result, 960, 778);
    _putDontNest(result, 1020, 806);
    _putDontNest(result, 858, 908);
    _putDontNest(result, 978, 772);
    _putDontNest(result, 1008, 858);
    _putDontNest(result, 778, 988);
    _putDontNest(result, 900, 760);
    _putDontNest(result, 760, 828);
    _putDontNest(result, 738, 858);
    _putDontNest(result, 1018, 828);
    _putDontNest(result, 840, 898);
    _putDontNest(result, 878, 928);
    _putDontNest(result, 880, 938);
    _putDontNest(result, 830, 1008);
    _putDontNest(result, 930, 868);
    _putDontNest(result, 860, 918);
    _putDontNest(result, 908, 838);
    _putDontNest(result, 948, 878);
    _putDontNest(result, 990, 784);
    _putDontNest(result, 838, 1028);
    _putDontNest(result, 948, 760);
    _putDontNest(result, 920, 748);
    _putDontNest(result, 950, 766);
    _putDontNest(result, 738, 778);
    _putDontNest(result, 806, 968);
    _putDontNest(result, 888, 898);
    _putDontNest(result, 988, 806);
    _putDontNest(result, 1010, 772);
    _putDontNest(result, 900, 878);
    _putDontNest(result, 890, 908);
    _putDontNest(result, 970, 828);
    _putDontNest(result, 950, 888);
    _putDontNest(result, 910, 742);
    _putDontNest(result, 754, 778);
    _putDontNest(result, 736, 772);
    _putDontNest(result, 868, 958);
    _putDontNest(result, 940, 838);
    _putDontNest(result, 898, 868);
    _putDontNest(result, 960, 858);
    _putDontNest(result, 1008, 778);
    _putDontNest(result, 850, 948);
    _putDontNest(result, 848, 938);
    _putDontNest(result, 870, 1028);
    _putDontNest(result, 868, 1030);
      
    return result;
  }
    
  protected static IntegerMap _initDontNestGroups() {
    IntegerMap result = org.rascalmpl.library.lang.rascal.syntax.RascalRascal._initDontNestGroups();
    int resultStoreId = result.size();
    
    
    ++resultStoreId;
    
    result.putUnsafe(830, resultStoreId);
    result.putUnsafe(766, resultStoreId);
    result.putUnsafe(828, resultStoreId);
    result.putUnsafe(1020, resultStoreId);
    result.putUnsafe(1018, resultStoreId);
    result.putUnsafe(890, resultStoreId);
    result.putUnsafe(698, resultStoreId);
    result.putUnsafe(760, resultStoreId);
    result.putUnsafe(888, resultStoreId);
    result.putUnsafe(950, resultStoreId);
    result.putUnsafe(948, resultStoreId);
    result.putUnsafe(1010, resultStoreId);
    result.putUnsafe(754, resultStoreId);
    result.putUnsafe(1008, resultStoreId);
    result.putUnsafe(880, resultStoreId);
    result.putUnsafe(878, resultStoreId);
    result.putUnsafe(940, resultStoreId);
    result.putUnsafe(938, resultStoreId);
    result.putUnsafe(744, resultStoreId);
    result.putUnsafe(1000, resultStoreId);
    result.putUnsafe(998, resultStoreId);
    result.putUnsafe(806, resultStoreId);
    result.putUnsafe(870, resultStoreId);
    result.putUnsafe(868, resultStoreId);
    result.putUnsafe(930, resultStoreId);
    result.putUnsafe(738, resultStoreId);
    result.putUnsafe(736, resultStoreId);
    result.putUnsafe(928, resultStoreId);
    result.putUnsafe(990, resultStoreId);
    result.putUnsafe(860, resultStoreId);
    result.putUnsafe(988, resultStoreId);
    result.putUnsafe(858, resultStoreId);
    result.putUnsafe(920, resultStoreId);
    result.putUnsafe(918, resultStoreId);
    result.putUnsafe(980, resultStoreId);
    result.putUnsafe(850, resultStoreId);
    result.putUnsafe(978, resultStoreId);
    result.putUnsafe(720, resultStoreId);
    result.putUnsafe(784, resultStoreId);
    result.putUnsafe(848, resultStoreId);
    result.putUnsafe(910, resultStoreId);
    result.putUnsafe(908, resultStoreId);
    result.putUnsafe(778, resultStoreId);
    result.putUnsafe(970, resultStoreId);
    result.putUnsafe(840, resultStoreId);
    result.putUnsafe(968, resultStoreId);
    result.putUnsafe(838, resultStoreId);
    result.putUnsafe(1028, resultStoreId);
    result.putUnsafe(900, resultStoreId);
    result.putUnsafe(772, resultStoreId);
    result.putUnsafe(898, resultStoreId);
    result.putUnsafe(960, resultStoreId);
      
    return result;
  }
  
  protected boolean hasNestingRestrictions(String name){
		return (_dontNest.size() != 0); // TODO Make more specific.
  }
    
  protected IntegerList getFilteredParents(int childId) {
		return _dontNest.get(childId);
  }
    
  // initialize priorities     
  static {
    _dontNest = _initDontNest();
    _resultStoreIdMappings = _initDontNestGroups();
  }
    
  // Production declarations
	
  private static final IConstructor prod__OctalLongLiteral__char_class___range__48_48_iter__char_class___range__48_55_char_class___range__76_76_range__108_108_ = (IConstructor) _read("prod(lex(\"OctalLongLiteral\"),[\\char-class([range(48,48)]),iter(\\char-class([range(48,55)])),\\char-class([range(76,76),range(108,108)])],{})", Factory.Production);
  private static final IConstructor prod__IdentifierKeywords__conditional__lit_protected__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(keywords(\"IdentifierKeywords\"),[conditional(lit(\"protected\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__IntegralType_NumericType__IntegralType_ = (IConstructor) _read("prod(label(\"IntegralType\",sort(\"NumericType\")),[sort(\"IntegralType\")],{})", Factory.Production);
  private static final IConstructor prod__start__View__layouts_LAYOUTLIST_top_View_layouts_LAYOUTLIST_ = (IConstructor) _read("prod(start(sort(\"View\")),[layouts(\"LAYOUTLIST\"),label(\"top\",sort(\"View\")),layouts(\"LAYOUTLIST\")],{})", Factory.Production);
  private static final IConstructor prod__lit_____char_class___range__45_45_char_class___range__45_45_ = (IConstructor) _read("prod(lit(\"--\"),[\\char-class([range(45,45)]),\\char-class([range(45,45)])],{})", Factory.Production);
  private static final IConstructor prod__incr21_Expression__Expression_layouts_LAYOUTLIST_lit___43_43__tag__NotSupported___112_114_101_102_101_114 = (IConstructor) _read("prod(label(\"incr21\",sort(\"Expression\")),[sort(\"Expression\"),layouts(\"LAYOUTLIST\"),lit(\"++\")],{tag(NotSupported(\"prefer\"))})", Factory.Production);
  private static final IConstructor prod__StatementExpression_Expression__StatementExpression_ = (IConstructor) _read("prod(label(\"StatementExpression\",sort(\"Expression\")),[sort(\"StatementExpression\")],{})", Factory.Production);
  private static final IConstructor regular__iter__char_class___range__117_117 = (IConstructor) _read("regular(iter(\\char-class([range(117,117)])))", Factory.Production);
  private static final IConstructor prod__instanceof_Expression__Expression_layouts_LAYOUTLIST_conditional__lit_instanceof__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_ReferenceType_ = (IConstructor) _read("prod(label(\"instanceof\",sort(\"Expression\")),[sort(\"Expression\"),layouts(\"LAYOUTLIST\"),conditional(lit(\"instanceof\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts(\"LAYOUTLIST\"),sort(\"ReferenceType\")],{})", Factory.Production);
  private static final IConstructor prod__lit_grammar__char_class___range__103_103_char_class___range__114_114_char_class___range__97_97_char_class___range__109_109_char_class___range__109_109_char_class___range__97_97_char_class___range__114_114_ = (IConstructor) _read("prod(lit(\"grammar\"),[\\char-class([range(103,103)]),\\char-class([range(114,114)]),\\char-class([range(97,97)]),\\char-class([range(109,109)]),\\char-class([range(109,109)]),\\char-class([range(97,97)]),\\char-class([range(114,114)])],{})", Factory.Production);
  private static final IConstructor prod__Name_Dim_p_Expression_Expression__lit___40_layouts_LAYOUTLIST_Name_layouts_LAYOUTLIST_iter_seps__Dim__layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_Expression_ = (IConstructor) _read("prod(label(\"Name-Dim-p-Expression\",sort(\"Expression\")),[lit(\"(\"),layouts(\"LAYOUTLIST\"),sort(\"Name\"),layouts(\"LAYOUTLIST\"),\\iter-seps(sort(\"Dim\"),[layouts(\"LAYOUTLIST\")]),layouts(\"LAYOUTLIST\"),lit(\")\"),layouts(\"LAYOUTLIST\"),sort(\"Expression\")],{})", Factory.Production);
  private static final IConstructor prod__lit___45_61__char_class___range__45_45_char_class___range__61_61_ = (IConstructor) _read("prod(lit(\"-=\"),[\\char-class([range(45,45)]),\\char-class([range(61,61)])],{})", Factory.Production);
  private static final IConstructor regular__iter_star__char_class___range__48_57 = (IConstructor) _read("regular(\\iter-star(\\char-class([range(48,57)])))", Factory.Production);
  private static final IConstructor prod__SwitchLabel_p_BlockStatement_p_SwitchBlockStatementGroup__iter_seps__SwitchLabel__layouts_LAYOUTLIST_layouts_LAYOUTLIST_iter_seps__BlockStatement__layouts_LAYOUTLIST_ = (IConstructor) _read("prod(label(\"SwitchLabel-p-BlockStatement-p\",sort(\"SwitchBlockStatementGroup\")),[\\iter-seps(sort(\"SwitchLabel\"),[layouts(\"LAYOUTLIST\")]),layouts(\"LAYOUTLIST\"),\\iter-seps(sort(\"BlockStatement\"),[layouts(\"LAYOUTLIST\")])],{})", Factory.Production);
  private static final IConstructor prod__InterfaceMemberDeclaration_s_InterfaceBody__lit___123_layouts_LAYOUTLIST_iter_star_seps__InterfaceMemberDeclaration__layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___125_ = (IConstructor) _read("prod(label(\"InterfaceMemberDeclaration-s\",sort(\"InterfaceBody\")),[lit(\"{\"),layouts(\"LAYOUTLIST\"),\\iter-star-seps(sort(\"InterfaceMemberDeclaration\"),[layouts(\"LAYOUTLIST\")]),layouts(\"LAYOUTLIST\"),lit(\"}\")],{})", Factory.Production);
  private static final IConstructor prod__IdentifierKeywords__conditional__lit_super__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(keywords(\"IdentifierKeywords\"),[conditional(lit(\"super\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__Name_ClassOrInterfaceType__Name_ = (IConstructor) _read("prod(label(\"Name\",sort(\"ClassOrInterfaceType\")),[sort(\"Name\")],{})", Factory.Production);
  private static final IConstructor prod__FloatingPointLiteral_Literal__conditional__FloatingPointLiteral__not_follow__char_class___range__46_46_range__48_57_range__65_90_range__95_95_range__97_122__tag__NotSupported___112_114_101_102_101_114 = (IConstructor) _read("prod(label(\"FloatingPointLiteral\",sort(\"Literal\")),[conditional(lex(\"FloatingPointLiteral\"),{\\not-follow(\\char-class([range(46,46),range(48,57),range(65,90),range(95,95),range(97,122)]))})],{tag(NotSupported(\"prefer\"))})", Factory.Production);
  private static final IConstructor regular__iter_star_seps__Expression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST = (IConstructor) _read("regular(\\iter-star-seps(sort(\"Expression\"),[layouts(\"LAYOUTLIST\"),lit(\",\"),layouts(\"LAYOUTLIST\")]))", Factory.Production);
  private static final IConstructor prod__lit_int__char_class___range__105_105_char_class___range__110_110_char_class___range__116_116_ = (IConstructor) _read("prod(lit(\"int\"),[\\char-class([range(105,105)]),\\char-class([range(110,110)]),\\char-class([range(116,116)])],{})", Factory.Production);
  private static final IConstructor prod__IdentifierKeywords__conditional__lit_catch__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(keywords(\"IdentifierKeywords\"),[conditional(lit(\"catch\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__IdentifierKeywords__conditional__lit_interface__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(keywords(\"IdentifierKeywords\"),[conditional(lit(\"interface\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__FloatingPointLiteral__iter__char_class___range__48_57_lit___46_iter_star__char_class___range__48_57_opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_char_class___range__70_70_range__102_102_ = (IConstructor) _read("prod(lex(\"FloatingPointLiteral\"),[iter(\\char-class([range(48,57)])),lit(\".\"),\\iter-star(\\char-class([range(48,57)])),opt(seq([\\char-class([range(69,69),range(101,101)]),opt(\\char-class([range(43,43),range(45,45)])),iter(\\char-class([range(48,57)]))])),\\char-class([range(70,70),range(102,102)])],{})", Factory.Production);
  private static final IConstructor regular__opt__char_class___range__68_68_range__100_100 = (IConstructor) _read("regular(opt(\\char-class([range(68,68),range(100,100)])))", Factory.Production);
  private static final IConstructor prod__PrimitiveType_Type__PrimitiveType_ = (IConstructor) _read("prod(label(\"PrimitiveType\",sort(\"Type\")),[sort(\"PrimitiveType\")],{})", Factory.Production);
  private static final IConstructor prod__assignSL_AssignmentOperator__lit___60_60_61_ = (IConstructor) _read("prod(label(\"assignSL\",sort(\"AssignmentOperator\")),[lit(\"\\<\\<=\")],{})", Factory.Production);
  private static final IConstructor prod__IdentifierKeywords__conditional__lit_boolean__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(keywords(\"IdentifierKeywords\"),[conditional(lit(\"boolean\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor regular__iter_star_seps__VariableInitializer__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST = (IConstructor) _read("regular(\\iter-star-seps(sort(\"VariableInitializer\"),[layouts(\"LAYOUTLIST\"),lit(\",\"),layouts(\"LAYOUTLIST\")]))", Factory.Production);
  private static final IConstructor prod__lit_catch__char_class___range__99_99_char_class___range__97_97_char_class___range__116_116_char_class___range__99_99_char_class___range__104_104_ = (IConstructor) _read("prod(lit(\"catch\"),[\\char-class([range(99,99)]),\\char-class([range(97,97)]),\\char-class([range(116,116)]),\\char-class([range(99,99)]),\\char-class([range(104,104)])],{})", Factory.Production);
  private static final IConstructor prod__ANTLR__lit_grammar_layouts_LAYOUTLIST_Identifier_layouts_LAYOUTLIST_lit___59_layouts_LAYOUTLIST_iter_seps__Thing__layouts_LAYOUTLIST_ = (IConstructor) _read("prod(sort(\"ANTLR\"),[lit(\"grammar\"),layouts(\"LAYOUTLIST\"),lex(\"Identifier\"),layouts(\"LAYOUTLIST\"),lit(\";\"),layouts(\"LAYOUTLIST\"),\\iter-seps(sort(\"Thing\"),[layouts(\"LAYOUTLIST\")])],{})", Factory.Production);
  private static final IConstructor prod__MethodDeclaration_ClassMemberDeclaration__MethodDeclaration_ = (IConstructor) _read("prod(label(\"MethodDeclaration\",sort(\"ClassMemberDeclaration\")),[sort(\"MethodDeclaration\")],{})", Factory.Production);
  private static final IConstructor prod__lit_case__char_class___range__99_99_char_class___range__97_97_char_class___range__115_115_char_class___range__101_101_ = (IConstructor) _read("prod(lit(\"case\"),[\\char-class([range(99,99)]),\\char-class([range(97,97)]),\\char-class([range(115,115)]),\\char-class([range(101,101)])],{})", Factory.Production);
  private static final IConstructor prod__SingleTypeImportDeclaration_ImportDeclaration__SingleTypeImportDeclaration_ = (IConstructor) _read("prod(label(\"SingleTypeImportDeclaration\",sort(\"ImportDeclaration\")),[sort(\"SingleTypeImportDeclaration\")],{})", Factory.Production);
  private static final IConstructor prod__BreakStatement_StatementWithoutTrailingSubstatement__BreakStatement_ = (IConstructor) _read("prod(label(\"BreakStatement\",sort(\"StatementWithoutTrailingSubstatement\")),[sort(\"BreakStatement\")],{})", Factory.Production);
  private static final IConstructor prod__MethodHeader_MethodBody_MethodDeclaration__MethodHeader_layouts_LAYOUTLIST_MethodBody_ = (IConstructor) _read("prod(label(\"MethodHeader-MethodBody\",sort(\"MethodDeclaration\")),[sort(\"MethodHeader\"),layouts(\"LAYOUTLIST\"),sort(\"MethodBody\")],{})", Factory.Production);
  private static final IConstructor prod__semicolon_LocalVariableDeclarationStatement__LocalVariableDeclaration_layouts_LAYOUTLIST_lit___59_ = (IConstructor) _read("prod(label(\"semicolon\",sort(\"LocalVariableDeclarationStatement\")),[sort(\"LocalVariableDeclaration\"),layouts(\"LAYOUTLIST\"),lit(\";\")],{})", Factory.Production);
  private static final IConstructor prod__lit___47_61__char_class___range__47_47_char_class___range__61_61_ = (IConstructor) _read("prod(lit(\"/=\"),[\\char-class([range(47,47)]),\\char-class([range(61,61)])],{})", Factory.Production);
  private static final IConstructor prod__ClassType__Identifier_layouts_LAYOUTLIST_lit___60_layouts_LAYOUTLIST_iter_seps__ClassType__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___62_ = (IConstructor) _read("prod(sort(\"ClassType\"),[lex(\"Identifier\"),layouts(\"LAYOUTLIST\"),lit(\"\\<\"),layouts(\"LAYOUTLIST\"),\\iter-seps(sort(\"ClassType\"),[layouts(\"LAYOUTLIST\"),lit(\",\"),layouts(\"LAYOUTLIST\")]),layouts(\"LAYOUTLIST\"),lit(\"\\>\")],{})", Factory.Production);
  private static final IConstructor prod__final_Modifier__conditional__lit_final__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(label(\"final\",sort(\"Modifier\")),[conditional(lit(\"final\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__lit___60_100_101_102_97_117_108_116_45_112_97_99_107_97_103_101_62__char_class___range__60_60_char_class___range__100_100_char_class___range__101_101_char_class___range__102_102_char_class___range__97_97_char_class___range__117_117_char_class___range__108_108_char_class___range__116_116_char_class___range__45_45_char_class___range__112_112_char_class___range__97_97_char_class___range__99_99_char_class___range__107_107_char_class___range__97_97_char_class___range__103_103_char_class___range__101_101_char_class___range__62_62_ = (IConstructor) _read("prod(lit(\"\\<default-package\\>\"),[\\char-class([range(60,60)]),\\char-class([range(100,100)]),\\char-class([range(101,101)]),\\char-class([range(102,102)]),\\char-class([range(97,97)]),\\char-class([range(117,117)]),\\char-class([range(108,108)]),\\char-class([range(116,116)]),\\char-class([range(45,45)]),\\char-class([range(112,112)]),\\char-class([range(97,97)]),\\char-class([range(99,99)]),\\char-class([range(107,107)]),\\char-class([range(97,97)]),\\char-class([range(103,103)]),\\char-class([range(101,101)]),\\char-class([range(62,62)])],{})", Factory.Production);
  private static final IConstructor prod__lit___47_47__char_class___range__47_47_char_class___range__47_47_ = (IConstructor) _read("prod(lit(\"//\"),[\\char-class([range(47,47)]),\\char-class([range(47,47)])],{})", Factory.Production);
  private static final IConstructor prod__plus_Expression11_Expression__Expression_layouts_LAYOUTLIST_lit___43_layouts_LAYOUTLIST_Expression__assoc__left = (IConstructor) _read("prod(label(\"plus-Expression11\",sort(\"Expression\")),[sort(\"Expression\"),layouts(\"LAYOUTLIST\"),lit(\"+\"),layouts(\"LAYOUTLIST\"),sort(\"Expression\")],{assoc(left())})", Factory.Production);
  private static final IConstructor prod__minus_Expression__lit___layouts_LAYOUTLIST_Expression_ = (IConstructor) _read("prod(label(\"minus\",sort(\"Expression\")),[lit(\"-\"),layouts(\"LAYOUTLIST\"),sort(\"Expression\")],{})", Factory.Production);
  private static final IConstructor prod__IdentifierKeywords__conditional__lit_byte__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(keywords(\"IdentifierKeywords\"),[conditional(lit(\"byte\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor regular__iter__char_class___range__48_55 = (IConstructor) _read("regular(iter(\\char-class([range(48,55)])))", Factory.Production);
  private static final IConstructor regular__iter__char_class___range__48_57 = (IConstructor) _read("regular(iter(\\char-class([range(48,57)])))", Factory.Production);
  private static final IConstructor prod__StaticInitializer_ClassBodyDeclaration__StaticInitializer_ = (IConstructor) _read("prod(label(\"StaticInitializer\",sort(\"ClassBodyDeclaration\")),[sort(\"StaticInitializer\")],{})", Factory.Production);
  private static final IConstructor prod__lit_char__char_class___range__99_99_char_class___range__104_104_char_class___range__97_97_char_class___range__114_114_ = (IConstructor) _read("prod(lit(\"char\"),[\\char-class([range(99,99)]),\\char-class([range(104,104)]),\\char-class([range(97,97)]),\\char-class([range(114,114)])],{})", Factory.Production);
  private static final IConstructor prod__Identifier__conditional__lit___60_115_116_97_116_105_99_45_105_110_105_116_62__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(sort(\"Identifier\"),[conditional(lit(\"\\<static-init\\>\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor regular__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57 = (IConstructor) _read("regular(seq([\\char-class([range(69,69),range(101,101)]),opt(\\char-class([range(43,43),range(45,45)])),iter(\\char-class([range(48,57)]))]))", Factory.Production);
  private static final IConstructor prod__LongLiteral_Literal__LongLiteral__tag__NotSupported___112_114_101_102_101_114 = (IConstructor) _read("prod(label(\"LongLiteral\",sort(\"Literal\")),[sort(\"LongLiteral\")],{tag(NotSupported(\"prefer\"))})", Factory.Production);
  private static final IConstructor regular__iter_seps__StatementExpression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST = (IConstructor) _read("regular(\\iter-seps(sort(\"StatementExpression\"),[layouts(\"LAYOUTLIST\"),lit(\",\"),layouts(\"LAYOUTLIST\")]))", Factory.Production);
  private static final IConstructor prod__Expression_Expression31_Expression__Expression_layouts_LAYOUTLIST_lit___94_layouts_LAYOUTLIST_Expression__assoc__left = (IConstructor) _read("prod(label(\"Expression-Expression31\",sort(\"Expression\")),[sort(\"Expression\"),layouts(\"LAYOUTLIST\"),lit(\"^\"),layouts(\"LAYOUTLIST\"),sort(\"Expression\")],{assoc(left())})", Factory.Production);
  private static final IConstructor prod__DoubleLiteral__iter__char_class___range__48_57_char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_opt__char_class___range__68_68_range__100_100_ = (IConstructor) _read("prod(lex(\"DoubleLiteral\"),[iter(\\char-class([range(48,57)])),\\char-class([range(69,69),range(101,101)]),opt(\\char-class([range(43,43),range(45,45)])),iter(\\char-class([range(48,57)])),opt(\\char-class([range(68,68),range(100,100)]))],{})", Factory.Production);
  private static final IConstructor prod__NullLiteral_Literal__NullLiteral__tag__NotSupported___112_114_101_102_101_114 = (IConstructor) _read("prod(label(\"NullLiteral\",sort(\"Literal\")),[lex(\"NullLiteral\")],{tag(NotSupported(\"prefer\"))})", Factory.Production);
  private static final IConstructor prod__lit___62_62_62_61__char_class___range__62_62_char_class___range__62_62_char_class___range__62_62_char_class___range__61_61_ = (IConstructor) _read("prod(lit(\"\\>\\>\\>=\"),[\\char-class([range(62,62)]),\\char-class([range(62,62)]),\\char-class([range(62,62)]),\\char-class([range(61,61)])],{})", Factory.Production);
  private static final IConstructor prod__switch_SwitchStatement__lit_switch_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_SwitchBlock_ = (IConstructor) _read("prod(label(\"switch\",sort(\"SwitchStatement\")),[lit(\"switch\"),layouts(\"LAYOUTLIST\"),lit(\"(\"),layouts(\"LAYOUTLIST\"),sort(\"Expression\"),layouts(\"LAYOUTLIST\"),lit(\")\"),layouts(\"LAYOUTLIST\"),sort(\"SwitchBlock\")],{})", Factory.Production);
  private static final IConstructor prod__Identifier1_VariableDeclaratorId__conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(label(\"Identifier1\",sort(\"VariableDeclaratorId\")),[conditional(lex(\"Identifier\"),{delete(conditional(keywords(\"IdentifierKeywords\"),{\\not-follow(\\char-class([range(36,36),range(48,57),range(65,90),range(95,95),range(97,122)]))}))})],{})", Factory.Production);
  private static final IConstructor prod__lit_throw__char_class___range__116_116_char_class___range__104_104_char_class___range__114_114_char_class___range__111_111_char_class___range__119_119_ = (IConstructor) _read("prod(lit(\"throw\"),[\\char-class([range(116,116)]),\\char-class([range(104,104)]),\\char-class([range(114,114)]),\\char-class([range(111,111)]),\\char-class([range(119,119)])],{})", Factory.Production);
  private static final IConstructor prod__HexLongLiteral__char_class___range__48_48_char_class___range__88_88_range__120_120_iter__char_class___range__48_57_range__65_70_range__97_102_char_class___range__76_76_range__108_108_ = (IConstructor) _read("prod(lex(\"HexLongLiteral\"),[\\char-class([range(48,48)]),\\char-class([range(88,88),range(120,120)]),iter(\\char-class([range(48,57),range(65,70),range(97,102)])),\\char-class([range(76,76),range(108,108)])],{})", Factory.Production);
  private static final IConstructor prod__new2_ArrayCreationExpression__conditional__lit_new__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_PrimitiveType_layouts_LAYOUTLIST_iter_seps__DimExprInitialized__layouts_LAYOUTLIST_layouts_LAYOUTLIST_ArrayInitializer_ = (IConstructor) _read("prod(label(\"new2\",sort(\"ArrayCreationExpression\")),[conditional(lit(\"new\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts(\"LAYOUTLIST\"),sort(\"PrimitiveType\"),layouts(\"LAYOUTLIST\"),\\iter-seps(sort(\"DimExprInitialized\"),[layouts(\"LAYOUTLIST\")]),layouts(\"LAYOUTLIST\"),sort(\"ArrayInitializer\")],{})", Factory.Production);
  private static final IConstructor prod__StatementExpressionList_ForInit__StatementExpressionList_ = (IConstructor) _read("prod(label(\"StatementExpressionList\",sort(\"ForInit\")),[sort(\"StatementExpressionList\")],{})", Factory.Production);
  private static final IConstructor prod__lit___47_42__char_class___range__47_47_char_class___range__42_42_ = (IConstructor) _read("prod(lit(\"/*\"),[\\char-class([range(47,47)]),\\char-class([range(42,42)])],{})", Factory.Production);
  private static final IConstructor prod__lit_protected__char_class___range__112_112_char_class___range__114_114_char_class___range__111_111_char_class___range__116_116_char_class___range__101_101_char_class___range__99_99_char_class___range__116_116_char_class___range__101_101_char_class___range__100_100_ = (IConstructor) _read("prod(lit(\"protected\"),[\\char-class([range(112,112)]),\\char-class([range(114,114)]),\\char-class([range(111,111)]),\\char-class([range(116,116)]),\\char-class([range(101,101)]),\\char-class([range(99,99)]),\\char-class([range(116,116)]),\\char-class([range(101,101)]),\\char-class([range(100,100)])],{})", Factory.Production);
  private static final IConstructor prod__Thing__lit_start_layouts_LAYOUTLIST_conditional__empty__not_follow__lit_returns_ = (IConstructor) _read("prod(sort(\"Thing\"),[lit(\"start\"),layouts(\"LAYOUTLIST\"),conditional(empty(),{\\not-follow(lit(\"returns\"))})],{})", Factory.Production);
  private static final IConstructor prod__char_IntegralType__conditional__lit_char__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(label(\"char\",sort(\"IntegralType\")),[conditional(lit(\"char\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__double_FloatingPointType__conditional__lit_double__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(label(\"double\",sort(\"FloatingPointType\")),[conditional(lit(\"double\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__Comment__lit___47_42_iter_star__alt___conditional__char_class___range__42_42__not_follow__char_class___range__47_47_char_class___range__0_41_range__43_65535_lit___42_47_ = (IConstructor) _read("prod(lex(\"Comment\"),[lit(\"/*\"),\\iter-star(alt({conditional(\\char-class([range(42,42)]),{\\not-follow(\\char-class([range(47,47)]))}),\\char-class([range(0,41),range(43,65535)])})),lit(\"*/\")],{})", Factory.Production);
  private static final IConstructor prod__LabeledStatement_Statement__LabeledStatement_ = (IConstructor) _read("prod(label(\"LabeledStatement\",sort(\"Statement\")),[sort(\"LabeledStatement\")],{})", Factory.Production);
  private static final IConstructor prod__IdentifierKeywords__conditional__lit_case__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(keywords(\"IdentifierKeywords\"),[conditional(lit(\"case\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__Thing__conditional__Word__delete__lit_start_ = (IConstructor) _read("prod(sort(\"Thing\"),[conditional(lex(\"Word\"),{delete(lit(\"start\"))})],{})", Factory.Production);
  private static final IConstructor prod__gt1_Expression__Expression_layouts_LAYOUTLIST_lit___62_layouts_LAYOUTLIST_Expression__assoc__left = (IConstructor) _read("prod(label(\"gt1\",sort(\"Expression\")),[sort(\"Expression\"),layouts(\"LAYOUTLIST\"),lit(\"\\>\"),layouts(\"LAYOUTLIST\"),sort(\"Expression\")],{assoc(left())})", Factory.Production);
  private static final IConstructor prod__assignMul_AssignmentOperator__lit___42_61_ = (IConstructor) _read("prod(label(\"assignMul\",sort(\"AssignmentOperator\")),[lit(\"*=\")],{})", Factory.Production);
  private static final IConstructor prod__IdentifierKeywords__conditional__lit_double__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(keywords(\"IdentifierKeywords\"),[conditional(lit(\"double\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__ClassDeclaration_Statement__ClassDeclaration_ = (IConstructor) _read("prod(label(\"ClassDeclaration\",sort(\"Statement\")),[sort(\"ClassDeclaration\")],{})", Factory.Production);
  private static final IConstructor prod__MethodInvocationConstructor_MethodInvocation__Primary_layouts_LAYOUTLIST_lit___46_layouts_LAYOUTLIST_ClassInstanceCreationExpression__tag__NotSupported___112_114_101_102_101_114 = (IConstructor) _read("prod(label(\"MethodInvocationConstructor\",sort(\"MethodInvocation\")),[sort(\"Primary\"),layouts(\"LAYOUTLIST\"),lit(\".\"),layouts(\"LAYOUTLIST\"),sort(\"ClassInstanceCreationExpression\")],{tag(NotSupported(\"prefer\"))})", Factory.Production);
  private static final IConstructor regular__iter_seps__BlockStatement__layouts_LAYOUTLIST = (IConstructor) _read("regular(\\iter-seps(sort(\"BlockStatement\"),[layouts(\"LAYOUTLIST\")]))", Factory.Production);
  private static final IConstructor prod__Identifier__conditional__lit___60_105_110_105_116_62__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(sort(\"Identifier\"),[conditional(lit(\"\\<init\\>\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__lit___10__char_class___range__10_10_ = (IConstructor) _read("prod(lit(\"\\n\"),[\\char-class([range(10,10)])],{})", Factory.Production);
  private static final IConstructor prod__new1_ArrayCreationExpression__conditional__lit_new__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_ClassOrInterfaceType_layouts_LAYOUTLIST_iter_seps__DimExpr__layouts_LAYOUTLIST_layouts_LAYOUTLIST_iter_star_seps__Dim__layouts_LAYOUTLIST_ = (IConstructor) _read("prod(label(\"new1\",sort(\"ArrayCreationExpression\")),[conditional(lit(\"new\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts(\"LAYOUTLIST\"),sort(\"ClassOrInterfaceType\"),layouts(\"LAYOUTLIST\"),\\iter-seps(sort(\"DimExpr\"),[layouts(\"LAYOUTLIST\")]),layouts(\"LAYOUTLIST\"),\\iter-star-seps(sort(\"Dim\"),[layouts(\"LAYOUTLIST\")])],{})", Factory.Production);
  private static final IConstructor prod__new_comma_ClassInstanceCreationExpression__conditional__lit_new__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_ClassType_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_iter_star_seps__Expression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41_ = (IConstructor) _read("prod(label(\"new-comma\",sort(\"ClassInstanceCreationExpression\")),[conditional(lit(\"new\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts(\"LAYOUTLIST\"),sort(\"ClassType\"),layouts(\"LAYOUTLIST\"),lit(\"(\"),layouts(\"LAYOUTLIST\"),\\iter-star-seps(sort(\"Expression\"),[layouts(\"LAYOUTLIST\"),lit(\",\"),layouts(\"LAYOUTLIST\")]),layouts(\"LAYOUTLIST\"),lit(\")\")],{})", Factory.Production);
  private static final IConstructor prod__Expression2_DimExpr__lit___91_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___93_ = (IConstructor) _read("prod(label(\"Expression2\",sort(\"DimExpr\")),[lit(\"[\"),layouts(\"LAYOUTLIST\"),sort(\"Expression\"),layouts(\"LAYOUTLIST\"),lit(\"]\")],{})", Factory.Production);
  private static final IConstructor prod__Identifier__conditional__lit___60_100_101_102_97_117_108_116_45_112_97_99_107_97_103_101_62__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(sort(\"Identifier\"),[conditional(lit(\"\\<default-package\\>\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__abstract_Modifier__conditional__lit_abstract__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(label(\"abstract\",sort(\"Modifier\")),[conditional(lit(\"abstract\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__ClassDeclaration2_ClassBodyDeclaration__InterfaceDeclaration_ = (IConstructor) _read("prod(label(\"ClassDeclaration2\",sort(\"ClassBodyDeclaration\")),[sort(\"InterfaceDeclaration\")],{})", Factory.Production);
  private static final IConstructor prod__import_times_semicolon_TypeImportOnDemandDeclaration__conditional__lit_import__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Name_layouts_LAYOUTLIST_lit___46_layouts_LAYOUTLIST_lit___42_layouts_LAYOUTLIST_lit___59_ = (IConstructor) _read("prod(label(\"import-times-semicolon\",sort(\"TypeImportOnDemandDeclaration\")),[conditional(lit(\"import\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts(\"LAYOUTLIST\"),sort(\"Name\"),layouts(\"LAYOUTLIST\"),lit(\".\"),layouts(\"LAYOUTLIST\"),lit(\"*\"),layouts(\"LAYOUTLIST\"),lit(\";\")],{})", Factory.Production);
  private static final IConstructor prod__continue_semicolon_ContinueStatement__conditional__lit_continue__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_opt__Identifier_layouts_LAYOUTLIST_lit___59_ = (IConstructor) _read("prod(label(\"continue-semicolon\",sort(\"ContinueStatement\")),[conditional(lit(\"continue\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts(\"LAYOUTLIST\"),opt(lex(\"Identifier\")),layouts(\"LAYOUTLIST\"),lit(\";\")],{})", Factory.Production);
  private static final IConstructor prod__ReferenceType_Type__ReferenceType_ = (IConstructor) _read("prod(label(\"ReferenceType\",sort(\"Type\")),[sort(\"ReferenceType\")],{})", Factory.Production);
  private static final IConstructor prod__finally_Finally__conditional__lit_finally__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Block_ = (IConstructor) _read("prod(label(\"finally\",sort(\"Finally\")),[conditional(lit(\"finally\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts(\"LAYOUTLIST\"),sort(\"Block\")],{})", Factory.Production);
  private static final IConstructor prod__lit___70_73_76_69_58__char_class___range__70_70_char_class___range__73_73_char_class___range__76_76_char_class___range__69_69_char_class___range__58_58_ = (IConstructor) _read("prod(lit(\"FILE:\"),[\\char-class([range(70,70)]),\\char-class([range(73,73)]),\\char-class([range(76,76)]),\\char-class([range(69,69)]),\\char-class([range(58,58)])],{})", Factory.Production);
  private static final IConstructor prod__lit___59__char_class___range__59_59_ = (IConstructor) _read("prod(lit(\";\"),[\\char-class([range(59,59)])],{})", Factory.Production);
  private static final IConstructor prod__lit___58__char_class___range__58_58_ = (IConstructor) _read("prod(lit(\":\"),[\\char-class([range(58,58)])],{})", Factory.Production);
  private static final IConstructor prod__lit___61__char_class___range__61_61_ = (IConstructor) _read("prod(lit(\"=\"),[\\char-class([range(61,61)])],{})", Factory.Production);
  private static final IConstructor prod__lit___60__char_class___range__60_60_ = (IConstructor) _read("prod(lit(\"\\<\"),[\\char-class([range(60,60)])],{})", Factory.Production);
  private static final IConstructor prod__lit___63__char_class___range__63_63_ = (IConstructor) _read("prod(lit(\"?\"),[\\char-class([range(63,63)])],{})", Factory.Production);
  private static final IConstructor prod__transient_Modifier__conditional__lit_transient__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(label(\"transient\",sort(\"Modifier\")),[conditional(lit(\"transient\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor regular__opt__char_class___range__43_43_range__45_45 = (IConstructor) _read("regular(opt(\\char-class([range(43,43),range(45,45)])))", Factory.Production);
  private static final IConstructor prod__lit___60_115_116_97_116_105_99_45_105_110_105_116_62__char_class___range__60_60_char_class___range__115_115_char_class___range__116_116_char_class___range__97_97_char_class___range__116_116_char_class___range__105_105_char_class___range__99_99_char_class___range__45_45_char_class___range__105_105_char_class___range__110_110_char_class___range__105_105_char_class___range__116_116_char_class___range__62_62_ = (IConstructor) _read("prod(lit(\"\\<static-init\\>\"),[\\char-class([range(60,60)]),\\char-class([range(115,115)]),\\char-class([range(116,116)]),\\char-class([range(97,97)]),\\char-class([range(116,116)]),\\char-class([range(105,105)]),\\char-class([range(99,99)]),\\char-class([range(45,45)]),\\char-class([range(105,105)]),\\char-class([range(110,110)]),\\char-class([range(105,105)]),\\char-class([range(116,116)]),\\char-class([range(62,62)])],{})", Factory.Production);
  private static final IConstructor prod__lit___62__char_class___range__62_62_ = (IConstructor) _read("prod(lit(\"\\>\"),[\\char-class([range(62,62)])],{})", Factory.Production);
  private static final IConstructor prod__lit_0__char_class___range__48_48_ = (IConstructor) _read("prod(lit(\"0\"),[\\char-class([range(48,48)])],{})", Factory.Production);
  private static final IConstructor regular__iter_star_seps__SwitchLabel__layouts_LAYOUTLIST = (IConstructor) _read("regular(\\iter-star-seps(sort(\"SwitchLabel\"),[layouts(\"LAYOUTLIST\")]))", Factory.Production);
  private static final IConstructor prod__Comment__lit___47_42_iter_star__CommentChar_lit___42_47__tag__category___67_111_109_109_101_110_116 = (IConstructor) _read("prod(lex(\"Comment\"),[lit(\"/*\"),\\iter-star(lex(\"CommentChar\")),lit(\"*/\")],{tag(category(\"Comment\"))})", Factory.Production);
  private static final IConstructor prod__CommentChar__conditional__Asterisk__not_follow__char_class___range__47_47_ = (IConstructor) _read("prod(lex(\"CommentChar\"),[conditional(lex(\"Asterisk\"),{\\not-follow(\\char-class([range(47,47)]))})],{})", Factory.Production);
  private static final IConstructor prod__lit___41__char_class___range__41_41_ = (IConstructor) _read("prod(lit(\")\"),[\\char-class([range(41,41)])],{})", Factory.Production);
  private static final IConstructor prod__lit___40__char_class___range__40_40_ = (IConstructor) _read("prod(lit(\"(\"),[\\char-class([range(40,40)])],{})", Factory.Production);
  private static final IConstructor prod__lit___43__char_class___range__43_43_ = (IConstructor) _read("prod(lit(\"+\"),[\\char-class([range(43,43)])],{})", Factory.Production);
  private static final IConstructor prod__lit___42__char_class___range__42_42_ = (IConstructor) _read("prod(lit(\"*\"),[\\char-class([range(42,42)])],{})", Factory.Production);
  private static final IConstructor prod__ForStatement_Statement__ForStatement_ = (IConstructor) _read("prod(label(\"ForStatement\",sort(\"Statement\")),[sort(\"ForStatement\")],{})", Factory.Production);
  private static final IConstructor prod__lit____char_class___range__45_45_ = (IConstructor) _read("prod(lit(\"-\"),[\\char-class([range(45,45)])],{})", Factory.Production);
  private static final IConstructor prod__IdentifierKeywords__conditional__lit_volatile__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(keywords(\"IdentifierKeywords\"),[conditional(lit(\"volatile\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__lit___44__char_class___range__44_44_ = (IConstructor) _read("prod(lit(\",\"),[\\char-class([range(44,44)])],{})", Factory.Production);
  private static final IConstructor prod__lit___47__char_class___range__47_47_ = (IConstructor) _read("prod(lit(\"/\"),[\\char-class([range(47,47)])],{})", Factory.Production);
  private static final IConstructor prod__lit_if__char_class___range__105_105_char_class___range__102_102_ = (IConstructor) _read("prod(lit(\"if\"),[\\char-class([range(105,105)]),\\char-class([range(102,102)])],{})", Factory.Production);
  private static final IConstructor prod__lit___46__char_class___range__46_46_ = (IConstructor) _read("prod(lit(\".\"),[\\char-class([range(46,46)])],{})", Factory.Production);
  private static final IConstructor prod__Expression12_Expression__Expression_layouts_LAYOUTLIST_lit___62_62_62_layouts_LAYOUTLIST_Expression__assoc__left = (IConstructor) _read("prod(label(\"Expression12\",sort(\"Expression\")),[sort(\"Expression\"),layouts(\"LAYOUTLIST\"),lit(\"\\>\\>\\>\"),layouts(\"LAYOUTLIST\"),sort(\"Expression\")],{assoc(left())})", Factory.Production);
  private static final IConstructor prod__lit___33__char_class___range__33_33_ = (IConstructor) _read("prod(lit(\"!\"),[\\char-class([range(33,33)])],{})", Factory.Production);
  private static final IConstructor prod__lit___34__char_class___range__34_34_ = (IConstructor) _read("prod(lit(\"\\\"\"),[\\char-class([range(34,34)])],{})", Factory.Production);
  private static final IConstructor prod__lit___37__char_class___range__37_37_ = (IConstructor) _read("prod(lit(\"%\"),[\\char-class([range(37,37)])],{})", Factory.Production);
  private static final IConstructor prod__lit_return__char_class___range__114_114_char_class___range__101_101_char_class___range__116_116_char_class___range__117_117_char_class___range__114_114_char_class___range__110_110_ = (IConstructor) _read("prod(lit(\"return\"),[\\char-class([range(114,114)]),\\char-class([range(101,101)]),\\char-class([range(116,116)]),\\char-class([range(117,117)]),\\char-class([range(114,114)]),\\char-class([range(110,110)])],{})", Factory.Production);
  private static final IConstructor prod__lit___39__char_class___range__39_39_ = (IConstructor) _read("prod(lit(\"\\'\\\\\"),[\\char-class([range(39,39)])],{})", Factory.Production);
  private static final IConstructor prod__lit___38__char_class___range__38_38_ = (IConstructor) _read("prod(lit(\"&\"),[\\char-class([range(38,38)])],{})", Factory.Production);
  private static final IConstructor prod__lit___91__char_class___range__91_91_ = (IConstructor) _read("prod(lit(\"[\"),[\\char-class([range(91,91)])],{})", Factory.Production);
  private static final IConstructor regular__iter_star_seps__Dim__layouts_LAYOUTLIST = (IConstructor) _read("regular(\\iter-star-seps(sort(\"Dim\"),[layouts(\"LAYOUTLIST\")]))", Factory.Production);
  private static final IConstructor prod__public_Modifier__conditional__lit_public__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(label(\"public\",sort(\"Modifier\")),[conditional(lit(\"public\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__IdentifierKeywords__conditional__lit_import__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(keywords(\"IdentifierKeywords\"),[conditional(lit(\"import\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__lit___94__char_class___range__94_94_ = (IConstructor) _read("prod(lit(\"^\"),[\\char-class([range(94,94)])],{})", Factory.Production);
  private static final IConstructor prod__new_ArrayCreationExpression__conditional__lit_new__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_PrimitiveType_layouts_LAYOUTLIST_iter_seps__DimExpr__layouts_LAYOUTLIST_layouts_LAYOUTLIST_iter_star_seps__Dim__layouts_LAYOUTLIST_ = (IConstructor) _read("prod(label(\"new\",sort(\"ArrayCreationExpression\")),[conditional(lit(\"new\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts(\"LAYOUTLIST\"),sort(\"PrimitiveType\"),layouts(\"LAYOUTLIST\"),\\iter-seps(sort(\"DimExpr\"),[layouts(\"LAYOUTLIST\")]),layouts(\"LAYOUTLIST\"),\\iter-star-seps(sort(\"Dim\"),[layouts(\"LAYOUTLIST\")])],{})", Factory.Production);
  private static final IConstructor prod__lit___92__char_class___range__92_92_ = (IConstructor) _read("prod(lit(\"\\\\\"),[\\char-class([range(92,92)])],{})", Factory.Production);
  private static final IConstructor prod__lit___93__char_class___range__93_93_ = (IConstructor) _read("prod(lit(\"]\"),[\\char-class([range(93,93)])],{})", Factory.Production);
  private static final IConstructor prod__Dim_dunno_a_0_Dim__lit___91_layouts_LAYOUTLIST_lit___93_ = (IConstructor) _read("prod(label(\"Dim-dunno-a_0\",sort(\"Dim\")),[lit(\"[\"),layouts(\"LAYOUTLIST\"),lit(\"]\")],{})", Factory.Production);
  private static final IConstructor regular__iter_seps__VariableDeclarator__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST = (IConstructor) _read("regular(\\iter-seps(sort(\"VariableDeclarator\"),[layouts(\"LAYOUTLIST\"),lit(\",\"),layouts(\"LAYOUTLIST\")]))", Factory.Production);
  private static final IConstructor prod__lit___43_43__char_class___range__43_43_char_class___range__43_43_ = (IConstructor) _read("prod(lit(\"++\"),[\\char-class([range(43,43)]),\\char-class([range(43,43)])],{})", Factory.Production);
  private static final IConstructor prod__extends_Super__conditional__lit_extends__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_ClassType_ = (IConstructor) _read("prod(label(\"extends\",sort(\"Super\")),[conditional(lit(\"extends\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts(\"LAYOUTLIST\"),sort(\"ClassType\")],{})", Factory.Production);
  private static final IConstructor prod__Statement_BlockStatement__Statement_ = (IConstructor) _read("prod(label(\"Statement\",sort(\"BlockStatement\")),[sort(\"Statement\")],{})", Factory.Production);
  private static final IConstructor prod__Type_VariableDeclaratorId_FormalParameter__iter_star_seps__Modifier__layouts_LAYOUTLIST_layouts_LAYOUTLIST_Type_layouts_LAYOUTLIST_VariableDeclaratorId_ = (IConstructor) _read("prod(label(\"Type-VariableDeclaratorId\",sort(\"FormalParameter\")),[\\iter-star-seps(sort(\"Modifier\"),[layouts(\"LAYOUTLIST\")]),layouts(\"LAYOUTLIST\"),sort(\"Type\"),layouts(\"LAYOUTLIST\"),sort(\"VariableDeclaratorId\")],{})", Factory.Production);
  private static final IConstructor prod__ExplicitConstructorInvocation_opt_BlockStatement_s_ConstructorBody__lit___123_layouts_LAYOUTLIST_opt__ExplicitConstructorInvocation_layouts_LAYOUTLIST_iter_star_seps__BlockStatement__layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___125_ = (IConstructor) _read("prod(label(\"ExplicitConstructorInvocation-opt-BlockStatement-s\",sort(\"ConstructorBody\")),[lit(\"{\"),layouts(\"LAYOUTLIST\"),opt(sort(\"ExplicitConstructorInvocation\")),layouts(\"LAYOUTLIST\"),\\iter-star-seps(sort(\"BlockStatement\"),[layouts(\"LAYOUTLIST\")]),layouts(\"LAYOUTLIST\"),lit(\"}\")],{})", Factory.Production);
  private static final IConstructor prod__Literal_PrimaryNoNewArray__Literal__tag__NotSupported___97_118_111_105_100 = (IConstructor) _read("prod(label(\"Literal\",sort(\"PrimaryNoNewArray\")),[sort(\"Literal\")],{tag(NotSupported(\"avoid\"))})", Factory.Production);
  private static final IConstructor prod__IdentifierKeywords__conditional__lit_abstract__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(keywords(\"IdentifierKeywords\"),[conditional(lit(\"abstract\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__comma11_MethodInvocation__Name_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_iter_star_seps__Expression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41__tag__NotSupported___97_118_111_105_100 = (IConstructor) _read("prod(label(\"comma11\",sort(\"MethodInvocation\")),[sort(\"Name\"),layouts(\"LAYOUTLIST\"),lit(\"(\"),layouts(\"LAYOUTLIST\"),\\iter-star-seps(sort(\"Expression\"),[layouts(\"LAYOUTLIST\"),lit(\",\"),layouts(\"LAYOUTLIST\")]),layouts(\"LAYOUTLIST\"),lit(\")\")],{tag(NotSupported(\"avoid\"))})", Factory.Production);
  private static final IConstructor prod__lit___43_61__char_class___range__43_43_char_class___range__61_61_ = (IConstructor) _read("prod(lit(\"+=\"),[\\char-class([range(43,43)]),\\char-class([range(61,61)])],{})", Factory.Production);
  private static final IConstructor prod__semicolon3_MethodBody__lit___59_ = (IConstructor) _read("prod(label(\"semicolon3\",sort(\"MethodBody\")),[lit(\";\")],{})", Factory.Production);
  private static final IConstructor prod__ClassDeclaration1_ClassBodyDeclaration__ClassDeclaration_ = (IConstructor) _read("prod(label(\"ClassDeclaration1\",sort(\"ClassBodyDeclaration\")),[sort(\"ClassDeclaration\")],{})", Factory.Production);
  private static final IConstructor regular__iter_star_seps__ImportDeclaration__layouts_LAYOUTLIST = (IConstructor) _read("regular(\\iter-star-seps(sort(\"ImportDeclaration\"),[layouts(\"LAYOUTLIST\")]))", Factory.Production);
  private static final IConstructor prod__lit_float__char_class___range__102_102_char_class___range__108_108_char_class___range__111_111_char_class___range__97_97_char_class___range__116_116_ = (IConstructor) _read("prod(lit(\"float\"),[\\char-class([range(102,102)]),\\char-class([range(108,108)]),\\char-class([range(111,111)]),\\char-class([range(97,97)]),\\char-class([range(116,116)])],{})", Factory.Production);
  private static final IConstructor prod__case_colon_SwitchLabel__conditional__lit_case__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___58_ = (IConstructor) _read("prod(label(\"case-colon\",sort(\"SwitchLabel\")),[conditional(lit(\"case\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts(\"LAYOUTLIST\"),sort(\"Expression\"),layouts(\"LAYOUTLIST\"),lit(\":\")],{})", Factory.Production);
  private static final IConstructor prod__lit___123__char_class___range__123_123_ = (IConstructor) _read("prod(lit(\"{\"),[\\char-class([range(123,123)])],{})", Factory.Production);
  private static final IConstructor prod__DecimalIntegerLiteral__lit_0_ = (IConstructor) _read("prod(lex(\"DecimalIntegerLiteral\"),[lit(\"0\")],{})", Factory.Production);
  private static final IConstructor prod__Primary_Expression__Primary__tag__NotSupported___112_114_101_102_101_114 = (IConstructor) _read("prod(label(\"Primary\",sort(\"Expression\")),[sort(\"Primary\")],{tag(NotSupported(\"prefer\"))})", Factory.Production);
  private static final IConstructor regular__iter_star_seps__SwitchBlockStatementGroup__layouts_LAYOUTLIST = (IConstructor) _read("regular(\\iter-star-seps(sort(\"SwitchBlockStatementGroup\"),[layouts(\"LAYOUTLIST\")]))", Factory.Production);
  private static final IConstructor prod__boolean_PrimitiveType__conditional__lit_boolean__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(label(\"boolean\",sort(\"PrimitiveType\")),[conditional(lit(\"boolean\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__super_FieldAccess__conditional__lit_super__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___46_layouts_LAYOUTLIST_conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122__tag__NotSupported___112_114_101_102_101_114 = (IConstructor) _read("prod(label(\"super\",sort(\"FieldAccess\")),[conditional(lit(\"super\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts(\"LAYOUTLIST\"),lit(\".\"),layouts(\"LAYOUTLIST\"),conditional(lex(\"Identifier\"),{delete(conditional(keywords(\"IdentifierKeywords\"),{\\not-follow(\\char-class([range(36,36),range(48,57),range(65,90),range(95,95),range(97,122)]))}))})],{tag(NotSupported(\"prefer\"))})", Factory.Production);
  private static final IConstructor prod__lit___126__char_class___range__126_126_ = (IConstructor) _read("prod(lit(\"~\"),[\\char-class([range(126,126)])],{})", Factory.Production);
  private static final IConstructor prod__int_IntegralType__conditional__lit_int__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(label(\"int\",sort(\"IntegralType\")),[conditional(lit(\"int\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__lit___125__char_class___range__125_125_ = (IConstructor) _read("prod(lit(\"}\"),[\\char-class([range(125,125)])],{})", Factory.Production);
  private static final IConstructor prod__lit___124__char_class___range__124_124_ = (IConstructor) _read("prod(lit(\"|\"),[\\char-class([range(124,124)])],{})", Factory.Production);
  private static final IConstructor regular__opt__seq___lit___46_layouts_LAYOUTLIST_Identifier = (IConstructor) _read("regular(opt(seq([lit(\".\"),layouts(\"LAYOUTLIST\"),lex(\"Identifier\")])))", Factory.Production);
  private static final IConstructor prod__lit___42_47__char_class___range__42_42_char_class___range__47_47_ = (IConstructor) _read("prod(lit(\"*/\"),[\\char-class([range(42,42)]),\\char-class([range(47,47)])],{})", Factory.Production);
  private static final IConstructor prod__start__CompilationUnit__layouts_LAYOUTLIST_top_CompilationUnit_layouts_LAYOUTLIST_ = (IConstructor) _read("prod(start(sort(\"CompilationUnit\")),[layouts(\"LAYOUTLIST\"),label(\"top\",sort(\"CompilationUnit\")),layouts(\"LAYOUTLIST\")],{})", Factory.Production);
  private static final IConstructor prod__try_TryStatement__conditional__lit_try__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Block_layouts_LAYOUTLIST_iter_seps__CatchClause__layouts_LAYOUTLIST_ = (IConstructor) _read("prod(label(\"try\",sort(\"TryStatement\")),[conditional(lit(\"try\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts(\"LAYOUTLIST\"),sort(\"Block\"),layouts(\"LAYOUTLIST\"),\\iter-seps(sort(\"CatchClause\"),[layouts(\"LAYOUTLIST\")])],{})", Factory.Production);
  private static final IConstructor regular__opt__lit___44 = (IConstructor) _read("regular(opt(lit(\",\")))", Factory.Production);
  private static final IConstructor regular__opt__lit___47 = (IConstructor) _read("regular(opt(lit(\"/\")))", Factory.Production);
  private static final IConstructor regular__iter_star__CommentChar = (IConstructor) _read("regular(\\iter-star(lex(\"CommentChar\")))", Factory.Production);
  private static final IConstructor prod__semicolon4_AbstractMethodDeclaration__MethodHeader_layouts_LAYOUTLIST_lit___59_ = (IConstructor) _read("prod(label(\"semicolon4\",sort(\"AbstractMethodDeclaration\")),[sort(\"MethodHeader\"),layouts(\"LAYOUTLIST\"),lit(\";\")],{})", Factory.Production);
  private static final IConstructor prod__IdentifierKeywords__conditional__lit_true__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(keywords(\"IdentifierKeywords\"),[conditional(lit(\"true\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__NumericType_PrimitiveType__NumericType_ = (IConstructor) _read("prod(label(\"NumericType\",sort(\"PrimitiveType\")),[sort(\"NumericType\")],{})", Factory.Production);
  private static final IConstructor prod__assignSR_AssignmentOperator__lit___62_62_61_ = (IConstructor) _read("prod(label(\"assignSR\",sort(\"AssignmentOperator\")),[lit(\"\\>\\>=\")],{})", Factory.Production);
  private static final IConstructor regular__iter_seps__CatchClause__layouts_LAYOUTLIST = (IConstructor) _read("regular(\\iter-seps(sort(\"CatchClause\"),[layouts(\"LAYOUTLIST\")]))", Factory.Production);
  private static final IConstructor prod__while_WhileStatement__conditional__lit_while__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_Statement_ = (IConstructor) _read("prod(label(\"while\",sort(\"WhileStatement\")),[conditional(lit(\"while\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts(\"LAYOUTLIST\"),lit(\"(\"),layouts(\"LAYOUTLIST\"),sort(\"Expression\"),layouts(\"LAYOUTLIST\"),lit(\")\"),layouts(\"LAYOUTLIST\"),sort(\"Statement\")],{})", Factory.Production);
  private static final IConstructor prod__LabeledStatementNoShortIf_StatementNoShortIf__LabeledStatementNoShortIf_ = (IConstructor) _read("prod(label(\"LabeledStatementNoShortIf\",sort(\"StatementNoShortIf\")),[sort(\"LabeledStatementNoShortIf\")],{})", Factory.Production);
  private static final IConstructor prod__Block1_MethodBody__Block_ = (IConstructor) _read("prod(label(\"Block1\",sort(\"MethodBody\")),[sort(\"Block\")],{})", Factory.Production);
  private static final IConstructor prod__lit___42_61__char_class___range__42_42_char_class___range__61_61_ = (IConstructor) _read("prod(lit(\"*=\"),[\\char-class([range(42,42)]),\\char-class([range(61,61)])],{})", Factory.Production);
  private static final IConstructor prod__IdentifierKeywords__conditional__lit_while__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(keywords(\"IdentifierKeywords\"),[conditional(lit(\"while\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor regular__alt___conditional__char_class___range__42_42__not_follow__char_class___range__47_47_char_class___range__0_41_range__43_65535 = (IConstructor) _read("regular(alt({conditional(\\char-class([range(42,42)]),{\\not-follow(\\char-class([range(47,47)]))}),\\char-class([range(0,41),range(43,65535)])}))", Factory.Production);
  private static final IConstructor prod__ReturnStatement_StatementWithoutTrailingSubstatement__ReturnStatement_ = (IConstructor) _read("prod(label(\"ReturnStatement\",sort(\"StatementWithoutTrailingSubstatement\")),[sort(\"ReturnStatement\")],{})", Factory.Production);
  private static final IConstructor prod__StringCharacter__char_class___range__0_33_range__35_91_range__93_65535_ = (IConstructor) _read("prod(lex(\"StringCharacter\"),[\\char-class([range(0,33),range(35,91),range(93,65535)])],{})", Factory.Production);
  private static final IConstructor prod__decr21_StatementExpression__Expression_layouts_LAYOUTLIST_lit_____tag__NotSupported___112_114_101_102_101_114 = (IConstructor) _read("prod(label(\"decr21\",sort(\"StatementExpression\")),[sort(\"Expression\"),layouts(\"LAYOUTLIST\"),lit(\"--\")],{tag(NotSupported(\"prefer\"))})", Factory.Production);
  private static final IConstructor prod__implements_comma_Interfaces__conditional__lit_implements__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_iter_seps__InterfaceType__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_ = (IConstructor) _read("prod(label(\"implements-comma\",sort(\"Interfaces\")),[conditional(lit(\"implements\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts(\"LAYOUTLIST\"),\\iter-seps(sort(\"InterfaceType\"),[layouts(\"LAYOUTLIST\"),lit(\",\"),layouts(\"LAYOUTLIST\")])],{})", Factory.Production);
  private static final IConstructor prod__LAYOUT__char_class___range__9_10_range__13_13_range__32_32_ = (IConstructor) _read("prod(sort(\"LAYOUT\"),[\\char-class([range(9,10),range(13,13),range(32,32)])],{})", Factory.Production);
  private static final IConstructor prod__FieldAccess1_LeftHandSide__FieldAccess_ = (IConstructor) _read("prod(label(\"FieldAccess1\",sort(\"LeftHandSide\")),[sort(\"FieldAccess\")],{})", Factory.Production);
  private static final IConstructor prod__ArrayAccess_PrimaryNoNewArray__ArrayAccess_ = (IConstructor) _read("prod(label(\"ArrayAccess\",sort(\"PrimaryNoNewArray\")),[sort(\"ArrayAccess\")],{})", Factory.Production);
  private static final IConstructor prod__ConstantDeclaration_InterfaceMemberDeclaration__ConstantDeclaration_ = (IConstructor) _read("prod(label(\"ConstantDeclaration\",sort(\"InterfaceMemberDeclaration\")),[sort(\"ConstantDeclaration\")],{})", Factory.Production);
  private static final IConstructor prod__lit___37_61__char_class___range__37_37_char_class___range__61_61_ = (IConstructor) _read("prod(lit(\"%=\"),[\\char-class([range(37,37)]),\\char-class([range(61,61)])],{})", Factory.Production);
  private static final IConstructor prod__IdentifierKeywords__conditional__lit_finally__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(keywords(\"IdentifierKeywords\"),[conditional(lit(\"finally\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__return_semicolon_ReturnStatement__conditional__lit_return__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_opt__Expression_layouts_LAYOUTLIST_lit___59_ = (IConstructor) _read("prod(label(\"return-semicolon\",sort(\"ReturnStatement\")),[conditional(lit(\"return\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts(\"LAYOUTLIST\"),opt(sort(\"Expression\")),layouts(\"LAYOUTLIST\"),lit(\";\")],{})", Factory.Production);
  private static final IConstructor prod__ClassInstanceCreationExpression_StatementExpression__ClassInstanceCreationExpression_ = (IConstructor) _read("prod(label(\"ClassInstanceCreationExpression\",sort(\"StatementExpression\")),[sort(\"ClassInstanceCreationExpression\")],{})", Factory.Production);
  private static final IConstructor regular__iter__char_class___range__48_57_range__65_70_range__97_102 = (IConstructor) _read("regular(iter(\\char-class([range(48,57),range(65,70),range(97,102)])))", Factory.Production);
  private static final IConstructor prod__bar11_Expression__Expression_layouts_LAYOUTLIST_lit___124_layouts_LAYOUTLIST_Expression__assoc__left = (IConstructor) _read("prod(label(\"bar11\",sort(\"Expression\")),[sort(\"Expression\"),layouts(\"LAYOUTLIST\"),lit(\"|\"),layouts(\"LAYOUTLIST\"),sort(\"Expression\")],{assoc(left())})", Factory.Production);
  private static final IConstructor prod__SingleCharacter__UnicodeEscape_ = (IConstructor) _read("prod(lex(\"SingleCharacter\"),[lex(\"UnicodeEscape\")],{})", Factory.Production);
  private static final IConstructor prod__ContinueStatement_StatementWithoutTrailingSubstatement__ContinueStatement_ = (IConstructor) _read("prod(label(\"ContinueStatement\",sort(\"StatementWithoutTrailingSubstatement\")),[sort(\"ContinueStatement\")],{})", Factory.Production);
  private static final IConstructor prod__IntegerLiteral_Literal__IntegerLiteral__tag__NotSupported___112_114_101_102_101_114 = (IConstructor) _read("prod(label(\"IntegerLiteral\",sort(\"Literal\")),[sort(\"IntegerLiteral\")],{tag(NotSupported(\"prefer\"))})", Factory.Production);
  private static final IConstructor prod__lit_do__char_class___range__100_100_char_class___range__111_111_ = (IConstructor) _read("prod(lit(\"do\"),[\\char-class([range(100,100)]),\\char-class([range(111,111)])],{})", Factory.Production);
  private static final IConstructor prod__colon_LabeledStatement__conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___58_layouts_LAYOUTLIST_Statement_ = (IConstructor) _read("prod(label(\"colon\",sort(\"LabeledStatement\")),[conditional(lex(\"Identifier\"),{delete(conditional(keywords(\"IdentifierKeywords\"),{\\not-follow(\\char-class([range(36,36),range(48,57),range(65,90),range(95,95),range(97,122)]))}))}),layouts(\"LAYOUTLIST\"),lit(\":\"),layouts(\"LAYOUTLIST\"),sort(\"Statement\")],{})", Factory.Production);
  private static final IConstructor prod__ClassOrInterfaceType_ReferenceType__ClassOrInterfaceType_ = (IConstructor) _read("prod(label(\"ClassOrInterfaceType\",sort(\"ReferenceType\")),[sort(\"ClassOrInterfaceType\")],{})", Factory.Production);
  private static final IConstructor prod__IdentifierKeywords__conditional__lit_static__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(keywords(\"IdentifierKeywords\"),[conditional(lit(\"static\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__static1_StaticInitializer__conditional__lit_static__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Block_ = (IConstructor) _read("prod(label(\"static1\",sort(\"StaticInitializer\")),[conditional(lit(\"static\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts(\"LAYOUTLIST\"),sort(\"Block\")],{})", Factory.Production);
  private static final IConstructor prod__IdentifierKeywords__conditional__lit_this__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(keywords(\"IdentifierKeywords\"),[conditional(lit(\"this\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__assertWithExpression_AssertStatement__lit_assert_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___59__tag__NotSupported___112_114_101_102_101_114 = (IConstructor) _read("prod(label(\"assertWithExpression\",sort(\"AssertStatement\")),[lit(\"assert\"),layouts(\"LAYOUTLIST\"),sort(\"Expression\"),layouts(\"LAYOUTLIST\"),lit(\";\")],{tag(NotSupported(\"prefer\"))})", Factory.Production);
  private static final IConstructor prod__VariableDeclaratorId1_VariableDeclaratorId__VariableDeclaratorId_layouts_LAYOUTLIST_lit___91_layouts_LAYOUTLIST_lit___93_ = (IConstructor) _read("prod(label(\"VariableDeclaratorId1\",sort(\"VariableDeclaratorId\")),[sort(\"VariableDeclaratorId\"),layouts(\"LAYOUTLIST\"),lit(\"[\"),layouts(\"LAYOUTLIST\"),lit(\"]\")],{})", Factory.Production);
  private static final IConstructor prod__Asterisk__char_class___range__42_42_ = (IConstructor) _read("prod(lex(\"Asterisk\"),[\\char-class([range(42,42)])],{})", Factory.Production);
  private static final IConstructor prod__Cast_Expression_Expression__lit___40_layouts_LAYOUTLIST_Type_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_Expression_ = (IConstructor) _read("prod(label(\"Cast-Expression\",sort(\"Expression\")),[lit(\"(\"),layouts(\"LAYOUTLIST\"),sort(\"Type\"),layouts(\"LAYOUTLIST\"),lit(\")\"),layouts(\"LAYOUTLIST\"),sort(\"Expression\")],{})", Factory.Production);
  private static final IConstructor prod__DoubleLiteral__iter__char_class___range__48_57_opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_char_class___range__68_68_range__100_100_ = (IConstructor) _read("prod(lex(\"DoubleLiteral\"),[iter(\\char-class([range(48,57)])),opt(seq([\\char-class([range(69,69),range(101,101)]),opt(\\char-class([range(43,43),range(45,45)])),iter(\\char-class([range(48,57)]))])),\\char-class([range(68,68),range(100,100)])],{})", Factory.Production);
  private static final IConstructor prod__IfThenElseStatementNoShortIf_StatementNoShortIf__IfThenElseStatementNoShortIf_ = (IConstructor) _read("prod(label(\"IfThenElseStatementNoShortIf\",sort(\"StatementNoShortIf\")),[sort(\"IfThenElseStatementNoShortIf\")],{})", Factory.Production);
  private static final IConstructor prod__volatile_Modifier__conditional__lit_volatile__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(label(\"volatile\",sort(\"Modifier\")),[conditional(lit(\"volatile\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__FileHeader__lit___70_73_76_69_58_iter_star__char_class___range__0_9_range__11_65535_lit___10_ = (IConstructor) _read("prod(lex(\"FileHeader\"),[lit(\"FILE:\"),\\iter-star(\\char-class([range(0,9),range(11,65535)])),lit(\"\\n\")],{})", Factory.Production);
  private static final IConstructor prod__PrimaryNoNewArray_Expression_ArrayAccess__PrimaryNoNewArray_layouts_LAYOUTLIST_lit___91_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___93__tag__NotSupported___112_114_101_102_101_114 = (IConstructor) _read("prod(label(\"PrimaryNoNewArray-Expression\",sort(\"ArrayAccess\")),[sort(\"PrimaryNoNewArray\"),layouts(\"LAYOUTLIST\"),lit(\"[\"),layouts(\"LAYOUTLIST\"),sort(\"Expression\"),layouts(\"LAYOUTLIST\"),lit(\"]\")],{tag(NotSupported(\"prefer\"))})", Factory.Production);
  private static final IConstructor prod__le1_Expression__Expression_layouts_LAYOUTLIST_lit___60_61_layouts_LAYOUTLIST_Expression__assoc__left = (IConstructor) _read("prod(label(\"le1\",sort(\"Expression\")),[sort(\"Expression\"),layouts(\"LAYOUTLIST\"),lit(\"\\<=\"),layouts(\"LAYOUTLIST\"),sort(\"Expression\")],{assoc(left())})", Factory.Production);
  private static final IConstructor prod__InnerClassDeclaration_InterfaceMemberDeclaration__ClassDeclaration_ = (IConstructor) _read("prod(label(\"InnerClassDeclaration\",sort(\"InterfaceMemberDeclaration\")),[sort(\"ClassDeclaration\")],{})", Factory.Production);
  private static final IConstructor regular__opt__ForInit = (IConstructor) _read("regular(opt(sort(\"ForInit\")))", Factory.Production);
  private static final IConstructor prod__for_semicolon_semicolon_ForStatementNoShortIf__lit_for_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_opt__ForInit_layouts_LAYOUTLIST_lit___59_layouts_LAYOUTLIST_opt__Expression_layouts_LAYOUTLIST_lit___59_layouts_LAYOUTLIST_opt__ForUpdate_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_StatementNoShortIf_ = (IConstructor) _read("prod(label(\"for-semicolon-semicolon\",sort(\"ForStatementNoShortIf\")),[lit(\"for\"),layouts(\"LAYOUTLIST\"),lit(\"(\"),layouts(\"LAYOUTLIST\"),opt(sort(\"ForInit\")),layouts(\"LAYOUTLIST\"),lit(\";\"),layouts(\"LAYOUTLIST\"),opt(sort(\"Expression\")),layouts(\"LAYOUTLIST\"),lit(\";\"),layouts(\"LAYOUTLIST\"),opt(sort(\"ForUpdate\")),layouts(\"LAYOUTLIST\"),lit(\")\"),layouts(\"LAYOUTLIST\"),sort(\"StatementNoShortIf\")],{})", Factory.Production);
  private static final IConstructor prod__DecimalIntegerLiteral_IntegerLiteral__conditional__DecimalIntegerLiteral__not_follow__char_class___range__46_46_range__48_57_range__65_90_range__95_95_range__97_122__tag__NotSupported___112_114_101_102_101_114 = (IConstructor) _read("prod(label(\"DecimalIntegerLiteral\",sort(\"IntegerLiteral\")),[conditional(lex(\"DecimalIntegerLiteral\"),{\\not-follow(\\char-class([range(46,46),range(48,57),range(65,90),range(95,95),range(97,122)]))})],{tag(NotSupported(\"prefer\"))})", Factory.Production);
  private static final IConstructor prod__IdentifierKeywords__conditional__lit_final__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(keywords(\"IdentifierKeywords\"),[conditional(lit(\"final\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__IdentifierKeywords__conditional__lit_try__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(keywords(\"IdentifierKeywords\"),[conditional(lit(\"try\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__incr31_Expression__lit___43_43_layouts_LAYOUTLIST_Expression__tag__NotSupported___112_114_101_102_101_114 = (IConstructor) _read("prod(label(\"incr31\",sort(\"Expression\")),[lit(\"++\"),layouts(\"LAYOUTLIST\"),sort(\"Expression\")],{tag(NotSupported(\"prefer\"))})", Factory.Production);
  private static final IConstructor prod__Primary_Identifier_FieldAccess__Primary_layouts_LAYOUTLIST_lit___46_layouts_LAYOUTLIST_conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(label(\"Primary-Identifier\",sort(\"FieldAccess\")),[sort(\"Primary\"),layouts(\"LAYOUTLIST\"),lit(\".\"),layouts(\"LAYOUTLIST\"),conditional(lex(\"Identifier\"),{delete(conditional(keywords(\"IdentifierKeywords\"),{\\not-follow(\\char-class([range(36,36),range(48,57),range(65,90),range(95,95),range(97,122)]))}))})],{})", Factory.Production);
  private static final IConstructor prod__OctalLongLiteral_LongLiteral__conditional__OctalLongLiteral__not_follow__char_class___range__46_46_range__48_57_range__65_90_range__95_95_range__97_122__tag__NotSupported___112_114_101_102_101_114 = (IConstructor) _read("prod(label(\"OctalLongLiteral\",sort(\"LongLiteral\")),[conditional(lex(\"OctalLongLiteral\"),{\\not-follow(\\char-class([range(46,46),range(48,57),range(65,90),range(95,95),range(97,122)]))})],{tag(NotSupported(\"prefer\"))})", Factory.Production);
  private static final IConstructor regular__opt__PackageDeclaration = (IConstructor) _read("regular(opt(sort(\"PackageDeclaration\")))", Factory.Production);
  private static final IConstructor regular__iter_star_seps__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122__layouts_$default$ = (IConstructor) _read("regular(\\iter-star-seps(\\char-class([range(36,36),range(48,57),range(65,90),range(95,95),range(97,122)]),[layouts(\"$default$\")]))", Factory.Production);
  private static final IConstructor prod__IdentifierKeywords__conditional__lit_long__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(keywords(\"IdentifierKeywords\"),[conditional(lit(\"long\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__Identifier_SimpleName__conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(label(\"Identifier\",sort(\"SimpleName\")),[conditional(lex(\"Identifier\"),{delete(conditional(keywords(\"IdentifierKeywords\"),{\\not-follow(\\char-class([range(36,36),range(48,57),range(65,90),range(95,95),range(97,122)]))}))})],{})", Factory.Production);
  private static final IConstructor prod__lit___38_38__char_class___range__38_38_char_class___range__38_38_ = (IConstructor) _read("prod(lit(\"&&\"),[\\char-class([range(38,38)]),\\char-class([range(38,38)])],{})", Factory.Production);
  private static final IConstructor regular__iter_star__char_class___range__9_10_range__13_13_range__32_32 = (IConstructor) _read("regular(\\iter-star(\\char-class([range(9,10),range(13,13),range(32,32)])))", Factory.Production);
  private static final IConstructor prod__SwitchStatement_StatementWithoutTrailingSubstatement__SwitchStatement_ = (IConstructor) _read("prod(label(\"SwitchStatement\",sort(\"StatementWithoutTrailingSubstatement\")),[sort(\"SwitchStatement\")],{})", Factory.Production);
  private static final IConstructor regular__iter_seps__DimExpr__layouts_LAYOUTLIST = (IConstructor) _read("regular(\\iter-seps(sort(\"DimExpr\"),[layouts(\"LAYOUTLIST\")]))", Factory.Production);
  private static final IConstructor prod__lit_transient__char_class___range__116_116_char_class___range__114_114_char_class___range__97_97_char_class___range__110_110_char_class___range__115_115_char_class___range__105_105_char_class___range__101_101_char_class___range__110_110_char_class___range__116_116_ = (IConstructor) _read("prod(lit(\"transient\"),[\\char-class([range(116,116)]),\\char-class([range(114,114)]),\\char-class([range(97,97)]),\\char-class([range(110,110)]),\\char-class([range(115,115)]),\\char-class([range(105,105)]),\\char-class([range(101,101)]),\\char-class([range(110,110)]),\\char-class([range(116,116)])],{})", Factory.Production);
  private static final IConstructor prod__minus_Expression11_Expression__Expression_layouts_LAYOUTLIST_lit___layouts_LAYOUTLIST_Expression__assoc__left = (IConstructor) _read("prod(label(\"minus-Expression11\",sort(\"Expression\")),[sort(\"Expression\"),layouts(\"LAYOUTLIST\"),lit(\"-\"),layouts(\"LAYOUTLIST\"),sort(\"Expression\")],{assoc(left())})", Factory.Production);
  private static final IConstructor prod__address11_Expression__Expression_layouts_LAYOUTLIST_lit___38_layouts_LAYOUTLIST_Expression__assoc__left = (IConstructor) _read("prod(label(\"address11\",sort(\"Expression\")),[sort(\"Expression\"),layouts(\"LAYOUTLIST\"),lit(\"&\"),layouts(\"LAYOUTLIST\"),sort(\"Expression\")],{assoc(left())})", Factory.Production);
  private static final IConstructor prod__lit_long__char_class___range__108_108_char_class___range__111_111_char_class___range__110_110_char_class___range__103_103_ = (IConstructor) _read("prod(lit(\"long\"),[\\char-class([range(108,108)]),\\char-class([range(111,111)]),\\char-class([range(110,110)]),\\char-class([range(103,103)])],{})", Factory.Production);
  private static final IConstructor prod__IdentifierKeywords__conditional__lit_null__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(keywords(\"IdentifierKeywords\"),[conditional(lit(\"null\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__lit_synchronized__char_class___range__115_115_char_class___range__121_121_char_class___range__110_110_char_class___range__99_99_char_class___range__104_104_char_class___range__114_114_char_class___range__111_111_char_class___range__110_110_char_class___range__105_105_char_class___range__122_122_char_class___range__101_101_char_class___range__100_100_ = (IConstructor) _read("prod(lit(\"synchronized\"),[\\char-class([range(115,115)]),\\char-class([range(121,121)]),\\char-class([range(110,110)]),\\char-class([range(99,99)]),\\char-class([range(104,104)]),\\char-class([range(114,114)]),\\char-class([range(111,111)]),\\char-class([range(110,110)]),\\char-class([range(105,105)]),\\char-class([range(122,122)]),\\char-class([range(101,101)]),\\char-class([range(100,100)])],{})", Factory.Production);
  private static final IConstructor prod__semicolon1_EmptyStatement__lit___59_ = (IConstructor) _read("prod(label(\"semicolon1\",sort(\"EmptyStatement\")),[lit(\";\")],{})", Factory.Production);
  private static final IConstructor prod__MethodDeclarator_MethodDeclarator__MethodDeclarator_layouts_LAYOUTLIST_lit___91_layouts_LAYOUTLIST_lit___93_ = (IConstructor) _read("prod(label(\"MethodDeclarator\",sort(\"MethodDeclarator\")),[sort(\"MethodDeclarator\"),layouts(\"LAYOUTLIST\"),lit(\"[\"),layouts(\"LAYOUTLIST\"),lit(\"]\")],{})", Factory.Production);
  private static final IConstructor prod__lit___38_61__char_class___range__38_38_char_class___range__61_61_ = (IConstructor) _read("prod(lit(\"&=\"),[\\char-class([range(38,38)]),\\char-class([range(61,61)])],{})", Factory.Production);
  private static final IConstructor prod__colon2_Expression__Expression_layouts_LAYOUTLIST_lit___63_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___58_layouts_LAYOUTLIST_Expression__tag__NotSupported___112_114_101_102_101_114 = (IConstructor) _read("prod(label(\"colon2\",sort(\"Expression\")),[sort(\"Expression\"),layouts(\"LAYOUTLIST\"),lit(\"?\"),layouts(\"LAYOUTLIST\"),sort(\"Expression\"),layouts(\"LAYOUTLIST\"),lit(\":\"),layouts(\"LAYOUTLIST\"),sort(\"Expression\")],{tag(NotSupported(\"prefer\"))})", Factory.Production);
  private static final IConstructor prod__comma5_ConstructorDeclarator__SimpleName_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_iter_star_seps__FormalParameter__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41_ = (IConstructor) _read("prod(label(\"comma5\",sort(\"ConstructorDeclarator\")),[sort(\"SimpleName\"),layouts(\"LAYOUTLIST\"),lit(\"(\"),layouts(\"LAYOUTLIST\"),\\iter-star-seps(sort(\"FormalParameter\"),[layouts(\"LAYOUTLIST\"),lit(\",\"),layouts(\"LAYOUTLIST\")]),layouts(\"LAYOUTLIST\"),lit(\")\")],{})", Factory.Production);
  private static final IConstructor prod__lit_native__char_class___range__110_110_char_class___range__97_97_char_class___range__116_116_char_class___range__105_105_char_class___range__118_118_char_class___range__101_101_ = (IConstructor) _read("prod(lit(\"native\"),[\\char-class([range(110,110)]),\\char-class([range(97,97)]),\\char-class([range(116,116)]),\\char-class([range(105,105)]),\\char-class([range(118,118)]),\\char-class([range(101,101)])],{})", Factory.Production);
  private static final IConstructor prod__EscapeSequence__lit___92_char_class___range__48_51_char_class___range__48_55_char_class___range__48_55_ = (IConstructor) _read("prod(lex(\"EscapeSequence\"),[lit(\"\\\\\"),\\char-class([range(48,51)]),\\char-class([range(48,55)]),\\char-class([range(48,55)])],{})", Factory.Production);
  private static final IConstructor prod__NullLiteral__conditional__lit_null__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(lex(\"NullLiteral\"),[conditional(lit(\"null\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__StatementExpressionList1_ForUpdate__StatementExpressionList_ = (IConstructor) _read("prod(label(\"StatementExpressionList1\",sort(\"ForUpdate\")),[sort(\"StatementExpressionList\")],{})", Factory.Production);
  private static final IConstructor prod__decr31_StatementExpression__lit____layouts_LAYOUTLIST_Expression__tag__NotSupported___112_114_101_102_101_114 = (IConstructor) _read("prod(label(\"decr31\",sort(\"StatementExpression\")),[lit(\"--\"),layouts(\"LAYOUTLIST\"),sort(\"Expression\")],{tag(NotSupported(\"prefer\"))})", Factory.Production);
  private static final IConstructor prod__lit___33_61__char_class___range__33_33_char_class___range__61_61_ = (IConstructor) _read("prod(lit(\"!=\"),[\\char-class([range(33,33)]),\\char-class([range(61,61)])],{})", Factory.Production);
  private static final IConstructor prod__ClassBodyDeclaration_s_ClassBody__lit___123_layouts_LAYOUTLIST_iter_star_seps__ClassBodyDeclaration__layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___125_ = (IConstructor) _read("prod(label(\"ClassBodyDeclaration-s\",sort(\"ClassBody\")),[lit(\"{\"),layouts(\"LAYOUTLIST\"),\\iter-star-seps(sort(\"ClassBodyDeclaration\"),[layouts(\"LAYOUTLIST\")]),layouts(\"LAYOUTLIST\"),lit(\"}\")],{})", Factory.Production);
  private static final IConstructor prod__WhileStatementNoShortIf_StatementNoShortIf__WhileStatementNoShortIf_ = (IConstructor) _read("prod(label(\"WhileStatementNoShortIf\",sort(\"StatementNoShortIf\")),[sort(\"WhileStatementNoShortIf\")],{})", Factory.Production);
  private static final IConstructor prod__lit_this__char_class___range__116_116_char_class___range__104_104_char_class___range__105_105_char_class___range__115_115_ = (IConstructor) _read("prod(lit(\"this\"),[\\char-class([range(116,116)]),\\char-class([range(104,104)]),\\char-class([range(105,105)]),\\char-class([range(115,115)])],{})", Factory.Production);
  private static final IConstructor regular__iter_seps__ClassType__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST = (IConstructor) _read("regular(\\iter-seps(sort(\"ClassType\"),[layouts(\"LAYOUTLIST\"),lit(\",\"),layouts(\"LAYOUTLIST\")]))", Factory.Production);
  private static final IConstructor prod__FloatingPointLiteral__lit___46_iter__char_class___range__48_57_opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_char_class___range__70_70_range__102_102_ = (IConstructor) _read("prod(lex(\"FloatingPointLiteral\"),[lit(\".\"),iter(\\char-class([range(48,57)])),opt(seq([\\char-class([range(69,69),range(101,101)]),opt(\\char-class([range(43,43),range(45,45)])),iter(\\char-class([range(48,57)]))])),\\char-class([range(70,70),range(102,102)])],{})", Factory.Production);
  private static final IConstructor prod__ForStatementNoShortIf_StatementNoShortIf__ForStatementNoShortIf_ = (IConstructor) _read("prod(label(\"ForStatementNoShortIf\",sort(\"StatementNoShortIf\")),[sort(\"ForStatementNoShortIf\")],{})", Factory.Production);
  private static final IConstructor prod__IdentifierKeywords__conditional__lit_break__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(keywords(\"IdentifierKeywords\"),[conditional(lit(\"break\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__semicolon2_ExpressionStatement__StatementExpression_layouts_LAYOUTLIST_lit___59_ = (IConstructor) _read("prod(label(\"semicolon2\",sort(\"ExpressionStatement\")),[sort(\"StatementExpression\"),layouts(\"LAYOUTLIST\"),lit(\";\")],{})", Factory.Production);
  private static final IConstructor prod__Comment__lit___47_47_iter_star__char_class___range__0_9_range__11_65535_char_class___range__10_10_ = (IConstructor) _read("prod(lex(\"Comment\"),[lit(\"//\"),\\iter-star(\\char-class([range(0,9),range(11,65535)])),\\char-class([range(10,10)])],{})", Factory.Production);
  private static final IConstructor prod__Identifier__char_class___range__36_36_range__65_90_range__95_95_range__97_122_layouts_$default$_conditional__iter_star_seps__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122__layouts_$default$__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(sort(\"Identifier\"),[\\char-class([range(36,36),range(65,90),range(95,95),range(97,122)]),layouts(\"$default$\"),conditional(\\iter-star-seps(\\char-class([range(36,36),range(48,57),range(65,90),range(95,95),range(97,122)]),[layouts(\"$default$\")]),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__div1_Expression__Expression_layouts_LAYOUTLIST_lit___47_layouts_LAYOUTLIST_Expression__assoc__left = (IConstructor) _read("prod(label(\"div1\",sort(\"Expression\")),[sort(\"Expression\"),layouts(\"LAYOUTLIST\"),lit(\"/\"),layouts(\"LAYOUTLIST\"),sort(\"Expression\")],{assoc(left())})", Factory.Production);
  private static final IConstructor prod__plus_Expression__lit___43_layouts_LAYOUTLIST_Expression_ = (IConstructor) _read("prod(label(\"plus\",sort(\"Expression\")),[lit(\"+\"),layouts(\"LAYOUTLIST\"),sort(\"Expression\")],{})", Factory.Production);
  private static final IConstructor prod__lit_implements__char_class___range__105_105_char_class___range__109_109_char_class___range__112_112_char_class___range__108_108_char_class___range__101_101_char_class___range__109_109_char_class___range__101_101_char_class___range__110_110_char_class___range__116_116_char_class___range__115_115_ = (IConstructor) _read("prod(lit(\"implements\"),[\\char-class([range(105,105)]),\\char-class([range(109,109)]),\\char-class([range(112,112)]),\\char-class([range(108,108)]),\\char-class([range(101,101)]),\\char-class([range(109,109)]),\\char-class([range(101,101)]),\\char-class([range(110,110)]),\\char-class([range(116,116)]),\\char-class([range(115,115)])],{})", Factory.Production);
  private static final IConstructor prod__CharacterLiteral_Literal__CharacterLiteral__tag__NotSupported___112_114_101_102_101_114 = (IConstructor) _read("prod(label(\"CharacterLiteral\",sort(\"Literal\")),[lex(\"CharacterLiteral\")],{tag(NotSupported(\"prefer\"))})", Factory.Production);
  private static final IConstructor prod__void_MethodRes__conditional__lit_void__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(label(\"void\",sort(\"MethodRes\")),[conditional(lit(\"void\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__AssignmentOperator_dunno_b_0_AssignmentOperator__lit___62_62_62_61_ = (IConstructor) _read("prod(label(\"AssignmentOperator-dunno-b_0\",sort(\"AssignmentOperator\")),[lit(\"\\>\\>\\>=\")],{})", Factory.Production);
  private static final IConstructor prod__ArrayType1_ArrayType__ArrayType_layouts_LAYOUTLIST_lit___91_layouts_LAYOUTLIST_lit___93_ = (IConstructor) _read("prod(label(\"ArrayType1\",sort(\"ArrayType\")),[sort(\"ArrayType\"),layouts(\"LAYOUTLIST\"),lit(\"[\"),layouts(\"LAYOUTLIST\"),lit(\"]\")],{})", Factory.Production);
  private static final IConstructor prod__lit_view__char_class___range__118_118_char_class___range__105_105_char_class___range__101_101_char_class___range__119_119_ = (IConstructor) _read("prod(lit(\"view\"),[\\char-class([range(118,118)]),\\char-class([range(105,105)]),\\char-class([range(101,101)]),\\char-class([range(119,119)])],{})", Factory.Production);
  private static final IConstructor prod__native_Modifier__conditional__lit_native__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(label(\"native\",sort(\"Modifier\")),[conditional(lit(\"native\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__Assignment1_Expression__Assignment_ = (IConstructor) _read("prod(label(\"Assignment1\",sort(\"Expression\")),[sort(\"Assignment\")],{})", Factory.Production);
  private static final IConstructor prod__byte_IntegralType__conditional__lit_byte__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(label(\"byte\",sort(\"IntegralType\")),[conditional(lit(\"byte\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__PrimitiveType1_ArrayType__PrimitiveType_layouts_LAYOUTLIST_lit___91_layouts_LAYOUTLIST_lit___93_ = (IConstructor) _read("prod(label(\"PrimitiveType1\",sort(\"ArrayType\")),[sort(\"PrimitiveType\"),layouts(\"LAYOUTLIST\"),lit(\"[\"),layouts(\"LAYOUTLIST\"),lit(\"]\")],{})", Factory.Production);
  private static final IConstructor prod__lit_while__char_class___range__119_119_char_class___range__104_104_char_class___range__105_105_char_class___range__108_108_char_class___range__101_101_ = (IConstructor) _read("prod(lit(\"while\"),[\\char-class([range(119,119)]),\\char-class([range(104,104)]),\\char-class([range(105,105)]),\\char-class([range(108,108)]),\\char-class([range(101,101)])],{})", Factory.Production);
  private static final IConstructor prod__Comment__lit___47_47_conditional__iter_star__char_class___range__0_9_range__11_65535__end_of_line_ = (IConstructor) _read("prod(lex(\"Comment\"),[lit(\"//\"),conditional(\\iter-star(\\char-class([range(0,9),range(11,65535)])),{\\end-of-line()})],{})", Factory.Production);
  private static final IConstructor prod__AbstractMethodDeclaration_InterfaceMemberDeclaration__AbstractMethodDeclaration_ = (IConstructor) _read("prod(label(\"AbstractMethodDeclaration\",sort(\"InterfaceMemberDeclaration\")),[sort(\"AbstractMethodDeclaration\")],{})", Factory.Production);
  private static final IConstructor prod__synchronized_SynchronizedStatement__conditional__lit_synchronized__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_Block_ = (IConstructor) _read("prod(label(\"synchronized\",sort(\"SynchronizedStatement\")),[conditional(lit(\"synchronized\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts(\"LAYOUTLIST\"),lit(\"(\"),layouts(\"LAYOUTLIST\"),sort(\"Expression\"),layouts(\"LAYOUTLIST\"),lit(\")\"),layouts(\"LAYOUTLIST\"),sort(\"Block\")],{})", Factory.Production);
  private static final IConstructor prod__times1_Expression__Expression_layouts_LAYOUTLIST_lit___42_layouts_LAYOUTLIST_Expression__assoc__left = (IConstructor) _read("prod(label(\"times1\",sort(\"Expression\")),[sort(\"Expression\"),layouts(\"LAYOUTLIST\"),lit(\"*\"),layouts(\"LAYOUTLIST\"),sort(\"Expression\")],{assoc(left())})", Factory.Production);
  private static final IConstructor prod__IdentifierKeywords__conditional__lit_instanceof__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(keywords(\"IdentifierKeywords\"),[conditional(lit(\"instanceof\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__OctalIntegerLiteral__char_class___range__48_48_iter__char_class___range__48_55_ = (IConstructor) _read("prod(lex(\"OctalIntegerLiteral\"),[\\char-class([range(48,48)]),iter(\\char-class([range(48,55)]))],{})", Factory.Production);
  private static final IConstructor prod__IfThenElseStatement_Statement__IfThenElseStatement_ = (IConstructor) _read("prod(label(\"IfThenElseStatement\",sort(\"Statement\")),[sort(\"IfThenElseStatement\")],{})", Factory.Production);
  private static final IConstructor prod__IdentifierKeywords__conditional__lit_void__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(keywords(\"IdentifierKeywords\"),[conditional(lit(\"void\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__class_Name__Type_layouts_LAYOUTLIST_lit___46_layouts_LAYOUTLIST_conditional__lit_class__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(label(\"class\",sort(\"Name\")),[sort(\"Type\"),layouts(\"LAYOUTLIST\"),lit(\".\"),layouts(\"LAYOUTLIST\"),conditional(lit(\"class\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__BlockStatement_s_Block__lit___123_layouts_LAYOUTLIST_iter_star_seps__BlockStatement__layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___125_ = (IConstructor) _read("prod(label(\"BlockStatement-s\",sort(\"Block\")),[lit(\"{\"),layouts(\"LAYOUTLIST\"),\\iter-star-seps(sort(\"BlockStatement\"),[layouts(\"LAYOUTLIST\")]),layouts(\"LAYOUTLIST\"),lit(\"}\")],{})", Factory.Production);
  private static final IConstructor prod__Type__Identifier_layouts_LAYOUTLIST_lit___60_layouts_LAYOUTLIST_iter_seps__Type__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___62_ = (IConstructor) _read("prod(sort(\"Type\"),[lex(\"Identifier\"),layouts(\"LAYOUTLIST\"),lit(\"\\<\"),layouts(\"LAYOUTLIST\"),\\iter-seps(sort(\"Type\"),[layouts(\"LAYOUTLIST\"),lit(\",\"),layouts(\"LAYOUTLIST\")]),layouts(\"LAYOUTLIST\"),lit(\"\\>\")],{})", Factory.Production);
  private static final IConstructor prod__IdentifierKeywords__conditional__lit_native__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(keywords(\"IdentifierKeywords\"),[conditional(lit(\"native\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__shift_right1_Expression__Expression_layouts_LAYOUTLIST_lit___62_62_layouts_LAYOUTLIST_Expression__assoc__left = (IConstructor) _read("prod(label(\"shift-right1\",sort(\"Expression\")),[sort(\"Expression\"),layouts(\"LAYOUTLIST\"),lit(\"\\>\\>\"),layouts(\"LAYOUTLIST\"),sort(\"Expression\")],{assoc(left())})", Factory.Production);
  private static final IConstructor prod__comma1_StatementExpressionList__iter_seps__StatementExpression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_ = (IConstructor) _read("prod(label(\"comma1\",sort(\"StatementExpressionList\")),[\\iter-seps(sort(\"StatementExpression\"),[layouts(\"LAYOUTLIST\"),lit(\",\"),layouts(\"LAYOUTLIST\")])],{})", Factory.Production);
  private static final IConstructor prod__DecimalLongLiteral__lit_0_char_class___range__76_76_range__108_108_ = (IConstructor) _read("prod(lex(\"DecimalLongLiteral\"),[lit(\"0\"),\\char-class([range(76,76),range(108,108)])],{})", Factory.Production);
  private static final IConstructor prod__lit_default__char_class___range__100_100_char_class___range__101_101_char_class___range__102_102_char_class___range__97_97_char_class___range__117_117_char_class___range__108_108_char_class___range__116_116_ = (IConstructor) _read("prod(lit(\"default\"),[\\char-class([range(100,100)]),\\char-class([range(101,101)]),\\char-class([range(102,102)]),\\char-class([range(97,97)]),\\char-class([range(117,117)]),\\char-class([range(108,108)]),\\char-class([range(116,116)])],{})", Factory.Production);
  private static final IConstructor prod__throws_comma_Throws__conditional__lit_throws__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_iter_seps__ClassType__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_ = (IConstructor) _read("prod(label(\"throws-comma\",sort(\"Throws\")),[conditional(lit(\"throws\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts(\"LAYOUTLIST\"),\\iter-seps(sort(\"ClassType\"),[layouts(\"LAYOUTLIST\"),lit(\",\"),layouts(\"LAYOUTLIST\")])],{})", Factory.Production);
  private static final IConstructor prod__IdentifierKeywords__conditional__lit_implements__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(keywords(\"IdentifierKeywords\"),[conditional(lit(\"implements\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__Name1_ArrayType__Name_layouts_LAYOUTLIST_lit___91_layouts_LAYOUTLIST_lit___93_ = (IConstructor) _read("prod(label(\"Name1\",sort(\"ArrayType\")),[sort(\"Name\"),layouts(\"LAYOUTLIST\"),lit(\"[\"),layouts(\"LAYOUTLIST\"),lit(\"]\")],{})", Factory.Production);
  private static final IConstructor prod__IdentifierKeywords__conditional__lit_default__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(keywords(\"IdentifierKeywords\"),[conditional(lit(\"default\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__BooleanLiteral__conditional__lit_false__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(lex(\"BooleanLiteral\"),[conditional(lit(\"false\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__FieldDeclaration_ConstantDeclaration__FieldDeclaration_ = (IConstructor) _read("prod(label(\"FieldDeclaration\",sort(\"ConstantDeclaration\")),[sort(\"FieldDeclaration\")],{})", Factory.Production);
  private static final IConstructor regular__iter_star_seps__TokenDef__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST = (IConstructor) _read("regular(\\iter-star-seps(sort(\"TokenDef\"),[layouts(\"LAYOUTLIST\"),lit(\",\"),layouts(\"LAYOUTLIST\")]))", Factory.Production);
  private static final IConstructor prod__lit_super__char_class___range__115_115_char_class___range__117_117_char_class___range__112_112_char_class___range__101_101_char_class___range__114_114_ = (IConstructor) _read("prod(lit(\"super\"),[\\char-class([range(115,115)]),\\char-class([range(117,117)]),\\char-class([range(112,112)]),\\char-class([range(101,101)]),\\char-class([range(114,114)])],{})", Factory.Production);
  private static final IConstructor prod__assignDiv_AssignmentOperator__lit___47_61_ = (IConstructor) _read("prod(label(\"assignDiv\",sort(\"AssignmentOperator\")),[lit(\"/=\")],{})", Factory.Production);
  private static final IConstructor regular__iter__char_class___range__0_8_range__11_12_range__14_31_range__33_65535 = (IConstructor) _read("regular(iter(\\char-class([range(0,8),range(11,12),range(14,31),range(33,65535)])))", Factory.Production);
  private static final IConstructor prod__StatementWithoutTrailingSubstatement_Statement__StatementWithoutTrailingSubstatement_ = (IConstructor) _read("prod(label(\"StatementWithoutTrailingSubstatement\",sort(\"Statement\")),[sort(\"StatementWithoutTrailingSubstatement\")],{})", Factory.Production);
  private static final IConstructor prod__layouts_$QUOTES__conditional__iter_star__char_class___range__9_10_range__13_13_range__32_32__not_follow__char_class___range__9_10_range__13_13_range__32_32_ = (IConstructor) _read("prod(layouts(\"$QUOTES\"),[conditional(\\iter-star(\\char-class([range(9,10),range(13,13),range(32,32)])),{\\not-follow(\\char-class([range(9,10),range(13,13),range(32,32)]))})],{})", Factory.Production);
  private static final IConstructor prod__lit_byte__char_class___range__98_98_char_class___range__121_121_char_class___range__116_116_char_class___range__101_101_ = (IConstructor) _read("prod(lit(\"byte\"),[\\char-class([range(98,98)]),\\char-class([range(121,121)]),\\char-class([range(116,116)]),\\char-class([range(101,101)])],{})", Factory.Production);
  private static final IConstructor regular__iter_star__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122 = (IConstructor) _read("regular(\\iter-star(\\char-class([range(36,36),range(48,57),range(65,90),range(95,95),range(97,122)])))", Factory.Production);
  private static final IConstructor prod__assignExp_AssignmentOperator__lit___94_61_ = (IConstructor) _read("prod(label(\"assignExp\",sort(\"AssignmentOperator\")),[lit(\"^=\")],{})", Factory.Production);
  private static final IConstructor prod__lit___61_61__char_class___range__61_61_char_class___range__61_61_ = (IConstructor) _read("prod(lit(\"==\"),[\\char-class([range(61,61)]),\\char-class([range(61,61)])],{})", Factory.Production);
  private static final IConstructor prod__DecimalLongLiteral__char_class___range__49_57_iter_star__char_class___range__48_57_char_class___range__76_76_range__108_108_ = (IConstructor) _read("prod(lex(\"DecimalLongLiteral\"),[\\char-class([range(49,57)]),\\iter-star(\\char-class([range(48,57)])),\\char-class([range(76,76),range(108,108)])],{})", Factory.Production);
  private static final IConstructor prod__Expression_VariableInitializer__Expression_ = (IConstructor) _read("prod(label(\"Expression\",sort(\"VariableInitializer\")),[sort(\"Expression\")],{})", Factory.Production);
  private static final IConstructor prod__lit___62_61__char_class___range__62_62_char_class___range__61_61_ = (IConstructor) _read("prod(lit(\"\\>=\"),[\\char-class([range(62,62)]),\\char-class([range(61,61)])],{})", Factory.Production);
  private static final IConstructor prod__IdentifierKeywords__conditional__lit_class__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(keywords(\"IdentifierKeywords\"),[conditional(lit(\"class\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__IdentifierKeywords__conditional__lit_new__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(keywords(\"IdentifierKeywords\"),[conditional(lit(\"new\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__lit_volatile__char_class___range__118_118_char_class___range__111_111_char_class___range__108_108_char_class___range__97_97_char_class___range__116_116_char_class___range__105_105_char_class___range__108_108_char_class___range__101_101_ = (IConstructor) _read("prod(lit(\"volatile\"),[\\char-class([range(118,118)]),\\char-class([range(111,111)]),\\char-class([range(108,108)]),\\char-class([range(97,97)]),\\char-class([range(116,116)]),\\char-class([range(105,105)]),\\char-class([range(108,108)]),\\char-class([range(101,101)])],{})", Factory.Production);
  private static final IConstructor prod__StringCharacter__EscapeSequence_ = (IConstructor) _read("prod(lex(\"StringCharacter\"),[lex(\"EscapeSequence\")],{})", Factory.Production);
  private static final IConstructor prod__IfThenStatement_Statement__IfThenStatement_ = (IConstructor) _read("prod(label(\"IfThenStatement\",sort(\"Statement\")),[sort(\"IfThenStatement\")],{})", Factory.Production);
  private static final IConstructor prod__lit_private__char_class___range__112_112_char_class___range__114_114_char_class___range__105_105_char_class___range__118_118_char_class___range__97_97_char_class___range__116_116_char_class___range__101_101_ = (IConstructor) _read("prod(lit(\"private\"),[\\char-class([range(112,112)]),\\char-class([range(114,114)]),\\char-class([range(105,105)]),\\char-class([range(118,118)]),\\char-class([range(97,97)]),\\char-class([range(116,116)]),\\char-class([range(101,101)])],{})", Factory.Production);
  private static final IConstructor prod__Identifier_p_Name__iter_seps__Identifier__layouts_LAYOUTLIST_lit___46_layouts_LAYOUTLIST__tag__NotSupported___97_118_111_105_100 = (IConstructor) _read("prod(label(\"Identifier-p\",sort(\"Name\")),[\\iter-seps(lex(\"Identifier\"),[layouts(\"LAYOUTLIST\"),lit(\".\"),layouts(\"LAYOUTLIST\")])],{tag(NotSupported(\"avoid\"))})", Factory.Production);
  private static final IConstructor regular__opt__ExplicitConstructorInvocation = (IConstructor) _read("regular(opt(sort(\"ExplicitConstructorInvocation\")))", Factory.Production);
  private static final IConstructor prod__semicolon5_TypeDeclaration__lit___59_ = (IConstructor) _read("prod(label(\"semicolon5\",sort(\"TypeDeclaration\")),[lit(\";\")],{})", Factory.Production);
  private static final IConstructor prod__lit___124_124__char_class___range__124_124_char_class___range__124_124_ = (IConstructor) _read("prod(lit(\"||\"),[\\char-class([range(124,124)]),\\char-class([range(124,124)])],{})", Factory.Production);
  private static final IConstructor prod__lit_finally__char_class___range__102_102_char_class___range__105_105_char_class___range__110_110_char_class___range__97_97_char_class___range__108_108_char_class___range__108_108_char_class___range__121_121_ = (IConstructor) _read("prod(lit(\"finally\"),[\\char-class([range(102,102)]),\\char-class([range(105,105)]),\\char-class([range(110,110)]),\\char-class([range(97,97)]),\\char-class([range(108,108)]),\\char-class([range(108,108)]),\\char-class([range(121,121)])],{})", Factory.Production);
  private static final IConstructor prod__lit___60_61__char_class___range__60_60_char_class___range__61_61_ = (IConstructor) _read("prod(lit(\"\\<=\"),[\\char-class([range(60,60)]),\\char-class([range(61,61)])],{})", Factory.Production);
  private static final IConstructor prod__lit___60_60__char_class___range__60_60_char_class___range__60_60_ = (IConstructor) _read("prod(lit(\"\\<\\<\"),[\\char-class([range(60,60)]),\\char-class([range(60,60)])],{})", Factory.Production);
  private static final IConstructor regular__opt__Identifier = (IConstructor) _read("regular(opt(lex(\"Identifier\")))", Factory.Production);
  private static final IConstructor prod__lit___94_61__char_class___range__94_94_char_class___range__61_61_ = (IConstructor) _read("prod(lit(\"^=\"),[\\char-class([range(94,94)]),\\char-class([range(61,61)])],{})", Factory.Production);
  private static final IConstructor prod__assignMin_AssignmentOperator__lit___45_61_ = (IConstructor) _read("prod(label(\"assignMin\",sort(\"AssignmentOperator\")),[lit(\"-=\")],{})", Factory.Production);
  private static final IConstructor prod__lit_import__char_class___range__105_105_char_class___range__109_109_char_class___range__112_112_char_class___range__111_111_char_class___range__114_114_char_class___range__116_116_ = (IConstructor) _read("prod(lit(\"import\"),[\\char-class([range(105,105)]),\\char-class([range(109,109)]),\\char-class([range(112,112)]),\\char-class([range(111,111)]),\\char-class([range(114,114)]),\\char-class([range(116,116)])],{})", Factory.Production);
  private static final IConstructor prod__lit_else__char_class___range__101_101_char_class___range__108_108_char_class___range__115_115_char_class___range__101_101_ = (IConstructor) _read("prod(lit(\"else\"),[\\char-class([range(101,101)]),\\char-class([range(108,108)]),\\char-class([range(115,115)]),\\char-class([range(101,101)])],{})", Factory.Production);
  private static final IConstructor prod__IdentifierKeywords__conditional__lit_continue__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(keywords(\"IdentifierKeywords\"),[conditional(lit(\"continue\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor regular__iter_star__alt___conditional__char_class___range__42_42__not_follow__char_class___range__47_47_char_class___range__0_41_range__43_65535 = (IConstructor) _read("regular(\\iter-star(alt({conditional(\\char-class([range(42,42)]),{\\not-follow(\\char-class([range(47,47)]))}),\\char-class([range(0,41),range(43,65535)])})))", Factory.Production);
  private static final IConstructor prod__PackageDeclaration_opt_ImportDeclaration_s_TypeDeclaration_s_CompilationUnit__opt__PackageDeclaration_layouts_LAYOUTLIST_iter_star_seps__ImportDeclaration__layouts_LAYOUTLIST_layouts_LAYOUTLIST_iter_seps__TypeDeclaration__layouts_LAYOUTLIST__tag__NotSupported___112_114_101_102_101_114 = (IConstructor) _read("prod(label(\"PackageDeclaration-opt-ImportDeclaration-s-TypeDeclaration-s\",sort(\"CompilationUnit\")),[opt(sort(\"PackageDeclaration\")),layouts(\"LAYOUTLIST\"),\\iter-star-seps(sort(\"ImportDeclaration\"),[layouts(\"LAYOUTLIST\")]),layouts(\"LAYOUTLIST\"),\\iter-seps(sort(\"TypeDeclaration\"),[layouts(\"LAYOUTLIST\")])],{tag(NotSupported(\"prefer\"))})", Factory.Production);
  private static final IConstructor prod__ArrayAccess1_LeftHandSide__ArrayAccess_ = (IConstructor) _read("prod(label(\"ArrayAccess1\",sort(\"LeftHandSide\")),[sort(\"ArrayAccess\")],{})", Factory.Production);
  private static final IConstructor prod__IdentifierKeywords__conditional__lit_float__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(keywords(\"IdentifierKeywords\"),[conditional(lit(\"float\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__IdentifierKeywords__conditional__lit_transient__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(keywords(\"IdentifierKeywords\"),[conditional(lit(\"transient\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__lit_double__char_class___range__100_100_char_class___range__111_111_char_class___range__117_117_char_class___range__98_98_char_class___range__108_108_char_class___range__101_101_ = (IConstructor) _read("prod(lit(\"double\"),[\\char-class([range(100,100)]),\\char-class([range(111,111)]),\\char-class([range(117,117)]),\\char-class([range(98,98)]),\\char-class([range(108,108)]),\\char-class([range(101,101)])],{})", Factory.Production);
  private static final IConstructor prod__ArrayCreationExpression_Primary__ArrayCreationExpression_ = (IConstructor) _read("prod(label(\"ArrayCreationExpression\",sort(\"Primary\")),[sort(\"ArrayCreationExpression\")],{})", Factory.Production);
  private static final IConstructor prod__Whitespace__char_class___range__9_10_range__12_13_range__32_32_ = (IConstructor) _read("prod(lex(\"Whitespace\"),[\\char-class([range(9,10),range(12,13),range(32,32)])],{})", Factory.Production);
  private static final IConstructor prod__new_comma1_ClassInstanceCreationExpression__conditional__lit_new__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_ClassType_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_iter_star_seps__Expression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_ClassBody_ = (IConstructor) _read("prod(label(\"new-comma1\",sort(\"ClassInstanceCreationExpression\")),[conditional(lit(\"new\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts(\"LAYOUTLIST\"),sort(\"ClassType\"),layouts(\"LAYOUTLIST\"),lit(\"(\"),layouts(\"LAYOUTLIST\"),\\iter-star-seps(sort(\"Expression\"),[layouts(\"LAYOUTLIST\"),lit(\",\"),layouts(\"LAYOUTLIST\")]),layouts(\"LAYOUTLIST\"),lit(\")\"),layouts(\"LAYOUTLIST\"),sort(\"ClassBody\")],{})", Factory.Production);
  private static final IConstructor prod__class1_ClassDeclaration__iter_star_seps__Modifier__layouts_LAYOUTLIST_layouts_LAYOUTLIST_conditional__lit_class__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_opt__Super_layouts_LAYOUTLIST_opt__Interfaces_layouts_LAYOUTLIST_ClassBody_ = (IConstructor) _read("prod(label(\"class1\",sort(\"ClassDeclaration\")),[\\iter-star-seps(sort(\"Modifier\"),[layouts(\"LAYOUTLIST\")]),layouts(\"LAYOUTLIST\"),conditional(lit(\"class\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts(\"LAYOUTLIST\"),conditional(lex(\"Identifier\"),{delete(conditional(keywords(\"IdentifierKeywords\"),{\\not-follow(\\char-class([range(36,36),range(48,57),range(65,90),range(95,95),range(97,122)]))}))}),layouts(\"LAYOUTLIST\"),opt(sort(\"Super\")),layouts(\"LAYOUTLIST\"),opt(sort(\"Interfaces\")),layouts(\"LAYOUTLIST\"),sort(\"ClassBody\")],{})", Factory.Production);
  private static final IConstructor regular__iter_star_seps__Modifier__layouts_LAYOUTLIST = (IConstructor) _read("regular(\\iter-star-seps(sort(\"Modifier\"),[layouts(\"LAYOUTLIST\")]))", Factory.Production);
  private static final IConstructor prod__lit_new__char_class___range__110_110_char_class___range__101_101_char_class___range__119_119_ = (IConstructor) _read("prod(lit(\"new\"),[\\char-class([range(110,110)]),\\char-class([range(101,101)]),\\char-class([range(119,119)])],{})", Factory.Production);
  private static final IConstructor prod__lit___62_62__char_class___range__62_62_char_class___range__62_62_ = (IConstructor) _read("prod(lit(\"\\>\\>\"),[\\char-class([range(62,62)]),\\char-class([range(62,62)])],{})", Factory.Production);
  private static final IConstructor prod__IdentifierKeywords__conditional__lit_throw__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(keywords(\"IdentifierKeywords\"),[conditional(lit(\"throw\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor regular__opt__Interfaces = (IConstructor) _read("regular(opt(sort(\"Interfaces\")))", Factory.Production);
  private static final IConstructor prod__lit_try__char_class___range__116_116_char_class___range__114_114_char_class___range__121_121_ = (IConstructor) _read("prod(lit(\"try\"),[\\char-class([range(116,116)]),\\char-class([range(114,114)]),\\char-class([range(121,121)])],{})", Factory.Production);
  private static final IConstructor prod__MethodInvocation_StatementExpression__MethodInvocation_ = (IConstructor) _read("prod(label(\"MethodInvocation\",sort(\"StatementExpression\")),[sort(\"MethodInvocation\")],{})", Factory.Production);
  private static final IConstructor prod__incr21_StatementExpression__Expression_layouts_LAYOUTLIST_lit___43_43__tag__NotSupported___112_114_101_102_101_114 = (IConstructor) _read("prod(label(\"incr21\",sort(\"StatementExpression\")),[sort(\"Expression\"),layouts(\"LAYOUTLIST\"),lit(\"++\")],{tag(NotSupported(\"prefer\"))})", Factory.Production);
  private static final IConstructor prod__Identifier__conditional__lit___60_100_101_102_97_117_108_116_45_112_97_99_107_97_103_101_62__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(lex(\"Identifier\"),[conditional(lit(\"\\<default-package\\>\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__IdentifierKeywords__conditional__lit_private__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(keywords(\"IdentifierKeywords\"),[conditional(lit(\"private\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__CharacterLiteral__lit___39_SingleCharacter_lit___39_ = (IConstructor) _read("prod(lex(\"CharacterLiteral\"),[lit(\"\\'\\\\\"),lex(\"SingleCharacter\"),lit(\"\\'\\\\\")],{})", Factory.Production);
  private static final IConstructor prod__lit_break__char_class___range__98_98_char_class___range__114_114_char_class___range__101_101_char_class___range__97_97_char_class___range__107_107_ = (IConstructor) _read("prod(lit(\"break\"),[\\char-class([range(98,98)]),\\char-class([range(114,114)]),\\char-class([range(101,101)]),\\char-class([range(97,97)]),\\char-class([range(107,107)])],{})", Factory.Production);
  private static final IConstructor prod__Identifier__conditional__lit___60_105_110_105_116_62__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(lex(\"Identifier\"),[conditional(lit(\"\\<init\\>\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__lit_interface__char_class___range__105_105_char_class___range__110_110_char_class___range__116_116_char_class___range__101_101_char_class___range__114_114_char_class___range__102_102_char_class___range__97_97_char_class___range__99_99_char_class___range__101_101_ = (IConstructor) _read("prod(lit(\"interface\"),[\\char-class([range(105,105)]),\\char-class([range(110,110)]),\\char-class([range(116,116)]),\\char-class([range(101,101)]),\\char-class([range(114,114)]),\\char-class([range(102,102)]),\\char-class([range(97,97)]),\\char-class([range(99,99)]),\\char-class([range(101,101)])],{})", Factory.Production);
  private static final IConstructor regular__opt__Throws = (IConstructor) _read("regular(opt(sort(\"Throws\")))", Factory.Production);
  private static final IConstructor prod__FloatingPointLiteral__iter__char_class___range__48_57_opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_char_class___range__70_70_range__102_102_ = (IConstructor) _read("prod(lex(\"FloatingPointLiteral\"),[iter(\\char-class([range(48,57)])),opt(seq([\\char-class([range(69,69),range(101,101)]),opt(\\char-class([range(43,43),range(45,45)])),iter(\\char-class([range(48,57)]))])),\\char-class([range(70,70),range(102,102)])],{})", Factory.Production);
  private static final IConstructor prod__IdentifierKeywords__conditional__lit_extends__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(keywords(\"IdentifierKeywords\"),[conditional(lit(\"extends\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor regular__iter_seps__Type__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST = (IConstructor) _read("regular(\\iter-seps(sort(\"Type\"),[layouts(\"LAYOUTLIST\"),lit(\",\"),layouts(\"LAYOUTLIST\")]))", Factory.Production);
  private static final IConstructor regular__iter_star_seps__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122__layouts_LAYOUTLIST = (IConstructor) _read("regular(\\iter-star-seps(\\char-class([range(36,36),range(48,57),range(65,90),range(95,95),range(97,122)]),[layouts(\"LAYOUTLIST\")]))", Factory.Production);
  private static final IConstructor prod__lit_true__char_class___range__116_116_char_class___range__114_114_char_class___range__117_117_char_class___range__101_101_ = (IConstructor) _read("prod(lit(\"true\"),[\\char-class([range(116,116)]),\\char-class([range(114,114)]),\\char-class([range(117,117)]),\\char-class([range(101,101)])],{})", Factory.Production);
  private static final IConstructor prod__digits_NatCon__iter__char_class___range__48_57_ = (IConstructor) _read("prod(label(\"digits\",lex(\"NatCon\")),[iter(\\char-class([range(48,57)]))],{})", Factory.Production);
  private static final IConstructor prod__BooleanLiteral__conditional__lit_true__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(lex(\"BooleanLiteral\"),[conditional(lit(\"true\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__lit_null__char_class___range__110_110_char_class___range__117_117_char_class___range__108_108_char_class___range__108_108_ = (IConstructor) _read("prod(lit(\"null\"),[\\char-class([range(110,110)]),\\char-class([range(117,117)]),\\char-class([range(108,108)]),\\char-class([range(108,108)])],{})", Factory.Production);
  private static final IConstructor prod__CommentChar__char_class___range__0_41_range__43_65535_ = (IConstructor) _read("prod(lex(\"CommentChar\"),[\\char-class([range(0,41),range(43,65535)])],{})", Factory.Production);
  private static final IConstructor prod__MethodInvocation1_PrimaryNoNewArray__MethodInvocation_ = (IConstructor) _read("prod(label(\"MethodInvocation1\",sort(\"PrimaryNoNewArray\")),[sort(\"MethodInvocation\")],{})", Factory.Production);
  private static final IConstructor prod__synchronized1_Modifier__conditional__lit_synchronized__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(label(\"synchronized1\",sort(\"Modifier\")),[conditional(lit(\"synchronized\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__catch_CatchClause__conditional__lit_catch__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_FormalParameter_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_Block_ = (IConstructor) _read("prod(label(\"catch\",sort(\"CatchClause\")),[conditional(lit(\"catch\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts(\"LAYOUTLIST\"),lit(\"(\"),layouts(\"LAYOUTLIST\"),sort(\"FormalParameter\"),layouts(\"LAYOUTLIST\"),lit(\")\"),layouts(\"LAYOUTLIST\"),sort(\"Block\")],{})", Factory.Production);
  private static final IConstructor prod__ConstructorDeclaration_ClassBodyDeclaration__ConstructorDeclaration_ = (IConstructor) _read("prod(label(\"ConstructorDeclaration\",sort(\"ClassBodyDeclaration\")),[sort(\"ConstructorDeclaration\")],{})", Factory.Production);
  private static final IConstructor prod__ArrayType_ReferenceType__ArrayType_ = (IConstructor) _read("prod(label(\"ArrayType\",sort(\"ReferenceType\")),[sort(\"ArrayType\")],{})", Factory.Production);
  private static final IConstructor prod__EscapeSequence__lit___92_char_class___range__34_34_range__39_39_range__92_92_range__98_98_range__102_102_range__110_110_range__114_114_range__116_116_ = (IConstructor) _read("prod(lex(\"EscapeSequence\"),[lit(\"\\\\\"),\\char-class([range(34,34),range(39,39),range(92,92),range(98,98),range(102,102),range(110,110),range(114,114),range(116,116)])],{})", Factory.Production);
  private static final IConstructor prod__PrimaryNoNewArray_Primary__PrimaryNoNewArray_ = (IConstructor) _read("prod(label(\"PrimaryNoNewArray\",sort(\"Primary\")),[sort(\"PrimaryNoNewArray\")],{})", Factory.Production);
  private static final IConstructor prod__lit_void__char_class___range__118_118_char_class___range__111_111_char_class___range__105_105_char_class___range__100_100_ = (IConstructor) _read("prod(lit(\"void\"),[\\char-class([range(118,118)]),\\char-class([range(111,111)]),\\char-class([range(105,105)]),\\char-class([range(100,100)])],{})", Factory.Production);
  private static final IConstructor prod__field_CompilationUnit__FieldDeclaration_ = (IConstructor) _read("prod(label(\"field\",sort(\"CompilationUnit\")),[sort(\"FieldDeclaration\")],{})", Factory.Production);
  private static final IConstructor prod__LAYOUT__Comment_ = (IConstructor) _read("prod(sort(\"LAYOUT\"),[lex(\"Comment\")],{})", Factory.Production);
  private static final IConstructor prod__FloatingPointLiteral__iter__char_class___range__48_57_char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_char_class___range__70_70_range__102_102_ = (IConstructor) _read("prod(lex(\"FloatingPointLiteral\"),[iter(\\char-class([range(48,57)])),\\char-class([range(69,69),range(101,101)]),opt(\\char-class([range(43,43),range(45,45)])),iter(\\char-class([range(48,57)])),\\char-class([range(70,70),range(102,102)])],{})", Factory.Production);
  private static final IConstructor prod__Name_Expression_ArrayAccess__Name_layouts_LAYOUTLIST_lit___91_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___93_ = (IConstructor) _read("prod(label(\"Name-Expression\",sort(\"ArrayAccess\")),[sort(\"Name\"),layouts(\"LAYOUTLIST\"),lit(\"[\"),layouts(\"LAYOUTLIST\"),sort(\"Expression\"),layouts(\"LAYOUTLIST\"),lit(\"]\")],{})", Factory.Production);
  private static final IConstructor prod__colon1_LabeledStatementNoShortIf__conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___58_layouts_LAYOUTLIST_StatementNoShortIf_ = (IConstructor) _read("prod(label(\"colon1\",sort(\"LabeledStatementNoShortIf\")),[conditional(lex(\"Identifier\"),{delete(conditional(keywords(\"IdentifierKeywords\"),{\\not-follow(\\char-class([range(36,36),range(48,57),range(65,90),range(95,95),range(97,122)]))}))}),layouts(\"LAYOUTLIST\"),lit(\":\"),layouts(\"LAYOUTLIST\"),sort(\"StatementNoShortIf\")],{})", Factory.Production);
  private static final IConstructor regular__iter_star_seps__ClassBodyDeclaration__layouts_LAYOUTLIST = (IConstructor) _read("regular(\\iter-star-seps(sort(\"ClassBodyDeclaration\"),[layouts(\"LAYOUTLIST\")]))", Factory.Production);
  private static final IConstructor prod__empty__ = (IConstructor) _read("prod(empty(),[],{})", Factory.Production);
  private static final IConstructor regular__opt__Expression = (IConstructor) _read("regular(opt(sort(\"Expression\")))", Factory.Production);
  private static final IConstructor prod__IdentifierKeywords__conditional__lit_return__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(keywords(\"IdentifierKeywords\"),[conditional(lit(\"return\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__Identifier__conditional__lit___60_115_116_97_116_105_99_45_105_110_105_116_62__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(lex(\"Identifier\"),[conditional(lit(\"\\<static-init\\>\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__Name11_FieldAccess__Name__tag__NotSupported___97_118_111_105_100 = (IConstructor) _read("prod(label(\"Name11\",sort(\"FieldAccess\")),[sort(\"Name\")],{tag(NotSupported(\"avoid\"))})", Factory.Production);
  private static final IConstructor prod__lit_switch__char_class___range__115_115_char_class___range__119_119_char_class___range__105_105_char_class___range__116_116_char_class___range__99_99_char_class___range__104_104_ = (IConstructor) _read("prod(lit(\"switch\"),[\\char-class([range(115,115)]),\\char-class([range(119,119)]),\\char-class([range(105,105)]),\\char-class([range(116,116)]),\\char-class([range(99,99)]),\\char-class([range(104,104)])],{})", Factory.Production);
  private static final IConstructor prod__assignAnd_AssignmentOperator__lit___38_61_ = (IConstructor) _read("prod(label(\"assignAnd\",sort(\"AssignmentOperator\")),[lit(\"&=\")],{})", Factory.Production);
  private static final IConstructor prod__file_with_header_File__FileHeader_layouts_LAYOUTLIST_CompilationUnit_ = (IConstructor) _read("prod(label(\"file-with-header\",sort(\"File\")),[lex(\"FileHeader\"),layouts(\"LAYOUTLIST\"),sort(\"CompilationUnit\")],{})", Factory.Production);
  private static final IConstructor prod__type_MethodRes__Type_ = (IConstructor) _read("prod(label(\"type\",sort(\"MethodRes\")),[sort(\"Type\")],{})", Factory.Production);
  private static final IConstructor prod__WhileStatement_Statement__WhileStatement_ = (IConstructor) _read("prod(label(\"WhileStatement\",sort(\"Statement\")),[sort(\"WhileStatement\")],{})", Factory.Production);
  private static final IConstructor prod__break_semicolon_BreakStatement__conditional__lit_break__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_opt__Identifier_layouts_LAYOUTLIST_lit___59_ = (IConstructor) _read("prod(label(\"break-semicolon\",sort(\"BreakStatement\")),[conditional(lit(\"break\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts(\"LAYOUTLIST\"),opt(lex(\"Identifier\")),layouts(\"LAYOUTLIST\"),lit(\";\")],{})", Factory.Production);
  private static final IConstructor prod__PrimitiveType_Dim_s_Expression_Expression__lit___40_layouts_LAYOUTLIST_PrimitiveType_layouts_LAYOUTLIST_iter_star_seps__Dim__layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_Expression_ = (IConstructor) _read("prod(label(\"PrimitiveType-Dim-s-Expression\",sort(\"Expression\")),[lit(\"(\"),layouts(\"LAYOUTLIST\"),sort(\"PrimitiveType\"),layouts(\"LAYOUTLIST\"),\\iter-star-seps(sort(\"Dim\"),[layouts(\"LAYOUTLIST\")]),layouts(\"LAYOUTLIST\"),lit(\")\"),layouts(\"LAYOUTLIST\"),sort(\"Expression\")],{})", Factory.Production);
  private static final IConstructor prod__lit_returns__char_class___range__114_114_char_class___range__101_101_char_class___range__116_116_char_class___range__117_117_char_class___range__114_114_char_class___range__110_110_char_class___range__115_115_ = (IConstructor) _read("prod(lit(\"returns\"),[\\char-class([range(114,114)]),\\char-class([range(101,101)]),\\char-class([range(116,116)]),\\char-class([range(117,117)]),\\char-class([range(114,114)]),\\char-class([range(110,110)]),\\char-class([range(115,115)])],{})", Factory.Production);
  private static final IConstructor regular__iter_star_seps__FormalParameter__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST = (IConstructor) _read("regular(\\iter-star-seps(sort(\"FormalParameter\"),[layouts(\"LAYOUTLIST\"),lit(\",\"),layouts(\"LAYOUTLIST\")]))", Factory.Production);
  private static final IConstructor prod__try1_TryStatement__conditional__lit_try__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Block_layouts_LAYOUTLIST_iter_star_seps__CatchClause__layouts_LAYOUTLIST_layouts_LAYOUTLIST_Finally_ = (IConstructor) _read("prod(label(\"try1\",sort(\"TryStatement\")),[conditional(lit(\"try\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts(\"LAYOUTLIST\"),sort(\"Block\"),layouts(\"LAYOUTLIST\"),\\iter-star-seps(sort(\"CatchClause\"),[layouts(\"LAYOUTLIST\")]),layouts(\"LAYOUTLIST\"),sort(\"Finally\")],{})", Factory.Production);
  private static final IConstructor regular__opt__ForUpdate = (IConstructor) _read("regular(opt(sort(\"ForUpdate\")))", Factory.Production);
  private static final IConstructor prod__IdentifierKeywords__conditional__lit_public__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(keywords(\"IdentifierKeywords\"),[conditional(lit(\"public\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor regular__iter_star_seps__InterfaceMemberDeclaration__layouts_LAYOUTLIST = (IConstructor) _read("regular(\\iter-star-seps(sort(\"InterfaceMemberDeclaration\"),[layouts(\"LAYOUTLIST\")]))", Factory.Production);
  private static final IConstructor prod__and11_Expression__Expression_layouts_LAYOUTLIST_lit___38_38_layouts_LAYOUTLIST_Expression__assoc__left = (IConstructor) _read("prod(label(\"and11\",sort(\"Expression\")),[sort(\"Expression\"),layouts(\"LAYOUTLIST\"),lit(\"&&\"),layouts(\"LAYOUTLIST\"),sort(\"Expression\")],{assoc(left())})", Factory.Production);
  private static final IConstructor prod__ClassMemberDeclaration_ClassBodyDeclaration__ClassMemberDeclaration_ = (IConstructor) _read("prod(label(\"ClassMemberDeclaration\",sort(\"ClassBodyDeclaration\")),[sort(\"ClassMemberDeclaration\")],{})", Factory.Production);
  private static final IConstructor prod__TryStatement_StatementWithoutTrailingSubstatement__TryStatement_ = (IConstructor) _read("prod(label(\"TryStatement\",sort(\"StatementWithoutTrailingSubstatement\")),[sort(\"TryStatement\")],{})", Factory.Production);
  private static final IConstructor prod__VariableDeclaratorId_VariableDeclarator__VariableDeclaratorId_ = (IConstructor) _read("prod(label(\"VariableDeclaratorId\",sort(\"VariableDeclarator\")),[sort(\"VariableDeclaratorId\")],{})", Factory.Production);
  private static final IConstructor regular__iter_seps__TypeDeclaration__layouts_LAYOUTLIST = (IConstructor) _read("regular(\\iter-seps(sort(\"TypeDeclaration\"),[layouts(\"LAYOUTLIST\")]))", Factory.Production);
  private static final IConstructor prod__or11_Expression__Expression_layouts_LAYOUTLIST_lit___124_124_layouts_LAYOUTLIST_Expression__assoc__left = (IConstructor) _read("prod(label(\"or11\",sort(\"Expression\")),[sort(\"Expression\"),layouts(\"LAYOUTLIST\"),lit(\"||\"),layouts(\"LAYOUTLIST\"),sort(\"Expression\")],{assoc(left())})", Factory.Production);
  private static final IConstructor prod__lit_assert__char_class___range__97_97_char_class___range__115_115_char_class___range__115_115_char_class___range__101_101_char_class___range__114_114_char_class___range__116_116_ = (IConstructor) _read("prod(lit(\"assert\"),[\\char-class([range(97,97)]),\\char-class([range(115,115)]),\\char-class([range(115,115)]),\\char-class([range(101,101)]),\\char-class([range(114,114)]),\\char-class([range(116,116)])],{})", Factory.Production);
  private static final IConstructor regular__iter_seps__InterfaceType__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST = (IConstructor) _read("regular(\\iter-seps(sort(\"InterfaceType\"),[layouts(\"LAYOUTLIST\"),lit(\",\"),layouts(\"LAYOUTLIST\")]))", Factory.Production);
  private static final IConstructor prod__EscapeSequence__lit___92_char_class___range__48_55_ = (IConstructor) _read("prod(lex(\"EscapeSequence\"),[lit(\"\\\\\"),\\char-class([range(48,55)])],{})", Factory.Production);
  private static final IConstructor prod__TokenDef__Identifier_layouts_LAYOUTLIST_Identifier_ = (IConstructor) _read("prod(sort(\"TokenDef\"),[lex(\"Identifier\"),layouts(\"LAYOUTLIST\"),lex(\"Identifier\")],{})", Factory.Production);
  private static final IConstructor prod__IdentifierKeywords__conditional__lit_switch__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(keywords(\"IdentifierKeywords\"),[conditional(lit(\"switch\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__default_colon_SwitchLabel__conditional__lit_default__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___58_ = (IConstructor) _read("prod(label(\"default-colon\",sort(\"SwitchLabel\")),[conditional(lit(\"default\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts(\"LAYOUTLIST\"),lit(\":\")],{})", Factory.Production);
  private static final IConstructor prod__lit___124_61__char_class___range__124_124_char_class___range__61_61_ = (IConstructor) _read("prod(lit(\"|=\"),[\\char-class([range(124,124)]),\\char-class([range(61,61)])],{})", Factory.Production);
  private static final IConstructor prod__MethodHeader_MethodHeader__iter_star_seps__Modifier__layouts_LAYOUTLIST_layouts_LAYOUTLIST_MethodRes_layouts_LAYOUTLIST_MethodDeclarator_layouts_LAYOUTLIST_opt__Throws_ = (IConstructor) _read("prod(label(\"MethodHeader\",sort(\"MethodHeader\")),[\\iter-star-seps(sort(\"Modifier\"),[layouts(\"LAYOUTLIST\")]),layouts(\"LAYOUTLIST\"),sort(\"MethodRes\"),layouts(\"LAYOUTLIST\"),sort(\"MethodDeclarator\"),layouts(\"LAYOUTLIST\"),opt(sort(\"Throws\"))],{})", Factory.Production);
  private static final IConstructor prod__IdentifierKeywords__conditional__lit_throws__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(keywords(\"IdentifierKeywords\"),[conditional(lit(\"throws\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__comma2_MethodDeclarator__conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_iter_star_seps__FormalParameter__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41_ = (IConstructor) _read("prod(label(\"comma2\",sort(\"MethodDeclarator\")),[conditional(lex(\"Identifier\"),{delete(conditional(keywords(\"IdentifierKeywords\"),{\\not-follow(\\char-class([range(36,36),range(48,57),range(65,90),range(95,95),range(97,122)]))}))}),layouts(\"LAYOUTLIST\"),lit(\"(\"),layouts(\"LAYOUTLIST\"),\\iter-star-seps(sort(\"FormalParameter\"),[layouts(\"LAYOUTLIST\"),lit(\",\"),layouts(\"LAYOUTLIST\")]),layouts(\"LAYOUTLIST\"),lit(\")\")],{})", Factory.Production);
  private static final IConstructor prod__lit_start__char_class___range__115_115_char_class___range__116_116_char_class___range__97_97_char_class___range__114_114_char_class___range__116_116_ = (IConstructor) _read("prod(lit(\"start\"),[\\char-class([range(115,115)]),\\char-class([range(116,116)]),\\char-class([range(97,97)]),\\char-class([range(114,114)]),\\char-class([range(116,116)])],{})", Factory.Production);
  private static final IConstructor prod__super_comma_MethodInvocation__conditional__lit_super__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___46_layouts_LAYOUTLIST_conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_iter_star_seps__Expression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41__tag__NotSupported___112_114_101_102_101_114 = (IConstructor) _read("prod(label(\"super-comma\",sort(\"MethodInvocation\")),[conditional(lit(\"super\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts(\"LAYOUTLIST\"),lit(\".\"),layouts(\"LAYOUTLIST\"),conditional(lex(\"Identifier\"),{delete(conditional(keywords(\"IdentifierKeywords\"),{\\not-follow(\\char-class([range(36,36),range(48,57),range(65,90),range(95,95),range(97,122)]))}))}),layouts(\"LAYOUTLIST\"),lit(\"(\"),layouts(\"LAYOUTLIST\"),\\iter-star-seps(sort(\"Expression\"),[layouts(\"LAYOUTLIST\"),lit(\",\"),layouts(\"LAYOUTLIST\")]),layouts(\"LAYOUTLIST\"),lit(\")\")],{tag(NotSupported(\"prefer\"))})", Factory.Production);
  private static final IConstructor prod__not_Expression__lit___33_layouts_LAYOUTLIST_Expression_ = (IConstructor) _read("prod(label(\"not\",sort(\"Expression\")),[lit(\"!\"),layouts(\"LAYOUTLIST\"),sort(\"Expression\")],{})", Factory.Production);
  private static final IConstructor prod__ExpressionStatement_StatementWithoutTrailingSubstatement__ExpressionStatement_ = (IConstructor) _read("prod(label(\"ExpressionStatement\",sort(\"StatementWithoutTrailingSubstatement\")),[sort(\"ExpressionStatement\")],{})", Factory.Production);
  private static final IConstructor prod__if_else_IfThenElseStatement__conditional__lit_if__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_StatementNoShortIf_layouts_LAYOUTLIST_conditional__lit_else__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Statement_ = (IConstructor) _read("prod(label(\"if-else\",sort(\"IfThenElseStatement\")),[conditional(lit(\"if\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts(\"LAYOUTLIST\"),lit(\"(\"),layouts(\"LAYOUTLIST\"),sort(\"Expression\"),layouts(\"LAYOUTLIST\"),lit(\")\"),layouts(\"LAYOUTLIST\"),sort(\"StatementNoShortIf\"),layouts(\"LAYOUTLIST\"),conditional(lit(\"else\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts(\"LAYOUTLIST\"),sort(\"Statement\")],{})", Factory.Production);
  private static final IConstructor prod__StatementWithoutTrailingSubstatement1_StatementNoShortIf__StatementWithoutTrailingSubstatement_ = (IConstructor) _read("prod(label(\"StatementWithoutTrailingSubstatement1\",sort(\"StatementNoShortIf\")),[sort(\"StatementWithoutTrailingSubstatement\")],{})", Factory.Production);
  private static final IConstructor prod__DoubleLiteral__iter__char_class___range__48_57_lit___46_iter_star__char_class___range__48_57_opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_opt__char_class___range__68_68_range__100_100_ = (IConstructor) _read("prod(lex(\"DoubleLiteral\"),[iter(\\char-class([range(48,57)])),lit(\".\"),\\iter-star(\\char-class([range(48,57)])),opt(seq([\\char-class([range(69,69),range(101,101)]),opt(\\char-class([range(43,43),range(45,45)])),iter(\\char-class([range(48,57)]))])),opt(\\char-class([range(68,68),range(100,100)]))],{})", Factory.Production);
  private static final IConstructor prod__LocalVariableDeclarationStatement_BlockStatement__iter_star_seps__Modifier__layouts_LAYOUTLIST_layouts_LAYOUTLIST_LocalVariableDeclarationStatement_ = (IConstructor) _read("prod(label(\"LocalVariableDeclarationStatement\",sort(\"BlockStatement\")),[\\iter-star-seps(sort(\"Modifier\"),[layouts(\"LAYOUTLIST\")]),layouts(\"LAYOUTLIST\"),sort(\"LocalVariableDeclarationStatement\")],{})", Factory.Production);
  private static final IConstructor prod__comma_comma_ArrayInitializer__lit___123_layouts_LAYOUTLIST_iter_star_seps__VariableInitializer__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_opt__lit___44_layouts_LAYOUTLIST_lit___125_ = (IConstructor) _read("prod(label(\"comma-comma\",sort(\"ArrayInitializer\")),[lit(\"{\"),layouts(\"LAYOUTLIST\"),\\iter-star-seps(sort(\"VariableInitializer\"),[layouts(\"LAYOUTLIST\"),lit(\",\"),layouts(\"LAYOUTLIST\")]),layouts(\"LAYOUTLIST\"),opt(lit(\",\")),layouts(\"LAYOUTLIST\"),lit(\"}\")],{})", Factory.Production);
  private static final IConstructor prod__lit_short__char_class___range__115_115_char_class___range__104_104_char_class___range__111_111_char_class___range__114_114_char_class___range__116_116_ = (IConstructor) _read("prod(lit(\"short\"),[\\char-class([range(115,115)]),\\char-class([range(104,104)]),\\char-class([range(111,111)]),\\char-class([range(114,114)]),\\char-class([range(116,116)])],{})", Factory.Production);
  private static final IConstructor prod__CharacterLiteral__lit___39_EscapeSequence_lit___39_ = (IConstructor) _read("prod(lex(\"CharacterLiteral\"),[lit(\"\\'\\\\\"),lex(\"EscapeSequence\"),lit(\"\\'\\\\\")],{})", Factory.Production);
  private static final IConstructor prod__Expression1_PrimaryNoNewArray__lit___40_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___41_ = (IConstructor) _read("prod(label(\"Expression1\",sort(\"PrimaryNoNewArray\")),[lit(\"(\"),layouts(\"LAYOUTLIST\"),sort(\"Expression\"),layouts(\"LAYOUTLIST\"),lit(\")\")],{})", Factory.Production);
  private static final IConstructor prod__SynchronizedStatement_StatementWithoutTrailingSubstatement__SynchronizedStatement_ = (IConstructor) _read("prod(label(\"SynchronizedStatement\",sort(\"StatementWithoutTrailingSubstatement\")),[sort(\"SynchronizedStatement\")],{})", Factory.Production);
  private static final IConstructor prod__IdentifierKeywords__conditional__lit_package__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(keywords(\"IdentifierKeywords\"),[conditional(lit(\"package\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__Block_StatementWithoutTrailingSubstatement__Block_ = (IConstructor) _read("prod(label(\"Block\",sort(\"StatementWithoutTrailingSubstatement\")),[sort(\"Block\")],{})", Factory.Production);
  private static final IConstructor prod__lit_for__char_class___range__102_102_char_class___range__111_111_char_class___range__114_114_ = (IConstructor) _read("prod(lit(\"for\"),[\\char-class([range(102,102)]),\\char-class([range(111,111)]),\\char-class([range(114,114)])],{})", Factory.Production);
  private static final IConstructor prod__UnicodeEscape__lit___92_iter__char_class___range__117_117_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_ = (IConstructor) _read("prod(lex(\"UnicodeEscape\"),[lit(\"\\\\\"),iter(\\char-class([range(117,117)])),\\char-class([range(48,57),range(65,70),range(97,102)]),\\char-class([range(48,57),range(65,70),range(97,102)]),\\char-class([range(48,57),range(65,70),range(97,102)]),\\char-class([range(48,57),range(65,70),range(97,102)])],{})", Factory.Production);
  private static final IConstructor regular__iter_seps__DimExprInitialized__layouts_LAYOUTLIST = (IConstructor) _read("regular(\\iter-seps(sort(\"DimExprInitialized\"),[layouts(\"LAYOUTLIST\")]))", Factory.Production);
  private static final IConstructor regular__iter_seps__Identifier__layouts_LAYOUTLIST_lit___47_layouts_LAYOUTLIST = (IConstructor) _read("regular(\\iter-seps(lex(\"Identifier\"),[layouts(\"LAYOUTLIST\"),lit(\"/\"),layouts(\"LAYOUTLIST\")]))", Factory.Production);
  private static final IConstructor regular__iter_seps__Identifier__layouts_LAYOUTLIST_lit___46_layouts_LAYOUTLIST = (IConstructor) _read("regular(\\iter-seps(lex(\"Identifier\"),[layouts(\"LAYOUTLIST\"),lit(\".\"),layouts(\"LAYOUTLIST\")]))", Factory.Production);
  private static final IConstructor regular__iter_star__LAYOUT = (IConstructor) _read("regular(\\iter-star(sort(\"LAYOUT\")))", Factory.Production);
  private static final IConstructor prod__DecimalIntegerLiteral__char_class___range__49_57_iter_star__char_class___range__48_57_ = (IConstructor) _read("prod(lex(\"DecimalIntegerLiteral\"),[\\char-class([range(49,57)]),\\iter-star(\\char-class([range(48,57)]))],{})", Factory.Production);
  private static final IConstructor regular__empty = (IConstructor) _read("regular(empty())", Factory.Production);
  private static final IConstructor prod__BooleanLiteral_Literal__BooleanLiteral__tag__NotSupported___112_114_101_102_101_114 = (IConstructor) _read("prod(label(\"BooleanLiteral\",sort(\"Literal\")),[lex(\"BooleanLiteral\")],{tag(NotSupported(\"prefer\"))})", Factory.Production);
  private static final IConstructor regular__iter_star__char_class___range__0_9_range__11_65535 = (IConstructor) _read("regular(\\iter-star(\\char-class([range(0,9),range(11,65535)])))", Factory.Production);
  private static final IConstructor regular__iter_seps__SwitchLabel__layouts_LAYOUTLIST = (IConstructor) _read("regular(\\iter-seps(sort(\"SwitchLabel\"),[layouts(\"LAYOUTLIST\")]))", Factory.Production);
  private static final IConstructor prod__lit_instanceof__char_class___range__105_105_char_class___range__110_110_char_class___range__115_115_char_class___range__116_116_char_class___range__97_97_char_class___range__110_110_char_class___range__99_99_char_class___range__101_101_char_class___range__111_111_char_class___range__102_102_ = (IConstructor) _read("prod(lit(\"instanceof\"),[\\char-class([range(105,105)]),\\char-class([range(110,110)]),\\char-class([range(115,115)]),\\char-class([range(116,116)]),\\char-class([range(97,97)]),\\char-class([range(110,110)]),\\char-class([range(99,99)]),\\char-class([range(101,101)]),\\char-class([range(111,111)]),\\char-class([range(102,102)])],{})", Factory.Production);
  private static final IConstructor prod__new3_ArrayCreationExpression__conditional__lit_new__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_ClassOrInterfaceType_layouts_LAYOUTLIST_iter_seps__DimExprInitialized__layouts_LAYOUTLIST_layouts_LAYOUTLIST_ArrayInitializer_ = (IConstructor) _read("prod(label(\"new3\",sort(\"ArrayCreationExpression\")),[conditional(lit(\"new\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts(\"LAYOUTLIST\"),sort(\"ClassOrInterfaceType\"),layouts(\"LAYOUTLIST\"),\\iter-seps(sort(\"DimExprInitialized\"),[layouts(\"LAYOUTLIST\")]),layouts(\"LAYOUTLIST\"),sort(\"ArrayInitializer\")],{})", Factory.Production);
  private static final IConstructor prod__while1_WhileStatementNoShortIf__lit_while_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_StatementNoShortIf_ = (IConstructor) _read("prod(label(\"while1\",sort(\"WhileStatementNoShortIf\")),[lit(\"while\"),layouts(\"LAYOUTLIST\"),lit(\"(\"),layouts(\"LAYOUTLIST\"),sort(\"Expression\"),layouts(\"LAYOUTLIST\"),lit(\")\"),layouts(\"LAYOUTLIST\"),sort(\"StatementNoShortIf\")],{})", Factory.Production);
  private static final IConstructor prod__layouts_$BACKTICKS__ = (IConstructor) _read("prod(layouts(\"$BACKTICKS\"),[],{})", Factory.Production);
  private static final IConstructor regular__opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57 = (IConstructor) _read("regular(opt(seq([\\char-class([range(69,69),range(101,101)]),opt(\\char-class([range(43,43),range(45,45)])),iter(\\char-class([range(48,57)]))])))", Factory.Production);
  private static final IConstructor prod__static_Modifier__conditional__lit_static__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(label(\"static\",sort(\"Modifier\")),[conditional(lit(\"static\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor regular__iter_star_seps__BlockStatement__layouts_LAYOUTLIST = (IConstructor) _read("regular(\\iter-star-seps(sort(\"BlockStatement\"),[layouts(\"LAYOUTLIST\")]))", Factory.Production);
  private static final IConstructor prod__for_semicolon_semicolon_ForStatement__conditional__lit_for__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_opt__ForInit_layouts_LAYOUTLIST_lit___59_layouts_LAYOUTLIST_opt__Expression_layouts_LAYOUTLIST_lit___59_layouts_LAYOUTLIST_opt__ForUpdate_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_Statement_ = (IConstructor) _read("prod(label(\"for-semicolon-semicolon\",sort(\"ForStatement\")),[conditional(lit(\"for\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts(\"LAYOUTLIST\"),lit(\"(\"),layouts(\"LAYOUTLIST\"),opt(sort(\"ForInit\")),layouts(\"LAYOUTLIST\"),lit(\";\"),layouts(\"LAYOUTLIST\"),opt(sort(\"Expression\")),layouts(\"LAYOUTLIST\"),lit(\";\"),layouts(\"LAYOUTLIST\"),opt(sort(\"ForUpdate\")),layouts(\"LAYOUTLIST\"),lit(\")\"),layouts(\"LAYOUTLIST\"),sort(\"Statement\")],{})", Factory.Production);
  private static final IConstructor prod__OctalIntegerLiteral_IntegerLiteral__conditional__OctalIntegerLiteral__not_follow__char_class___range__46_46_range__48_57_range__65_90_range__95_95_range__97_122__tag__NotSupported___112_114_101_102_101_114 = (IConstructor) _read("prod(label(\"OctalIntegerLiteral\",sort(\"IntegerLiteral\")),[conditional(lex(\"OctalIntegerLiteral\"),{\\not-follow(\\char-class([range(46,46),range(48,57),range(65,90),range(95,95),range(97,122)]))})],{tag(NotSupported(\"prefer\"))})", Factory.Production);
  private static final IConstructor prod__comma21_MethodInvocation__Primary_layouts_LAYOUTLIST_lit___46_layouts_LAYOUTLIST_conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_iter_star_seps__Expression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41_ = (IConstructor) _read("prod(label(\"comma21\",sort(\"MethodInvocation\")),[sort(\"Primary\"),layouts(\"LAYOUTLIST\"),lit(\".\"),layouts(\"LAYOUTLIST\"),conditional(lex(\"Identifier\"),{delete(conditional(keywords(\"IdentifierKeywords\"),{\\not-follow(\\char-class([range(36,36),range(48,57),range(65,90),range(95,95),range(97,122)]))}))}),layouts(\"LAYOUTLIST\"),lit(\"(\"),layouts(\"LAYOUTLIST\"),\\iter-star-seps(sort(\"Expression\"),[layouts(\"LAYOUTLIST\"),lit(\",\"),layouts(\"LAYOUTLIST\")]),layouts(\"LAYOUTLIST\"),lit(\")\")],{})", Factory.Production);
  private static final IConstructor prod__incr31_StatementExpression__lit___43_43_layouts_LAYOUTLIST_Expression__tag__NotSupported___112_114_101_102_101_114 = (IConstructor) _read("prod(label(\"incr31\",sort(\"StatementExpression\")),[lit(\"++\"),layouts(\"LAYOUTLIST\"),sort(\"Expression\")],{tag(NotSupported(\"prefer\"))})", Factory.Production);
  private static final IConstructor prod__this1_PrimaryNoNewArray__Name_layouts_LAYOUTLIST_lit___46_layouts_LAYOUTLIST_conditional__lit_this__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(label(\"this1\",sort(\"PrimaryNoNewArray\")),[sort(\"Name\"),layouts(\"LAYOUTLIST\"),lit(\".\"),layouts(\"LAYOUTLIST\"),conditional(lit(\"this\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__lit_extends__char_class___range__101_101_char_class___range__120_120_char_class___range__116_116_char_class___range__101_101_char_class___range__110_110_char_class___range__100_100_char_class___range__115_115_ = (IConstructor) _read("prod(lit(\"extends\"),[\\char-class([range(101,101)]),\\char-class([range(120,120)]),\\char-class([range(116,116)]),\\char-class([range(101,101)]),\\char-class([range(110,110)]),\\char-class([range(100,100)]),\\char-class([range(115,115)])],{})", Factory.Production);
  private static final IConstructor prod__layouts_$default$__ = (IConstructor) _read("prod(layouts(\"$default$\"),[],{})", Factory.Production);
  private static final IConstructor prod__AssertStatement_Statement__AssertStatement_ = (IConstructor) _read("prod(label(\"AssertStatement\",sort(\"Statement\")),[sort(\"AssertStatement\")],{})", Factory.Production);
  private static final IConstructor prod__IdentifierKeywords__conditional__lit_else__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(keywords(\"IdentifierKeywords\"),[conditional(lit(\"else\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__IdentifierKeywords__conditional__lit_if__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(keywords(\"IdentifierKeywords\"),[conditional(lit(\"if\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__float_FloatingPointType__conditional__lit_float__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(label(\"float\",sort(\"FloatingPointType\")),[conditional(lit(\"float\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor regular__iter_star__StringCharacter = (IConstructor) _read("regular(\\iter-star(lex(\"StringCharacter\")))", Factory.Production);
  private static final IConstructor prod__IdentifierKeywords__conditional__lit_do__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(keywords(\"IdentifierKeywords\"),[conditional(lit(\"do\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__IdentifierKeywords__conditional__lit_for__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(keywords(\"IdentifierKeywords\"),[conditional(lit(\"for\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__interface_InterfaceDeclaration__iter_star_seps__Modifier__layouts_LAYOUTLIST_layouts_LAYOUTLIST_conditional__lit_interface__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_opt__ExtendsInterfaces_layouts_LAYOUTLIST_InterfaceBody_ = (IConstructor) _read("prod(label(\"interface\",sort(\"InterfaceDeclaration\")),[\\iter-star-seps(sort(\"Modifier\"),[layouts(\"LAYOUTLIST\")]),layouts(\"LAYOUTLIST\"),conditional(lit(\"interface\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts(\"LAYOUTLIST\"),conditional(lex(\"Identifier\"),{delete(conditional(keywords(\"IdentifierKeywords\"),{\\not-follow(\\char-class([range(36,36),range(48,57),range(65,90),range(95,95),range(97,122)]))}))}),layouts(\"LAYOUTLIST\"),opt(sort(\"ExtendsInterfaces\")),layouts(\"LAYOUTLIST\"),sort(\"InterfaceBody\")],{})", Factory.Production);
  private static final IConstructor regular__iter_star_seps__CatchClause__layouts_LAYOUTLIST = (IConstructor) _read("regular(\\iter-star-seps(sort(\"CatchClause\"),[layouts(\"LAYOUTLIST\")]))", Factory.Production);
  private static final IConstructor prod__EmptyStatement_StatementWithoutTrailingSubstatement__EmptyStatement_ = (IConstructor) _read("prod(label(\"EmptyStatement\",sort(\"StatementWithoutTrailingSubstatement\")),[sort(\"EmptyStatement\")],{})", Factory.Production);
  private static final IConstructor prod__import_semicolon_SingleTypeImportDeclaration__conditional__lit_import__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Name_layouts_LAYOUTLIST_lit___59_ = (IConstructor) _read("prod(label(\"import-semicolon\",sort(\"SingleTypeImportDeclaration\")),[conditional(lit(\"import\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts(\"LAYOUTLIST\"),sort(\"Name\"),layouts(\"LAYOUTLIST\"),lit(\";\")],{})", Factory.Production);
  private static final IConstructor prod__StringCharacter__UnicodeEscape_ = (IConstructor) _read("prod(lex(\"StringCharacter\"),[lex(\"UnicodeEscape\")],{})", Factory.Production);
  private static final IConstructor prod__HexLongLiteral_LongLiteral__conditional__HexLongLiteral__not_follow__char_class___range__46_46_range__48_57_range__65_90_range__95_95_range__97_122__tag__NotSupported___112_114_101_102_101_114 = (IConstructor) _read("prod(label(\"HexLongLiteral\",sort(\"LongLiteral\")),[conditional(lex(\"HexLongLiteral\"),{\\not-follow(\\char-class([range(46,46),range(48,57),range(65,90),range(95,95),range(97,122)]))})],{tag(NotSupported(\"prefer\"))})", Factory.Production);
  private static final IConstructor prod__Thing__lit_start_layouts_LAYOUTLIST_lit_returns_layouts_LAYOUTLIST_lit___91_layouts_LAYOUTLIST_iter_star_seps__FormalParameter__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___93_ = (IConstructor) _read("prod(sort(\"Thing\"),[lit(\"start\"),layouts(\"LAYOUTLIST\"),lit(\"returns\"),layouts(\"LAYOUTLIST\"),lit(\"[\"),layouts(\"LAYOUTLIST\"),\\iter-star-seps(sort(\"FormalParameter\"),[layouts(\"LAYOUTLIST\"),lit(\",\"),layouts(\"LAYOUTLIST\")]),layouts(\"LAYOUTLIST\"),lit(\"]\")],{})", Factory.Production);
  private static final IConstructor prod__start__ANTLR__layouts_LAYOUTLIST_top_ANTLR_layouts_LAYOUTLIST_ = (IConstructor) _read("prod(start(sort(\"ANTLR\")),[layouts(\"LAYOUTLIST\"),label(\"top\",sort(\"ANTLR\")),layouts(\"LAYOUTLIST\")],{})", Factory.Production);
  private static final IConstructor prod__assignMod_AssignmentOperator__lit___37_61_ = (IConstructor) _read("prod(label(\"assignMod\",sort(\"AssignmentOperator\")),[lit(\"%=\")],{})", Factory.Production);
  private static final IConstructor prod__HexIntegerLiteral_IntegerLiteral__conditional__HexIntegerLiteral__not_follow__char_class___range__46_46_range__48_57_range__65_90_range__95_95_range__97_122__tag__NotSupported___112_114_101_102_101_114 = (IConstructor) _read("prod(label(\"HexIntegerLiteral\",sort(\"IntegerLiteral\")),[conditional(lex(\"HexIntegerLiteral\"),{\\not-follow(\\char-class([range(46,46),range(48,57),range(65,90),range(95,95),range(97,122)]))})],{tag(NotSupported(\"prefer\"))})", Factory.Production);
  private static final IConstructor regular__opt__Super = (IConstructor) _read("regular(opt(sort(\"Super\")))", Factory.Production);
  private static final IConstructor prod__this0_PrimaryNoNewArray__conditional__lit_this__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(label(\"this0\",sort(\"PrimaryNoNewArray\")),[conditional(lit(\"this\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__SingleCharacter__char_class___range__0_38_range__40_91_range__93_65535_ = (IConstructor) _read("prod(lex(\"SingleCharacter\"),[\\char-class([range(0,38),range(40,91),range(93,65535)])],{})", Factory.Production);
  private static final IConstructor prod__not_equal1_Expression__Expression_layouts_LAYOUTLIST_lit___33_61_layouts_LAYOUTLIST_Expression__assoc__left = (IConstructor) _read("prod(label(\"not-equal1\",sort(\"Expression\")),[sort(\"Expression\"),layouts(\"LAYOUTLIST\"),lit(\"!=\"),layouts(\"LAYOUTLIST\"),sort(\"Expression\")],{assoc(left())})", Factory.Production);
  private static final IConstructor prod__FieldDeclaration1_ClassMemberDeclaration__FieldDeclaration_ = (IConstructor) _read("prod(label(\"FieldDeclaration1\",sort(\"ClassMemberDeclaration\")),[sort(\"FieldDeclaration\")],{})", Factory.Production);
  private static final IConstructor prod__DoubleLiteral__lit___46_iter__char_class___range__48_57_opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_opt__char_class___range__68_68_range__100_100_ = (IConstructor) _read("prod(lex(\"DoubleLiteral\"),[lit(\".\"),iter(\\char-class([range(48,57)])),opt(seq([\\char-class([range(69,69),range(101,101)]),opt(\\char-class([range(43,43),range(45,45)])),iter(\\char-class([range(48,57)]))])),opt(\\char-class([range(68,68),range(100,100)]))],{})", Factory.Production);
  private static final IConstructor prod__ClassInstanceCreationExpression1_PrimaryNoNewArray__ClassInstanceCreationExpression_ = (IConstructor) _read("prod(label(\"ClassInstanceCreationExpression1\",sort(\"PrimaryNoNewArray\")),[sort(\"ClassInstanceCreationExpression\")],{})", Factory.Production);
  private static final IConstructor prod__Comment__lit___47_47_iter_star__char_class___range__0_9_range__11_65535_char_class___range__10_10__tag__category___67_111_109_109_101_110_116 = (IConstructor) _read("prod(lex(\"Comment\"),[lit(\"//\"),\\iter-star(\\char-class([range(0,9),range(11,65535)])),\\char-class([range(10,10)])],{tag(category(\"Comment\"))})", Factory.Production);
  private static final IConstructor prod__Expression_opt_DimExprInitialized__lit___91_layouts_LAYOUTLIST_opt__Expression_layouts_LAYOUTLIST_lit___93_ = (IConstructor) _read("prod(label(\"Expression-opt\",sort(\"DimExprInitialized\")),[lit(\"[\"),layouts(\"LAYOUTLIST\"),opt(sort(\"Expression\")),layouts(\"LAYOUTLIST\"),lit(\"]\")],{})", Factory.Production);
  private static final IConstructor prod__comma_LocalVariableDeclaration__Type_layouts_LAYOUTLIST_iter_seps__VariableDeclarator__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_ = (IConstructor) _read("prod(label(\"comma\",sort(\"LocalVariableDeclaration\")),[sort(\"Type\"),layouts(\"LAYOUTLIST\"),\\iter-seps(sort(\"VariableDeclarator\"),[layouts(\"LAYOUTLIST\"),lit(\",\"),layouts(\"LAYOUTLIST\")])],{})", Factory.Production);
  private static final IConstructor prod__HexIntegerLiteral__char_class___range__48_48_char_class___range__88_88_range__120_120_iter__char_class___range__48_57_range__65_70_range__97_102_ = (IConstructor) _read("prod(lex(\"HexIntegerLiteral\"),[\\char-class([range(48,48)]),\\char-class([range(88,88),range(120,120)]),iter(\\char-class([range(48,57),range(65,70),range(97,102)]))],{})", Factory.Production);
  private static final IConstructor prod__File__opt__lit___47_layouts_LAYOUTLIST_iter_seps__Identifier__layouts_LAYOUTLIST_lit___47_layouts_LAYOUTLIST_layouts_LAYOUTLIST_opt__seq___lit___46_layouts_LAYOUTLIST_Identifier_ = (IConstructor) _read("prod(sort(\"File\"),[opt(lit(\"/\")),layouts(\"LAYOUTLIST\"),\\iter-seps(lex(\"Identifier\"),[layouts(\"LAYOUTLIST\"),lit(\"/\"),layouts(\"LAYOUTLIST\")]),layouts(\"LAYOUTLIST\"),opt(seq([lit(\".\"),layouts(\"LAYOUTLIST\"),lex(\"Identifier\")]))],{})", Factory.Production);
  private static final IConstructor prod__tilde_Expression__lit___126_layouts_LAYOUTLIST_Expression_ = (IConstructor) _read("prod(label(\"tilde\",sort(\"Expression\")),[lit(\"~\"),layouts(\"LAYOUTLIST\"),sort(\"Expression\")],{})", Factory.Production);
  private static final IConstructor prod__StringLiteral_Literal__StringLiteral__tag__NotSupported___112_114_101_102_101_114 = (IConstructor) _read("prod(label(\"StringLiteral\",sort(\"Literal\")),[lex(\"StringLiteral\")],{tag(NotSupported(\"prefer\"))})", Factory.Production);
  private static final IConstructor prod__shift_left1_Expression__Expression_layouts_LAYOUTLIST_lit___60_60_layouts_LAYOUTLIST_Expression__assoc__left = (IConstructor) _read("prod(label(\"shift-left1\",sort(\"Expression\")),[sort(\"Expression\"),layouts(\"LAYOUTLIST\"),lit(\"\\<\\<\"),layouts(\"LAYOUTLIST\"),sort(\"Expression\")],{assoc(left())})", Factory.Production);
  private static final IConstructor prod__IdentifierKeywords__conditional__lit_synchronized__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(keywords(\"IdentifierKeywords\"),[conditional(lit(\"synchronized\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__super_comma_semicolon_ExplicitConstructorInvocation__conditional__lit_super__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_iter_star_seps__Expression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_lit___59_ = (IConstructor) _read("prod(label(\"super-comma-semicolon\",sort(\"ExplicitConstructorInvocation\")),[conditional(lit(\"super\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts(\"LAYOUTLIST\"),lit(\"(\"),layouts(\"LAYOUTLIST\"),\\iter-star-seps(sort(\"Expression\"),[layouts(\"LAYOUTLIST\"),lit(\",\"),layouts(\"LAYOUTLIST\")]),layouts(\"LAYOUTLIST\"),lit(\")\"),layouts(\"LAYOUTLIST\"),lit(\";\")],{})", Factory.Production);
  private static final IConstructor prod__decr21_Expression__Expression_layouts_LAYOUTLIST_lit_____tag__NotSupported___112_114_101_102_101_114 = (IConstructor) _read("prod(label(\"decr21\",sort(\"Expression\")),[sort(\"Expression\"),layouts(\"LAYOUTLIST\"),lit(\"--\")],{tag(NotSupported(\"prefer\"))})", Factory.Production);
  private static final IConstructor prod__lit_continue__char_class___range__99_99_char_class___range__111_111_char_class___range__110_110_char_class___range__116_116_char_class___range__105_105_char_class___range__110_110_char_class___range__117_117_char_class___range__101_101_ = (IConstructor) _read("prod(lit(\"continue\"),[\\char-class([range(99,99)]),\\char-class([range(111,111)]),\\char-class([range(110,110)]),\\char-class([range(116,116)]),\\char-class([range(105,105)]),\\char-class([range(110,110)]),\\char-class([range(117,117)]),\\char-class([range(101,101)])],{})", Factory.Production);
  private static final IConstructor prod__lit___60_60_61__char_class___range__60_60_char_class___range__60_60_char_class___range__61_61_ = (IConstructor) _read("prod(lit(\"\\<\\<=\"),[\\char-class([range(60,60)]),\\char-class([range(60,60)]),\\char-class([range(61,61)])],{})", Factory.Production);
  private static final IConstructor prod__extends_comma_ExtendsInterfaces__conditional__lit_extends__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_iter_seps__InterfaceType__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_ = (IConstructor) _read("prod(label(\"extends-comma\",sort(\"ExtendsInterfaces\")),[conditional(lit(\"extends\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts(\"LAYOUTLIST\"),\\iter-seps(sort(\"InterfaceType\"),[layouts(\"LAYOUTLIST\"),lit(\",\"),layouts(\"LAYOUTLIST\")])],{})", Factory.Production);
  private static final IConstructor prod__IdentifierKeywords__conditional__lit_short__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(keywords(\"IdentifierKeywords\"),[conditional(lit(\"short\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor regular__iter_seps__Dim__layouts_LAYOUTLIST = (IConstructor) _read("regular(\\iter-seps(sort(\"Dim\"),[layouts(\"LAYOUTLIST\")]))", Factory.Production);
  private static final IConstructor prod__StringCharacter_s_StringLiteral__lit___34_iter_star__StringCharacter_lit___34_ = (IConstructor) _read("prod(label(\"StringCharacter-s\",lex(\"StringLiteral\")),[lit(\"\\\"\"),\\iter-star(lex(\"StringCharacter\")),lit(\"\\\"\")],{})", Factory.Production);
  private static final IConstructor prod__if_else_IfThenElseStatementNoShortIf__lit_if_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_StatementNoShortIf_layouts_LAYOUTLIST_conditional__lit_else__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_StatementNoShortIf_ = (IConstructor) _read("prod(label(\"if-else\",sort(\"IfThenElseStatementNoShortIf\")),[lit(\"if\"),layouts(\"LAYOUTLIST\"),lit(\"(\"),layouts(\"LAYOUTLIST\"),sort(\"Expression\"),layouts(\"LAYOUTLIST\"),lit(\")\"),layouts(\"LAYOUTLIST\"),sort(\"StatementNoShortIf\"),layouts(\"LAYOUTLIST\"),conditional(lit(\"else\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts(\"LAYOUTLIST\"),sort(\"StatementNoShortIf\")],{})", Factory.Production);
  private static final IConstructor prod__ge1_Expression__Expression_layouts_LAYOUTLIST_lit___62_61_layouts_LAYOUTLIST_Expression__assoc__left = (IConstructor) _read("prod(label(\"ge1\",sort(\"Expression\")),[sort(\"Expression\"),layouts(\"LAYOUTLIST\"),lit(\"\\>=\"),layouts(\"LAYOUTLIST\"),sort(\"Expression\")],{assoc(left())})", Factory.Production);
  private static final IConstructor prod__equal1_AssignmentOperator__lit___61_ = (IConstructor) _read("prod(label(\"equal1\",sort(\"AssignmentOperator\")),[lit(\"=\")],{})", Factory.Production);
  private static final IConstructor prod__FloatingPointType_NumericType__FloatingPointType_ = (IConstructor) _read("prod(label(\"FloatingPointType\",sort(\"NumericType\")),[sort(\"FloatingPointType\")],{})", Factory.Production);
  private static final IConstructor prod__throw_semicolon_ThrowStatement__conditional__lit_throw__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___59_ = (IConstructor) _read("prod(label(\"throw-semicolon\",sort(\"ThrowStatement\")),[conditional(lit(\"throw\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts(\"LAYOUTLIST\"),sort(\"Expression\"),layouts(\"LAYOUTLIST\"),lit(\";\")],{})", Factory.Production);
  private static final IConstructor prod__lit_boolean__char_class___range__98_98_char_class___range__111_111_char_class___range__111_111_char_class___range__108_108_char_class___range__101_101_char_class___range__97_97_char_class___range__110_110_ = (IConstructor) _read("prod(lit(\"boolean\"),[\\char-class([range(98,98)]),\\char-class([range(111,111)]),\\char-class([range(111,111)]),\\char-class([range(108,108)]),\\char-class([range(101,101)]),\\char-class([range(97,97)]),\\char-class([range(110,110)])],{})", Factory.Production);
  private static final IConstructor prod__ClassDeclaration11_TypeDeclaration__ClassDeclaration_ = (IConstructor) _read("prod(label(\"ClassDeclaration11\",sort(\"TypeDeclaration\")),[sort(\"ClassDeclaration\")],{})", Factory.Production);
  private static final IConstructor prod__BlockClassMember_ClassMemberDeclaration__Block_ = (IConstructor) _read("prod(label(\"BlockClassMember\",sort(\"ClassMemberDeclaration\")),[sort(\"Block\")],{})", Factory.Production);
  private static final IConstructor prod__semicolon11_ClassBodyDeclaration__lit___59_ = (IConstructor) _read("prod(label(\"semicolon11\",sort(\"ClassBodyDeclaration\")),[lit(\";\")],{})", Factory.Production);
  private static final IConstructor prod__IdentifierKeywords__conditional__lit_false__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(keywords(\"IdentifierKeywords\"),[conditional(lit(\"false\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor regular__seq___lit___46_layouts_LAYOUTLIST_Identifier = (IConstructor) _read("regular(seq([lit(\".\"),layouts(\"LAYOUTLIST\"),lex(\"Identifier\")]))", Factory.Production);
  private static final IConstructor prod__private_Modifier__conditional__lit_private__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(label(\"private\",sort(\"Modifier\")),[conditional(lit(\"private\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__SwitchBlockStatementGroup_s_SwitchLabel_s_SwitchBlock__lit___123_layouts_LAYOUTLIST_iter_star_seps__SwitchBlockStatementGroup__layouts_LAYOUTLIST_layouts_LAYOUTLIST_iter_star_seps__SwitchLabel__layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___125_ = (IConstructor) _read("prod(label(\"SwitchBlockStatementGroup-s-SwitchLabel-s\",sort(\"SwitchBlock\")),[lit(\"{\"),layouts(\"LAYOUTLIST\"),\\iter-star-seps(sort(\"SwitchBlockStatementGroup\"),[layouts(\"LAYOUTLIST\")]),layouts(\"LAYOUTLIST\"),\\iter-star-seps(sort(\"SwitchLabel\"),[layouts(\"LAYOUTLIST\")]),layouts(\"LAYOUTLIST\"),lit(\"}\")],{})", Factory.Production);
  private static final IConstructor prod__layouts_LAYOUTLIST__conditional__iter_star__LAYOUT__not_follow__char_class___range__9_10_range__12_13_range__32_32_not_follow__lit___47_47_not_follow__lit___47_42_ = (IConstructor) _read("prod(layouts(\"LAYOUTLIST\"),[conditional(\\iter-star(sort(\"LAYOUT\")),{\\not-follow(\\char-class([range(9,10),range(12,13),range(32,32)])),\\not-follow(lit(\"//\")),\\not-follow(lit(\"/*\"))})],{})", Factory.Production);
  private static final IConstructor prod__ClassOrInterfaceType2_InterfaceType__ClassOrInterfaceType_ = (IConstructor) _read("prod(label(\"ClassOrInterfaceType2\",sort(\"InterfaceType\")),[sort(\"ClassOrInterfaceType\")],{})", Factory.Production);
  private static final IConstructor prod__lit_false__char_class___range__102_102_char_class___range__97_97_char_class___range__108_108_char_class___range__115_115_char_class___range__101_101_ = (IConstructor) _read("prod(lit(\"false\"),[\\char-class([range(102,102)]),\\char-class([range(97,97)]),\\char-class([range(108,108)]),\\char-class([range(115,115)]),\\char-class([range(101,101)])],{})", Factory.Production);
  private static final IConstructor prod__if_IfThenStatement__lit_if_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_Statement_ = (IConstructor) _read("prod(label(\"if\",sort(\"IfThenStatement\")),[lit(\"if\"),layouts(\"LAYOUTLIST\"),lit(\"(\"),layouts(\"LAYOUTLIST\"),sort(\"Expression\"),layouts(\"LAYOUTLIST\"),lit(\")\"),layouts(\"LAYOUTLIST\"),sort(\"Statement\")],{})", Factory.Production);
  private static final IConstructor prod__FieldAccess_PrimaryNoNewArray__FieldAccess_ = (IConstructor) _read("prod(label(\"FieldAccess\",sort(\"PrimaryNoNewArray\")),[sort(\"FieldAccess\")],{})", Factory.Production);
  private static final IConstructor regular__opt__ExtendsInterfaces = (IConstructor) _read("regular(opt(sort(\"ExtendsInterfaces\")))", Factory.Production);
  private static final IConstructor prod__mod_Expression11_Expression__Expression_layouts_LAYOUTLIST_lit___37_layouts_LAYOUTLIST_Expression__assoc__left = (IConstructor) _read("prod(label(\"mod-Expression11\",sort(\"Expression\")),[sort(\"Expression\"),layouts(\"LAYOUTLIST\"),lit(\"%\"),layouts(\"LAYOUTLIST\"),sort(\"Expression\")],{assoc(left())})", Factory.Production);
  private static final IConstructor prod__DoubleLiteral_Literal__conditional__DoubleLiteral__not_follow__char_class___range__46_46_range__48_57_range__65_90_range__95_95_range__97_122__tag__NotSupported___112_114_101_102_101_114 = (IConstructor) _read("prod(label(\"DoubleLiteral\",sort(\"Literal\")),[conditional(lex(\"DoubleLiteral\"),{\\not-follow(\\char-class([range(46,46),range(48,57),range(65,90),range(95,95),range(97,122)]))})],{tag(NotSupported(\"prefer\"))})", Factory.Production);
  private static final IConstructor prod__equal2_VariableDeclarator__VariableDeclaratorId_layouts_LAYOUTLIST_lit___61_layouts_LAYOUTLIST_VariableInitializer_ = (IConstructor) _read("prod(label(\"equal2\",sort(\"VariableDeclarator\")),[sort(\"VariableDeclaratorId\"),layouts(\"LAYOUTLIST\"),lit(\"=\"),layouts(\"LAYOUTLIST\"),sort(\"VariableInitializer\")],{})", Factory.Production);
  private static final IConstructor prod__lit___60_105_110_105_116_62__char_class___range__60_60_char_class___range__105_105_char_class___range__110_110_char_class___range__105_105_char_class___range__116_116_char_class___range__62_62_ = (IConstructor) _read("prod(lit(\"\\<init\\>\"),[\\char-class([range(60,60)]),\\char-class([range(105,105)]),\\char-class([range(110,110)]),\\char-class([range(105,105)]),\\char-class([range(116,116)]),\\char-class([range(62,62)])],{})", Factory.Production);
  private static final IConstructor prod__assignOr_AssignmentOperator__lit___124_61_ = (IConstructor) _read("prod(label(\"assignOr\",sort(\"AssignmentOperator\")),[lit(\"|=\")],{})", Factory.Production);
  private static final IConstructor prod__Identifier__char_class___range__36_36_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_conditional__iter_star_seps__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122__layouts_LAYOUTLIST__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(sort(\"Identifier\"),[\\char-class([range(36,36),range(65,90),range(95,95),range(97,122)]),layouts(\"LAYOUTLIST\"),conditional(\\iter-star-seps(\\char-class([range(36,36),range(48,57),range(65,90),range(95,95),range(97,122)]),[layouts(\"LAYOUTLIST\")]),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__do_while_semicolon_DoStatement__conditional__lit_do__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Statement_layouts_LAYOUTLIST_conditional__lit_while__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_lit___59_ = (IConstructor) _read("prod(label(\"do-while-semicolon\",sort(\"DoStatement\")),[conditional(lit(\"do\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts(\"LAYOUTLIST\"),sort(\"Statement\"),layouts(\"LAYOUTLIST\"),conditional(lit(\"while\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts(\"LAYOUTLIST\"),lit(\"(\"),layouts(\"LAYOUTLIST\"),sort(\"Expression\"),layouts(\"LAYOUTLIST\"),lit(\")\"),layouts(\"LAYOUTLIST\"),lit(\";\")],{})", Factory.Production);
  private static final IConstructor prod__this_comma_semicolon_ExplicitConstructorInvocation__conditional__lit_this__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_iter_star_seps__Expression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_lit___59_ = (IConstructor) _read("prod(label(\"this-comma-semicolon\",sort(\"ExplicitConstructorInvocation\")),[conditional(lit(\"this\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts(\"LAYOUTLIST\"),lit(\"(\"),layouts(\"LAYOUTLIST\"),\\iter-star-seps(sort(\"Expression\"),[layouts(\"LAYOUTLIST\"),lit(\",\"),layouts(\"LAYOUTLIST\")]),layouts(\"LAYOUTLIST\"),lit(\")\"),layouts(\"LAYOUTLIST\"),lit(\";\")],{})", Factory.Production);
  private static final IConstructor prod__Modifier_s_ConstructorDeclarator_Throws_opt_ConstructorBody_ConstructorDeclaration__iter_star_seps__Modifier__layouts_LAYOUTLIST_layouts_LAYOUTLIST_ConstructorDeclarator_layouts_LAYOUTLIST_opt__Throws_layouts_LAYOUTLIST_ConstructorBody_ = (IConstructor) _read("prod(label(\"Modifier-s-ConstructorDeclarator-Throws-opt-ConstructorBody\",sort(\"ConstructorDeclaration\")),[\\iter-star-seps(sort(\"Modifier\"),[layouts(\"LAYOUTLIST\")]),layouts(\"LAYOUTLIST\"),sort(\"ConstructorDeclarator\"),layouts(\"LAYOUTLIST\"),opt(sort(\"Throws\")),layouts(\"LAYOUTLIST\"),sort(\"ConstructorBody\")],{})", Factory.Production);
  private static final IConstructor prod__lit___62_62_61__char_class___range__62_62_char_class___range__62_62_char_class___range__61_61_ = (IConstructor) _read("prod(lit(\"\\>\\>=\"),[\\char-class([range(62,62)]),\\char-class([range(62,62)]),\\char-class([range(61,61)])],{})", Factory.Production);
  private static final IConstructor prod__DoStatement_StatementWithoutTrailingSubstatement__DoStatement_ = (IConstructor) _read("prod(label(\"DoStatement\",sort(\"StatementWithoutTrailingSubstatement\")),[sort(\"DoStatement\")],{})", Factory.Production);
  private static final IConstructor prod__Identifier__char_class___range__36_36_range__65_90_range__95_95_range__97_122_conditional__iter_star__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(lex(\"Identifier\"),[\\char-class([range(36,36),range(65,90),range(95,95),range(97,122)]),conditional(\\iter-star(\\char-class([range(36,36),range(48,57),range(65,90),range(95,95),range(97,122)])),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__lit___62_62_62__char_class___range__62_62_char_class___range__62_62_char_class___range__62_62_ = (IConstructor) _read("prod(lit(\"\\>\\>\\>\"),[\\char-class([range(62,62)]),\\char-class([range(62,62)]),\\char-class([range(62,62)])],{})", Factory.Production);
  private static final IConstructor prod__lit_throws__char_class___range__116_116_char_class___range__104_104_char_class___range__114_114_char_class___range__111_111_char_class___range__119_119_char_class___range__115_115_ = (IConstructor) _read("prod(lit(\"throws\"),[\\char-class([range(116,116)]),\\char-class([range(104,104)]),\\char-class([range(114,114)]),\\char-class([range(111,111)]),\\char-class([range(119,119)]),\\char-class([range(115,115)])],{})", Factory.Production);
  private static final IConstructor prod__ArrayInitializer_VariableInitializer__ArrayInitializer_ = (IConstructor) _read("prod(label(\"ArrayInitializer\",sort(\"VariableInitializer\")),[sort(\"ArrayInitializer\")],{})", Factory.Production);
  private static final IConstructor prod__IdentifierKeywords__conditional__lit_char__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(keywords(\"IdentifierKeywords\"),[conditional(lit(\"char\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__ClassOrInterfaceType1_ClassType__ClassOrInterfaceType_ = (IConstructor) _read("prod(label(\"ClassOrInterfaceType1\",sort(\"ClassType\")),[sort(\"ClassOrInterfaceType\")],{})", Factory.Production);
  private static final IConstructor prod__lit_package__char_class___range__112_112_char_class___range__97_97_char_class___range__99_99_char_class___range__107_107_char_class___range__97_97_char_class___range__103_103_char_class___range__101_101_ = (IConstructor) _read("prod(lit(\"package\"),[\\char-class([range(112,112)]),\\char-class([range(97,97)]),\\char-class([range(99,99)]),\\char-class([range(107,107)]),\\char-class([range(97,97)]),\\char-class([range(103,103)]),\\char-class([range(101,101)])],{})", Factory.Production);
  private static final IConstructor prod__protected_Modifier__conditional__lit_protected__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(label(\"protected\",sort(\"Modifier\")),[conditional(lit(\"protected\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__lt1_Expression__Expression_layouts_LAYOUTLIST_lit___60_layouts_LAYOUTLIST_Expression__assoc__left = (IConstructor) _read("prod(label(\"lt1\",sort(\"Expression\")),[sort(\"Expression\"),layouts(\"LAYOUTLIST\"),lit(\"\\<\"),layouts(\"LAYOUTLIST\"),sort(\"Expression\")],{assoc(left())})", Factory.Production);
  private static final IConstructor prod__LocalVariableDeclaration_ForInit__LocalVariableDeclaration_ = (IConstructor) _read("prod(label(\"LocalVariableDeclaration\",sort(\"ForInit\")),[sort(\"LocalVariableDeclaration\")],{})", Factory.Production);
  private static final IConstructor prod__comma_semicolon_FieldDeclaration__iter_star_seps__Modifier__layouts_LAYOUTLIST_layouts_LAYOUTLIST_Type_layouts_LAYOUTLIST_iter_seps__VariableDeclarator__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___59_ = (IConstructor) _read("prod(label(\"comma-semicolon\",sort(\"FieldDeclaration\")),[\\iter-star-seps(sort(\"Modifier\"),[layouts(\"LAYOUTLIST\")]),layouts(\"LAYOUTLIST\"),sort(\"Type\"),layouts(\"LAYOUTLIST\"),\\iter-seps(sort(\"VariableDeclarator\"),[layouts(\"LAYOUTLIST\"),lit(\",\"),layouts(\"LAYOUTLIST\")]),layouts(\"LAYOUTLIST\"),lit(\";\")],{})", Factory.Production);
  private static final IConstructor prod__LeftHandSide_AssignmentOperator_Expression_Assignment__LeftHandSide_layouts_LAYOUTLIST_AssignmentOperator_layouts_LAYOUTLIST_Expression_ = (IConstructor) _read("prod(label(\"LeftHandSide-AssignmentOperator-Expression\",sort(\"Assignment\")),[sort(\"LeftHandSide\"),layouts(\"LAYOUTLIST\"),sort(\"AssignmentOperator\"),layouts(\"LAYOUTLIST\"),sort(\"Expression\")],{})", Factory.Production);
  private static final IConstructor prod__InterfaceDeclaration_TypeDeclaration__InterfaceDeclaration_ = (IConstructor) _read("prod(label(\"InterfaceDeclaration\",sort(\"TypeDeclaration\")),[sort(\"InterfaceDeclaration\")],{})", Factory.Production);
  private static final IConstructor prod__Assignment_StatementExpression__Assignment_ = (IConstructor) _read("prod(label(\"Assignment\",sort(\"StatementExpression\")),[sort(\"Assignment\")],{})", Factory.Production);
  private static final IConstructor prod__package_semicolon_PackageDeclaration__conditional__lit_package__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Name_layouts_LAYOUTLIST_lit___59_ = (IConstructor) _read("prod(label(\"package-semicolon\",sort(\"PackageDeclaration\")),[conditional(lit(\"package\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts(\"LAYOUTLIST\"),sort(\"Name\"),layouts(\"LAYOUTLIST\"),lit(\";\")],{})", Factory.Production);
  private static final IConstructor regular__iter_seps__Thing__layouts_LAYOUTLIST = (IConstructor) _read("regular(\\iter-seps(sort(\"Thing\"),[layouts(\"LAYOUTLIST\")]))", Factory.Production);
  private static final IConstructor prod__DecimalLongLiteral_LongLiteral__conditional__DecimalLongLiteral__not_follow__char_class___range__46_46_range__48_57_range__65_90_range__95_95_range__97_122__tag__NotSupported___112_114_101_102_101_114 = (IConstructor) _read("prod(label(\"DecimalLongLiteral\",sort(\"LongLiteral\")),[conditional(lex(\"DecimalLongLiteral\"),{\\not-follow(\\char-class([range(46,46),range(48,57),range(65,90),range(95,95),range(97,122)]))})],{tag(NotSupported(\"prefer\"))})", Factory.Production);
  private static final IConstructor prod__TypeImportOnDemandDeclaration_ImportDeclaration__TypeImportOnDemandDeclaration_ = (IConstructor) _read("prod(label(\"TypeImportOnDemandDeclaration\",sort(\"ImportDeclaration\")),[sort(\"TypeImportOnDemandDeclaration\")],{})", Factory.Production);
  private static final IConstructor prod__IdentifierKeywords__conditional__lit_int__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(keywords(\"IdentifierKeywords\"),[conditional(lit(\"int\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__equal1_Expression__Expression_layouts_LAYOUTLIST_lit___61_61_layouts_LAYOUTLIST_Expression__assoc__left = (IConstructor) _read("prod(label(\"equal1\",sort(\"Expression\")),[sort(\"Expression\"),layouts(\"LAYOUTLIST\"),lit(\"==\"),layouts(\"LAYOUTLIST\"),sort(\"Expression\")],{assoc(left())})", Factory.Production);
  private static final IConstructor prod__short_IntegralType__conditional__lit_short__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(label(\"short\",sort(\"IntegralType\")),[conditional(lit(\"short\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__lit_public__char_class___range__112_112_char_class___range__117_117_char_class___range__98_98_char_class___range__108_108_char_class___range__105_105_char_class___range__99_99_ = (IConstructor) _read("prod(lit(\"public\"),[\\char-class([range(112,112)]),\\char-class([range(117,117)]),\\char-class([range(98,98)]),\\char-class([range(108,108)]),\\char-class([range(105,105)]),\\char-class([range(99,99)])],{})", Factory.Production);
  private static final IConstructor prod__View__lit_view_layouts_LAYOUTLIST_Identifier_layouts_LAYOUTLIST_lit_grammar_layouts_LAYOUTLIST_File_layouts_LAYOUTLIST_lit___123_layouts_LAYOUTLIST_iter_star_seps__TokenDef__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___125_ = (IConstructor) _read("prod(sort(\"View\"),[lit(\"view\"),layouts(\"LAYOUTLIST\"),lex(\"Identifier\"),layouts(\"LAYOUTLIST\"),lit(\"grammar\"),layouts(\"LAYOUTLIST\"),sort(\"File\"),layouts(\"LAYOUTLIST\"),lit(\"{\"),layouts(\"LAYOUTLIST\"),\\iter-star-seps(sort(\"TokenDef\"),[layouts(\"LAYOUTLIST\"),lit(\",\"),layouts(\"LAYOUTLIST\")]),layouts(\"LAYOUTLIST\"),lit(\"}\")],{})", Factory.Production);
  private static final IConstructor prod__EscapeSequence__lit___92_char_class___range__48_55_char_class___range__48_55_ = (IConstructor) _read("prod(lex(\"EscapeSequence\"),[lit(\"\\\\\"),\\char-class([range(48,55)]),\\char-class([range(48,55)])],{})", Factory.Production);
  private static final IConstructor prod__lit_static__char_class___range__115_115_char_class___range__116_116_char_class___range__97_97_char_class___range__116_116_char_class___range__105_105_char_class___range__99_99_ = (IConstructor) _read("prod(lit(\"static\"),[\\char-class([range(115,115)]),\\char-class([range(116,116)]),\\char-class([range(97,97)]),\\char-class([range(116,116)]),\\char-class([range(105,105)]),\\char-class([range(99,99)])],{})", Factory.Production);
  private static final IConstructor prod__decr31_Expression__lit____layouts_LAYOUTLIST_Expression__tag__NotSupported___112_114_101_102_101_114 = (IConstructor) _read("prod(label(\"decr31\",sort(\"Expression\")),[lit(\"--\"),layouts(\"LAYOUTLIST\"),sort(\"Expression\")],{tag(NotSupported(\"prefer\"))})", Factory.Production);
  private static final IConstructor prod__lit_final__char_class___range__102_102_char_class___range__105_105_char_class___range__110_110_char_class___range__97_97_char_class___range__108_108_ = (IConstructor) _read("prod(lit(\"final\"),[\\char-class([range(102,102)]),\\char-class([range(105,105)]),\\char-class([range(110,110)]),\\char-class([range(97,97)]),\\char-class([range(108,108)])],{})", Factory.Production);
  private static final IConstructor prod__ThrowStatement_StatementWithoutTrailingSubstatement__ThrowStatement_ = (IConstructor) _read("prod(label(\"ThrowStatement\",sort(\"StatementWithoutTrailingSubstatement\")),[sort(\"ThrowStatement\")],{})", Factory.Production);
  private static final IConstructor prod__InnerInterfaceDeclaration_InterfaceMemberDeclaration__InterfaceDeclaration_ = (IConstructor) _read("prod(label(\"InnerInterfaceDeclaration\",sort(\"InterfaceMemberDeclaration\")),[sort(\"InterfaceDeclaration\")],{})", Factory.Production);
  private static final IConstructor prod__assignPlus_AssignmentOperator__lit___43_61_ = (IConstructor) _read("prod(label(\"assignPlus\",sort(\"AssignmentOperator\")),[lit(\"+=\")],{})", Factory.Production);
  private static final IConstructor prod__long_IntegralType__conditional__lit_long__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = (IConstructor) _read("prod(label(\"long\",sort(\"IntegralType\")),[conditional(lit(\"long\"),{\\not-follow(\\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__lit_class__char_class___range__99_99_char_class___range__108_108_char_class___range__97_97_char_class___range__115_115_char_class___range__115_115_ = (IConstructor) _read("prod(lit(\"class\"),[\\char-class([range(99,99)]),\\char-class([range(108,108)]),\\char-class([range(97,97)]),\\char-class([range(115,115)]),\\char-class([range(115,115)])],{})", Factory.Production);
  private static final IConstructor prod__Word__conditional__iter__char_class___range__0_8_range__11_12_range__14_31_range__33_65535__not_follow__char_class___range__0_8_range__11_12_range__14_31_range__33_65535_ = (IConstructor) _read("prod(lex(\"Word\"),[conditional(iter(\\char-class([range(0,8),range(11,12),range(14,31),range(33,65535)])),{\\not-follow(\\char-class([range(0,8),range(11,12),range(14,31),range(33,65535)]))})],{})", Factory.Production);
  private static final IConstructor prod__lit_abstract__char_class___range__97_97_char_class___range__98_98_char_class___range__115_115_char_class___range__116_116_char_class___range__114_114_char_class___range__97_97_char_class___range__99_99_char_class___range__116_116_ = (IConstructor) _read("prod(lit(\"abstract\"),[\\char-class([range(97,97)]),\\char-class([range(98,98)]),\\char-class([range(115,115)]),\\char-class([range(116,116)]),\\char-class([range(114,114)]),\\char-class([range(97,97)]),\\char-class([range(99,99)]),\\char-class([range(116,116)])],{})", Factory.Production);
    
  // Item declarations
	
	
  private static class StatementExpressionList {
    public final static AbstractStackNode[] prod__comma1_StatementExpressionList__iter_seps__StatementExpression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_ = _init_prod__comma1_StatementExpressionList__iter_seps__StatementExpression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_();
    private static final AbstractStackNode[] _init_prod__comma1_StatementExpressionList__iter_seps__StatementExpression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new SeparatedListStackNode(4, 0, regular__iter_seps__StatementExpression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST, new NonTerminalStackNode(6, 0, "StatementExpression", null, null), new AbstractStackNode[]{new NonTerminalStackNode(8, 1, "layouts_LAYOUTLIST", null, null), new LiteralStackNode(10, 2, prod__lit___44__char_class___range__44_44_, new char[] {44}, null, null), new NonTerminalStackNode(12, 3, "layouts_LAYOUTLIST", null, null)}, true, null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__comma1_StatementExpressionList__iter_seps__StatementExpression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_);
      return tmp;
	}
  }
	
  private static class OctalLongLiteral {
    public final static AbstractStackNode[] prod__OctalLongLiteral__char_class___range__48_48_iter__char_class___range__48_55_char_class___range__76_76_range__108_108_ = _init_prod__OctalLongLiteral__char_class___range__48_48_iter__char_class___range__48_55_char_class___range__76_76_range__108_108_();
    private static final AbstractStackNode[] _init_prod__OctalLongLiteral__char_class___range__48_48_iter__char_class___range__48_55_char_class___range__76_76_range__108_108_() {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new CharStackNode(20, 2, new char[][]{{76,76},{108,108}}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new ListStackNode(16, 1, regular__iter__char_class___range__48_55, new CharStackNode(18, 0, new char[][]{{48,55}}, null, null), true, null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new CharStackNode(14, 0, new char[][]{{48,48}}, null, null);
      tmp[0].setProduction(tmp);
      tmp[2].setParentProduction(Generator.prod__OctalLongLiteral__char_class___range__48_48_iter__char_class___range__48_55_char_class___range__76_76_range__108_108_);
      return tmp;
	}
  }
	
  private static class Literal {
    public final static AbstractStackNode[] prod__IntegerLiteral_Literal__IntegerLiteral__tag__NotSupported___112_114_101_102_101_114 = _init_prod__IntegerLiteral_Literal__IntegerLiteral__tag__NotSupported___112_114_101_102_101_114();
    private static final AbstractStackNode[] _init_prod__IntegerLiteral_Literal__IntegerLiteral__tag__NotSupported___112_114_101_102_101_114() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(24, 0, "IntegerLiteral", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__IntegerLiteral_Literal__IntegerLiteral__tag__NotSupported___112_114_101_102_101_114);
      return tmp;
	}
    public final static AbstractStackNode[] prod__BooleanLiteral_Literal__BooleanLiteral__tag__NotSupported___112_114_101_102_101_114 = _init_prod__BooleanLiteral_Literal__BooleanLiteral__tag__NotSupported___112_114_101_102_101_114();
    private static final AbstractStackNode[] _init_prod__BooleanLiteral_Literal__BooleanLiteral__tag__NotSupported___112_114_101_102_101_114() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(26, 0, "BooleanLiteral", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__BooleanLiteral_Literal__BooleanLiteral__tag__NotSupported___112_114_101_102_101_114);
      return tmp;
	}
    public final static AbstractStackNode[] prod__FloatingPointLiteral_Literal__conditional__FloatingPointLiteral__not_follow__char_class___range__46_46_range__48_57_range__65_90_range__95_95_range__97_122__tag__NotSupported___112_114_101_102_101_114 = _init_prod__FloatingPointLiteral_Literal__conditional__FloatingPointLiteral__not_follow__char_class___range__46_46_range__48_57_range__65_90_range__95_95_range__97_122__tag__NotSupported___112_114_101_102_101_114();
    private static final AbstractStackNode[] _init_prod__FloatingPointLiteral_Literal__conditional__FloatingPointLiteral__not_follow__char_class___range__46_46_range__48_57_range__65_90_range__95_95_range__97_122__tag__NotSupported___112_114_101_102_101_114() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(28, 0, "FloatingPointLiteral", null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{46,46},{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__FloatingPointLiteral_Literal__conditional__FloatingPointLiteral__not_follow__char_class___range__46_46_range__48_57_range__65_90_range__95_95_range__97_122__tag__NotSupported___112_114_101_102_101_114);
      return tmp;
	}
    public final static AbstractStackNode[] prod__DoubleLiteral_Literal__conditional__DoubleLiteral__not_follow__char_class___range__46_46_range__48_57_range__65_90_range__95_95_range__97_122__tag__NotSupported___112_114_101_102_101_114 = _init_prod__DoubleLiteral_Literal__conditional__DoubleLiteral__not_follow__char_class___range__46_46_range__48_57_range__65_90_range__95_95_range__97_122__tag__NotSupported___112_114_101_102_101_114();
    private static final AbstractStackNode[] _init_prod__DoubleLiteral_Literal__conditional__DoubleLiteral__not_follow__char_class___range__46_46_range__48_57_range__65_90_range__95_95_range__97_122__tag__NotSupported___112_114_101_102_101_114() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(30, 0, "DoubleLiteral", null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{46,46},{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__DoubleLiteral_Literal__conditional__DoubleLiteral__not_follow__char_class___range__46_46_range__48_57_range__65_90_range__95_95_range__97_122__tag__NotSupported___112_114_101_102_101_114);
      return tmp;
	}
    public final static AbstractStackNode[] prod__CharacterLiteral_Literal__CharacterLiteral__tag__NotSupported___112_114_101_102_101_114 = _init_prod__CharacterLiteral_Literal__CharacterLiteral__tag__NotSupported___112_114_101_102_101_114();
    private static final AbstractStackNode[] _init_prod__CharacterLiteral_Literal__CharacterLiteral__tag__NotSupported___112_114_101_102_101_114() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(32, 0, "CharacterLiteral", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__CharacterLiteral_Literal__CharacterLiteral__tag__NotSupported___112_114_101_102_101_114);
      return tmp;
	}
    public final static AbstractStackNode[] prod__NullLiteral_Literal__NullLiteral__tag__NotSupported___112_114_101_102_101_114 = _init_prod__NullLiteral_Literal__NullLiteral__tag__NotSupported___112_114_101_102_101_114();
    private static final AbstractStackNode[] _init_prod__NullLiteral_Literal__NullLiteral__tag__NotSupported___112_114_101_102_101_114() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(34, 0, "NullLiteral", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__NullLiteral_Literal__NullLiteral__tag__NotSupported___112_114_101_102_101_114);
      return tmp;
	}
    public final static AbstractStackNode[] prod__StringLiteral_Literal__StringLiteral__tag__NotSupported___112_114_101_102_101_114 = _init_prod__StringLiteral_Literal__StringLiteral__tag__NotSupported___112_114_101_102_101_114();
    private static final AbstractStackNode[] _init_prod__StringLiteral_Literal__StringLiteral__tag__NotSupported___112_114_101_102_101_114() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(36, 0, "StringLiteral", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__StringLiteral_Literal__StringLiteral__tag__NotSupported___112_114_101_102_101_114);
      return tmp;
	}
    public final static AbstractStackNode[] prod__LongLiteral_Literal__LongLiteral__tag__NotSupported___112_114_101_102_101_114 = _init_prod__LongLiteral_Literal__LongLiteral__tag__NotSupported___112_114_101_102_101_114();
    private static final AbstractStackNode[] _init_prod__LongLiteral_Literal__LongLiteral__tag__NotSupported___112_114_101_102_101_114() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(38, 0, "LongLiteral", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__LongLiteral_Literal__LongLiteral__tag__NotSupported___112_114_101_102_101_114);
      return tmp;
	}
  }
	
  private static class ConstructorBody {
    public final static AbstractStackNode[] prod__ExplicitConstructorInvocation_opt_BlockStatement_s_ConstructorBody__lit___123_layouts_LAYOUTLIST_opt__ExplicitConstructorInvocation_layouts_LAYOUTLIST_iter_star_seps__BlockStatement__layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___125_ = _init_prod__ExplicitConstructorInvocation_opt_BlockStatement_s_ConstructorBody__lit___123_layouts_LAYOUTLIST_opt__ExplicitConstructorInvocation_layouts_LAYOUTLIST_iter_star_seps__BlockStatement__layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___125_();
    private static final AbstractStackNode[] _init_prod__ExplicitConstructorInvocation_opt_BlockStatement_s_ConstructorBody__lit___123_layouts_LAYOUTLIST_opt__ExplicitConstructorInvocation_layouts_LAYOUTLIST_iter_star_seps__BlockStatement__layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___125_() {
      AbstractStackNode[] tmp = new AbstractStackNode[7];
      
      tmp[6] = new LiteralStackNode(110, 6, prod__lit___125__char_class___range__125_125_, new char[] {125}, null, null);
      tmp[6].setProduction(tmp);
      tmp[5] = new NonTerminalStackNode(108, 5, "layouts_LAYOUTLIST", null, null);
      tmp[5].setProduction(tmp);
      tmp[4] = new SeparatedListStackNode(102, 4, regular__iter_star_seps__BlockStatement__layouts_LAYOUTLIST, new NonTerminalStackNode(104, 0, "BlockStatement", null, null), new AbstractStackNode[]{new NonTerminalStackNode(106, 1, "layouts_LAYOUTLIST", null, null)}, false, null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(100, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new OptionalStackNode(96, 2, regular__opt__ExplicitConstructorInvocation, new NonTerminalStackNode(98, 0, "ExplicitConstructorInvocation", null, null), null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(94, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(92, 0, prod__lit___123__char_class___range__123_123_, new char[] {123}, null, null);
      tmp[0].setProduction(tmp);
      tmp[6].setParentProduction(Generator.prod__ExplicitConstructorInvocation_opt_BlockStatement_s_ConstructorBody__lit___123_layouts_LAYOUTLIST_opt__ExplicitConstructorInvocation_layouts_LAYOUTLIST_iter_star_seps__BlockStatement__layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___125_);
      return tmp;
	}
  }
	
  private static class LocalVariableDeclarationStatement {
    public final static AbstractStackNode[] prod__semicolon_LocalVariableDeclarationStatement__LocalVariableDeclaration_layouts_LAYOUTLIST_lit___59_ = _init_prod__semicolon_LocalVariableDeclarationStatement__LocalVariableDeclaration_layouts_LAYOUTLIST_lit___59_();
    private static final AbstractStackNode[] _init_prod__semicolon_LocalVariableDeclarationStatement__LocalVariableDeclaration_layouts_LAYOUTLIST_lit___59_() {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new LiteralStackNode(90, 2, prod__lit___59__char_class___range__59_59_, new char[] {59}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(88, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new NonTerminalStackNode(86, 0, "LocalVariableDeclaration", null, null);
      tmp[0].setProduction(tmp);
      tmp[2].setParentProduction(Generator.prod__semicolon_LocalVariableDeclarationStatement__LocalVariableDeclaration_layouts_LAYOUTLIST_lit___59_);
      return tmp;
	}
  }
	
  private static class SynchronizedStatement {
    public final static AbstractStackNode[] prod__synchronized_SynchronizedStatement__conditional__lit_synchronized__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_Block_ = _init_prod__synchronized_SynchronizedStatement__conditional__lit_synchronized__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_Block_();
    private static final AbstractStackNode[] _init_prod__synchronized_SynchronizedStatement__conditional__lit_synchronized__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_Block_() {
      AbstractStackNode[] tmp = new AbstractStackNode[9];
      
      tmp[8] = new NonTerminalStackNode(128, 8, "Block", null, null);
      tmp[8].setProduction(tmp);
      tmp[7] = new NonTerminalStackNode(126, 7, "layouts_LAYOUTLIST", null, null);
      tmp[7].setProduction(tmp);
      tmp[6] = new LiteralStackNode(124, 6, prod__lit___41__char_class___range__41_41_, new char[] {41}, null, null);
      tmp[6].setProduction(tmp);
      tmp[5] = new NonTerminalStackNode(122, 5, "layouts_LAYOUTLIST", null, null);
      tmp[5].setProduction(tmp);
      tmp[4] = new NonTerminalStackNode(120, 4, "Expression", null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(118, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new LiteralStackNode(116, 2, prod__lit___40__char_class___range__40_40_, new char[] {40}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(114, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(112, 0, prod__lit_synchronized__char_class___range__115_115_char_class___range__121_121_char_class___range__110_110_char_class___range__99_99_char_class___range__104_104_char_class___range__114_114_char_class___range__111_111_char_class___range__110_110_char_class___range__105_105_char_class___range__122_122_char_class___range__101_101_char_class___range__100_100_, new char[] {115,121,110,99,104,114,111,110,105,122,101,100}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[8].setParentProduction(Generator.prod__synchronized_SynchronizedStatement__conditional__lit_synchronized__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_Block_);
      return tmp;
	}
  }
	
  private static class VariableInitializer {
    public final static AbstractStackNode[] prod__Expression_VariableInitializer__Expression_ = _init_prod__Expression_VariableInitializer__Expression_();
    private static final AbstractStackNode[] _init_prod__Expression_VariableInitializer__Expression_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(162, 0, "Expression", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__Expression_VariableInitializer__Expression_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__ArrayInitializer_VariableInitializer__ArrayInitializer_ = _init_prod__ArrayInitializer_VariableInitializer__ArrayInitializer_();
    private static final AbstractStackNode[] _init_prod__ArrayInitializer_VariableInitializer__ArrayInitializer_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(164, 0, "ArrayInitializer", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__ArrayInitializer_VariableInitializer__ArrayInitializer_);
      return tmp;
	}
  }
	
  private static class InterfaceDeclaration {
    public final static AbstractStackNode[] prod__interface_InterfaceDeclaration__iter_star_seps__Modifier__layouts_LAYOUTLIST_layouts_LAYOUTLIST_conditional__lit_interface__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_opt__ExtendsInterfaces_layouts_LAYOUTLIST_InterfaceBody_ = _init_prod__interface_InterfaceDeclaration__iter_star_seps__Modifier__layouts_LAYOUTLIST_layouts_LAYOUTLIST_conditional__lit_interface__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_opt__ExtendsInterfaces_layouts_LAYOUTLIST_InterfaceBody_();
    private static final AbstractStackNode[] _init_prod__interface_InterfaceDeclaration__iter_star_seps__Modifier__layouts_LAYOUTLIST_layouts_LAYOUTLIST_conditional__lit_interface__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_opt__ExtendsInterfaces_layouts_LAYOUTLIST_InterfaceBody_() {
      AbstractStackNode[] tmp = new AbstractStackNode[9];
      
      tmp[8] = new NonTerminalStackNode(192, 8, "InterfaceBody", null, null);
      tmp[8].setProduction(tmp);
      tmp[7] = new NonTerminalStackNode(190, 7, "layouts_LAYOUTLIST", null, null);
      tmp[7].setProduction(tmp);
      tmp[6] = new OptionalStackNode(186, 6, regular__opt__ExtendsInterfaces, new NonTerminalStackNode(188, 0, "ExtendsInterfaces", null, null), null, null);
      tmp[6].setProduction(tmp);
      tmp[5] = new NonTerminalStackNode(184, 5, "layouts_LAYOUTLIST", null, null);
      tmp[5].setProduction(tmp);
      tmp[4] = new NonTerminalStackNode(182, 4, "Identifier", null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(180, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new LiteralStackNode(178, 2, prod__lit_interface__char_class___range__105_105_char_class___range__110_110_char_class___range__116_116_char_class___range__101_101_char_class___range__114_114_char_class___range__102_102_char_class___range__97_97_char_class___range__99_99_char_class___range__101_101_, new char[] {105,110,116,101,114,102,97,99,101}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(176, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new SeparatedListStackNode(170, 0, regular__iter_star_seps__Modifier__layouts_LAYOUTLIST, new NonTerminalStackNode(172, 0, "Modifier", null, null), new AbstractStackNode[]{new NonTerminalStackNode(174, 1, "layouts_LAYOUTLIST", null, null)}, false, null, null);
      tmp[0].setProduction(tmp);
      tmp[8].setParentProduction(Generator.prod__interface_InterfaceDeclaration__iter_star_seps__Modifier__layouts_LAYOUTLIST_layouts_LAYOUTLIST_conditional__lit_interface__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_opt__ExtendsInterfaces_layouts_LAYOUTLIST_InterfaceBody_);
      return tmp;
	}
  }
	
  private static class PrimitiveType {
    public final static AbstractStackNode[] prod__boolean_PrimitiveType__conditional__lit_boolean__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__boolean_PrimitiveType__conditional__lit_boolean__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__boolean_PrimitiveType__conditional__lit_boolean__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(166, 0, prod__lit_boolean__char_class___range__98_98_char_class___range__111_111_char_class___range__111_111_char_class___range__108_108_char_class___range__101_101_char_class___range__97_97_char_class___range__110_110_, new char[] {98,111,111,108,101,97,110}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__boolean_PrimitiveType__conditional__lit_boolean__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__NumericType_PrimitiveType__NumericType_ = _init_prod__NumericType_PrimitiveType__NumericType_();
    private static final AbstractStackNode[] _init_prod__NumericType_PrimitiveType__NumericType_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(168, 0, "NumericType", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__NumericType_PrimitiveType__NumericType_);
      return tmp;
	}
  }
	
  private static class FloatingPointLiteral {
    public final static AbstractStackNode[] prod__FloatingPointLiteral__iter__char_class___range__48_57_lit___46_iter_star__char_class___range__48_57_opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_char_class___range__70_70_range__102_102_ = _init_prod__FloatingPointLiteral__iter__char_class___range__48_57_lit___46_iter_star__char_class___range__48_57_opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_char_class___range__70_70_range__102_102_();
    private static final AbstractStackNode[] _init_prod__FloatingPointLiteral__iter__char_class___range__48_57_lit___46_iter_star__char_class___range__48_57_opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_char_class___range__70_70_range__102_102_() {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new CharStackNode(220, 4, new char[][]{{70,70},{102,102}}, null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new OptionalStackNode(206, 3, regular__opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57, new SequenceStackNode(208, 0, regular__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57, new AbstractStackNode[]{new CharStackNode(210, 0, new char[][]{{69,69},{101,101}}, null, null), new OptionalStackNode(212, 1, regular__opt__char_class___range__43_43_range__45_45, new CharStackNode(214, 0, new char[][]{{43,43},{45,45}}, null, null), null, null), new ListStackNode(216, 2, regular__iter__char_class___range__48_57, new CharStackNode(218, 0, new char[][]{{48,57}}, null, null), true, null, null)}, null, null), null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new ListStackNode(202, 2, regular__iter_star__char_class___range__48_57, new CharStackNode(204, 0, new char[][]{{48,57}}, null, null), false, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new LiteralStackNode(200, 1, prod__lit___46__char_class___range__46_46_, new char[] {46}, null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new ListStackNode(196, 0, regular__iter__char_class___range__48_57, new CharStackNode(198, 0, new char[][]{{48,57}}, null, null), true, null, null);
      tmp[0].setProduction(tmp);
      tmp[4].setParentProduction(Generator.prod__FloatingPointLiteral__iter__char_class___range__48_57_lit___46_iter_star__char_class___range__48_57_opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_char_class___range__70_70_range__102_102_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__FloatingPointLiteral__iter__char_class___range__48_57_char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_char_class___range__70_70_range__102_102_ = _init_prod__FloatingPointLiteral__iter__char_class___range__48_57_char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_char_class___range__70_70_range__102_102_();
    private static final AbstractStackNode[] _init_prod__FloatingPointLiteral__iter__char_class___range__48_57_char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_char_class___range__70_70_range__102_102_() {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new CharStackNode(236, 4, new char[][]{{70,70},{102,102}}, null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new ListStackNode(232, 3, regular__iter__char_class___range__48_57, new CharStackNode(234, 0, new char[][]{{48,57}}, null, null), true, null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new OptionalStackNode(228, 2, regular__opt__char_class___range__43_43_range__45_45, new CharStackNode(230, 0, new char[][]{{43,43},{45,45}}, null, null), null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new CharStackNode(226, 1, new char[][]{{69,69},{101,101}}, null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new ListStackNode(222, 0, regular__iter__char_class___range__48_57, new CharStackNode(224, 0, new char[][]{{48,57}}, null, null), true, null, null);
      tmp[0].setProduction(tmp);
      tmp[4].setParentProduction(Generator.prod__FloatingPointLiteral__iter__char_class___range__48_57_char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_char_class___range__70_70_range__102_102_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__FloatingPointLiteral__lit___46_iter__char_class___range__48_57_opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_char_class___range__70_70_range__102_102_ = _init_prod__FloatingPointLiteral__lit___46_iter__char_class___range__48_57_opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_char_class___range__70_70_range__102_102_();
    private static final AbstractStackNode[] _init_prod__FloatingPointLiteral__lit___46_iter__char_class___range__48_57_opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_char_class___range__70_70_range__102_102_() {
      AbstractStackNode[] tmp = new AbstractStackNode[4];
      
      tmp[3] = new CharStackNode(258, 3, new char[][]{{70,70},{102,102}}, null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new OptionalStackNode(244, 2, regular__opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57, new SequenceStackNode(246, 0, regular__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57, new AbstractStackNode[]{new CharStackNode(248, 0, new char[][]{{69,69},{101,101}}, null, null), new OptionalStackNode(250, 1, regular__opt__char_class___range__43_43_range__45_45, new CharStackNode(252, 0, new char[][]{{43,43},{45,45}}, null, null), null, null), new ListStackNode(254, 2, regular__iter__char_class___range__48_57, new CharStackNode(256, 0, new char[][]{{48,57}}, null, null), true, null, null)}, null, null), null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new ListStackNode(240, 1, regular__iter__char_class___range__48_57, new CharStackNode(242, 0, new char[][]{{48,57}}, null, null), true, null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(238, 0, prod__lit___46__char_class___range__46_46_, new char[] {46}, null, null);
      tmp[0].setProduction(tmp);
      tmp[3].setParentProduction(Generator.prod__FloatingPointLiteral__lit___46_iter__char_class___range__48_57_opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_char_class___range__70_70_range__102_102_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__FloatingPointLiteral__iter__char_class___range__48_57_opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_char_class___range__70_70_range__102_102_ = _init_prod__FloatingPointLiteral__iter__char_class___range__48_57_opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_char_class___range__70_70_range__102_102_();
    private static final AbstractStackNode[] _init_prod__FloatingPointLiteral__iter__char_class___range__48_57_opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_char_class___range__70_70_range__102_102_() {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new CharStackNode(278, 2, new char[][]{{70,70},{102,102}}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new OptionalStackNode(264, 1, regular__opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57, new SequenceStackNode(266, 0, regular__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57, new AbstractStackNode[]{new CharStackNode(268, 0, new char[][]{{69,69},{101,101}}, null, null), new OptionalStackNode(270, 1, regular__opt__char_class___range__43_43_range__45_45, new CharStackNode(272, 0, new char[][]{{43,43},{45,45}}, null, null), null, null), new ListStackNode(274, 2, regular__iter__char_class___range__48_57, new CharStackNode(276, 0, new char[][]{{48,57}}, null, null), true, null, null)}, null, null), null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new ListStackNode(260, 0, regular__iter__char_class___range__48_57, new CharStackNode(262, 0, new char[][]{{48,57}}, null, null), true, null, null);
      tmp[0].setProduction(tmp);
      tmp[2].setParentProduction(Generator.prod__FloatingPointLiteral__iter__char_class___range__48_57_opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_char_class___range__70_70_range__102_102_);
      return tmp;
	}
  }
	
  private static class Name {
    public final static AbstractStackNode[] prod__Identifier_p_Name__iter_seps__Identifier__layouts_LAYOUTLIST_lit___46_layouts_LAYOUTLIST__tag__NotSupported___97_118_111_105_100 = _init_prod__Identifier_p_Name__iter_seps__Identifier__layouts_LAYOUTLIST_lit___46_layouts_LAYOUTLIST__tag__NotSupported___97_118_111_105_100();
    private static final AbstractStackNode[] _init_prod__Identifier_p_Name__iter_seps__Identifier__layouts_LAYOUTLIST_lit___46_layouts_LAYOUTLIST__tag__NotSupported___97_118_111_105_100() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new SeparatedListStackNode(288, 0, regular__iter_seps__Identifier__layouts_LAYOUTLIST_lit___46_layouts_LAYOUTLIST, new NonTerminalStackNode(290, 0, "Identifier", null, null), new AbstractStackNode[]{new NonTerminalStackNode(292, 1, "layouts_LAYOUTLIST", null, null), new LiteralStackNode(294, 2, prod__lit___46__char_class___range__46_46_, new char[] {46}, null, null), new NonTerminalStackNode(296, 3, "layouts_LAYOUTLIST", null, null)}, true, null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__Identifier_p_Name__iter_seps__Identifier__layouts_LAYOUTLIST_lit___46_layouts_LAYOUTLIST__tag__NotSupported___97_118_111_105_100);
      return tmp;
	}
    public final static AbstractStackNode[] prod__class_Name__Type_layouts_LAYOUTLIST_lit___46_layouts_LAYOUTLIST_conditional__lit_class__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__class_Name__Type_layouts_LAYOUTLIST_lit___46_layouts_LAYOUTLIST_conditional__lit_class__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__class_Name__Type_layouts_LAYOUTLIST_lit___46_layouts_LAYOUTLIST_conditional__lit_class__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new LiteralStackNode(306, 4, prod__lit_class__char_class___range__99_99_char_class___range__108_108_char_class___range__97_97_char_class___range__115_115_char_class___range__115_115_, new char[] {99,108,97,115,115}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(304, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new LiteralStackNode(302, 2, prod__lit___46__char_class___range__46_46_, new char[] {46}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(300, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new NonTerminalStackNode(298, 0, "Type", null, null);
      tmp[0].setProduction(tmp);
      tmp[4].setParentProduction(Generator.prod__class_Name__Type_layouts_LAYOUTLIST_lit___46_layouts_LAYOUTLIST_conditional__lit_class__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
  }
	
  private static class AssertStatement {
    public final static AbstractStackNode[] prod__assertWithExpression_AssertStatement__lit_assert_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___59__tag__NotSupported___112_114_101_102_101_114 = _init_prod__assertWithExpression_AssertStatement__lit_assert_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___59__tag__NotSupported___112_114_101_102_101_114();
    private static final AbstractStackNode[] _init_prod__assertWithExpression_AssertStatement__lit_assert_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___59__tag__NotSupported___112_114_101_102_101_114() {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new LiteralStackNode(344, 4, prod__lit___59__char_class___range__59_59_, new char[] {59}, null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(342, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new NonTerminalStackNode(340, 2, "Expression", null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(338, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(336, 0, prod__lit_assert__char_class___range__97_97_char_class___range__115_115_char_class___range__115_115_char_class___range__101_101_char_class___range__114_114_char_class___range__116_116_, new char[] {97,115,115,101,114,116}, null, null);
      tmp[0].setProduction(tmp);
      tmp[4].setParentProduction(Generator.prod__assertWithExpression_AssertStatement__lit_assert_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___59__tag__NotSupported___112_114_101_102_101_114);
      return tmp;
	}
  }
	
  private static class ClassType {
    public final static AbstractStackNode[] prod__ClassType__Identifier_layouts_LAYOUTLIST_lit___60_layouts_LAYOUTLIST_iter_seps__ClassType__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___62_ = _init_prod__ClassType__Identifier_layouts_LAYOUTLIST_lit___60_layouts_LAYOUTLIST_iter_seps__ClassType__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___62_();
    private static final AbstractStackNode[] _init_prod__ClassType__Identifier_layouts_LAYOUTLIST_lit___60_layouts_LAYOUTLIST_iter_seps__ClassType__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___62_() {
      AbstractStackNode[] tmp = new AbstractStackNode[7];
      
      tmp[6] = new LiteralStackNode(380, 6, prod__lit___62__char_class___range__62_62_, new char[] {62}, null, null);
      tmp[6].setProduction(tmp);
      tmp[5] = new NonTerminalStackNode(378, 5, "layouts_LAYOUTLIST", null, null);
      tmp[5].setProduction(tmp);
      tmp[4] = new SeparatedListStackNode(368, 4, regular__iter_seps__ClassType__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST, new NonTerminalStackNode(370, 0, "ClassType", null, null), new AbstractStackNode[]{new NonTerminalStackNode(372, 1, "layouts_LAYOUTLIST", null, null), new LiteralStackNode(374, 2, prod__lit___44__char_class___range__44_44_, new char[] {44}, null, null), new NonTerminalStackNode(376, 3, "layouts_LAYOUTLIST", null, null)}, true, null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(366, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new LiteralStackNode(364, 2, prod__lit___60__char_class___range__60_60_, new char[] {60}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(362, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new NonTerminalStackNode(360, 0, "Identifier", null, null);
      tmp[0].setProduction(tmp);
      tmp[6].setParentProduction(Generator.prod__ClassType__Identifier_layouts_LAYOUTLIST_lit___60_layouts_LAYOUTLIST_iter_seps__ClassType__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___62_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__ClassOrInterfaceType1_ClassType__ClassOrInterfaceType_ = _init_prod__ClassOrInterfaceType1_ClassType__ClassOrInterfaceType_();
    private static final AbstractStackNode[] _init_prod__ClassOrInterfaceType1_ClassType__ClassOrInterfaceType_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(382, 0, "ClassOrInterfaceType", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__ClassOrInterfaceType1_ClassType__ClassOrInterfaceType_);
      return tmp;
	}
  }
	
  private static class AssignmentOperator {
    public final static AbstractStackNode[] prod__assignOr_AssignmentOperator__lit___124_61_ = _init_prod__assignOr_AssignmentOperator__lit___124_61_();
    private static final AbstractStackNode[] _init_prod__assignOr_AssignmentOperator__lit___124_61_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(384, 0, prod__lit___124_61__char_class___range__124_124_char_class___range__61_61_, new char[] {124,61}, null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__assignOr_AssignmentOperator__lit___124_61_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__assignMin_AssignmentOperator__lit___45_61_ = _init_prod__assignMin_AssignmentOperator__lit___45_61_();
    private static final AbstractStackNode[] _init_prod__assignMin_AssignmentOperator__lit___45_61_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(386, 0, prod__lit___45_61__char_class___range__45_45_char_class___range__61_61_, new char[] {45,61}, null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__assignMin_AssignmentOperator__lit___45_61_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__assignAnd_AssignmentOperator__lit___38_61_ = _init_prod__assignAnd_AssignmentOperator__lit___38_61_();
    private static final AbstractStackNode[] _init_prod__assignAnd_AssignmentOperator__lit___38_61_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(388, 0, prod__lit___38_61__char_class___range__38_38_char_class___range__61_61_, new char[] {38,61}, null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__assignAnd_AssignmentOperator__lit___38_61_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__assignMul_AssignmentOperator__lit___42_61_ = _init_prod__assignMul_AssignmentOperator__lit___42_61_();
    private static final AbstractStackNode[] _init_prod__assignMul_AssignmentOperator__lit___42_61_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(390, 0, prod__lit___42_61__char_class___range__42_42_char_class___range__61_61_, new char[] {42,61}, null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__assignMul_AssignmentOperator__lit___42_61_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__equal1_AssignmentOperator__lit___61_ = _init_prod__equal1_AssignmentOperator__lit___61_();
    private static final AbstractStackNode[] _init_prod__equal1_AssignmentOperator__lit___61_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(392, 0, prod__lit___61__char_class___range__61_61_, new char[] {61}, null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__equal1_AssignmentOperator__lit___61_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__assignSR_AssignmentOperator__lit___62_62_61_ = _init_prod__assignSR_AssignmentOperator__lit___62_62_61_();
    private static final AbstractStackNode[] _init_prod__assignSR_AssignmentOperator__lit___62_62_61_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(394, 0, prod__lit___62_62_61__char_class___range__62_62_char_class___range__62_62_char_class___range__61_61_, new char[] {62,62,61}, null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__assignSR_AssignmentOperator__lit___62_62_61_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__assignDiv_AssignmentOperator__lit___47_61_ = _init_prod__assignDiv_AssignmentOperator__lit___47_61_();
    private static final AbstractStackNode[] _init_prod__assignDiv_AssignmentOperator__lit___47_61_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(396, 0, prod__lit___47_61__char_class___range__47_47_char_class___range__61_61_, new char[] {47,61}, null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__assignDiv_AssignmentOperator__lit___47_61_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__assignSL_AssignmentOperator__lit___60_60_61_ = _init_prod__assignSL_AssignmentOperator__lit___60_60_61_();
    private static final AbstractStackNode[] _init_prod__assignSL_AssignmentOperator__lit___60_60_61_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(398, 0, prod__lit___60_60_61__char_class___range__60_60_char_class___range__60_60_char_class___range__61_61_, new char[] {60,60,61}, null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__assignSL_AssignmentOperator__lit___60_60_61_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__assignPlus_AssignmentOperator__lit___43_61_ = _init_prod__assignPlus_AssignmentOperator__lit___43_61_();
    private static final AbstractStackNode[] _init_prod__assignPlus_AssignmentOperator__lit___43_61_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(400, 0, prod__lit___43_61__char_class___range__43_43_char_class___range__61_61_, new char[] {43,61}, null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__assignPlus_AssignmentOperator__lit___43_61_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__assignExp_AssignmentOperator__lit___94_61_ = _init_prod__assignExp_AssignmentOperator__lit___94_61_();
    private static final AbstractStackNode[] _init_prod__assignExp_AssignmentOperator__lit___94_61_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(402, 0, prod__lit___94_61__char_class___range__94_94_char_class___range__61_61_, new char[] {94,61}, null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__assignExp_AssignmentOperator__lit___94_61_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__AssignmentOperator_dunno_b_0_AssignmentOperator__lit___62_62_62_61_ = _init_prod__AssignmentOperator_dunno_b_0_AssignmentOperator__lit___62_62_62_61_();
    private static final AbstractStackNode[] _init_prod__AssignmentOperator_dunno_b_0_AssignmentOperator__lit___62_62_62_61_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(404, 0, prod__lit___62_62_62_61__char_class___range__62_62_char_class___range__62_62_char_class___range__62_62_char_class___range__61_61_, new char[] {62,62,62,61}, null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__AssignmentOperator_dunno_b_0_AssignmentOperator__lit___62_62_62_61_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__assignMod_AssignmentOperator__lit___37_61_ = _init_prod__assignMod_AssignmentOperator__lit___37_61_();
    private static final AbstractStackNode[] _init_prod__assignMod_AssignmentOperator__lit___37_61_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(406, 0, prod__lit___37_61__char_class___range__37_37_char_class___range__61_61_, new char[] {37,61}, null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__assignMod_AssignmentOperator__lit___37_61_);
      return tmp;
	}
  }
	
  private static class Expression {
    public final static AbstractStackNode[] prod__PrimitiveType_Dim_s_Expression_Expression__lit___40_layouts_LAYOUTLIST_PrimitiveType_layouts_LAYOUTLIST_iter_star_seps__Dim__layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_Expression_ = _init_prod__PrimitiveType_Dim_s_Expression_Expression__lit___40_layouts_LAYOUTLIST_PrimitiveType_layouts_LAYOUTLIST_iter_star_seps__Dim__layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_Expression_();
    private static final AbstractStackNode[] _init_prod__PrimitiveType_Dim_s_Expression_Expression__lit___40_layouts_LAYOUTLIST_PrimitiveType_layouts_LAYOUTLIST_iter_star_seps__Dim__layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_Expression_() {
      AbstractStackNode[] tmp = new AbstractStackNode[9];
      
      tmp[7] = new NonTerminalStackNode(804, 7, "layouts_LAYOUTLIST", null, null);
      tmp[7].setProduction(tmp);
      tmp[5] = new NonTerminalStackNode(800, 5, "layouts_LAYOUTLIST", null, null);
      tmp[5].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(792, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(788, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[2] = new NonTerminalStackNode(790, 2, "PrimitiveType", null, null);
      tmp[2].setProduction(tmp);
      tmp[4] = new SeparatedListStackNode(794, 4, regular__iter_star_seps__Dim__layouts_LAYOUTLIST, new NonTerminalStackNode(796, 0, "Dim", null, null), new AbstractStackNode[]{new NonTerminalStackNode(798, 1, "layouts_LAYOUTLIST", null, null)}, false, null, null);
      tmp[4].setProduction(tmp);
      tmp[6] = new LiteralStackNode(802, 6, prod__lit___41__char_class___range__41_41_, new char[] {41}, null, null);
      tmp[6].setProduction(tmp);
      tmp[8] = new NonTerminalStackNode(806, 8, "Expression", null, null);
      tmp[8].setProduction(tmp);
      tmp[0] = new LiteralStackNode(786, 0, prod__lit___40__char_class___range__40_40_, new char[] {40}, null, null);
      tmp[0].setProduction(tmp);
      tmp[8].setParentProduction(Generator.prod__PrimitiveType_Dim_s_Expression_Expression__lit___40_layouts_LAYOUTLIST_PrimitiveType_layouts_LAYOUTLIST_iter_star_seps__Dim__layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_Expression_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__gt1_Expression__Expression_layouts_LAYOUTLIST_lit___62_layouts_LAYOUTLIST_Expression__assoc__left = _init_prod__gt1_Expression__Expression_layouts_LAYOUTLIST_lit___62_layouts_LAYOUTLIST_Expression__assoc__left();
    private static final AbstractStackNode[] _init_prod__gt1_Expression__Expression_layouts_LAYOUTLIST_lit___62_layouts_LAYOUTLIST_Expression__assoc__left() {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[3] = new NonTerminalStackNode(916, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(912, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[2] = new LiteralStackNode(914, 2, prod__lit___62__char_class___range__62_62_, new char[] {62}, null, null);
      tmp[2].setProduction(tmp);
      tmp[4] = new NonTerminalStackNode(918, 4, "Expression", null, null);
      tmp[4].setProduction(tmp);
      tmp[0] = new NonTerminalStackNode(910, 0, "Expression", null, null);
      tmp[0].setProduction(tmp);
      tmp[4].setParentProduction(Generator.prod__gt1_Expression__Expression_layouts_LAYOUTLIST_lit___62_layouts_LAYOUTLIST_Expression__assoc__left);
      return tmp;
	}
    public final static AbstractStackNode[] prod__ge1_Expression__Expression_layouts_LAYOUTLIST_lit___62_61_layouts_LAYOUTLIST_Expression__assoc__left = _init_prod__ge1_Expression__Expression_layouts_LAYOUTLIST_lit___62_61_layouts_LAYOUTLIST_Expression__assoc__left();
    private static final AbstractStackNode[] _init_prod__ge1_Expression__Expression_layouts_LAYOUTLIST_lit___62_61_layouts_LAYOUTLIST_Expression__assoc__left() {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[3] = new NonTerminalStackNode(926, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(922, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new NonTerminalStackNode(920, 0, "Expression", null, null);
      tmp[0].setProduction(tmp);
      tmp[2] = new LiteralStackNode(924, 2, prod__lit___62_61__char_class___range__62_62_char_class___range__61_61_, new char[] {62,61}, null, null);
      tmp[2].setProduction(tmp);
      tmp[4] = new NonTerminalStackNode(928, 4, "Expression", null, null);
      tmp[4].setProduction(tmp);
      tmp[4].setParentProduction(Generator.prod__ge1_Expression__Expression_layouts_LAYOUTLIST_lit___62_61_layouts_LAYOUTLIST_Expression__assoc__left);
      return tmp;
	}
    public final static AbstractStackNode[] prod__le1_Expression__Expression_layouts_LAYOUTLIST_lit___60_61_layouts_LAYOUTLIST_Expression__assoc__left = _init_prod__le1_Expression__Expression_layouts_LAYOUTLIST_lit___60_61_layouts_LAYOUTLIST_Expression__assoc__left();
    private static final AbstractStackNode[] _init_prod__le1_Expression__Expression_layouts_LAYOUTLIST_lit___60_61_layouts_LAYOUTLIST_Expression__assoc__left() {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[3] = new NonTerminalStackNode(936, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(932, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[2] = new LiteralStackNode(934, 2, prod__lit___60_61__char_class___range__60_60_char_class___range__61_61_, new char[] {60,61}, null, null);
      tmp[2].setProduction(tmp);
      tmp[4] = new NonTerminalStackNode(938, 4, "Expression", null, null);
      tmp[4].setProduction(tmp);
      tmp[0] = new NonTerminalStackNode(930, 0, "Expression", null, null);
      tmp[0].setProduction(tmp);
      tmp[4].setParentProduction(Generator.prod__le1_Expression__Expression_layouts_LAYOUTLIST_lit___60_61_layouts_LAYOUTLIST_Expression__assoc__left);
      return tmp;
	}
    public final static AbstractStackNode[] prod__incr21_Expression__Expression_layouts_LAYOUTLIST_lit___43_43__tag__NotSupported___112_114_101_102_101_114 = _init_prod__incr21_Expression__Expression_layouts_LAYOUTLIST_lit___43_43__tag__NotSupported___112_114_101_102_101_114();
    private static final AbstractStackNode[] _init_prod__incr21_Expression__Expression_layouts_LAYOUTLIST_lit___43_43__tag__NotSupported___112_114_101_102_101_114() {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new LiteralStackNode(748, 2, prod__lit___43_43__char_class___range__43_43_char_class___range__43_43_, new char[] {43,43}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(746, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new NonTerminalStackNode(744, 0, "Expression", null, null);
      tmp[0].setProduction(tmp);
      tmp[2].setParentProduction(Generator.prod__incr21_Expression__Expression_layouts_LAYOUTLIST_lit___43_43__tag__NotSupported___112_114_101_102_101_114);
      return tmp;
	}
    public final static AbstractStackNode[] prod__and11_Expression__Expression_layouts_LAYOUTLIST_lit___38_38_layouts_LAYOUTLIST_Expression__assoc__left = _init_prod__and11_Expression__Expression_layouts_LAYOUTLIST_lit___38_38_layouts_LAYOUTLIST_Expression__assoc__left();
    private static final AbstractStackNode[] _init_prod__and11_Expression__Expression_layouts_LAYOUTLIST_lit___38_38_layouts_LAYOUTLIST_Expression__assoc__left() {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[3] = new NonTerminalStackNode(1016, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(1012, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[2] = new LiteralStackNode(1014, 2, prod__lit___38_38__char_class___range__38_38_char_class___range__38_38_, new char[] {38,38}, null, null);
      tmp[2].setProduction(tmp);
      tmp[4] = new NonTerminalStackNode(1018, 4, "Expression", null, null);
      tmp[4].setProduction(tmp);
      tmp[0] = new NonTerminalStackNode(1010, 0, "Expression", null, null);
      tmp[0].setProduction(tmp);
      tmp[4].setParentProduction(Generator.prod__and11_Expression__Expression_layouts_LAYOUTLIST_lit___38_38_layouts_LAYOUTLIST_Expression__assoc__left);
      return tmp;
	}
    public final static AbstractStackNode[] prod__times1_Expression__Expression_layouts_LAYOUTLIST_lit___42_layouts_LAYOUTLIST_Expression__assoc__left = _init_prod__times1_Expression__Expression_layouts_LAYOUTLIST_lit___42_layouts_LAYOUTLIST_Expression__assoc__left();
    private static final AbstractStackNode[] _init_prod__times1_Expression__Expression_layouts_LAYOUTLIST_lit___42_layouts_LAYOUTLIST_Expression__assoc__left() {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new NonTerminalStackNode(838, 4, "Expression", null, null);
      tmp[4].setProduction(tmp);
      tmp[2] = new LiteralStackNode(834, 2, prod__lit___42__char_class___range__42_42_, new char[] {42}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(832, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(836, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[0] = new NonTerminalStackNode(830, 0, "Expression", null, null);
      tmp[0].setProduction(tmp);
      tmp[4].setParentProduction(Generator.prod__times1_Expression__Expression_layouts_LAYOUTLIST_lit___42_layouts_LAYOUTLIST_Expression__assoc__left);
      return tmp;
	}
    public final static AbstractStackNode[] prod__lt1_Expression__Expression_layouts_LAYOUTLIST_lit___60_layouts_LAYOUTLIST_Expression__assoc__left = _init_prod__lt1_Expression__Expression_layouts_LAYOUTLIST_lit___60_layouts_LAYOUTLIST_Expression__assoc__left();
    private static final AbstractStackNode[] _init_prod__lt1_Expression__Expression_layouts_LAYOUTLIST_lit___60_layouts_LAYOUTLIST_Expression__assoc__left() {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[3] = new NonTerminalStackNode(946, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(942, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[2] = new LiteralStackNode(944, 2, prod__lit___60__char_class___range__60_60_, new char[] {60}, null, null);
      tmp[2].setProduction(tmp);
      tmp[4] = new NonTerminalStackNode(948, 4, "Expression", null, null);
      tmp[4].setProduction(tmp);
      tmp[0] = new NonTerminalStackNode(940, 0, "Expression", null, null);
      tmp[0].setProduction(tmp);
      tmp[4].setParentProduction(Generator.prod__lt1_Expression__Expression_layouts_LAYOUTLIST_lit___60_layouts_LAYOUTLIST_Expression__assoc__left);
      return tmp;
	}
    public final static AbstractStackNode[] prod__minus_Expression__lit___layouts_LAYOUTLIST_Expression_ = _init_prod__minus_Expression__lit___layouts_LAYOUTLIST_Expression_();
    private static final AbstractStackNode[] _init_prod__minus_Expression__lit___layouts_LAYOUTLIST_Expression_() {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[1] = new NonTerminalStackNode(782, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(780, 0, prod__lit____char_class___range__45_45_, new char[] {45}, null, null);
      tmp[0].setProduction(tmp);
      tmp[2] = new NonTerminalStackNode(784, 2, "Expression", null, null);
      tmp[2].setProduction(tmp);
      tmp[2].setParentProduction(Generator.prod__minus_Expression__lit___layouts_LAYOUTLIST_Expression_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__plus_Expression11_Expression__Expression_layouts_LAYOUTLIST_lit___43_layouts_LAYOUTLIST_Expression__assoc__left = _init_prod__plus_Expression11_Expression__Expression_layouts_LAYOUTLIST_lit___43_layouts_LAYOUTLIST_Expression__assoc__left();
    private static final AbstractStackNode[] _init_prod__plus_Expression11_Expression__Expression_layouts_LAYOUTLIST_lit___43_layouts_LAYOUTLIST_Expression__assoc__left() {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[3] = new NonTerminalStackNode(866, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(862, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[2] = new LiteralStackNode(864, 2, prod__lit___43__char_class___range__43_43_, new char[] {43}, null, null);
      tmp[2].setProduction(tmp);
      tmp[4] = new NonTerminalStackNode(868, 4, "Expression", null, null);
      tmp[4].setProduction(tmp);
      tmp[0] = new NonTerminalStackNode(860, 0, "Expression", null, null);
      tmp[0].setProduction(tmp);
      tmp[4].setParentProduction(Generator.prod__plus_Expression11_Expression__Expression_layouts_LAYOUTLIST_lit___43_layouts_LAYOUTLIST_Expression__assoc__left);
      return tmp;
	}
    public final static AbstractStackNode[] prod__StatementExpression_Expression__StatementExpression_ = _init_prod__StatementExpression_Expression__StatementExpression_();
    private static final AbstractStackNode[] _init_prod__StatementExpression_Expression__StatementExpression_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(632, 0, "StatementExpression", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__StatementExpression_Expression__StatementExpression_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__not_equal1_Expression__Expression_layouts_LAYOUTLIST_lit___33_61_layouts_LAYOUTLIST_Expression__assoc__left = _init_prod__not_equal1_Expression__Expression_layouts_LAYOUTLIST_lit___33_61_layouts_LAYOUTLIST_Expression__assoc__left();
    private static final AbstractStackNode[] _init_prod__not_equal1_Expression__Expression_layouts_LAYOUTLIST_lit___33_61_layouts_LAYOUTLIST_Expression__assoc__left() {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[3] = new NonTerminalStackNode(976, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(972, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[2] = new LiteralStackNode(974, 2, prod__lit___33_61__char_class___range__33_33_char_class___range__61_61_, new char[] {33,61}, null, null);
      tmp[2].setProduction(tmp);
      tmp[4] = new NonTerminalStackNode(978, 4, "Expression", null, null);
      tmp[4].setProduction(tmp);
      tmp[0] = new NonTerminalStackNode(970, 0, "Expression", null, null);
      tmp[0].setProduction(tmp);
      tmp[4].setParentProduction(Generator.prod__not_equal1_Expression__Expression_layouts_LAYOUTLIST_lit___33_61_layouts_LAYOUTLIST_Expression__assoc__left);
      return tmp;
	}
    public final static AbstractStackNode[] prod__or11_Expression__Expression_layouts_LAYOUTLIST_lit___124_124_layouts_LAYOUTLIST_Expression__assoc__left = _init_prod__or11_Expression__Expression_layouts_LAYOUTLIST_lit___124_124_layouts_LAYOUTLIST_Expression__assoc__left();
    private static final AbstractStackNode[] _init_prod__or11_Expression__Expression_layouts_LAYOUTLIST_lit___124_124_layouts_LAYOUTLIST_Expression__assoc__left() {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[3] = new NonTerminalStackNode(1026, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(1022, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[2] = new LiteralStackNode(1024, 2, prod__lit___124_124__char_class___range__124_124_char_class___range__124_124_, new char[] {124,124}, null, null);
      tmp[2].setProduction(tmp);
      tmp[4] = new NonTerminalStackNode(1028, 4, "Expression", null, null);
      tmp[4].setProduction(tmp);
      tmp[0] = new NonTerminalStackNode(1020, 0, "Expression", null, null);
      tmp[0].setProduction(tmp);
      tmp[4].setParentProduction(Generator.prod__or11_Expression__Expression_layouts_LAYOUTLIST_lit___124_124_layouts_LAYOUTLIST_Expression__assoc__left);
      return tmp;
	}
    public final static AbstractStackNode[] prod__instanceof_Expression__Expression_layouts_LAYOUTLIST_conditional__lit_instanceof__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_ReferenceType_ = _init_prod__instanceof_Expression__Expression_layouts_LAYOUTLIST_conditional__lit_instanceof__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_ReferenceType_();
    private static final AbstractStackNode[] _init_prod__instanceof_Expression__Expression_layouts_LAYOUTLIST_conditional__lit_instanceof__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_ReferenceType_() {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[3] = new NonTerminalStackNode(956, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(952, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[2] = new LiteralStackNode(954, 2, prod__lit_instanceof__char_class___range__105_105_char_class___range__110_110_char_class___range__115_115_char_class___range__116_116_char_class___range__97_97_char_class___range__110_110_char_class___range__99_99_char_class___range__101_101_char_class___range__111_111_char_class___range__102_102_, new char[] {105,110,115,116,97,110,99,101,111,102}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[2].setProduction(tmp);
      tmp[4] = new NonTerminalStackNode(958, 4, "ReferenceType", null, null);
      tmp[4].setProduction(tmp);
      tmp[0] = new NonTerminalStackNode(950, 0, "Expression", null, null);
      tmp[0].setProduction(tmp);
      tmp[4].setParentProduction(Generator.prod__instanceof_Expression__Expression_layouts_LAYOUTLIST_conditional__lit_instanceof__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_ReferenceType_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__incr31_Expression__lit___43_43_layouts_LAYOUTLIST_Expression__tag__NotSupported___112_114_101_102_101_114 = _init_prod__incr31_Expression__lit___43_43_layouts_LAYOUTLIST_Expression__tag__NotSupported___112_114_101_102_101_114();
    private static final AbstractStackNode[] _init_prod__incr31_Expression__lit___43_43_layouts_LAYOUTLIST_Expression__tag__NotSupported___112_114_101_102_101_114() {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new NonTerminalStackNode(760, 2, "Expression", null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(758, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(756, 0, prod__lit___43_43__char_class___range__43_43_char_class___range__43_43_, new char[] {43,43}, null, null);
      tmp[0].setProduction(tmp);
      tmp[2].setParentProduction(Generator.prod__incr31_Expression__lit___43_43_layouts_LAYOUTLIST_Expression__tag__NotSupported___112_114_101_102_101_114);
      return tmp;
	}
    public final static AbstractStackNode[] prod__Name_Dim_p_Expression_Expression__lit___40_layouts_LAYOUTLIST_Name_layouts_LAYOUTLIST_iter_seps__Dim__layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_Expression_ = _init_prod__Name_Dim_p_Expression_Expression__lit___40_layouts_LAYOUTLIST_Name_layouts_LAYOUTLIST_iter_seps__Dim__layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_Expression_();
    private static final AbstractStackNode[] _init_prod__Name_Dim_p_Expression_Expression__lit___40_layouts_LAYOUTLIST_Name_layouts_LAYOUTLIST_iter_seps__Dim__layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_Expression_() {
      AbstractStackNode[] tmp = new AbstractStackNode[9];
      
      tmp[7] = new NonTerminalStackNode(826, 7, "layouts_LAYOUTLIST", null, null);
      tmp[7].setProduction(tmp);
      tmp[5] = new NonTerminalStackNode(822, 5, "layouts_LAYOUTLIST", null, null);
      tmp[5].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(814, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(810, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[2] = new NonTerminalStackNode(812, 2, "Name", null, null);
      tmp[2].setProduction(tmp);
      tmp[4] = new SeparatedListStackNode(816, 4, regular__iter_seps__Dim__layouts_LAYOUTLIST, new NonTerminalStackNode(818, 0, "Dim", null, null), new AbstractStackNode[]{new NonTerminalStackNode(820, 1, "layouts_LAYOUTLIST", null, null)}, true, null, null);
      tmp[4].setProduction(tmp);
      tmp[6] = new LiteralStackNode(824, 6, prod__lit___41__char_class___range__41_41_, new char[] {41}, null, null);
      tmp[6].setProduction(tmp);
      tmp[8] = new NonTerminalStackNode(828, 8, "Expression", null, null);
      tmp[8].setProduction(tmp);
      tmp[0] = new LiteralStackNode(808, 0, prod__lit___40__char_class___range__40_40_, new char[] {40}, null, null);
      tmp[0].setProduction(tmp);
      tmp[8].setParentProduction(Generator.prod__Name_Dim_p_Expression_Expression__lit___40_layouts_LAYOUTLIST_Name_layouts_LAYOUTLIST_iter_seps__Dim__layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_Expression_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__shift_right1_Expression__Expression_layouts_LAYOUTLIST_lit___62_62_layouts_LAYOUTLIST_Expression__assoc__left = _init_prod__shift_right1_Expression__Expression_layouts_LAYOUTLIST_lit___62_62_layouts_LAYOUTLIST_Expression__assoc__left();
    private static final AbstractStackNode[] _init_prod__shift_right1_Expression__Expression_layouts_LAYOUTLIST_lit___62_62_layouts_LAYOUTLIST_Expression__assoc__left() {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[3] = new NonTerminalStackNode(896, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(892, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[2] = new LiteralStackNode(894, 2, prod__lit___62_62__char_class___range__62_62_char_class___range__62_62_, new char[] {62,62}, null, null);
      tmp[2].setProduction(tmp);
      tmp[4] = new NonTerminalStackNode(898, 4, "Expression", null, null);
      tmp[4].setProduction(tmp);
      tmp[0] = new NonTerminalStackNode(890, 0, "Expression", null, null);
      tmp[0].setProduction(tmp);
      tmp[4].setParentProduction(Generator.prod__shift_right1_Expression__Expression_layouts_LAYOUTLIST_lit___62_62_layouts_LAYOUTLIST_Expression__assoc__left);
      return tmp;
	}
    public final static AbstractStackNode[] prod__bar11_Expression__Expression_layouts_LAYOUTLIST_lit___124_layouts_LAYOUTLIST_Expression__assoc__left = _init_prod__bar11_Expression__Expression_layouts_LAYOUTLIST_lit___124_layouts_LAYOUTLIST_Expression__assoc__left();
    private static final AbstractStackNode[] _init_prod__bar11_Expression__Expression_layouts_LAYOUTLIST_lit___124_layouts_LAYOUTLIST_Expression__assoc__left() {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[3] = new NonTerminalStackNode(1006, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(1002, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[2] = new LiteralStackNode(1004, 2, prod__lit___124__char_class___range__124_124_, new char[] {124}, null, null);
      tmp[2].setProduction(tmp);
      tmp[4] = new NonTerminalStackNode(1008, 4, "Expression", null, null);
      tmp[4].setProduction(tmp);
      tmp[0] = new NonTerminalStackNode(1000, 0, "Expression", null, null);
      tmp[0].setProduction(tmp);
      tmp[4].setParentProduction(Generator.prod__bar11_Expression__Expression_layouts_LAYOUTLIST_lit___124_layouts_LAYOUTLIST_Expression__assoc__left);
      return tmp;
	}
    public final static AbstractStackNode[] prod__Primary_Expression__Primary__tag__NotSupported___112_114_101_102_101_114 = _init_prod__Primary_Expression__Primary__tag__NotSupported___112_114_101_102_101_114();
    private static final AbstractStackNode[] _init_prod__Primary_Expression__Primary__tag__NotSupported___112_114_101_102_101_114() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(464, 0, "Primary", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__Primary_Expression__Primary__tag__NotSupported___112_114_101_102_101_114);
      return tmp;
	}
    public final static AbstractStackNode[] prod__Expression_Expression31_Expression__Expression_layouts_LAYOUTLIST_lit___94_layouts_LAYOUTLIST_Expression__assoc__left = _init_prod__Expression_Expression31_Expression__Expression_layouts_LAYOUTLIST_lit___94_layouts_LAYOUTLIST_Expression__assoc__left();
    private static final AbstractStackNode[] _init_prod__Expression_Expression31_Expression__Expression_layouts_LAYOUTLIST_lit___94_layouts_LAYOUTLIST_Expression__assoc__left() {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[3] = new NonTerminalStackNode(996, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(992, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[2] = new LiteralStackNode(994, 2, prod__lit___94__char_class___range__94_94_, new char[] {94}, null, null);
      tmp[2].setProduction(tmp);
      tmp[4] = new NonTerminalStackNode(998, 4, "Expression", null, null);
      tmp[4].setProduction(tmp);
      tmp[0] = new NonTerminalStackNode(990, 0, "Expression", null, null);
      tmp[0].setProduction(tmp);
      tmp[4].setParentProduction(Generator.prod__Expression_Expression31_Expression__Expression_layouts_LAYOUTLIST_lit___94_layouts_LAYOUTLIST_Expression__assoc__left);
      return tmp;
	}
    public final static AbstractStackNode[] prod__div1_Expression__Expression_layouts_LAYOUTLIST_lit___47_layouts_LAYOUTLIST_Expression__assoc__left = _init_prod__div1_Expression__Expression_layouts_LAYOUTLIST_lit___47_layouts_LAYOUTLIST_Expression__assoc__left();
    private static final AbstractStackNode[] _init_prod__div1_Expression__Expression_layouts_LAYOUTLIST_lit___47_layouts_LAYOUTLIST_Expression__assoc__left() {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[3] = new NonTerminalStackNode(846, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(842, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[2] = new LiteralStackNode(844, 2, prod__lit___47__char_class___range__47_47_, new char[] {47}, null, null);
      tmp[2].setProduction(tmp);
      tmp[4] = new NonTerminalStackNode(848, 4, "Expression", null, null);
      tmp[4].setProduction(tmp);
      tmp[0] = new NonTerminalStackNode(840, 0, "Expression", null, null);
      tmp[0].setProduction(tmp);
      tmp[4].setParentProduction(Generator.prod__div1_Expression__Expression_layouts_LAYOUTLIST_lit___47_layouts_LAYOUTLIST_Expression__assoc__left);
      return tmp;
	}
    public final static AbstractStackNode[] prod__plus_Expression__lit___43_layouts_LAYOUTLIST_Expression_ = _init_prod__plus_Expression__lit___43_layouts_LAYOUTLIST_Expression_();
    private static final AbstractStackNode[] _init_prod__plus_Expression__lit___43_layouts_LAYOUTLIST_Expression_() {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[1] = new NonTerminalStackNode(764, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[2] = new NonTerminalStackNode(766, 2, "Expression", null, null);
      tmp[2].setProduction(tmp);
      tmp[0] = new LiteralStackNode(762, 0, prod__lit___43__char_class___range__43_43_, new char[] {43}, null, null);
      tmp[0].setProduction(tmp);
      tmp[2].setParentProduction(Generator.prod__plus_Expression__lit___43_layouts_LAYOUTLIST_Expression_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__mod_Expression11_Expression__Expression_layouts_LAYOUTLIST_lit___37_layouts_LAYOUTLIST_Expression__assoc__left = _init_prod__mod_Expression11_Expression__Expression_layouts_LAYOUTLIST_lit___37_layouts_LAYOUTLIST_Expression__assoc__left();
    private static final AbstractStackNode[] _init_prod__mod_Expression11_Expression__Expression_layouts_LAYOUTLIST_lit___37_layouts_LAYOUTLIST_Expression__assoc__left() {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[3] = new NonTerminalStackNode(856, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(852, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[2] = new LiteralStackNode(854, 2, prod__lit___37__char_class___range__37_37_, new char[] {37}, null, null);
      tmp[2].setProduction(tmp);
      tmp[4] = new NonTerminalStackNode(858, 4, "Expression", null, null);
      tmp[4].setProduction(tmp);
      tmp[0] = new NonTerminalStackNode(850, 0, "Expression", null, null);
      tmp[0].setProduction(tmp);
      tmp[4].setParentProduction(Generator.prod__mod_Expression11_Expression__Expression_layouts_LAYOUTLIST_lit___37_layouts_LAYOUTLIST_Expression__assoc__left);
      return tmp;
	}
    public final static AbstractStackNode[] prod__equal1_Expression__Expression_layouts_LAYOUTLIST_lit___61_61_layouts_LAYOUTLIST_Expression__assoc__left = _init_prod__equal1_Expression__Expression_layouts_LAYOUTLIST_lit___61_61_layouts_LAYOUTLIST_Expression__assoc__left();
    private static final AbstractStackNode[] _init_prod__equal1_Expression__Expression_layouts_LAYOUTLIST_lit___61_61_layouts_LAYOUTLIST_Expression__assoc__left() {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[3] = new NonTerminalStackNode(966, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(962, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[2] = new LiteralStackNode(964, 2, prod__lit___61_61__char_class___range__61_61_char_class___range__61_61_, new char[] {61,61}, null, null);
      tmp[2].setProduction(tmp);
      tmp[4] = new NonTerminalStackNode(968, 4, "Expression", null, null);
      tmp[4].setProduction(tmp);
      tmp[0] = new NonTerminalStackNode(960, 0, "Expression", null, null);
      tmp[0].setProduction(tmp);
      tmp[4].setParentProduction(Generator.prod__equal1_Expression__Expression_layouts_LAYOUTLIST_lit___61_61_layouts_LAYOUTLIST_Expression__assoc__left);
      return tmp;
	}
    public final static AbstractStackNode[] prod__not_Expression__lit___33_layouts_LAYOUTLIST_Expression_ = _init_prod__not_Expression__lit___33_layouts_LAYOUTLIST_Expression_();
    private static final AbstractStackNode[] _init_prod__not_Expression__lit___33_layouts_LAYOUTLIST_Expression_() {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[1] = new NonTerminalStackNode(776, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(774, 0, prod__lit___33__char_class___range__33_33_, new char[] {33}, null, null);
      tmp[0].setProduction(tmp);
      tmp[2] = new NonTerminalStackNode(778, 2, "Expression", null, null);
      tmp[2].setProduction(tmp);
      tmp[2].setParentProduction(Generator.prod__not_Expression__lit___33_layouts_LAYOUTLIST_Expression_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__tilde_Expression__lit___126_layouts_LAYOUTLIST_Expression_ = _init_prod__tilde_Expression__lit___126_layouts_LAYOUTLIST_Expression_();
    private static final AbstractStackNode[] _init_prod__tilde_Expression__lit___126_layouts_LAYOUTLIST_Expression_() {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[1] = new NonTerminalStackNode(770, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[2] = new NonTerminalStackNode(772, 2, "Expression", null, null);
      tmp[2].setProduction(tmp);
      tmp[0] = new LiteralStackNode(768, 0, prod__lit___126__char_class___range__126_126_, new char[] {126}, null, null);
      tmp[0].setProduction(tmp);
      tmp[2].setParentProduction(Generator.prod__tilde_Expression__lit___126_layouts_LAYOUTLIST_Expression_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__shift_left1_Expression__Expression_layouts_LAYOUTLIST_lit___60_60_layouts_LAYOUTLIST_Expression__assoc__left = _init_prod__shift_left1_Expression__Expression_layouts_LAYOUTLIST_lit___60_60_layouts_LAYOUTLIST_Expression__assoc__left();
    private static final AbstractStackNode[] _init_prod__shift_left1_Expression__Expression_layouts_LAYOUTLIST_lit___60_60_layouts_LAYOUTLIST_Expression__assoc__left() {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[3] = new NonTerminalStackNode(886, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(882, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[2] = new LiteralStackNode(884, 2, prod__lit___60_60__char_class___range__60_60_char_class___range__60_60_, new char[] {60,60}, null, null);
      tmp[2].setProduction(tmp);
      tmp[4] = new NonTerminalStackNode(888, 4, "Expression", null, null);
      tmp[4].setProduction(tmp);
      tmp[0] = new NonTerminalStackNode(880, 0, "Expression", null, null);
      tmp[0].setProduction(tmp);
      tmp[4].setParentProduction(Generator.prod__shift_left1_Expression__Expression_layouts_LAYOUTLIST_lit___60_60_layouts_LAYOUTLIST_Expression__assoc__left);
      return tmp;
	}
    public final static AbstractStackNode[] prod__Assignment1_Expression__Assignment_ = _init_prod__Assignment1_Expression__Assignment_();
    private static final AbstractStackNode[] _init_prod__Assignment1_Expression__Assignment_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(1030, 0, "Assignment", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__Assignment1_Expression__Assignment_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__decr31_Expression__lit____layouts_LAYOUTLIST_Expression__tag__NotSupported___112_114_101_102_101_114 = _init_prod__decr31_Expression__lit____layouts_LAYOUTLIST_Expression__tag__NotSupported___112_114_101_102_101_114();
    private static final AbstractStackNode[] _init_prod__decr31_Expression__lit____layouts_LAYOUTLIST_Expression__tag__NotSupported___112_114_101_102_101_114() {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new NonTerminalStackNode(754, 2, "Expression", null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(752, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(750, 0, prod__lit_____char_class___range__45_45_char_class___range__45_45_, new char[] {45,45}, null, null);
      tmp[0].setProduction(tmp);
      tmp[2].setParentProduction(Generator.prod__decr31_Expression__lit____layouts_LAYOUTLIST_Expression__tag__NotSupported___112_114_101_102_101_114);
      return tmp;
	}
    public final static AbstractStackNode[] prod__minus_Expression11_Expression__Expression_layouts_LAYOUTLIST_lit___layouts_LAYOUTLIST_Expression__assoc__left = _init_prod__minus_Expression11_Expression__Expression_layouts_LAYOUTLIST_lit___layouts_LAYOUTLIST_Expression__assoc__left();
    private static final AbstractStackNode[] _init_prod__minus_Expression11_Expression__Expression_layouts_LAYOUTLIST_lit___layouts_LAYOUTLIST_Expression__assoc__left() {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[0] = new NonTerminalStackNode(870, 0, "Expression", null, null);
      tmp[0].setProduction(tmp);
      tmp[4] = new NonTerminalStackNode(878, 4, "Expression", null, null);
      tmp[4].setProduction(tmp);
      tmp[2] = new LiteralStackNode(874, 2, prod__lit____char_class___range__45_45_, new char[] {45}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(872, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(876, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[4].setParentProduction(Generator.prod__minus_Expression11_Expression__Expression_layouts_LAYOUTLIST_lit___layouts_LAYOUTLIST_Expression__assoc__left);
      return tmp;
	}
    public final static AbstractStackNode[] prod__address11_Expression__Expression_layouts_LAYOUTLIST_lit___38_layouts_LAYOUTLIST_Expression__assoc__left = _init_prod__address11_Expression__Expression_layouts_LAYOUTLIST_lit___38_layouts_LAYOUTLIST_Expression__assoc__left();
    private static final AbstractStackNode[] _init_prod__address11_Expression__Expression_layouts_LAYOUTLIST_lit___38_layouts_LAYOUTLIST_Expression__assoc__left() {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[3] = new NonTerminalStackNode(986, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(982, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[2] = new LiteralStackNode(984, 2, prod__lit___38__char_class___range__38_38_, new char[] {38}, null, null);
      tmp[2].setProduction(tmp);
      tmp[4] = new NonTerminalStackNode(988, 4, "Expression", null, null);
      tmp[4].setProduction(tmp);
      tmp[0] = new NonTerminalStackNode(980, 0, "Expression", null, null);
      tmp[0].setProduction(tmp);
      tmp[4].setParentProduction(Generator.prod__address11_Expression__Expression_layouts_LAYOUTLIST_lit___38_layouts_LAYOUTLIST_Expression__assoc__left);
      return tmp;
	}
    public final static AbstractStackNode[] prod__decr21_Expression__Expression_layouts_LAYOUTLIST_lit_____tag__NotSupported___112_114_101_102_101_114 = _init_prod__decr21_Expression__Expression_layouts_LAYOUTLIST_lit_____tag__NotSupported___112_114_101_102_101_114();
    private static final AbstractStackNode[] _init_prod__decr21_Expression__Expression_layouts_LAYOUTLIST_lit_____tag__NotSupported___112_114_101_102_101_114() {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new LiteralStackNode(742, 2, prod__lit_____char_class___range__45_45_char_class___range__45_45_, new char[] {45,45}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(740, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new NonTerminalStackNode(738, 0, "Expression", null, null);
      tmp[0].setProduction(tmp);
      tmp[2].setParentProduction(Generator.prod__decr21_Expression__Expression_layouts_LAYOUTLIST_lit_____tag__NotSupported___112_114_101_102_101_114);
      return tmp;
	}
    public final static AbstractStackNode[] prod__Expression12_Expression__Expression_layouts_LAYOUTLIST_lit___62_62_62_layouts_LAYOUTLIST_Expression__assoc__left = _init_prod__Expression12_Expression__Expression_layouts_LAYOUTLIST_lit___62_62_62_layouts_LAYOUTLIST_Expression__assoc__left();
    private static final AbstractStackNode[] _init_prod__Expression12_Expression__Expression_layouts_LAYOUTLIST_lit___62_62_62_layouts_LAYOUTLIST_Expression__assoc__left() {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[3] = new NonTerminalStackNode(906, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(902, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[2] = new LiteralStackNode(904, 2, prod__lit___62_62_62__char_class___range__62_62_char_class___range__62_62_char_class___range__62_62_, new char[] {62,62,62}, null, null);
      tmp[2].setProduction(tmp);
      tmp[4] = new NonTerminalStackNode(908, 4, "Expression", null, null);
      tmp[4].setProduction(tmp);
      tmp[0] = new NonTerminalStackNode(900, 0, "Expression", null, null);
      tmp[0].setProduction(tmp);
      tmp[4].setParentProduction(Generator.prod__Expression12_Expression__Expression_layouts_LAYOUTLIST_lit___62_62_62_layouts_LAYOUTLIST_Expression__assoc__left);
      return tmp;
	}
    public final static AbstractStackNode[] prod__Cast_Expression_Expression__lit___40_layouts_LAYOUTLIST_Type_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_Expression_ = _init_prod__Cast_Expression_Expression__lit___40_layouts_LAYOUTLIST_Type_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_Expression_();
    private static final AbstractStackNode[] _init_prod__Cast_Expression_Expression__lit___40_layouts_LAYOUTLIST_Type_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_Expression_() {
      AbstractStackNode[] tmp = new AbstractStackNode[7];
      
      tmp[6] = new NonTerminalStackNode(698, 6, "Expression", null, null);
      tmp[6].setProduction(tmp);
      tmp[0] = new LiteralStackNode(686, 0, prod__lit___40__char_class___range__40_40_, new char[] {40}, null, null);
      tmp[0].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(688, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[2] = new NonTerminalStackNode(690, 2, "Type", null, null);
      tmp[2].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(692, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[4] = new LiteralStackNode(694, 4, prod__lit___41__char_class___range__41_41_, new char[] {41}, null, null);
      tmp[4].setProduction(tmp);
      tmp[5] = new NonTerminalStackNode(696, 5, "layouts_LAYOUTLIST", null, null);
      tmp[5].setProduction(tmp);
      tmp[6].setParentProduction(Generator.prod__Cast_Expression_Expression__lit___40_layouts_LAYOUTLIST_Type_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_Expression_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__colon2_Expression__Expression_layouts_LAYOUTLIST_lit___63_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___58_layouts_LAYOUTLIST_Expression__tag__NotSupported___112_114_101_102_101_114 = _init_prod__colon2_Expression__Expression_layouts_LAYOUTLIST_lit___63_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___58_layouts_LAYOUTLIST_Expression__tag__NotSupported___112_114_101_102_101_114();
    private static final AbstractStackNode[] _init_prod__colon2_Expression__Expression_layouts_LAYOUTLIST_lit___63_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___58_layouts_LAYOUTLIST_Expression__tag__NotSupported___112_114_101_102_101_114() {
      AbstractStackNode[] tmp = new AbstractStackNode[9];
      
      tmp[8] = new NonTerminalStackNode(736, 8, "Expression", null, null);
      tmp[8].setProduction(tmp);
      tmp[7] = new NonTerminalStackNode(734, 7, "layouts_LAYOUTLIST", null, null);
      tmp[7].setProduction(tmp);
      tmp[6] = new LiteralStackNode(732, 6, prod__lit___58__char_class___range__58_58_, new char[] {58}, null, null);
      tmp[6].setProduction(tmp);
      tmp[5] = new NonTerminalStackNode(730, 5, "layouts_LAYOUTLIST", null, null);
      tmp[5].setProduction(tmp);
      tmp[4] = new NonTerminalStackNode(728, 4, "Expression", null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(726, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new LiteralStackNode(724, 2, prod__lit___63__char_class___range__63_63_, new char[] {63}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(722, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new NonTerminalStackNode(720, 0, "Expression", null, null);
      tmp[0].setProduction(tmp);
      tmp[8].setParentProduction(Generator.prod__colon2_Expression__Expression_layouts_LAYOUTLIST_lit___63_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___58_layouts_LAYOUTLIST_Expression__tag__NotSupported___112_114_101_102_101_114);
      return tmp;
	}
  }
	
  private static class ForStatement {
    public final static AbstractStackNode[] prod__for_semicolon_semicolon_ForStatement__conditional__lit_for__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_opt__ForInit_layouts_LAYOUTLIST_lit___59_layouts_LAYOUTLIST_opt__Expression_layouts_LAYOUTLIST_lit___59_layouts_LAYOUTLIST_opt__ForUpdate_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_Statement_ = _init_prod__for_semicolon_semicolon_ForStatement__conditional__lit_for__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_opt__ForInit_layouts_LAYOUTLIST_lit___59_layouts_LAYOUTLIST_opt__Expression_layouts_LAYOUTLIST_lit___59_layouts_LAYOUTLIST_opt__ForUpdate_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_Statement_();
    private static final AbstractStackNode[] _init_prod__for_semicolon_semicolon_ForStatement__conditional__lit_for__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_opt__ForInit_layouts_LAYOUTLIST_lit___59_layouts_LAYOUTLIST_opt__Expression_layouts_LAYOUTLIST_lit___59_layouts_LAYOUTLIST_opt__ForUpdate_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_Statement_() {
      AbstractStackNode[] tmp = new AbstractStackNode[17];
      
      tmp[16] = new NonTerminalStackNode(1070, 16, "Statement", null, null);
      tmp[16].setProduction(tmp);
      tmp[15] = new NonTerminalStackNode(1068, 15, "layouts_LAYOUTLIST", null, null);
      tmp[15].setProduction(tmp);
      tmp[14] = new LiteralStackNode(1066, 14, prod__lit___41__char_class___range__41_41_, new char[] {41}, null, null);
      tmp[14].setProduction(tmp);
      tmp[13] = new NonTerminalStackNode(1064, 13, "layouts_LAYOUTLIST", null, null);
      tmp[13].setProduction(tmp);
      tmp[12] = new OptionalStackNode(1060, 12, regular__opt__ForUpdate, new NonTerminalStackNode(1062, 0, "ForUpdate", null, null), null, null);
      tmp[12].setProduction(tmp);
      tmp[11] = new NonTerminalStackNode(1058, 11, "layouts_LAYOUTLIST", null, null);
      tmp[11].setProduction(tmp);
      tmp[10] = new LiteralStackNode(1056, 10, prod__lit___59__char_class___range__59_59_, new char[] {59}, null, null);
      tmp[10].setProduction(tmp);
      tmp[9] = new NonTerminalStackNode(1054, 9, "layouts_LAYOUTLIST", null, null);
      tmp[9].setProduction(tmp);
      tmp[8] = new OptionalStackNode(1050, 8, regular__opt__Expression, new NonTerminalStackNode(1052, 0, "Expression", null, null), null, null);
      tmp[8].setProduction(tmp);
      tmp[7] = new NonTerminalStackNode(1048, 7, "layouts_LAYOUTLIST", null, null);
      tmp[7].setProduction(tmp);
      tmp[6] = new LiteralStackNode(1046, 6, prod__lit___59__char_class___range__59_59_, new char[] {59}, null, null);
      tmp[6].setProduction(tmp);
      tmp[5] = new NonTerminalStackNode(1044, 5, "layouts_LAYOUTLIST", null, null);
      tmp[5].setProduction(tmp);
      tmp[4] = new OptionalStackNode(1040, 4, regular__opt__ForInit, new NonTerminalStackNode(1042, 0, "ForInit", null, null), null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(1038, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new LiteralStackNode(1036, 2, prod__lit___40__char_class___range__40_40_, new char[] {40}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(1034, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(1032, 0, prod__lit_for__char_class___range__102_102_char_class___range__111_111_char_class___range__114_114_, new char[] {102,111,114}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[16].setParentProduction(Generator.prod__for_semicolon_semicolon_ForStatement__conditional__lit_for__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_opt__ForInit_layouts_LAYOUTLIST_lit___59_layouts_LAYOUTLIST_opt__Expression_layouts_LAYOUTLIST_lit___59_layouts_LAYOUTLIST_opt__ForUpdate_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_Statement_);
      return tmp;
	}
  }
	
  private static class View {
    public final static AbstractStackNode[] prod__View__lit_view_layouts_LAYOUTLIST_Identifier_layouts_LAYOUTLIST_lit_grammar_layouts_LAYOUTLIST_File_layouts_LAYOUTLIST_lit___123_layouts_LAYOUTLIST_iter_star_seps__TokenDef__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___125_ = _init_prod__View__lit_view_layouts_LAYOUTLIST_Identifier_layouts_LAYOUTLIST_lit_grammar_layouts_LAYOUTLIST_File_layouts_LAYOUTLIST_lit___123_layouts_LAYOUTLIST_iter_star_seps__TokenDef__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___125_();
    private static final AbstractStackNode[] _init_prod__View__lit_view_layouts_LAYOUTLIST_Identifier_layouts_LAYOUTLIST_lit_grammar_layouts_LAYOUTLIST_File_layouts_LAYOUTLIST_lit___123_layouts_LAYOUTLIST_iter_star_seps__TokenDef__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___125_() {
      AbstractStackNode[] tmp = new AbstractStackNode[13];
      
      tmp[12] = new LiteralStackNode(1104, 12, prod__lit___125__char_class___range__125_125_, new char[] {125}, null, null);
      tmp[12].setProduction(tmp);
      tmp[11] = new NonTerminalStackNode(1102, 11, "layouts_LAYOUTLIST", null, null);
      tmp[11].setProduction(tmp);
      tmp[10] = new SeparatedListStackNode(1092, 10, regular__iter_star_seps__TokenDef__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST, new NonTerminalStackNode(1094, 0, "TokenDef", null, null), new AbstractStackNode[]{new NonTerminalStackNode(1096, 1, "layouts_LAYOUTLIST", null, null), new LiteralStackNode(1098, 2, prod__lit___44__char_class___range__44_44_, new char[] {44}, null, null), new NonTerminalStackNode(1100, 3, "layouts_LAYOUTLIST", null, null)}, false, null, null);
      tmp[10].setProduction(tmp);
      tmp[9] = new NonTerminalStackNode(1090, 9, "layouts_LAYOUTLIST", null, null);
      tmp[9].setProduction(tmp);
      tmp[8] = new LiteralStackNode(1088, 8, prod__lit___123__char_class___range__123_123_, new char[] {123}, null, null);
      tmp[8].setProduction(tmp);
      tmp[7] = new NonTerminalStackNode(1086, 7, "layouts_LAYOUTLIST", null, null);
      tmp[7].setProduction(tmp);
      tmp[6] = new NonTerminalStackNode(1084, 6, "File", null, null);
      tmp[6].setProduction(tmp);
      tmp[5] = new NonTerminalStackNode(1082, 5, "layouts_LAYOUTLIST", null, null);
      tmp[5].setProduction(tmp);
      tmp[4] = new LiteralStackNode(1080, 4, prod__lit_grammar__char_class___range__103_103_char_class___range__114_114_char_class___range__97_97_char_class___range__109_109_char_class___range__109_109_char_class___range__97_97_char_class___range__114_114_, new char[] {103,114,97,109,109,97,114}, null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(1078, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new NonTerminalStackNode(1076, 2, "Identifier", null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(1074, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(1072, 0, prod__lit_view__char_class___range__118_118_char_class___range__105_105_char_class___range__101_101_char_class___range__119_119_, new char[] {118,105,101,119}, null, null);
      tmp[0].setProduction(tmp);
      tmp[12].setParentProduction(Generator.prod__View__lit_view_layouts_LAYOUTLIST_Identifier_layouts_LAYOUTLIST_lit_grammar_layouts_LAYOUTLIST_File_layouts_LAYOUTLIST_lit___123_layouts_LAYOUTLIST_iter_star_seps__TokenDef__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___125_);
      return tmp;
	}
  }
	
  private static class EmptyStatement {
    public final static AbstractStackNode[] prod__semicolon1_EmptyStatement__lit___59_ = _init_prod__semicolon1_EmptyStatement__lit___59_();
    private static final AbstractStackNode[] _init_prod__semicolon1_EmptyStatement__lit___59_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(1106, 0, prod__lit___59__char_class___range__59_59_, new char[] {59}, null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__semicolon1_EmptyStatement__lit___59_);
      return tmp;
	}
  }
	
  private static class Thing {
    public final static AbstractStackNode[] prod__Thing__conditional__Word__delete__lit_start_ = _init_prod__Thing__conditional__Word__delete__lit_start_();
    private static final AbstractStackNode[] _init_prod__Thing__conditional__Word__delete__lit_start_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(1120, 0, "Word", null, new ICompletionFilter[] {new StringMatchRestriction(new char[] {115,116,97,114,116})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__Thing__conditional__Word__delete__lit_start_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__Thing__lit_start_layouts_LAYOUTLIST_conditional__empty__not_follow__lit_returns_ = _init_prod__Thing__lit_start_layouts_LAYOUTLIST_conditional__empty__not_follow__lit_returns_();
    private static final AbstractStackNode[] _init_prod__Thing__lit_start_layouts_LAYOUTLIST_conditional__empty__not_follow__lit_returns_() {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new EmptyStackNode(1126, 2, regular__empty, null, new ICompletionFilter[] {new StringFollowRestriction(new char[] {114,101,116,117,114,110,115})});
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(1124, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(1122, 0, prod__lit_start__char_class___range__115_115_char_class___range__116_116_char_class___range__97_97_char_class___range__114_114_char_class___range__116_116_, new char[] {115,116,97,114,116}, null, null);
      tmp[0].setProduction(tmp);
      tmp[2].setParentProduction(Generator.prod__Thing__lit_start_layouts_LAYOUTLIST_conditional__empty__not_follow__lit_returns_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__Thing__lit_start_layouts_LAYOUTLIST_lit_returns_layouts_LAYOUTLIST_lit___91_layouts_LAYOUTLIST_iter_star_seps__FormalParameter__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___93_ = _init_prod__Thing__lit_start_layouts_LAYOUTLIST_lit_returns_layouts_LAYOUTLIST_lit___91_layouts_LAYOUTLIST_iter_star_seps__FormalParameter__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___93_();
    private static final AbstractStackNode[] _init_prod__Thing__lit_start_layouts_LAYOUTLIST_lit_returns_layouts_LAYOUTLIST_lit___91_layouts_LAYOUTLIST_iter_star_seps__FormalParameter__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___93_() {
      AbstractStackNode[] tmp = new AbstractStackNode[9];
      
      tmp[8] = new LiteralStackNode(1152, 8, prod__lit___93__char_class___range__93_93_, new char[] {93}, null, null);
      tmp[8].setProduction(tmp);
      tmp[7] = new NonTerminalStackNode(1150, 7, "layouts_LAYOUTLIST", null, null);
      tmp[7].setProduction(tmp);
      tmp[6] = new SeparatedListStackNode(1140, 6, regular__iter_star_seps__FormalParameter__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST, new NonTerminalStackNode(1142, 0, "FormalParameter", null, null), new AbstractStackNode[]{new NonTerminalStackNode(1144, 1, "layouts_LAYOUTLIST", null, null), new LiteralStackNode(1146, 2, prod__lit___44__char_class___range__44_44_, new char[] {44}, null, null), new NonTerminalStackNode(1148, 3, "layouts_LAYOUTLIST", null, null)}, false, null, null);
      tmp[6].setProduction(tmp);
      tmp[5] = new NonTerminalStackNode(1138, 5, "layouts_LAYOUTLIST", null, null);
      tmp[5].setProduction(tmp);
      tmp[4] = new LiteralStackNode(1136, 4, prod__lit___91__char_class___range__91_91_, new char[] {91}, null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(1134, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new LiteralStackNode(1132, 2, prod__lit_returns__char_class___range__114_114_char_class___range__101_101_char_class___range__116_116_char_class___range__117_117_char_class___range__114_114_char_class___range__110_110_char_class___range__115_115_, new char[] {114,101,116,117,114,110,115}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(1130, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(1128, 0, prod__lit_start__char_class___range__115_115_char_class___range__116_116_char_class___range__97_97_char_class___range__114_114_char_class___range__116_116_, new char[] {115,116,97,114,116}, null, null);
      tmp[0].setProduction(tmp);
      tmp[8].setParentProduction(Generator.prod__Thing__lit_start_layouts_LAYOUTLIST_lit_returns_layouts_LAYOUTLIST_lit___91_layouts_LAYOUTLIST_iter_star_seps__FormalParameter__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___93_);
      return tmp;
	}
  }
	
  private static class Identifier {
    public final static AbstractStackNode[] prod__Identifier__conditional__lit___60_105_110_105_116_62__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__Identifier__conditional__lit___60_105_110_105_116_62__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__Identifier__conditional__lit___60_105_110_105_116_62__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(1156, 0, prod__lit___60_105_110_105_116_62__char_class___range__60_60_char_class___range__105_105_char_class___range__110_110_char_class___range__105_105_char_class___range__116_116_char_class___range__62_62_, new char[] {60,105,110,105,116,62}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__Identifier__conditional__lit___60_105_110_105_116_62__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__Identifier__char_class___range__36_36_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_conditional__iter_star_seps__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122__layouts_LAYOUTLIST__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__Identifier__char_class___range__36_36_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_conditional__iter_star_seps__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122__layouts_LAYOUTLIST__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__Identifier__char_class___range__36_36_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_conditional__iter_star_seps__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122__layouts_LAYOUTLIST__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new SeparatedListStackNode(1162, 2, regular__iter_star_seps__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122__layouts_LAYOUTLIST, new CharStackNode(1164, 0, new char[][]{{36,36},{48,57},{65,90},{95,95},{97,122}}, null, null), new AbstractStackNode[]{new NonTerminalStackNode(1166, 1, "layouts_LAYOUTLIST", null, null)}, false, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(1160, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new CharStackNode(1158, 0, new char[][]{{36,36},{65,90},{95,95},{97,122}}, null, null);
      tmp[0].setProduction(tmp);
      tmp[2].setParentProduction(Generator.prod__Identifier__char_class___range__36_36_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_conditional__iter_star_seps__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122__layouts_LAYOUTLIST__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__Identifier__char_class___range__36_36_range__65_90_range__95_95_range__97_122_layouts_$default$_conditional__iter_star_seps__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122__layouts_$default$__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__Identifier__char_class___range__36_36_range__65_90_range__95_95_range__97_122_layouts_$default$_conditional__iter_star_seps__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122__layouts_$default$__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__Identifier__char_class___range__36_36_range__65_90_range__95_95_range__97_122_layouts_$default$_conditional__iter_star_seps__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122__layouts_$default$__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new SeparatedListStackNode(1172, 2, regular__iter_star_seps__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122__layouts_$default$, new CharStackNode(1174, 0, new char[][]{{36,36},{48,57},{65,90},{95,95},{97,122}}, null, null), new AbstractStackNode[]{new NonTerminalStackNode(1176, 1, "layouts_$default$", null, null)}, false, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(1170, 1, "layouts_$default$", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new CharStackNode(1168, 0, new char[][]{{36,36},{65,90},{95,95},{97,122}}, null, null);
      tmp[0].setProduction(tmp);
      tmp[2].setParentProduction(Generator.prod__Identifier__char_class___range__36_36_range__65_90_range__95_95_range__97_122_layouts_$default$_conditional__iter_star_seps__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122__layouts_$default$__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__Identifier__conditional__lit___60_115_116_97_116_105_99_45_105_110_105_116_62__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__Identifier__conditional__lit___60_115_116_97_116_105_99_45_105_110_105_116_62__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__Identifier__conditional__lit___60_115_116_97_116_105_99_45_105_110_105_116_62__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(1178, 0, prod__lit___60_115_116_97_116_105_99_45_105_110_105_116_62__char_class___range__60_60_char_class___range__115_115_char_class___range__116_116_char_class___range__97_97_char_class___range__116_116_char_class___range__105_105_char_class___range__99_99_char_class___range__45_45_char_class___range__105_105_char_class___range__110_110_char_class___range__105_105_char_class___range__116_116_char_class___range__62_62_, new char[] {60,115,116,97,116,105,99,45,105,110,105,116,62}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__Identifier__conditional__lit___60_115_116_97_116_105_99_45_105_110_105_116_62__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__Identifier__conditional__lit___60_100_101_102_97_117_108_116_45_112_97_99_107_97_103_101_62__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__Identifier__conditional__lit___60_100_101_102_97_117_108_116_45_112_97_99_107_97_103_101_62__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__Identifier__conditional__lit___60_100_101_102_97_117_108_116_45_112_97_99_107_97_103_101_62__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(1180, 0, prod__lit___60_100_101_102_97_117_108_116_45_112_97_99_107_97_103_101_62__char_class___range__60_60_char_class___range__100_100_char_class___range__101_101_char_class___range__102_102_char_class___range__97_97_char_class___range__117_117_char_class___range__108_108_char_class___range__116_116_char_class___range__45_45_char_class___range__112_112_char_class___range__97_97_char_class___range__99_99_char_class___range__107_107_char_class___range__97_97_char_class___range__103_103_char_class___range__101_101_char_class___range__62_62_, new char[] {60,100,101,102,97,117,108,116,45,112,97,99,107,97,103,101,62}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__Identifier__conditional__lit___60_100_101_102_97_117_108_116_45_112_97_99_107_97_103_101_62__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
  }
	
  private static class Comment {
    public final static AbstractStackNode[] prod__Comment__lit___47_47_iter_star__char_class___range__0_9_range__11_65535_char_class___range__10_10_ = _init_prod__Comment__lit___47_47_iter_star__char_class___range__0_9_range__11_65535_char_class___range__10_10_();
    private static final AbstractStackNode[] _init_prod__Comment__lit___47_47_iter_star__char_class___range__0_9_range__11_65535_char_class___range__10_10_() {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new CharStackNode(1188, 2, new char[][]{{10,10}}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new ListStackNode(1184, 1, regular__iter_star__char_class___range__0_9_range__11_65535, new CharStackNode(1186, 0, new char[][]{{0,9},{11,65535}}, null, null), false, null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(1182, 0, prod__lit___47_47__char_class___range__47_47_char_class___range__47_47_, new char[] {47,47}, null, null);
      tmp[0].setProduction(tmp);
      tmp[2].setParentProduction(Generator.prod__Comment__lit___47_47_iter_star__char_class___range__0_9_range__11_65535_char_class___range__10_10_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__Comment__lit___47_42_iter_star__CommentChar_lit___42_47__tag__category___67_111_109_109_101_110_116 = _init_prod__Comment__lit___47_42_iter_star__CommentChar_lit___42_47__tag__category___67_111_109_109_101_110_116();
    private static final AbstractStackNode[] _init_prod__Comment__lit___47_42_iter_star__CommentChar_lit___42_47__tag__category___67_111_109_109_101_110_116() {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new LiteralStackNode(1196, 2, prod__lit___42_47__char_class___range__42_42_char_class___range__47_47_, new char[] {42,47}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new ListStackNode(1192, 1, regular__iter_star__CommentChar, new NonTerminalStackNode(1194, 0, "CommentChar", null, null), false, null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(1190, 0, prod__lit___47_42__char_class___range__47_47_char_class___range__42_42_, new char[] {47,42}, null, null);
      tmp[0].setProduction(tmp);
      tmp[2].setParentProduction(Generator.prod__Comment__lit___47_42_iter_star__CommentChar_lit___42_47__tag__category___67_111_109_109_101_110_116);
      return tmp;
	}
    public final static AbstractStackNode[] prod__Comment__lit___47_42_iter_star__alt___conditional__char_class___range__42_42__not_follow__char_class___range__47_47_char_class___range__0_41_range__43_65535_lit___42_47_ = _init_prod__Comment__lit___47_42_iter_star__alt___conditional__char_class___range__42_42__not_follow__char_class___range__47_47_char_class___range__0_41_range__43_65535_lit___42_47_();
    private static final AbstractStackNode[] _init_prod__Comment__lit___47_42_iter_star__alt___conditional__char_class___range__42_42__not_follow__char_class___range__47_47_char_class___range__0_41_range__43_65535_lit___42_47_() {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new LiteralStackNode(1208, 2, prod__lit___42_47__char_class___range__42_42_char_class___range__47_47_, new char[] {42,47}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new ListStackNode(1200, 1, regular__iter_star__alt___conditional__char_class___range__42_42__not_follow__char_class___range__47_47_char_class___range__0_41_range__43_65535, new AlternativeStackNode(1202, 0, regular__alt___conditional__char_class___range__42_42__not_follow__char_class___range__47_47_char_class___range__0_41_range__43_65535, new AbstractStackNode[]{new CharStackNode(1204, 0, new char[][]{{42,42}}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{47,47}})}), new CharStackNode(1206, 0, new char[][]{{0,41},{43,65535}}, null, null)}, null, null), false, null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(1198, 0, prod__lit___47_42__char_class___range__47_47_char_class___range__42_42_, new char[] {47,42}, null, null);
      tmp[0].setProduction(tmp);
      tmp[2].setParentProduction(Generator.prod__Comment__lit___47_42_iter_star__alt___conditional__char_class___range__42_42__not_follow__char_class___range__47_47_char_class___range__0_41_range__43_65535_lit___42_47_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__Comment__lit___47_47_conditional__iter_star__char_class___range__0_9_range__11_65535__end_of_line_ = _init_prod__Comment__lit___47_47_conditional__iter_star__char_class___range__0_9_range__11_65535__end_of_line_();
    private static final AbstractStackNode[] _init_prod__Comment__lit___47_47_conditional__iter_star__char_class___range__0_9_range__11_65535__end_of_line_() {
      AbstractStackNode[] tmp = new AbstractStackNode[2];
      
      tmp[1] = new ListStackNode(1212, 1, regular__iter_star__char_class___range__0_9_range__11_65535, new CharStackNode(1214, 0, new char[][]{{0,9},{11,65535}}, null, null), false, null, new ICompletionFilter[] {new AtEndOfLineRequirement()});
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(1210, 0, prod__lit___47_47__char_class___range__47_47_char_class___range__47_47_, new char[] {47,47}, null, null);
      tmp[0].setProduction(tmp);
      tmp[1].setParentProduction(Generator.prod__Comment__lit___47_47_conditional__iter_star__char_class___range__0_9_range__11_65535__end_of_line_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__Comment__lit___47_47_iter_star__char_class___range__0_9_range__11_65535_char_class___range__10_10__tag__category___67_111_109_109_101_110_116 = _init_prod__Comment__lit___47_47_iter_star__char_class___range__0_9_range__11_65535_char_class___range__10_10__tag__category___67_111_109_109_101_110_116();
    private static final AbstractStackNode[] _init_prod__Comment__lit___47_47_iter_star__char_class___range__0_9_range__11_65535_char_class___range__10_10__tag__category___67_111_109_109_101_110_116() {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new CharStackNode(1222, 2, new char[][]{{10,10}}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new ListStackNode(1218, 1, regular__iter_star__char_class___range__0_9_range__11_65535, new CharStackNode(1220, 0, new char[][]{{0,9},{11,65535}}, null, null), false, null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(1216, 0, prod__lit___47_47__char_class___range__47_47_char_class___range__47_47_, new char[] {47,47}, null, null);
      tmp[0].setProduction(tmp);
      tmp[2].setParentProduction(Generator.prod__Comment__lit___47_47_iter_star__char_class___range__0_9_range__11_65535_char_class___range__10_10__tag__category___67_111_109_109_101_110_116);
      return tmp;
	}
  }
	
  private static class ForUpdate {
    public final static AbstractStackNode[] prod__StatementExpressionList1_ForUpdate__StatementExpressionList_ = _init_prod__StatementExpressionList1_ForUpdate__StatementExpressionList_();
    private static final AbstractStackNode[] _init_prod__StatementExpressionList1_ForUpdate__StatementExpressionList_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(1224, 0, "StatementExpressionList", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__StatementExpressionList1_ForUpdate__StatementExpressionList_);
      return tmp;
	}
  }
	
  private static class FieldAccess {
    public final static AbstractStackNode[] prod__Name11_FieldAccess__Name__tag__NotSupported___97_118_111_105_100 = _init_prod__Name11_FieldAccess__Name__tag__NotSupported___97_118_111_105_100();
    private static final AbstractStackNode[] _init_prod__Name11_FieldAccess__Name__tag__NotSupported___97_118_111_105_100() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(1228, 0, "Name", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__Name11_FieldAccess__Name__tag__NotSupported___97_118_111_105_100);
      return tmp;
	}
    public final static AbstractStackNode[] prod__super_FieldAccess__conditional__lit_super__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___46_layouts_LAYOUTLIST_conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122__tag__NotSupported___112_114_101_102_101_114 = _init_prod__super_FieldAccess__conditional__lit_super__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___46_layouts_LAYOUTLIST_conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122__tag__NotSupported___112_114_101_102_101_114();
    private static final AbstractStackNode[] _init_prod__super_FieldAccess__conditional__lit_super__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___46_layouts_LAYOUTLIST_conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122__tag__NotSupported___112_114_101_102_101_114() {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new NonTerminalStackNode(1238, 4, "Identifier", null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(1236, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new LiteralStackNode(1234, 2, prod__lit___46__char_class___range__46_46_, new char[] {46}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(1232, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(1230, 0, prod__lit_super__char_class___range__115_115_char_class___range__117_117_char_class___range__112_112_char_class___range__101_101_char_class___range__114_114_, new char[] {115,117,112,101,114}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[4].setParentProduction(Generator.prod__super_FieldAccess__conditional__lit_super__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___46_layouts_LAYOUTLIST_conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122__tag__NotSupported___112_114_101_102_101_114);
      return tmp;
	}
    public final static AbstractStackNode[] prod__Primary_Identifier_FieldAccess__Primary_layouts_LAYOUTLIST_lit___46_layouts_LAYOUTLIST_conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__Primary_Identifier_FieldAccess__Primary_layouts_LAYOUTLIST_lit___46_layouts_LAYOUTLIST_conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__Primary_Identifier_FieldAccess__Primary_layouts_LAYOUTLIST_lit___46_layouts_LAYOUTLIST_conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new NonTerminalStackNode(1248, 4, "Identifier", null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(1246, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new LiteralStackNode(1244, 2, prod__lit___46__char_class___range__46_46_, new char[] {46}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(1242, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new NonTerminalStackNode(1240, 0, "Primary", null, null);
      tmp[0].setProduction(tmp);
      tmp[4].setParentProduction(Generator.prod__Primary_Identifier_FieldAccess__Primary_layouts_LAYOUTLIST_lit___46_layouts_LAYOUTLIST_conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
  }
	
  private static class LabeledStatementNoShortIf {
    public final static AbstractStackNode[] prod__colon1_LabeledStatementNoShortIf__conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___58_layouts_LAYOUTLIST_StatementNoShortIf_ = _init_prod__colon1_LabeledStatementNoShortIf__conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___58_layouts_LAYOUTLIST_StatementNoShortIf_();
    private static final AbstractStackNode[] _init_prod__colon1_LabeledStatementNoShortIf__conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___58_layouts_LAYOUTLIST_StatementNoShortIf_() {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new NonTerminalStackNode(1258, 4, "StatementNoShortIf", null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(1256, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new LiteralStackNode(1254, 2, prod__lit___58__char_class___range__58_58_, new char[] {58}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(1252, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new NonTerminalStackNode(1250, 0, "Identifier", null, null);
      tmp[0].setProduction(tmp);
      tmp[4].setParentProduction(Generator.prod__colon1_LabeledStatementNoShortIf__conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___58_layouts_LAYOUTLIST_StatementNoShortIf_);
      return tmp;
	}
  }
	
  private static class CommentChar {
    public final static AbstractStackNode[] prod__CommentChar__char_class___range__0_41_range__43_65535_ = _init_prod__CommentChar__char_class___range__0_41_range__43_65535_();
    private static final AbstractStackNode[] _init_prod__CommentChar__char_class___range__0_41_range__43_65535_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new CharStackNode(1260, 0, new char[][]{{0,41},{43,65535}}, null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__CommentChar__char_class___range__0_41_range__43_65535_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__CommentChar__conditional__Asterisk__not_follow__char_class___range__47_47_ = _init_prod__CommentChar__conditional__Asterisk__not_follow__char_class___range__47_47_();
    private static final AbstractStackNode[] _init_prod__CommentChar__conditional__Asterisk__not_follow__char_class___range__47_47_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(1262, 0, "Asterisk", null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{47,47}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__CommentChar__conditional__Asterisk__not_follow__char_class___range__47_47_);
      return tmp;
	}
  }
	
  private static class MethodHeader {
    public final static AbstractStackNode[] prod__MethodHeader_MethodHeader__iter_star_seps__Modifier__layouts_LAYOUTLIST_layouts_LAYOUTLIST_MethodRes_layouts_LAYOUTLIST_MethodDeclarator_layouts_LAYOUTLIST_opt__Throws_ = _init_prod__MethodHeader_MethodHeader__iter_star_seps__Modifier__layouts_LAYOUTLIST_layouts_LAYOUTLIST_MethodRes_layouts_LAYOUTLIST_MethodDeclarator_layouts_LAYOUTLIST_opt__Throws_();
    private static final AbstractStackNode[] _init_prod__MethodHeader_MethodHeader__iter_star_seps__Modifier__layouts_LAYOUTLIST_layouts_LAYOUTLIST_MethodRes_layouts_LAYOUTLIST_MethodDeclarator_layouts_LAYOUTLIST_opt__Throws_() {
      AbstractStackNode[] tmp = new AbstractStackNode[7];
      
      tmp[6] = new OptionalStackNode(1284, 6, regular__opt__Throws, new NonTerminalStackNode(1286, 0, "Throws", null, null), null, null);
      tmp[6].setProduction(tmp);
      tmp[5] = new NonTerminalStackNode(1282, 5, "layouts_LAYOUTLIST", null, null);
      tmp[5].setProduction(tmp);
      tmp[4] = new NonTerminalStackNode(1280, 4, "MethodDeclarator", null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(1278, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new NonTerminalStackNode(1276, 2, "MethodRes", null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(1274, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new SeparatedListStackNode(1268, 0, regular__iter_star_seps__Modifier__layouts_LAYOUTLIST, new NonTerminalStackNode(1270, 0, "Modifier", null, null), new AbstractStackNode[]{new NonTerminalStackNode(1272, 1, "layouts_LAYOUTLIST", null, null)}, false, null, null);
      tmp[0].setProduction(tmp);
      tmp[6].setParentProduction(Generator.prod__MethodHeader_MethodHeader__iter_star_seps__Modifier__layouts_LAYOUTLIST_layouts_LAYOUTLIST_MethodRes_layouts_LAYOUTLIST_MethodDeclarator_layouts_LAYOUTLIST_opt__Throws_);
      return tmp;
	}
  }
	
  private static class Assignment {
    public final static AbstractStackNode[] prod__LeftHandSide_AssignmentOperator_Expression_Assignment__LeftHandSide_layouts_LAYOUTLIST_AssignmentOperator_layouts_LAYOUTLIST_Expression_ = _init_prod__LeftHandSide_AssignmentOperator_Expression_Assignment__LeftHandSide_layouts_LAYOUTLIST_AssignmentOperator_layouts_LAYOUTLIST_Expression_();
    private static final AbstractStackNode[] _init_prod__LeftHandSide_AssignmentOperator_Expression_Assignment__LeftHandSide_layouts_LAYOUTLIST_AssignmentOperator_layouts_LAYOUTLIST_Expression_() {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new NonTerminalStackNode(1298, 4, "Expression", null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(1296, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new NonTerminalStackNode(1294, 2, "AssignmentOperator", null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(1292, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new NonTerminalStackNode(1290, 0, "LeftHandSide", null, null);
      tmp[0].setProduction(tmp);
      tmp[4].setParentProduction(Generator.prod__LeftHandSide_AssignmentOperator_Expression_Assignment__LeftHandSide_layouts_LAYOUTLIST_AssignmentOperator_layouts_LAYOUTLIST_Expression_);
      return tmp;
	}
  }
	
  private static class ArrayInitializer {
    public final static AbstractStackNode[] prod__comma_comma_ArrayInitializer__lit___123_layouts_LAYOUTLIST_iter_star_seps__VariableInitializer__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_opt__lit___44_layouts_LAYOUTLIST_lit___125_ = _init_prod__comma_comma_ArrayInitializer__lit___123_layouts_LAYOUTLIST_iter_star_seps__VariableInitializer__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_opt__lit___44_layouts_LAYOUTLIST_lit___125_();
    private static final AbstractStackNode[] _init_prod__comma_comma_ArrayInitializer__lit___123_layouts_LAYOUTLIST_iter_star_seps__VariableInitializer__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_opt__lit___44_layouts_LAYOUTLIST_lit___125_() {
      AbstractStackNode[] tmp = new AbstractStackNode[7];
      
      tmp[6] = new LiteralStackNode(1344, 6, prod__lit___125__char_class___range__125_125_, new char[] {125}, null, null);
      tmp[6].setProduction(tmp);
      tmp[5] = new NonTerminalStackNode(1342, 5, "layouts_LAYOUTLIST", null, null);
      tmp[5].setProduction(tmp);
      tmp[4] = new OptionalStackNode(1338, 4, regular__opt__lit___44, new LiteralStackNode(1340, 0, prod__lit___44__char_class___range__44_44_, new char[] {44}, null, null), null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(1336, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new SeparatedListStackNode(1326, 2, regular__iter_star_seps__VariableInitializer__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST, new NonTerminalStackNode(1328, 0, "VariableInitializer", null, null), new AbstractStackNode[]{new NonTerminalStackNode(1330, 1, "layouts_LAYOUTLIST", null, null), new LiteralStackNode(1332, 2, prod__lit___44__char_class___range__44_44_, new char[] {44}, null, null), new NonTerminalStackNode(1334, 3, "layouts_LAYOUTLIST", null, null)}, false, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(1324, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(1322, 0, prod__lit___123__char_class___range__123_123_, new char[] {123}, null, null);
      tmp[0].setProduction(tmp);
      tmp[6].setParentProduction(Generator.prod__comma_comma_ArrayInitializer__lit___123_layouts_LAYOUTLIST_iter_star_seps__VariableInitializer__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_opt__lit___44_layouts_LAYOUTLIST_lit___125_);
      return tmp;
	}
  }
	
  private static class Modifier {
    public final static AbstractStackNode[] prod__public_Modifier__conditional__lit_public__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__public_Modifier__conditional__lit_public__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__public_Modifier__conditional__lit_public__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(1364, 0, prod__lit_public__char_class___range__112_112_char_class___range__117_117_char_class___range__98_98_char_class___range__108_108_char_class___range__105_105_char_class___range__99_99_, new char[] {112,117,98,108,105,99}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__public_Modifier__conditional__lit_public__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__static_Modifier__conditional__lit_static__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__static_Modifier__conditional__lit_static__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__static_Modifier__conditional__lit_static__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(1366, 0, prod__lit_static__char_class___range__115_115_char_class___range__116_116_char_class___range__97_97_char_class___range__116_116_char_class___range__105_105_char_class___range__99_99_, new char[] {115,116,97,116,105,99}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__static_Modifier__conditional__lit_static__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__final_Modifier__conditional__lit_final__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__final_Modifier__conditional__lit_final__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__final_Modifier__conditional__lit_final__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(1368, 0, prod__lit_final__char_class___range__102_102_char_class___range__105_105_char_class___range__110_110_char_class___range__97_97_char_class___range__108_108_, new char[] {102,105,110,97,108}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__final_Modifier__conditional__lit_final__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__transient_Modifier__conditional__lit_transient__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__transient_Modifier__conditional__lit_transient__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__transient_Modifier__conditional__lit_transient__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(1370, 0, prod__lit_transient__char_class___range__116_116_char_class___range__114_114_char_class___range__97_97_char_class___range__110_110_char_class___range__115_115_char_class___range__105_105_char_class___range__101_101_char_class___range__110_110_char_class___range__116_116_, new char[] {116,114,97,110,115,105,101,110,116}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__transient_Modifier__conditional__lit_transient__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__private_Modifier__conditional__lit_private__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__private_Modifier__conditional__lit_private__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__private_Modifier__conditional__lit_private__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(1372, 0, prod__lit_private__char_class___range__112_112_char_class___range__114_114_char_class___range__105_105_char_class___range__118_118_char_class___range__97_97_char_class___range__116_116_char_class___range__101_101_, new char[] {112,114,105,118,97,116,101}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__private_Modifier__conditional__lit_private__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__volatile_Modifier__conditional__lit_volatile__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__volatile_Modifier__conditional__lit_volatile__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__volatile_Modifier__conditional__lit_volatile__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(1374, 0, prod__lit_volatile__char_class___range__118_118_char_class___range__111_111_char_class___range__108_108_char_class___range__97_97_char_class___range__116_116_char_class___range__105_105_char_class___range__108_108_char_class___range__101_101_, new char[] {118,111,108,97,116,105,108,101}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__volatile_Modifier__conditional__lit_volatile__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__abstract_Modifier__conditional__lit_abstract__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__abstract_Modifier__conditional__lit_abstract__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__abstract_Modifier__conditional__lit_abstract__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(1376, 0, prod__lit_abstract__char_class___range__97_97_char_class___range__98_98_char_class___range__115_115_char_class___range__116_116_char_class___range__114_114_char_class___range__97_97_char_class___range__99_99_char_class___range__116_116_, new char[] {97,98,115,116,114,97,99,116}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__abstract_Modifier__conditional__lit_abstract__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__protected_Modifier__conditional__lit_protected__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__protected_Modifier__conditional__lit_protected__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__protected_Modifier__conditional__lit_protected__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(1378, 0, prod__lit_protected__char_class___range__112_112_char_class___range__114_114_char_class___range__111_111_char_class___range__116_116_char_class___range__101_101_char_class___range__99_99_char_class___range__116_116_char_class___range__101_101_char_class___range__100_100_, new char[] {112,114,111,116,101,99,116,101,100}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__protected_Modifier__conditional__lit_protected__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__synchronized1_Modifier__conditional__lit_synchronized__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__synchronized1_Modifier__conditional__lit_synchronized__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__synchronized1_Modifier__conditional__lit_synchronized__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(1380, 0, prod__lit_synchronized__char_class___range__115_115_char_class___range__121_121_char_class___range__110_110_char_class___range__99_99_char_class___range__104_104_char_class___range__114_114_char_class___range__111_111_char_class___range__110_110_char_class___range__105_105_char_class___range__122_122_char_class___range__101_101_char_class___range__100_100_, new char[] {115,121,110,99,104,114,111,110,105,122,101,100}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__synchronized1_Modifier__conditional__lit_synchronized__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__native_Modifier__conditional__lit_native__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__native_Modifier__conditional__lit_native__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__native_Modifier__conditional__lit_native__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(1382, 0, prod__lit_native__char_class___range__110_110_char_class___range__97_97_char_class___range__116_116_char_class___range__105_105_char_class___range__118_118_char_class___range__101_101_, new char[] {110,97,116,105,118,101}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__native_Modifier__conditional__lit_native__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
  }
	
  private static class SingleTypeImportDeclaration {
    public final static AbstractStackNode[] prod__import_semicolon_SingleTypeImportDeclaration__conditional__lit_import__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Name_layouts_LAYOUTLIST_lit___59_ = _init_prod__import_semicolon_SingleTypeImportDeclaration__conditional__lit_import__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Name_layouts_LAYOUTLIST_lit___59_();
    private static final AbstractStackNode[] _init_prod__import_semicolon_SingleTypeImportDeclaration__conditional__lit_import__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Name_layouts_LAYOUTLIST_lit___59_() {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new LiteralStackNode(1398, 4, prod__lit___59__char_class___range__59_59_, new char[] {59}, null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(1396, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new NonTerminalStackNode(1394, 2, "Name", null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(1392, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(1390, 0, prod__lit_import__char_class___range__105_105_char_class___range__109_109_char_class___range__112_112_char_class___range__111_111_char_class___range__114_114_char_class___range__116_116_, new char[] {105,109,112,111,114,116}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[4].setParentProduction(Generator.prod__import_semicolon_SingleTypeImportDeclaration__conditional__lit_import__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Name_layouts_LAYOUTLIST_lit___59_);
      return tmp;
	}
  }
	
  private static class ArrayCreationExpression {
    public final static AbstractStackNode[] prod__new2_ArrayCreationExpression__conditional__lit_new__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_PrimitiveType_layouts_LAYOUTLIST_iter_seps__DimExprInitialized__layouts_LAYOUTLIST_layouts_LAYOUTLIST_ArrayInitializer_ = _init_prod__new2_ArrayCreationExpression__conditional__lit_new__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_PrimitiveType_layouts_LAYOUTLIST_iter_seps__DimExprInitialized__layouts_LAYOUTLIST_layouts_LAYOUTLIST_ArrayInitializer_();
    private static final AbstractStackNode[] _init_prod__new2_ArrayCreationExpression__conditional__lit_new__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_PrimitiveType_layouts_LAYOUTLIST_iter_seps__DimExprInitialized__layouts_LAYOUTLIST_layouts_LAYOUTLIST_ArrayInitializer_() {
      AbstractStackNode[] tmp = new AbstractStackNode[7];
      
      tmp[6] = new NonTerminalStackNode(1416, 6, "ArrayInitializer", null, null);
      tmp[6].setProduction(tmp);
      tmp[5] = new NonTerminalStackNode(1414, 5, "layouts_LAYOUTLIST", null, null);
      tmp[5].setProduction(tmp);
      tmp[4] = new SeparatedListStackNode(1408, 4, regular__iter_seps__DimExprInitialized__layouts_LAYOUTLIST, new NonTerminalStackNode(1410, 0, "DimExprInitialized", null, null), new AbstractStackNode[]{new NonTerminalStackNode(1412, 1, "layouts_LAYOUTLIST", null, null)}, true, null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(1406, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new NonTerminalStackNode(1404, 2, "PrimitiveType", null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(1402, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(1400, 0, prod__lit_new__char_class___range__110_110_char_class___range__101_101_char_class___range__119_119_, new char[] {110,101,119}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[6].setParentProduction(Generator.prod__new2_ArrayCreationExpression__conditional__lit_new__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_PrimitiveType_layouts_LAYOUTLIST_iter_seps__DimExprInitialized__layouts_LAYOUTLIST_layouts_LAYOUTLIST_ArrayInitializer_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__new_ArrayCreationExpression__conditional__lit_new__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_PrimitiveType_layouts_LAYOUTLIST_iter_seps__DimExpr__layouts_LAYOUTLIST_layouts_LAYOUTLIST_iter_star_seps__Dim__layouts_LAYOUTLIST_ = _init_prod__new_ArrayCreationExpression__conditional__lit_new__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_PrimitiveType_layouts_LAYOUTLIST_iter_seps__DimExpr__layouts_LAYOUTLIST_layouts_LAYOUTLIST_iter_star_seps__Dim__layouts_LAYOUTLIST_();
    private static final AbstractStackNode[] _init_prod__new_ArrayCreationExpression__conditional__lit_new__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_PrimitiveType_layouts_LAYOUTLIST_iter_seps__DimExpr__layouts_LAYOUTLIST_layouts_LAYOUTLIST_iter_star_seps__Dim__layouts_LAYOUTLIST_() {
      AbstractStackNode[] tmp = new AbstractStackNode[7];
      
      tmp[6] = new SeparatedListStackNode(1434, 6, regular__iter_star_seps__Dim__layouts_LAYOUTLIST, new NonTerminalStackNode(1436, 0, "Dim", null, null), new AbstractStackNode[]{new NonTerminalStackNode(1438, 1, "layouts_LAYOUTLIST", null, null)}, false, null, null);
      tmp[6].setProduction(tmp);
      tmp[5] = new NonTerminalStackNode(1432, 5, "layouts_LAYOUTLIST", null, null);
      tmp[5].setProduction(tmp);
      tmp[4] = new SeparatedListStackNode(1426, 4, regular__iter_seps__DimExpr__layouts_LAYOUTLIST, new NonTerminalStackNode(1428, 0, "DimExpr", null, null), new AbstractStackNode[]{new NonTerminalStackNode(1430, 1, "layouts_LAYOUTLIST", null, null)}, true, null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(1424, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new NonTerminalStackNode(1422, 2, "PrimitiveType", null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(1420, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(1418, 0, prod__lit_new__char_class___range__110_110_char_class___range__101_101_char_class___range__119_119_, new char[] {110,101,119}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[6].setParentProduction(Generator.prod__new_ArrayCreationExpression__conditional__lit_new__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_PrimitiveType_layouts_LAYOUTLIST_iter_seps__DimExpr__layouts_LAYOUTLIST_layouts_LAYOUTLIST_iter_star_seps__Dim__layouts_LAYOUTLIST_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__new1_ArrayCreationExpression__conditional__lit_new__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_ClassOrInterfaceType_layouts_LAYOUTLIST_iter_seps__DimExpr__layouts_LAYOUTLIST_layouts_LAYOUTLIST_iter_star_seps__Dim__layouts_LAYOUTLIST_ = _init_prod__new1_ArrayCreationExpression__conditional__lit_new__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_ClassOrInterfaceType_layouts_LAYOUTLIST_iter_seps__DimExpr__layouts_LAYOUTLIST_layouts_LAYOUTLIST_iter_star_seps__Dim__layouts_LAYOUTLIST_();
    private static final AbstractStackNode[] _init_prod__new1_ArrayCreationExpression__conditional__lit_new__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_ClassOrInterfaceType_layouts_LAYOUTLIST_iter_seps__DimExpr__layouts_LAYOUTLIST_layouts_LAYOUTLIST_iter_star_seps__Dim__layouts_LAYOUTLIST_() {
      AbstractStackNode[] tmp = new AbstractStackNode[7];
      
      tmp[6] = new SeparatedListStackNode(1456, 6, regular__iter_star_seps__Dim__layouts_LAYOUTLIST, new NonTerminalStackNode(1458, 0, "Dim", null, null), new AbstractStackNode[]{new NonTerminalStackNode(1460, 1, "layouts_LAYOUTLIST", null, null)}, false, null, null);
      tmp[6].setProduction(tmp);
      tmp[5] = new NonTerminalStackNode(1454, 5, "layouts_LAYOUTLIST", null, null);
      tmp[5].setProduction(tmp);
      tmp[4] = new SeparatedListStackNode(1448, 4, regular__iter_seps__DimExpr__layouts_LAYOUTLIST, new NonTerminalStackNode(1450, 0, "DimExpr", null, null), new AbstractStackNode[]{new NonTerminalStackNode(1452, 1, "layouts_LAYOUTLIST", null, null)}, true, null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(1446, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new NonTerminalStackNode(1444, 2, "ClassOrInterfaceType", null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(1442, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(1440, 0, prod__lit_new__char_class___range__110_110_char_class___range__101_101_char_class___range__119_119_, new char[] {110,101,119}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[6].setParentProduction(Generator.prod__new1_ArrayCreationExpression__conditional__lit_new__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_ClassOrInterfaceType_layouts_LAYOUTLIST_iter_seps__DimExpr__layouts_LAYOUTLIST_layouts_LAYOUTLIST_iter_star_seps__Dim__layouts_LAYOUTLIST_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__new3_ArrayCreationExpression__conditional__lit_new__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_ClassOrInterfaceType_layouts_LAYOUTLIST_iter_seps__DimExprInitialized__layouts_LAYOUTLIST_layouts_LAYOUTLIST_ArrayInitializer_ = _init_prod__new3_ArrayCreationExpression__conditional__lit_new__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_ClassOrInterfaceType_layouts_LAYOUTLIST_iter_seps__DimExprInitialized__layouts_LAYOUTLIST_layouts_LAYOUTLIST_ArrayInitializer_();
    private static final AbstractStackNode[] _init_prod__new3_ArrayCreationExpression__conditional__lit_new__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_ClassOrInterfaceType_layouts_LAYOUTLIST_iter_seps__DimExprInitialized__layouts_LAYOUTLIST_layouts_LAYOUTLIST_ArrayInitializer_() {
      AbstractStackNode[] tmp = new AbstractStackNode[7];
      
      tmp[6] = new NonTerminalStackNode(1478, 6, "ArrayInitializer", null, null);
      tmp[6].setProduction(tmp);
      tmp[5] = new NonTerminalStackNode(1476, 5, "layouts_LAYOUTLIST", null, null);
      tmp[5].setProduction(tmp);
      tmp[4] = new SeparatedListStackNode(1470, 4, regular__iter_seps__DimExprInitialized__layouts_LAYOUTLIST, new NonTerminalStackNode(1472, 0, "DimExprInitialized", null, null), new AbstractStackNode[]{new NonTerminalStackNode(1474, 1, "layouts_LAYOUTLIST", null, null)}, true, null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(1468, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new NonTerminalStackNode(1466, 2, "ClassOrInterfaceType", null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(1464, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(1462, 0, prod__lit_new__char_class___range__110_110_char_class___range__101_101_char_class___range__119_119_, new char[] {110,101,119}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[6].setParentProduction(Generator.prod__new3_ArrayCreationExpression__conditional__lit_new__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_ClassOrInterfaceType_layouts_LAYOUTLIST_iter_seps__DimExprInitialized__layouts_LAYOUTLIST_layouts_LAYOUTLIST_ArrayInitializer_);
      return tmp;
	}
  }
	
  private static class PrimaryNoNewArray {
    public final static AbstractStackNode[] prod__ArrayAccess_PrimaryNoNewArray__ArrayAccess_ = _init_prod__ArrayAccess_PrimaryNoNewArray__ArrayAccess_();
    private static final AbstractStackNode[] _init_prod__ArrayAccess_PrimaryNoNewArray__ArrayAccess_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(1510, 0, "ArrayAccess", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__ArrayAccess_PrimaryNoNewArray__ArrayAccess_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__FieldAccess_PrimaryNoNewArray__FieldAccess_ = _init_prod__FieldAccess_PrimaryNoNewArray__FieldAccess_();
    private static final AbstractStackNode[] _init_prod__FieldAccess_PrimaryNoNewArray__FieldAccess_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(1512, 0, "FieldAccess", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__FieldAccess_PrimaryNoNewArray__FieldAccess_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__Expression1_PrimaryNoNewArray__lit___40_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___41_ = _init_prod__Expression1_PrimaryNoNewArray__lit___40_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___41_();
    private static final AbstractStackNode[] _init_prod__Expression1_PrimaryNoNewArray__lit___40_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___41_() {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new LiteralStackNode(1522, 4, prod__lit___41__char_class___range__41_41_, new char[] {41}, null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(1520, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new NonTerminalStackNode(1518, 2, "Expression", null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(1516, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(1514, 0, prod__lit___40__char_class___range__40_40_, new char[] {40}, null, null);
      tmp[0].setProduction(tmp);
      tmp[4].setParentProduction(Generator.prod__Expression1_PrimaryNoNewArray__lit___40_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___41_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__Literal_PrimaryNoNewArray__Literal__tag__NotSupported___97_118_111_105_100 = _init_prod__Literal_PrimaryNoNewArray__Literal__tag__NotSupported___97_118_111_105_100();
    private static final AbstractStackNode[] _init_prod__Literal_PrimaryNoNewArray__Literal__tag__NotSupported___97_118_111_105_100() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(1524, 0, "Literal", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__Literal_PrimaryNoNewArray__Literal__tag__NotSupported___97_118_111_105_100);
      return tmp;
	}
    public final static AbstractStackNode[] prod__this1_PrimaryNoNewArray__Name_layouts_LAYOUTLIST_lit___46_layouts_LAYOUTLIST_conditional__lit_this__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__this1_PrimaryNoNewArray__Name_layouts_LAYOUTLIST_lit___46_layouts_LAYOUTLIST_conditional__lit_this__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__this1_PrimaryNoNewArray__Name_layouts_LAYOUTLIST_lit___46_layouts_LAYOUTLIST_conditional__lit_this__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new LiteralStackNode(1534, 4, prod__lit_this__char_class___range__116_116_char_class___range__104_104_char_class___range__105_105_char_class___range__115_115_, new char[] {116,104,105,115}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(1532, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new LiteralStackNode(1530, 2, prod__lit___46__char_class___range__46_46_, new char[] {46}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(1528, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new NonTerminalStackNode(1526, 0, "Name", null, null);
      tmp[0].setProduction(tmp);
      tmp[4].setParentProduction(Generator.prod__this1_PrimaryNoNewArray__Name_layouts_LAYOUTLIST_lit___46_layouts_LAYOUTLIST_conditional__lit_this__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__MethodInvocation1_PrimaryNoNewArray__MethodInvocation_ = _init_prod__MethodInvocation1_PrimaryNoNewArray__MethodInvocation_();
    private static final AbstractStackNode[] _init_prod__MethodInvocation1_PrimaryNoNewArray__MethodInvocation_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(1536, 0, "MethodInvocation", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__MethodInvocation1_PrimaryNoNewArray__MethodInvocation_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__ClassInstanceCreationExpression1_PrimaryNoNewArray__ClassInstanceCreationExpression_ = _init_prod__ClassInstanceCreationExpression1_PrimaryNoNewArray__ClassInstanceCreationExpression_();
    private static final AbstractStackNode[] _init_prod__ClassInstanceCreationExpression1_PrimaryNoNewArray__ClassInstanceCreationExpression_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(1538, 0, "ClassInstanceCreationExpression", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__ClassInstanceCreationExpression1_PrimaryNoNewArray__ClassInstanceCreationExpression_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__this0_PrimaryNoNewArray__conditional__lit_this__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__this0_PrimaryNoNewArray__conditional__lit_this__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__this0_PrimaryNoNewArray__conditional__lit_this__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(1540, 0, prod__lit_this__char_class___range__116_116_char_class___range__104_104_char_class___range__105_105_char_class___range__115_115_, new char[] {116,104,105,115}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__this0_PrimaryNoNewArray__conditional__lit_this__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
  }
	
  private static class ArrayAccess {
    public final static AbstractStackNode[] prod__Name_Expression_ArrayAccess__Name_layouts_LAYOUTLIST_lit___91_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___93_ = _init_prod__Name_Expression_ArrayAccess__Name_layouts_LAYOUTLIST_lit___91_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___93_();
    private static final AbstractStackNode[] _init_prod__Name_Expression_ArrayAccess__Name_layouts_LAYOUTLIST_lit___91_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___93_() {
      AbstractStackNode[] tmp = new AbstractStackNode[7];
      
      tmp[6] = new LiteralStackNode(1562, 6, prod__lit___93__char_class___range__93_93_, new char[] {93}, null, null);
      tmp[6].setProduction(tmp);
      tmp[5] = new NonTerminalStackNode(1560, 5, "layouts_LAYOUTLIST", null, null);
      tmp[5].setProduction(tmp);
      tmp[4] = new NonTerminalStackNode(1558, 4, "Expression", null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(1556, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new LiteralStackNode(1554, 2, prod__lit___91__char_class___range__91_91_, new char[] {91}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(1552, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new NonTerminalStackNode(1550, 0, "Name", null, null);
      tmp[0].setProduction(tmp);
      tmp[6].setParentProduction(Generator.prod__Name_Expression_ArrayAccess__Name_layouts_LAYOUTLIST_lit___91_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___93_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__PrimaryNoNewArray_Expression_ArrayAccess__PrimaryNoNewArray_layouts_LAYOUTLIST_lit___91_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___93__tag__NotSupported___112_114_101_102_101_114 = _init_prod__PrimaryNoNewArray_Expression_ArrayAccess__PrimaryNoNewArray_layouts_LAYOUTLIST_lit___91_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___93__tag__NotSupported___112_114_101_102_101_114();
    private static final AbstractStackNode[] _init_prod__PrimaryNoNewArray_Expression_ArrayAccess__PrimaryNoNewArray_layouts_LAYOUTLIST_lit___91_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___93__tag__NotSupported___112_114_101_102_101_114() {
      AbstractStackNode[] tmp = new AbstractStackNode[7];
      
      tmp[6] = new LiteralStackNode(1576, 6, prod__lit___93__char_class___range__93_93_, new char[] {93}, null, null);
      tmp[6].setProduction(tmp);
      tmp[5] = new NonTerminalStackNode(1574, 5, "layouts_LAYOUTLIST", null, null);
      tmp[5].setProduction(tmp);
      tmp[4] = new NonTerminalStackNode(1572, 4, "Expression", null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(1570, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new LiteralStackNode(1568, 2, prod__lit___91__char_class___range__91_91_, new char[] {91}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(1566, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new NonTerminalStackNode(1564, 0, "PrimaryNoNewArray", null, null);
      tmp[0].setProduction(tmp);
      tmp[6].setParentProduction(Generator.prod__PrimaryNoNewArray_Expression_ArrayAccess__PrimaryNoNewArray_layouts_LAYOUTLIST_lit___91_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___93__tag__NotSupported___112_114_101_102_101_114);
      return tmp;
	}
  }
	
  private static class SwitchLabel {
    public final static AbstractStackNode[] prod__case_colon_SwitchLabel__conditional__lit_case__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___58_ = _init_prod__case_colon_SwitchLabel__conditional__lit_case__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___58_();
    private static final AbstractStackNode[] _init_prod__case_colon_SwitchLabel__conditional__lit_case__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___58_() {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new LiteralStackNode(1604, 4, prod__lit___58__char_class___range__58_58_, new char[] {58}, null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(1602, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new NonTerminalStackNode(1600, 2, "Expression", null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(1598, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(1596, 0, prod__lit_case__char_class___range__99_99_char_class___range__97_97_char_class___range__115_115_char_class___range__101_101_, new char[] {99,97,115,101}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[4].setParentProduction(Generator.prod__case_colon_SwitchLabel__conditional__lit_case__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___58_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__default_colon_SwitchLabel__conditional__lit_default__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___58_ = _init_prod__default_colon_SwitchLabel__conditional__lit_default__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___58_();
    private static final AbstractStackNode[] _init_prod__default_colon_SwitchLabel__conditional__lit_default__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___58_() {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new LiteralStackNode(1610, 2, prod__lit___58__char_class___range__58_58_, new char[] {58}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(1608, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(1606, 0, prod__lit_default__char_class___range__100_100_char_class___range__101_101_char_class___range__102_102_char_class___range__97_97_char_class___range__117_117_char_class___range__108_108_char_class___range__116_116_, new char[] {100,101,102,97,117,108,116}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[2].setParentProduction(Generator.prod__default_colon_SwitchLabel__conditional__lit_default__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___58_);
      return tmp;
	}
  }
	
  private static class ClassBodyDeclaration {
    public final static AbstractStackNode[] prod__ClassMemberDeclaration_ClassBodyDeclaration__ClassMemberDeclaration_ = _init_prod__ClassMemberDeclaration_ClassBodyDeclaration__ClassMemberDeclaration_();
    private static final AbstractStackNode[] _init_prod__ClassMemberDeclaration_ClassBodyDeclaration__ClassMemberDeclaration_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(1612, 0, "ClassMemberDeclaration", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__ClassMemberDeclaration_ClassBodyDeclaration__ClassMemberDeclaration_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__ConstructorDeclaration_ClassBodyDeclaration__ConstructorDeclaration_ = _init_prod__ConstructorDeclaration_ClassBodyDeclaration__ConstructorDeclaration_();
    private static final AbstractStackNode[] _init_prod__ConstructorDeclaration_ClassBodyDeclaration__ConstructorDeclaration_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(1614, 0, "ConstructorDeclaration", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__ConstructorDeclaration_ClassBodyDeclaration__ConstructorDeclaration_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__StaticInitializer_ClassBodyDeclaration__StaticInitializer_ = _init_prod__StaticInitializer_ClassBodyDeclaration__StaticInitializer_();
    private static final AbstractStackNode[] _init_prod__StaticInitializer_ClassBodyDeclaration__StaticInitializer_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(1616, 0, "StaticInitializer", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__StaticInitializer_ClassBodyDeclaration__StaticInitializer_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__ClassDeclaration2_ClassBodyDeclaration__InterfaceDeclaration_ = _init_prod__ClassDeclaration2_ClassBodyDeclaration__InterfaceDeclaration_();
    private static final AbstractStackNode[] _init_prod__ClassDeclaration2_ClassBodyDeclaration__InterfaceDeclaration_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(1618, 0, "InterfaceDeclaration", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__ClassDeclaration2_ClassBodyDeclaration__InterfaceDeclaration_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__ClassDeclaration1_ClassBodyDeclaration__ClassDeclaration_ = _init_prod__ClassDeclaration1_ClassBodyDeclaration__ClassDeclaration_();
    private static final AbstractStackNode[] _init_prod__ClassDeclaration1_ClassBodyDeclaration__ClassDeclaration_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(1620, 0, "ClassDeclaration", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__ClassDeclaration1_ClassBodyDeclaration__ClassDeclaration_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__semicolon11_ClassBodyDeclaration__lit___59_ = _init_prod__semicolon11_ClassBodyDeclaration__lit___59_();
    private static final AbstractStackNode[] _init_prod__semicolon11_ClassBodyDeclaration__lit___59_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(1622, 0, prod__lit___59__char_class___range__59_59_, new char[] {59}, null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__semicolon11_ClassBodyDeclaration__lit___59_);
      return tmp;
	}
  }
	
  private static class ClassMemberDeclaration {
    public final static AbstractStackNode[] prod__FieldDeclaration1_ClassMemberDeclaration__FieldDeclaration_ = _init_prod__FieldDeclaration1_ClassMemberDeclaration__FieldDeclaration_();
    private static final AbstractStackNode[] _init_prod__FieldDeclaration1_ClassMemberDeclaration__FieldDeclaration_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(1630, 0, "FieldDeclaration", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__FieldDeclaration1_ClassMemberDeclaration__FieldDeclaration_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__MethodDeclaration_ClassMemberDeclaration__MethodDeclaration_ = _init_prod__MethodDeclaration_ClassMemberDeclaration__MethodDeclaration_();
    private static final AbstractStackNode[] _init_prod__MethodDeclaration_ClassMemberDeclaration__MethodDeclaration_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(1632, 0, "MethodDeclaration", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__MethodDeclaration_ClassMemberDeclaration__MethodDeclaration_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__BlockClassMember_ClassMemberDeclaration__Block_ = _init_prod__BlockClassMember_ClassMemberDeclaration__Block_();
    private static final AbstractStackNode[] _init_prod__BlockClassMember_ClassMemberDeclaration__Block_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(1634, 0, "Block", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__BlockClassMember_ClassMemberDeclaration__Block_);
      return tmp;
	}
  }
	
  private static class DimExprInitialized {
    public final static AbstractStackNode[] prod__Expression_opt_DimExprInitialized__lit___91_layouts_LAYOUTLIST_opt__Expression_layouts_LAYOUTLIST_lit___93_ = _init_prod__Expression_opt_DimExprInitialized__lit___91_layouts_LAYOUTLIST_opt__Expression_layouts_LAYOUTLIST_lit___93_();
    private static final AbstractStackNode[] _init_prod__Expression_opt_DimExprInitialized__lit___91_layouts_LAYOUTLIST_opt__Expression_layouts_LAYOUTLIST_lit___93_() {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new LiteralStackNode(1646, 4, prod__lit___93__char_class___range__93_93_, new char[] {93}, null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(1644, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new OptionalStackNode(1640, 2, regular__opt__Expression, new NonTerminalStackNode(1642, 0, "Expression", null, null), null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(1638, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(1636, 0, prod__lit___91__char_class___range__91_91_, new char[] {91}, null, null);
      tmp[0].setProduction(tmp);
      tmp[4].setParentProduction(Generator.prod__Expression_opt_DimExprInitialized__lit___91_layouts_LAYOUTLIST_opt__Expression_layouts_LAYOUTLIST_lit___93_);
      return tmp;
	}
  }
	
  private static class TryStatement {
    public final static AbstractStackNode[] prod__try1_TryStatement__conditional__lit_try__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Block_layouts_LAYOUTLIST_iter_star_seps__CatchClause__layouts_LAYOUTLIST_layouts_LAYOUTLIST_Finally_ = _init_prod__try1_TryStatement__conditional__lit_try__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Block_layouts_LAYOUTLIST_iter_star_seps__CatchClause__layouts_LAYOUTLIST_layouts_LAYOUTLIST_Finally_();
    private static final AbstractStackNode[] _init_prod__try1_TryStatement__conditional__lit_try__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Block_layouts_LAYOUTLIST_iter_star_seps__CatchClause__layouts_LAYOUTLIST_layouts_LAYOUTLIST_Finally_() {
      AbstractStackNode[] tmp = new AbstractStackNode[7];
      
      tmp[6] = new NonTerminalStackNode(1668, 6, "Finally", null, null);
      tmp[6].setProduction(tmp);
      tmp[5] = new NonTerminalStackNode(1666, 5, "layouts_LAYOUTLIST", null, null);
      tmp[5].setProduction(tmp);
      tmp[4] = new SeparatedListStackNode(1660, 4, regular__iter_star_seps__CatchClause__layouts_LAYOUTLIST, new NonTerminalStackNode(1662, 0, "CatchClause", null, null), new AbstractStackNode[]{new NonTerminalStackNode(1664, 1, "layouts_LAYOUTLIST", null, null)}, false, null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(1658, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new NonTerminalStackNode(1656, 2, "Block", null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(1654, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(1652, 0, prod__lit_try__char_class___range__116_116_char_class___range__114_114_char_class___range__121_121_, new char[] {116,114,121}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[6].setParentProduction(Generator.prod__try1_TryStatement__conditional__lit_try__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Block_layouts_LAYOUTLIST_iter_star_seps__CatchClause__layouts_LAYOUTLIST_layouts_LAYOUTLIST_Finally_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__try_TryStatement__conditional__lit_try__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Block_layouts_LAYOUTLIST_iter_seps__CatchClause__layouts_LAYOUTLIST_ = _init_prod__try_TryStatement__conditional__lit_try__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Block_layouts_LAYOUTLIST_iter_seps__CatchClause__layouts_LAYOUTLIST_();
    private static final AbstractStackNode[] _init_prod__try_TryStatement__conditional__lit_try__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Block_layouts_LAYOUTLIST_iter_seps__CatchClause__layouts_LAYOUTLIST_() {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new SeparatedListStackNode(1678, 4, regular__iter_seps__CatchClause__layouts_LAYOUTLIST, new NonTerminalStackNode(1680, 0, "CatchClause", null, null), new AbstractStackNode[]{new NonTerminalStackNode(1682, 1, "layouts_LAYOUTLIST", null, null)}, true, null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(1676, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new NonTerminalStackNode(1674, 2, "Block", null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(1672, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(1670, 0, prod__lit_try__char_class___range__116_116_char_class___range__114_114_char_class___range__121_121_, new char[] {116,114,121}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[4].setParentProduction(Generator.prod__try_TryStatement__conditional__lit_try__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Block_layouts_LAYOUTLIST_iter_seps__CatchClause__layouts_LAYOUTLIST_);
      return tmp;
	}
  }
	
  private static class MethodDeclarator {
    public final static AbstractStackNode[] prod__MethodDeclarator_MethodDeclarator__MethodDeclarator_layouts_LAYOUTLIST_lit___91_layouts_LAYOUTLIST_lit___93_ = _init_prod__MethodDeclarator_MethodDeclarator__MethodDeclarator_layouts_LAYOUTLIST_lit___91_layouts_LAYOUTLIST_lit___93_();
    private static final AbstractStackNode[] _init_prod__MethodDeclarator_MethodDeclarator__MethodDeclarator_layouts_LAYOUTLIST_lit___91_layouts_LAYOUTLIST_lit___93_() {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new LiteralStackNode(1692, 4, prod__lit___93__char_class___range__93_93_, new char[] {93}, null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(1690, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new LiteralStackNode(1688, 2, prod__lit___91__char_class___range__91_91_, new char[] {91}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(1686, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new NonTerminalStackNode(1684, 0, "MethodDeclarator", null, null);
      tmp[0].setProduction(tmp);
      tmp[4].setParentProduction(Generator.prod__MethodDeclarator_MethodDeclarator__MethodDeclarator_layouts_LAYOUTLIST_lit___91_layouts_LAYOUTLIST_lit___93_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__comma2_MethodDeclarator__conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_iter_star_seps__FormalParameter__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41_ = _init_prod__comma2_MethodDeclarator__conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_iter_star_seps__FormalParameter__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41_();
    private static final AbstractStackNode[] _init_prod__comma2_MethodDeclarator__conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_iter_star_seps__FormalParameter__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41_() {
      AbstractStackNode[] tmp = new AbstractStackNode[7];
      
      tmp[6] = new LiteralStackNode(1714, 6, prod__lit___41__char_class___range__41_41_, new char[] {41}, null, null);
      tmp[6].setProduction(tmp);
      tmp[5] = new NonTerminalStackNode(1712, 5, "layouts_LAYOUTLIST", null, null);
      tmp[5].setProduction(tmp);
      tmp[4] = new SeparatedListStackNode(1702, 4, regular__iter_star_seps__FormalParameter__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST, new NonTerminalStackNode(1704, 0, "FormalParameter", null, null), new AbstractStackNode[]{new NonTerminalStackNode(1706, 1, "layouts_LAYOUTLIST", null, null), new LiteralStackNode(1708, 2, prod__lit___44__char_class___range__44_44_, new char[] {44}, null, null), new NonTerminalStackNode(1710, 3, "layouts_LAYOUTLIST", null, null)}, false, null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(1700, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new LiteralStackNode(1698, 2, prod__lit___40__char_class___range__40_40_, new char[] {40}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(1696, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new NonTerminalStackNode(1694, 0, "Identifier", null, null);
      tmp[0].setProduction(tmp);
      tmp[6].setParentProduction(Generator.prod__comma2_MethodDeclarator__conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_iter_star_seps__FormalParameter__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41_);
      return tmp;
	}
  }
	
  private static class LocalVariableDeclaration {
    public final static AbstractStackNode[] prod__comma_LocalVariableDeclaration__Type_layouts_LAYOUTLIST_iter_seps__VariableDeclarator__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_ = _init_prod__comma_LocalVariableDeclaration__Type_layouts_LAYOUTLIST_iter_seps__VariableDeclarator__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_();
    private static final AbstractStackNode[] _init_prod__comma_LocalVariableDeclaration__Type_layouts_LAYOUTLIST_iter_seps__VariableDeclarator__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_() {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new SeparatedListStackNode(1720, 2, regular__iter_seps__VariableDeclarator__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST, new NonTerminalStackNode(1722, 0, "VariableDeclarator", null, null), new AbstractStackNode[]{new NonTerminalStackNode(1724, 1, "layouts_LAYOUTLIST", null, null), new LiteralStackNode(1726, 2, prod__lit___44__char_class___range__44_44_, new char[] {44}, null, null), new NonTerminalStackNode(1728, 3, "layouts_LAYOUTLIST", null, null)}, true, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(1718, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new NonTerminalStackNode(1716, 0, "Type", null, null);
      tmp[0].setProduction(tmp);
      tmp[2].setParentProduction(Generator.prod__comma_LocalVariableDeclaration__Type_layouts_LAYOUTLIST_iter_seps__VariableDeclarator__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_);
      return tmp;
	}
  }
	
  private static class Identifier {
    public final static AbstractStackNode[] prod__Identifier__conditional__lit___60_115_116_97_116_105_99_45_105_110_105_116_62__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__Identifier__conditional__lit___60_115_116_97_116_105_99_45_105_110_105_116_62__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__Identifier__conditional__lit___60_115_116_97_116_105_99_45_105_110_105_116_62__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(1744, 0, prod__lit___60_115_116_97_116_105_99_45_105_110_105_116_62__char_class___range__60_60_char_class___range__115_115_char_class___range__116_116_char_class___range__97_97_char_class___range__116_116_char_class___range__105_105_char_class___range__99_99_char_class___range__45_45_char_class___range__105_105_char_class___range__110_110_char_class___range__105_105_char_class___range__116_116_char_class___range__62_62_, new char[] {60,115,116,97,116,105,99,45,105,110,105,116,62}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__Identifier__conditional__lit___60_115_116_97_116_105_99_45_105_110_105_116_62__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__Identifier__conditional__lit___60_100_101_102_97_117_108_116_45_112_97_99_107_97_103_101_62__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__Identifier__conditional__lit___60_100_101_102_97_117_108_116_45_112_97_99_107_97_103_101_62__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__Identifier__conditional__lit___60_100_101_102_97_117_108_116_45_112_97_99_107_97_103_101_62__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(1746, 0, prod__lit___60_100_101_102_97_117_108_116_45_112_97_99_107_97_103_101_62__char_class___range__60_60_char_class___range__100_100_char_class___range__101_101_char_class___range__102_102_char_class___range__97_97_char_class___range__117_117_char_class___range__108_108_char_class___range__116_116_char_class___range__45_45_char_class___range__112_112_char_class___range__97_97_char_class___range__99_99_char_class___range__107_107_char_class___range__97_97_char_class___range__103_103_char_class___range__101_101_char_class___range__62_62_, new char[] {60,100,101,102,97,117,108,116,45,112,97,99,107,97,103,101,62}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__Identifier__conditional__lit___60_100_101_102_97_117_108_116_45_112_97_99_107_97_103_101_62__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__Identifier__conditional__lit___60_105_110_105_116_62__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__Identifier__conditional__lit___60_105_110_105_116_62__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__Identifier__conditional__lit___60_105_110_105_116_62__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(1748, 0, prod__lit___60_105_110_105_116_62__char_class___range__60_60_char_class___range__105_105_char_class___range__110_110_char_class___range__105_105_char_class___range__116_116_char_class___range__62_62_, new char[] {60,105,110,105,116,62}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__Identifier__conditional__lit___60_105_110_105_116_62__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__Identifier__char_class___range__36_36_range__65_90_range__95_95_range__97_122_conditional__iter_star__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__Identifier__char_class___range__36_36_range__65_90_range__95_95_range__97_122_conditional__iter_star__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__Identifier__char_class___range__36_36_range__65_90_range__95_95_range__97_122_conditional__iter_star__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[2];
      
      tmp[1] = new ListStackNode(1752, 1, regular__iter_star__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122, new CharStackNode(1754, 0, new char[][]{{36,36},{48,57},{65,90},{95,95},{97,122}}, null, null), false, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[1].setProduction(tmp);
      tmp[0] = new CharStackNode(1750, 0, new char[][]{{36,36},{65,90},{95,95},{97,122}}, null, null);
      tmp[0].setProduction(tmp);
      tmp[1].setParentProduction(Generator.prod__Identifier__char_class___range__36_36_range__65_90_range__95_95_range__97_122_conditional__iter_star__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
  }
	
  private static class NatCon {
    public final static AbstractStackNode[] prod__digits_NatCon__iter__char_class___range__48_57_ = _init_prod__digits_NatCon__iter__char_class___range__48_57_();
    private static final AbstractStackNode[] _init_prod__digits_NatCon__iter__char_class___range__48_57_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new ListStackNode(1770, 0, regular__iter__char_class___range__48_57, new CharStackNode(1772, 0, new char[][]{{48,57}}, null, null), true, null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__digits_NatCon__iter__char_class___range__48_57_);
      return tmp;
	}
  }
	
  private static class ExplicitConstructorInvocation {
    public final static AbstractStackNode[] prod__super_comma_semicolon_ExplicitConstructorInvocation__conditional__lit_super__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_iter_star_seps__Expression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_lit___59_ = _init_prod__super_comma_semicolon_ExplicitConstructorInvocation__conditional__lit_super__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_iter_star_seps__Expression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_lit___59_();
    private static final AbstractStackNode[] _init_prod__super_comma_semicolon_ExplicitConstructorInvocation__conditional__lit_super__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_iter_star_seps__Expression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_lit___59_() {
      AbstractStackNode[] tmp = new AbstractStackNode[9];
      
      tmp[8] = new LiteralStackNode(1798, 8, prod__lit___59__char_class___range__59_59_, new char[] {59}, null, null);
      tmp[8].setProduction(tmp);
      tmp[7] = new NonTerminalStackNode(1796, 7, "layouts_LAYOUTLIST", null, null);
      tmp[7].setProduction(tmp);
      tmp[6] = new LiteralStackNode(1794, 6, prod__lit___41__char_class___range__41_41_, new char[] {41}, null, null);
      tmp[6].setProduction(tmp);
      tmp[5] = new NonTerminalStackNode(1792, 5, "layouts_LAYOUTLIST", null, null);
      tmp[5].setProduction(tmp);
      tmp[4] = new SeparatedListStackNode(1782, 4, regular__iter_star_seps__Expression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST, new NonTerminalStackNode(1784, 0, "Expression", null, null), new AbstractStackNode[]{new NonTerminalStackNode(1786, 1, "layouts_LAYOUTLIST", null, null), new LiteralStackNode(1788, 2, prod__lit___44__char_class___range__44_44_, new char[] {44}, null, null), new NonTerminalStackNode(1790, 3, "layouts_LAYOUTLIST", null, null)}, false, null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(1780, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new LiteralStackNode(1778, 2, prod__lit___40__char_class___range__40_40_, new char[] {40}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(1776, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(1774, 0, prod__lit_super__char_class___range__115_115_char_class___range__117_117_char_class___range__112_112_char_class___range__101_101_char_class___range__114_114_, new char[] {115,117,112,101,114}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[8].setParentProduction(Generator.prod__super_comma_semicolon_ExplicitConstructorInvocation__conditional__lit_super__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_iter_star_seps__Expression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_lit___59_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__this_comma_semicolon_ExplicitConstructorInvocation__conditional__lit_this__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_iter_star_seps__Expression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_lit___59_ = _init_prod__this_comma_semicolon_ExplicitConstructorInvocation__conditional__lit_this__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_iter_star_seps__Expression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_lit___59_();
    private static final AbstractStackNode[] _init_prod__this_comma_semicolon_ExplicitConstructorInvocation__conditional__lit_this__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_iter_star_seps__Expression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_lit___59_() {
      AbstractStackNode[] tmp = new AbstractStackNode[9];
      
      tmp[8] = new LiteralStackNode(1824, 8, prod__lit___59__char_class___range__59_59_, new char[] {59}, null, null);
      tmp[8].setProduction(tmp);
      tmp[7] = new NonTerminalStackNode(1822, 7, "layouts_LAYOUTLIST", null, null);
      tmp[7].setProduction(tmp);
      tmp[6] = new LiteralStackNode(1820, 6, prod__lit___41__char_class___range__41_41_, new char[] {41}, null, null);
      tmp[6].setProduction(tmp);
      tmp[5] = new NonTerminalStackNode(1818, 5, "layouts_LAYOUTLIST", null, null);
      tmp[5].setProduction(tmp);
      tmp[4] = new SeparatedListStackNode(1808, 4, regular__iter_star_seps__Expression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST, new NonTerminalStackNode(1810, 0, "Expression", null, null), new AbstractStackNode[]{new NonTerminalStackNode(1812, 1, "layouts_LAYOUTLIST", null, null), new LiteralStackNode(1814, 2, prod__lit___44__char_class___range__44_44_, new char[] {44}, null, null), new NonTerminalStackNode(1816, 3, "layouts_LAYOUTLIST", null, null)}, false, null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(1806, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new LiteralStackNode(1804, 2, prod__lit___40__char_class___range__40_40_, new char[] {40}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(1802, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(1800, 0, prod__lit_this__char_class___range__116_116_char_class___range__104_104_char_class___range__105_105_char_class___range__115_115_, new char[] {116,104,105,115}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[8].setParentProduction(Generator.prod__this_comma_semicolon_ExplicitConstructorInvocation__conditional__lit_this__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_iter_star_seps__Expression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_lit___59_);
      return tmp;
	}
  }
	
  private static class LabeledStatement {
    public final static AbstractStackNode[] prod__colon_LabeledStatement__conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___58_layouts_LAYOUTLIST_Statement_ = _init_prod__colon_LabeledStatement__conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___58_layouts_LAYOUTLIST_Statement_();
    private static final AbstractStackNode[] _init_prod__colon_LabeledStatement__conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___58_layouts_LAYOUTLIST_Statement_() {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new NonTerminalStackNode(1844, 4, "Statement", null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(1842, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new LiteralStackNode(1840, 2, prod__lit___58__char_class___range__58_58_, new char[] {58}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(1838, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new NonTerminalStackNode(1836, 0, "Identifier", null, null);
      tmp[0].setProduction(tmp);
      tmp[4].setParentProduction(Generator.prod__colon_LabeledStatement__conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___58_layouts_LAYOUTLIST_Statement_);
      return tmp;
	}
  }
	
  private static class MethodBody {
    public final static AbstractStackNode[] prod__Block1_MethodBody__Block_ = _init_prod__Block1_MethodBody__Block_();
    private static final AbstractStackNode[] _init_prod__Block1_MethodBody__Block_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(1850, 0, "Block", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__Block1_MethodBody__Block_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__semicolon3_MethodBody__lit___59_ = _init_prod__semicolon3_MethodBody__lit___59_();
    private static final AbstractStackNode[] _init_prod__semicolon3_MethodBody__lit___59_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(1852, 0, prod__lit___59__char_class___range__59_59_, new char[] {59}, null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__semicolon3_MethodBody__lit___59_);
      return tmp;
	}
  }
	
  private static class FieldDeclaration {
    public final static AbstractStackNode[] prod__comma_semicolon_FieldDeclaration__iter_star_seps__Modifier__layouts_LAYOUTLIST_layouts_LAYOUTLIST_Type_layouts_LAYOUTLIST_iter_seps__VariableDeclarator__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___59_ = _init_prod__comma_semicolon_FieldDeclaration__iter_star_seps__Modifier__layouts_LAYOUTLIST_layouts_LAYOUTLIST_Type_layouts_LAYOUTLIST_iter_seps__VariableDeclarator__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___59_();
    private static final AbstractStackNode[] _init_prod__comma_semicolon_FieldDeclaration__iter_star_seps__Modifier__layouts_LAYOUTLIST_layouts_LAYOUTLIST_Type_layouts_LAYOUTLIST_iter_seps__VariableDeclarator__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___59_() {
      AbstractStackNode[] tmp = new AbstractStackNode[7];
      
      tmp[6] = new LiteralStackNode(1878, 6, prod__lit___59__char_class___range__59_59_, new char[] {59}, null, null);
      tmp[6].setProduction(tmp);
      tmp[5] = new NonTerminalStackNode(1876, 5, "layouts_LAYOUTLIST", null, null);
      tmp[5].setProduction(tmp);
      tmp[4] = new SeparatedListStackNode(1866, 4, regular__iter_seps__VariableDeclarator__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST, new NonTerminalStackNode(1868, 0, "VariableDeclarator", null, null), new AbstractStackNode[]{new NonTerminalStackNode(1870, 1, "layouts_LAYOUTLIST", null, null), new LiteralStackNode(1872, 2, prod__lit___44__char_class___range__44_44_, new char[] {44}, null, null), new NonTerminalStackNode(1874, 3, "layouts_LAYOUTLIST", null, null)}, true, null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(1864, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new NonTerminalStackNode(1862, 2, "Type", null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(1860, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new SeparatedListStackNode(1854, 0, regular__iter_star_seps__Modifier__layouts_LAYOUTLIST, new NonTerminalStackNode(1856, 0, "Modifier", null, null), new AbstractStackNode[]{new NonTerminalStackNode(1858, 1, "layouts_LAYOUTLIST", null, null)}, false, null, null);
      tmp[0].setProduction(tmp);
      tmp[6].setParentProduction(Generator.prod__comma_semicolon_FieldDeclaration__iter_star_seps__Modifier__layouts_LAYOUTLIST_layouts_LAYOUTLIST_Type_layouts_LAYOUTLIST_iter_seps__VariableDeclarator__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___59_);
      return tmp;
	}
  }
	
  private static class DecimalLongLiteral {
    public final static AbstractStackNode[] prod__DecimalLongLiteral__lit_0_char_class___range__76_76_range__108_108_ = _init_prod__DecimalLongLiteral__lit_0_char_class___range__76_76_range__108_108_();
    private static final AbstractStackNode[] _init_prod__DecimalLongLiteral__lit_0_char_class___range__76_76_range__108_108_() {
      AbstractStackNode[] tmp = new AbstractStackNode[2];
      
      tmp[1] = new CharStackNode(1916, 1, new char[][]{{76,76},{108,108}}, null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(1914, 0, prod__lit_0__char_class___range__48_48_, new char[] {48}, null, null);
      tmp[0].setProduction(tmp);
      tmp[1].setParentProduction(Generator.prod__DecimalLongLiteral__lit_0_char_class___range__76_76_range__108_108_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__DecimalLongLiteral__char_class___range__49_57_iter_star__char_class___range__48_57_char_class___range__76_76_range__108_108_ = _init_prod__DecimalLongLiteral__char_class___range__49_57_iter_star__char_class___range__48_57_char_class___range__76_76_range__108_108_();
    private static final AbstractStackNode[] _init_prod__DecimalLongLiteral__char_class___range__49_57_iter_star__char_class___range__48_57_char_class___range__76_76_range__108_108_() {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new CharStackNode(1924, 2, new char[][]{{76,76},{108,108}}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new ListStackNode(1920, 1, regular__iter_star__char_class___range__48_57, new CharStackNode(1922, 0, new char[][]{{48,57}}, null, null), false, null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new CharStackNode(1918, 0, new char[][]{{49,57}}, null, null);
      tmp[0].setProduction(tmp);
      tmp[2].setParentProduction(Generator.prod__DecimalLongLiteral__char_class___range__49_57_iter_star__char_class___range__48_57_char_class___range__76_76_range__108_108_);
      return tmp;
	}
  }
	
  private static class SwitchBlockStatementGroup {
    public final static AbstractStackNode[] prod__SwitchLabel_p_BlockStatement_p_SwitchBlockStatementGroup__iter_seps__SwitchLabel__layouts_LAYOUTLIST_layouts_LAYOUTLIST_iter_seps__BlockStatement__layouts_LAYOUTLIST_ = _init_prod__SwitchLabel_p_BlockStatement_p_SwitchBlockStatementGroup__iter_seps__SwitchLabel__layouts_LAYOUTLIST_layouts_LAYOUTLIST_iter_seps__BlockStatement__layouts_LAYOUTLIST_();
    private static final AbstractStackNode[] _init_prod__SwitchLabel_p_BlockStatement_p_SwitchBlockStatementGroup__iter_seps__SwitchLabel__layouts_LAYOUTLIST_layouts_LAYOUTLIST_iter_seps__BlockStatement__layouts_LAYOUTLIST_() {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new SeparatedListStackNode(1934, 2, regular__iter_seps__BlockStatement__layouts_LAYOUTLIST, new NonTerminalStackNode(1936, 0, "BlockStatement", null, null), new AbstractStackNode[]{new NonTerminalStackNode(1938, 1, "layouts_LAYOUTLIST", null, null)}, true, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(1932, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new SeparatedListStackNode(1926, 0, regular__iter_seps__SwitchLabel__layouts_LAYOUTLIST, new NonTerminalStackNode(1928, 0, "SwitchLabel", null, null), new AbstractStackNode[]{new NonTerminalStackNode(1930, 1, "layouts_LAYOUTLIST", null, null)}, true, null, null);
      tmp[0].setProduction(tmp);
      tmp[2].setParentProduction(Generator.prod__SwitchLabel_p_BlockStatement_p_SwitchBlockStatementGroup__iter_seps__SwitchLabel__layouts_LAYOUTLIST_layouts_LAYOUTLIST_iter_seps__BlockStatement__layouts_LAYOUTLIST_);
      return tmp;
	}
  }
	
  private static class start__View {
    public final static AbstractStackNode[] prod__start__View__layouts_LAYOUTLIST_top_View_layouts_LAYOUTLIST_ = _init_prod__start__View__layouts_LAYOUTLIST_top_View_layouts_LAYOUTLIST_();
    private static final AbstractStackNode[] _init_prod__start__View__layouts_LAYOUTLIST_top_View_layouts_LAYOUTLIST_() {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new NonTerminalStackNode(1946, 2, "layouts_LAYOUTLIST", null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(1944, 1, "View", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new NonTerminalStackNode(1942, 0, "layouts_LAYOUTLIST", null, null);
      tmp[0].setProduction(tmp);
      tmp[2].setParentProduction(Generator.prod__start__View__layouts_LAYOUTLIST_top_View_layouts_LAYOUTLIST_);
      return tmp;
	}
  }
	
  private static class FormalParameter {
    public final static AbstractStackNode[] prod__Type_VariableDeclaratorId_FormalParameter__iter_star_seps__Modifier__layouts_LAYOUTLIST_layouts_LAYOUTLIST_Type_layouts_LAYOUTLIST_VariableDeclaratorId_ = _init_prod__Type_VariableDeclaratorId_FormalParameter__iter_star_seps__Modifier__layouts_LAYOUTLIST_layouts_LAYOUTLIST_Type_layouts_LAYOUTLIST_VariableDeclaratorId_();
    private static final AbstractStackNode[] _init_prod__Type_VariableDeclaratorId_FormalParameter__iter_star_seps__Modifier__layouts_LAYOUTLIST_layouts_LAYOUTLIST_Type_layouts_LAYOUTLIST_VariableDeclaratorId_() {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new NonTerminalStackNode(1982, 4, "VariableDeclaratorId", null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(1980, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new NonTerminalStackNode(1978, 2, "Type", null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(1976, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new SeparatedListStackNode(1970, 0, regular__iter_star_seps__Modifier__layouts_LAYOUTLIST, new NonTerminalStackNode(1972, 0, "Modifier", null, null), new AbstractStackNode[]{new NonTerminalStackNode(1974, 1, "layouts_LAYOUTLIST", null, null)}, false, null, null);
      tmp[0].setProduction(tmp);
      tmp[4].setParentProduction(Generator.prod__Type_VariableDeclaratorId_FormalParameter__iter_star_seps__Modifier__layouts_LAYOUTLIST_layouts_LAYOUTLIST_Type_layouts_LAYOUTLIST_VariableDeclaratorId_);
      return tmp;
	}
  }
	
  private static class InterfaceBody {
    public final static AbstractStackNode[] prod__InterfaceMemberDeclaration_s_InterfaceBody__lit___123_layouts_LAYOUTLIST_iter_star_seps__InterfaceMemberDeclaration__layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___125_ = _init_prod__InterfaceMemberDeclaration_s_InterfaceBody__lit___123_layouts_LAYOUTLIST_iter_star_seps__InterfaceMemberDeclaration__layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___125_();
    private static final AbstractStackNode[] _init_prod__InterfaceMemberDeclaration_s_InterfaceBody__lit___123_layouts_LAYOUTLIST_iter_star_seps__InterfaceMemberDeclaration__layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___125_() {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new LiteralStackNode(1996, 4, prod__lit___125__char_class___range__125_125_, new char[] {125}, null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(1994, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new SeparatedListStackNode(1988, 2, regular__iter_star_seps__InterfaceMemberDeclaration__layouts_LAYOUTLIST, new NonTerminalStackNode(1990, 0, "InterfaceMemberDeclaration", null, null), new AbstractStackNode[]{new NonTerminalStackNode(1992, 1, "layouts_LAYOUTLIST", null, null)}, false, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(1986, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(1984, 0, prod__lit___123__char_class___range__123_123_, new char[] {123}, null, null);
      tmp[0].setProduction(tmp);
      tmp[4].setParentProduction(Generator.prod__InterfaceMemberDeclaration_s_InterfaceBody__lit___123_layouts_LAYOUTLIST_iter_star_seps__InterfaceMemberDeclaration__layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___125_);
      return tmp;
	}
  }
	
  private static class InterfaceMemberDeclaration {
    public final static AbstractStackNode[] prod__AbstractMethodDeclaration_InterfaceMemberDeclaration__AbstractMethodDeclaration_ = _init_prod__AbstractMethodDeclaration_InterfaceMemberDeclaration__AbstractMethodDeclaration_();
    private static final AbstractStackNode[] _init_prod__AbstractMethodDeclaration_InterfaceMemberDeclaration__AbstractMethodDeclaration_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(1998, 0, "AbstractMethodDeclaration", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__AbstractMethodDeclaration_InterfaceMemberDeclaration__AbstractMethodDeclaration_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__ConstantDeclaration_InterfaceMemberDeclaration__ConstantDeclaration_ = _init_prod__ConstantDeclaration_InterfaceMemberDeclaration__ConstantDeclaration_();
    private static final AbstractStackNode[] _init_prod__ConstantDeclaration_InterfaceMemberDeclaration__ConstantDeclaration_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(2000, 0, "ConstantDeclaration", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__ConstantDeclaration_InterfaceMemberDeclaration__ConstantDeclaration_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__InnerInterfaceDeclaration_InterfaceMemberDeclaration__InterfaceDeclaration_ = _init_prod__InnerInterfaceDeclaration_InterfaceMemberDeclaration__InterfaceDeclaration_();
    private static final AbstractStackNode[] _init_prod__InnerInterfaceDeclaration_InterfaceMemberDeclaration__InterfaceDeclaration_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(2002, 0, "InterfaceDeclaration", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__InnerInterfaceDeclaration_InterfaceMemberDeclaration__InterfaceDeclaration_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__InnerClassDeclaration_InterfaceMemberDeclaration__ClassDeclaration_ = _init_prod__InnerClassDeclaration_InterfaceMemberDeclaration__ClassDeclaration_();
    private static final AbstractStackNode[] _init_prod__InnerClassDeclaration_InterfaceMemberDeclaration__ClassDeclaration_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(2004, 0, "ClassDeclaration", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__InnerClassDeclaration_InterfaceMemberDeclaration__ClassDeclaration_);
      return tmp;
	}
  }
	
  private static class Throws {
    public final static AbstractStackNode[] prod__throws_comma_Throws__conditional__lit_throws__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_iter_seps__ClassType__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_ = _init_prod__throws_comma_Throws__conditional__lit_throws__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_iter_seps__ClassType__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_();
    private static final AbstractStackNode[] _init_prod__throws_comma_Throws__conditional__lit_throws__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_iter_seps__ClassType__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_() {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new SeparatedListStackNode(2064, 2, regular__iter_seps__ClassType__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST, new NonTerminalStackNode(2066, 0, "ClassType", null, null), new AbstractStackNode[]{new NonTerminalStackNode(2068, 1, "layouts_LAYOUTLIST", null, null), new LiteralStackNode(2070, 2, prod__lit___44__char_class___range__44_44_, new char[] {44}, null, null), new NonTerminalStackNode(2072, 3, "layouts_LAYOUTLIST", null, null)}, true, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(2062, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(2060, 0, prod__lit_throws__char_class___range__116_116_char_class___range__104_104_char_class___range__114_114_char_class___range__111_111_char_class___range__119_119_char_class___range__115_115_, new char[] {116,104,114,111,119,115}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[2].setParentProduction(Generator.prod__throws_comma_Throws__conditional__lit_throws__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_iter_seps__ClassType__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_);
      return tmp;
	}
  }
	
  private static class Block {
    public final static AbstractStackNode[] prod__BlockStatement_s_Block__lit___123_layouts_LAYOUTLIST_iter_star_seps__BlockStatement__layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___125_ = _init_prod__BlockStatement_s_Block__lit___123_layouts_LAYOUTLIST_iter_star_seps__BlockStatement__layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___125_();
    private static final AbstractStackNode[] _init_prod__BlockStatement_s_Block__lit___123_layouts_LAYOUTLIST_iter_star_seps__BlockStatement__layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___125_() {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new LiteralStackNode(2058, 4, prod__lit___125__char_class___range__125_125_, new char[] {125}, null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(2056, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new SeparatedListStackNode(2050, 2, regular__iter_star_seps__BlockStatement__layouts_LAYOUTLIST, new NonTerminalStackNode(2052, 0, "BlockStatement", null, null), new AbstractStackNode[]{new NonTerminalStackNode(2054, 1, "layouts_LAYOUTLIST", null, null)}, false, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(2048, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(2046, 0, prod__lit___123__char_class___range__123_123_, new char[] {123}, null, null);
      tmp[0].setProduction(tmp);
      tmp[4].setParentProduction(Generator.prod__BlockStatement_s_Block__lit___123_layouts_LAYOUTLIST_iter_star_seps__BlockStatement__layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___125_);
      return tmp;
	}
  }
	
  private static class ContinueStatement {
    public final static AbstractStackNode[] prod__continue_semicolon_ContinueStatement__conditional__lit_continue__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_opt__Identifier_layouts_LAYOUTLIST_lit___59_ = _init_prod__continue_semicolon_ContinueStatement__conditional__lit_continue__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_opt__Identifier_layouts_LAYOUTLIST_lit___59_();
    private static final AbstractStackNode[] _init_prod__continue_semicolon_ContinueStatement__conditional__lit_continue__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_opt__Identifier_layouts_LAYOUTLIST_lit___59_() {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new LiteralStackNode(2090, 4, prod__lit___59__char_class___range__59_59_, new char[] {59}, null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(2088, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new OptionalStackNode(2084, 2, regular__opt__Identifier, new NonTerminalStackNode(2086, 0, "Identifier", null, null), null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(2082, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(2080, 0, prod__lit_continue__char_class___range__99_99_char_class___range__111_111_char_class___range__110_110_char_class___range__116_116_char_class___range__105_105_char_class___range__110_110_char_class___range__117_117_char_class___range__101_101_, new char[] {99,111,110,116,105,110,117,101}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[4].setParentProduction(Generator.prod__continue_semicolon_ContinueStatement__conditional__lit_continue__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_opt__Identifier_layouts_LAYOUTLIST_lit___59_);
      return tmp;
	}
  }
	
  private static class Dim {
    public final static AbstractStackNode[] prod__Dim_dunno_a_0_Dim__lit___91_layouts_LAYOUTLIST_lit___93_ = _init_prod__Dim_dunno_a_0_Dim__lit___91_layouts_LAYOUTLIST_lit___93_();
    private static final AbstractStackNode[] _init_prod__Dim_dunno_a_0_Dim__lit___91_layouts_LAYOUTLIST_lit___93_() {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new LiteralStackNode(2078, 2, prod__lit___93__char_class___range__93_93_, new char[] {93}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(2076, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(2074, 0, prod__lit___91__char_class___range__91_91_, new char[] {91}, null, null);
      tmp[0].setProduction(tmp);
      tmp[2].setParentProduction(Generator.prod__Dim_dunno_a_0_Dim__lit___91_layouts_LAYOUTLIST_lit___93_);
      return tmp;
	}
  }
	
  private static class Whitespace {
    public final static AbstractStackNode[] prod__Whitespace__char_class___range__9_10_range__12_13_range__32_32_ = _init_prod__Whitespace__char_class___range__9_10_range__12_13_range__32_32_();
    private static final AbstractStackNode[] _init_prod__Whitespace__char_class___range__9_10_range__12_13_range__32_32_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new CharStackNode(2104, 0, new char[][]{{9,10},{12,13},{32,32}}, null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__Whitespace__char_class___range__9_10_range__12_13_range__32_32_);
      return tmp;
	}
  }
	
  private static class ImportDeclaration {
    public final static AbstractStackNode[] prod__TypeImportOnDemandDeclaration_ImportDeclaration__TypeImportOnDemandDeclaration_ = _init_prod__TypeImportOnDemandDeclaration_ImportDeclaration__TypeImportOnDemandDeclaration_();
    private static final AbstractStackNode[] _init_prod__TypeImportOnDemandDeclaration_ImportDeclaration__TypeImportOnDemandDeclaration_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(2100, 0, "TypeImportOnDemandDeclaration", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__TypeImportOnDemandDeclaration_ImportDeclaration__TypeImportOnDemandDeclaration_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__SingleTypeImportDeclaration_ImportDeclaration__SingleTypeImportDeclaration_ = _init_prod__SingleTypeImportDeclaration_ImportDeclaration__SingleTypeImportDeclaration_();
    private static final AbstractStackNode[] _init_prod__SingleTypeImportDeclaration_ImportDeclaration__SingleTypeImportDeclaration_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(2102, 0, "SingleTypeImportDeclaration", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__SingleTypeImportDeclaration_ImportDeclaration__SingleTypeImportDeclaration_);
      return tmp;
	}
  }
	
  private static class LongLiteral {
    public final static AbstractStackNode[] prod__DecimalLongLiteral_LongLiteral__conditional__DecimalLongLiteral__not_follow__char_class___range__46_46_range__48_57_range__65_90_range__95_95_range__97_122__tag__NotSupported___112_114_101_102_101_114 = _init_prod__DecimalLongLiteral_LongLiteral__conditional__DecimalLongLiteral__not_follow__char_class___range__46_46_range__48_57_range__65_90_range__95_95_range__97_122__tag__NotSupported___112_114_101_102_101_114();
    private static final AbstractStackNode[] _init_prod__DecimalLongLiteral_LongLiteral__conditional__DecimalLongLiteral__not_follow__char_class___range__46_46_range__48_57_range__65_90_range__95_95_range__97_122__tag__NotSupported___112_114_101_102_101_114() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(2122, 0, "DecimalLongLiteral", null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{46,46},{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__DecimalLongLiteral_LongLiteral__conditional__DecimalLongLiteral__not_follow__char_class___range__46_46_range__48_57_range__65_90_range__95_95_range__97_122__tag__NotSupported___112_114_101_102_101_114);
      return tmp;
	}
    public final static AbstractStackNode[] prod__HexLongLiteral_LongLiteral__conditional__HexLongLiteral__not_follow__char_class___range__46_46_range__48_57_range__65_90_range__95_95_range__97_122__tag__NotSupported___112_114_101_102_101_114 = _init_prod__HexLongLiteral_LongLiteral__conditional__HexLongLiteral__not_follow__char_class___range__46_46_range__48_57_range__65_90_range__95_95_range__97_122__tag__NotSupported___112_114_101_102_101_114();
    private static final AbstractStackNode[] _init_prod__HexLongLiteral_LongLiteral__conditional__HexLongLiteral__not_follow__char_class___range__46_46_range__48_57_range__65_90_range__95_95_range__97_122__tag__NotSupported___112_114_101_102_101_114() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(2124, 0, "HexLongLiteral", null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{46,46},{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__HexLongLiteral_LongLiteral__conditional__HexLongLiteral__not_follow__char_class___range__46_46_range__48_57_range__65_90_range__95_95_range__97_122__tag__NotSupported___112_114_101_102_101_114);
      return tmp;
	}
    public final static AbstractStackNode[] prod__OctalLongLiteral_LongLiteral__conditional__OctalLongLiteral__not_follow__char_class___range__46_46_range__48_57_range__65_90_range__95_95_range__97_122__tag__NotSupported___112_114_101_102_101_114 = _init_prod__OctalLongLiteral_LongLiteral__conditional__OctalLongLiteral__not_follow__char_class___range__46_46_range__48_57_range__65_90_range__95_95_range__97_122__tag__NotSupported___112_114_101_102_101_114();
    private static final AbstractStackNode[] _init_prod__OctalLongLiteral_LongLiteral__conditional__OctalLongLiteral__not_follow__char_class___range__46_46_range__48_57_range__65_90_range__95_95_range__97_122__tag__NotSupported___112_114_101_102_101_114() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(2126, 0, "OctalLongLiteral", null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{46,46},{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__OctalLongLiteral_LongLiteral__conditional__OctalLongLiteral__not_follow__char_class___range__46_46_range__48_57_range__65_90_range__95_95_range__97_122__tag__NotSupported___112_114_101_102_101_114);
      return tmp;
	}
  }
	
  private static class HexLongLiteral {
    public final static AbstractStackNode[] prod__HexLongLiteral__char_class___range__48_48_char_class___range__88_88_range__120_120_iter__char_class___range__48_57_range__65_70_range__97_102_char_class___range__76_76_range__108_108_ = _init_prod__HexLongLiteral__char_class___range__48_48_char_class___range__88_88_range__120_120_iter__char_class___range__48_57_range__65_70_range__97_102_char_class___range__76_76_range__108_108_();
    private static final AbstractStackNode[] _init_prod__HexLongLiteral__char_class___range__48_48_char_class___range__88_88_range__120_120_iter__char_class___range__48_57_range__65_70_range__97_102_char_class___range__76_76_range__108_108_() {
      AbstractStackNode[] tmp = new AbstractStackNode[4];
      
      tmp[3] = new CharStackNode(2136, 3, new char[][]{{76,76},{108,108}}, null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new ListStackNode(2132, 2, regular__iter__char_class___range__48_57_range__65_70_range__97_102, new CharStackNode(2134, 0, new char[][]{{48,57},{65,70},{97,102}}, null, null), true, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new CharStackNode(2130, 1, new char[][]{{88,88},{120,120}}, null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new CharStackNode(2128, 0, new char[][]{{48,48}}, null, null);
      tmp[0].setProduction(tmp);
      tmp[3].setParentProduction(Generator.prod__HexLongLiteral__char_class___range__48_48_char_class___range__88_88_range__120_120_iter__char_class___range__48_57_range__65_70_range__97_102_char_class___range__76_76_range__108_108_);
      return tmp;
	}
  }
	
  private static class MethodInvocation {
    public final static AbstractStackNode[] prod__comma11_MethodInvocation__Name_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_iter_star_seps__Expression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41__tag__NotSupported___97_118_111_105_100 = _init_prod__comma11_MethodInvocation__Name_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_iter_star_seps__Expression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41__tag__NotSupported___97_118_111_105_100();
    private static final AbstractStackNode[] _init_prod__comma11_MethodInvocation__Name_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_iter_star_seps__Expression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41__tag__NotSupported___97_118_111_105_100() {
      AbstractStackNode[] tmp = new AbstractStackNode[7];
      
      tmp[6] = new LiteralStackNode(2166, 6, prod__lit___41__char_class___range__41_41_, new char[] {41}, null, null);
      tmp[6].setProduction(tmp);
      tmp[5] = new NonTerminalStackNode(2164, 5, "layouts_LAYOUTLIST", null, null);
      tmp[5].setProduction(tmp);
      tmp[4] = new SeparatedListStackNode(2154, 4, regular__iter_star_seps__Expression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST, new NonTerminalStackNode(2156, 0, "Expression", null, null), new AbstractStackNode[]{new NonTerminalStackNode(2158, 1, "layouts_LAYOUTLIST", null, null), new LiteralStackNode(2160, 2, prod__lit___44__char_class___range__44_44_, new char[] {44}, null, null), new NonTerminalStackNode(2162, 3, "layouts_LAYOUTLIST", null, null)}, false, null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(2152, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new LiteralStackNode(2150, 2, prod__lit___40__char_class___range__40_40_, new char[] {40}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(2148, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new NonTerminalStackNode(2146, 0, "Name", null, null);
      tmp[0].setProduction(tmp);
      tmp[6].setParentProduction(Generator.prod__comma11_MethodInvocation__Name_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_iter_star_seps__Expression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41__tag__NotSupported___97_118_111_105_100);
      return tmp;
	}
    public final static AbstractStackNode[] prod__comma21_MethodInvocation__Primary_layouts_LAYOUTLIST_lit___46_layouts_LAYOUTLIST_conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_iter_star_seps__Expression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41_ = _init_prod__comma21_MethodInvocation__Primary_layouts_LAYOUTLIST_lit___46_layouts_LAYOUTLIST_conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_iter_star_seps__Expression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41_();
    private static final AbstractStackNode[] _init_prod__comma21_MethodInvocation__Primary_layouts_LAYOUTLIST_lit___46_layouts_LAYOUTLIST_conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_iter_star_seps__Expression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41_() {
      AbstractStackNode[] tmp = new AbstractStackNode[11];
      
      tmp[10] = new LiteralStackNode(2196, 10, prod__lit___41__char_class___range__41_41_, new char[] {41}, null, null);
      tmp[10].setProduction(tmp);
      tmp[9] = new NonTerminalStackNode(2194, 9, "layouts_LAYOUTLIST", null, null);
      tmp[9].setProduction(tmp);
      tmp[8] = new SeparatedListStackNode(2184, 8, regular__iter_star_seps__Expression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST, new NonTerminalStackNode(2186, 0, "Expression", null, null), new AbstractStackNode[]{new NonTerminalStackNode(2188, 1, "layouts_LAYOUTLIST", null, null), new LiteralStackNode(2190, 2, prod__lit___44__char_class___range__44_44_, new char[] {44}, null, null), new NonTerminalStackNode(2192, 3, "layouts_LAYOUTLIST", null, null)}, false, null, null);
      tmp[8].setProduction(tmp);
      tmp[7] = new NonTerminalStackNode(2182, 7, "layouts_LAYOUTLIST", null, null);
      tmp[7].setProduction(tmp);
      tmp[6] = new LiteralStackNode(2180, 6, prod__lit___40__char_class___range__40_40_, new char[] {40}, null, null);
      tmp[6].setProduction(tmp);
      tmp[5] = new NonTerminalStackNode(2178, 5, "layouts_LAYOUTLIST", null, null);
      tmp[5].setProduction(tmp);
      tmp[4] = new NonTerminalStackNode(2176, 4, "Identifier", null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(2174, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new LiteralStackNode(2172, 2, prod__lit___46__char_class___range__46_46_, new char[] {46}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(2170, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new NonTerminalStackNode(2168, 0, "Primary", null, null);
      tmp[0].setProduction(tmp);
      tmp[10].setParentProduction(Generator.prod__comma21_MethodInvocation__Primary_layouts_LAYOUTLIST_lit___46_layouts_LAYOUTLIST_conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_iter_star_seps__Expression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__super_comma_MethodInvocation__conditional__lit_super__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___46_layouts_LAYOUTLIST_conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_iter_star_seps__Expression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41__tag__NotSupported___112_114_101_102_101_114 = _init_prod__super_comma_MethodInvocation__conditional__lit_super__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___46_layouts_LAYOUTLIST_conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_iter_star_seps__Expression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41__tag__NotSupported___112_114_101_102_101_114();
    private static final AbstractStackNode[] _init_prod__super_comma_MethodInvocation__conditional__lit_super__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___46_layouts_LAYOUTLIST_conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_iter_star_seps__Expression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41__tag__NotSupported___112_114_101_102_101_114() {
      AbstractStackNode[] tmp = new AbstractStackNode[11];
      
      tmp[10] = new LiteralStackNode(2226, 10, prod__lit___41__char_class___range__41_41_, new char[] {41}, null, null);
      tmp[10].setProduction(tmp);
      tmp[9] = new NonTerminalStackNode(2224, 9, "layouts_LAYOUTLIST", null, null);
      tmp[9].setProduction(tmp);
      tmp[8] = new SeparatedListStackNode(2214, 8, regular__iter_star_seps__Expression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST, new NonTerminalStackNode(2216, 0, "Expression", null, null), new AbstractStackNode[]{new NonTerminalStackNode(2218, 1, "layouts_LAYOUTLIST", null, null), new LiteralStackNode(2220, 2, prod__lit___44__char_class___range__44_44_, new char[] {44}, null, null), new NonTerminalStackNode(2222, 3, "layouts_LAYOUTLIST", null, null)}, false, null, null);
      tmp[8].setProduction(tmp);
      tmp[7] = new NonTerminalStackNode(2212, 7, "layouts_LAYOUTLIST", null, null);
      tmp[7].setProduction(tmp);
      tmp[6] = new LiteralStackNode(2210, 6, prod__lit___40__char_class___range__40_40_, new char[] {40}, null, null);
      tmp[6].setProduction(tmp);
      tmp[5] = new NonTerminalStackNode(2208, 5, "layouts_LAYOUTLIST", null, null);
      tmp[5].setProduction(tmp);
      tmp[4] = new NonTerminalStackNode(2206, 4, "Identifier", null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(2204, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new LiteralStackNode(2202, 2, prod__lit___46__char_class___range__46_46_, new char[] {46}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(2200, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(2198, 0, prod__lit_super__char_class___range__115_115_char_class___range__117_117_char_class___range__112_112_char_class___range__101_101_char_class___range__114_114_, new char[] {115,117,112,101,114}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[10].setParentProduction(Generator.prod__super_comma_MethodInvocation__conditional__lit_super__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___46_layouts_LAYOUTLIST_conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_iter_star_seps__Expression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41__tag__NotSupported___112_114_101_102_101_114);
      return tmp;
	}
    public final static AbstractStackNode[] prod__MethodInvocationConstructor_MethodInvocation__Primary_layouts_LAYOUTLIST_lit___46_layouts_LAYOUTLIST_ClassInstanceCreationExpression__tag__NotSupported___112_114_101_102_101_114 = _init_prod__MethodInvocationConstructor_MethodInvocation__Primary_layouts_LAYOUTLIST_lit___46_layouts_LAYOUTLIST_ClassInstanceCreationExpression__tag__NotSupported___112_114_101_102_101_114();
    private static final AbstractStackNode[] _init_prod__MethodInvocationConstructor_MethodInvocation__Primary_layouts_LAYOUTLIST_lit___46_layouts_LAYOUTLIST_ClassInstanceCreationExpression__tag__NotSupported___112_114_101_102_101_114() {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new NonTerminalStackNode(2236, 4, "ClassInstanceCreationExpression", null, null);
      tmp[4].setProduction(tmp);
      tmp[0] = new NonTerminalStackNode(2228, 0, "Primary", null, null);
      tmp[0].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(2230, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[2] = new LiteralStackNode(2232, 2, prod__lit___46__char_class___range__46_46_, new char[] {46}, null, null);
      tmp[2].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(2234, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[4].setParentProduction(Generator.prod__MethodInvocationConstructor_MethodInvocation__Primary_layouts_LAYOUTLIST_lit___46_layouts_LAYOUTLIST_ClassInstanceCreationExpression__tag__NotSupported___112_114_101_102_101_114);
      return tmp;
	}
  }
	
  private static class DimExpr {
    public final static AbstractStackNode[] prod__Expression2_DimExpr__lit___91_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___93_ = _init_prod__Expression2_DimExpr__lit___91_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___93_();
    private static final AbstractStackNode[] _init_prod__Expression2_DimExpr__lit___91_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___93_() {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new LiteralStackNode(2246, 4, prod__lit___93__char_class___range__93_93_, new char[] {93}, null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(2244, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new NonTerminalStackNode(2242, 2, "Expression", null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(2240, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(2238, 0, prod__lit___91__char_class___range__91_91_, new char[] {91}, null, null);
      tmp[0].setProduction(tmp);
      tmp[4].setParentProduction(Generator.prod__Expression2_DimExpr__lit___91_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___93_);
      return tmp;
	}
  }
	
  private static class Interfaces {
    public final static AbstractStackNode[] prod__implements_comma_Interfaces__conditional__lit_implements__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_iter_seps__InterfaceType__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_ = _init_prod__implements_comma_Interfaces__conditional__lit_implements__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_iter_seps__InterfaceType__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_();
    private static final AbstractStackNode[] _init_prod__implements_comma_Interfaces__conditional__lit_implements__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_iter_seps__InterfaceType__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_() {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new SeparatedListStackNode(2252, 2, regular__iter_seps__InterfaceType__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST, new NonTerminalStackNode(2254, 0, "InterfaceType", null, null), new AbstractStackNode[]{new NonTerminalStackNode(2256, 1, "layouts_LAYOUTLIST", null, null), new LiteralStackNode(2258, 2, prod__lit___44__char_class___range__44_44_, new char[] {44}, null, null), new NonTerminalStackNode(2260, 3, "layouts_LAYOUTLIST", null, null)}, true, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(2250, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(2248, 0, prod__lit_implements__char_class___range__105_105_char_class___range__109_109_char_class___range__112_112_char_class___range__108_108_char_class___range__101_101_char_class___range__109_109_char_class___range__101_101_char_class___range__110_110_char_class___range__116_116_char_class___range__115_115_, new char[] {105,109,112,108,101,109,101,110,116,115}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[2].setParentProduction(Generator.prod__implements_comma_Interfaces__conditional__lit_implements__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_iter_seps__InterfaceType__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_);
      return tmp;
	}
  }
	
  private static class SwitchStatement {
    public final static AbstractStackNode[] prod__switch_SwitchStatement__lit_switch_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_SwitchBlock_ = _init_prod__switch_SwitchStatement__lit_switch_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_SwitchBlock_();
    private static final AbstractStackNode[] _init_prod__switch_SwitchStatement__lit_switch_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_SwitchBlock_() {
      AbstractStackNode[] tmp = new AbstractStackNode[9];
      
      tmp[8] = new NonTerminalStackNode(2282, 8, "SwitchBlock", null, null);
      tmp[8].setProduction(tmp);
      tmp[7] = new NonTerminalStackNode(2280, 7, "layouts_LAYOUTLIST", null, null);
      tmp[7].setProduction(tmp);
      tmp[6] = new LiteralStackNode(2278, 6, prod__lit___41__char_class___range__41_41_, new char[] {41}, null, null);
      tmp[6].setProduction(tmp);
      tmp[5] = new NonTerminalStackNode(2276, 5, "layouts_LAYOUTLIST", null, null);
      tmp[5].setProduction(tmp);
      tmp[4] = new NonTerminalStackNode(2274, 4, "Expression", null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(2272, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new LiteralStackNode(2270, 2, prod__lit___40__char_class___range__40_40_, new char[] {40}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(2268, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(2266, 0, prod__lit_switch__char_class___range__115_115_char_class___range__119_119_char_class___range__105_105_char_class___range__116_116_char_class___range__99_99_char_class___range__104_104_, new char[] {115,119,105,116,99,104}, null, null);
      tmp[0].setProduction(tmp);
      tmp[8].setParentProduction(Generator.prod__switch_SwitchStatement__lit_switch_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_SwitchBlock_);
      return tmp;
	}
  }
	
  private static class ClassOrInterfaceType {
    public final static AbstractStackNode[] prod__Name_ClassOrInterfaceType__Name_ = _init_prod__Name_ClassOrInterfaceType__Name_();
    private static final AbstractStackNode[] _init_prod__Name_ClassOrInterfaceType__Name_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(2290, 0, "Name", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__Name_ClassOrInterfaceType__Name_);
      return tmp;
	}
  }
	
  private static class HexIntegerLiteral {
    public final static AbstractStackNode[] prod__HexIntegerLiteral__char_class___range__48_48_char_class___range__88_88_range__120_120_iter__char_class___range__48_57_range__65_70_range__97_102_ = _init_prod__HexIntegerLiteral__char_class___range__48_48_char_class___range__88_88_range__120_120_iter__char_class___range__48_57_range__65_70_range__97_102_();
    private static final AbstractStackNode[] _init_prod__HexIntegerLiteral__char_class___range__48_48_char_class___range__88_88_range__120_120_iter__char_class___range__48_57_range__65_70_range__97_102_() {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new ListStackNode(2326, 2, regular__iter__char_class___range__48_57_range__65_70_range__97_102, new CharStackNode(2328, 0, new char[][]{{48,57},{65,70},{97,102}}, null, null), true, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new CharStackNode(2324, 1, new char[][]{{88,88},{120,120}}, null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new CharStackNode(2322, 0, new char[][]{{48,48}}, null, null);
      tmp[0].setProduction(tmp);
      tmp[2].setParentProduction(Generator.prod__HexIntegerLiteral__char_class___range__48_48_char_class___range__88_88_range__120_120_iter__char_class___range__48_57_range__65_70_range__97_102_);
      return tmp;
	}
  }
	
  private static class StatementWithoutTrailingSubstatement {
    public final static AbstractStackNode[] prod__EmptyStatement_StatementWithoutTrailingSubstatement__EmptyStatement_ = _init_prod__EmptyStatement_StatementWithoutTrailingSubstatement__EmptyStatement_();
    private static final AbstractStackNode[] _init_prod__EmptyStatement_StatementWithoutTrailingSubstatement__EmptyStatement_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(2300, 0, "EmptyStatement", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__EmptyStatement_StatementWithoutTrailingSubstatement__EmptyStatement_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__TryStatement_StatementWithoutTrailingSubstatement__TryStatement_ = _init_prod__TryStatement_StatementWithoutTrailingSubstatement__TryStatement_();
    private static final AbstractStackNode[] _init_prod__TryStatement_StatementWithoutTrailingSubstatement__TryStatement_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(2302, 0, "TryStatement", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__TryStatement_StatementWithoutTrailingSubstatement__TryStatement_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__ReturnStatement_StatementWithoutTrailingSubstatement__ReturnStatement_ = _init_prod__ReturnStatement_StatementWithoutTrailingSubstatement__ReturnStatement_();
    private static final AbstractStackNode[] _init_prod__ReturnStatement_StatementWithoutTrailingSubstatement__ReturnStatement_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(2304, 0, "ReturnStatement", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__ReturnStatement_StatementWithoutTrailingSubstatement__ReturnStatement_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__ThrowStatement_StatementWithoutTrailingSubstatement__ThrowStatement_ = _init_prod__ThrowStatement_StatementWithoutTrailingSubstatement__ThrowStatement_();
    private static final AbstractStackNode[] _init_prod__ThrowStatement_StatementWithoutTrailingSubstatement__ThrowStatement_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(2306, 0, "ThrowStatement", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__ThrowStatement_StatementWithoutTrailingSubstatement__ThrowStatement_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__DoStatement_StatementWithoutTrailingSubstatement__DoStatement_ = _init_prod__DoStatement_StatementWithoutTrailingSubstatement__DoStatement_();
    private static final AbstractStackNode[] _init_prod__DoStatement_StatementWithoutTrailingSubstatement__DoStatement_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(2308, 0, "DoStatement", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__DoStatement_StatementWithoutTrailingSubstatement__DoStatement_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__SynchronizedStatement_StatementWithoutTrailingSubstatement__SynchronizedStatement_ = _init_prod__SynchronizedStatement_StatementWithoutTrailingSubstatement__SynchronizedStatement_();
    private static final AbstractStackNode[] _init_prod__SynchronizedStatement_StatementWithoutTrailingSubstatement__SynchronizedStatement_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(2310, 0, "SynchronizedStatement", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__SynchronizedStatement_StatementWithoutTrailingSubstatement__SynchronizedStatement_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__Block_StatementWithoutTrailingSubstatement__Block_ = _init_prod__Block_StatementWithoutTrailingSubstatement__Block_();
    private static final AbstractStackNode[] _init_prod__Block_StatementWithoutTrailingSubstatement__Block_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(2312, 0, "Block", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__Block_StatementWithoutTrailingSubstatement__Block_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__SwitchStatement_StatementWithoutTrailingSubstatement__SwitchStatement_ = _init_prod__SwitchStatement_StatementWithoutTrailingSubstatement__SwitchStatement_();
    private static final AbstractStackNode[] _init_prod__SwitchStatement_StatementWithoutTrailingSubstatement__SwitchStatement_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(2314, 0, "SwitchStatement", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__SwitchStatement_StatementWithoutTrailingSubstatement__SwitchStatement_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__ContinueStatement_StatementWithoutTrailingSubstatement__ContinueStatement_ = _init_prod__ContinueStatement_StatementWithoutTrailingSubstatement__ContinueStatement_();
    private static final AbstractStackNode[] _init_prod__ContinueStatement_StatementWithoutTrailingSubstatement__ContinueStatement_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(2316, 0, "ContinueStatement", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__ContinueStatement_StatementWithoutTrailingSubstatement__ContinueStatement_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__ExpressionStatement_StatementWithoutTrailingSubstatement__ExpressionStatement_ = _init_prod__ExpressionStatement_StatementWithoutTrailingSubstatement__ExpressionStatement_();
    private static final AbstractStackNode[] _init_prod__ExpressionStatement_StatementWithoutTrailingSubstatement__ExpressionStatement_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(2318, 0, "ExpressionStatement", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__ExpressionStatement_StatementWithoutTrailingSubstatement__ExpressionStatement_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__BreakStatement_StatementWithoutTrailingSubstatement__BreakStatement_ = _init_prod__BreakStatement_StatementWithoutTrailingSubstatement__BreakStatement_();
    private static final AbstractStackNode[] _init_prod__BreakStatement_StatementWithoutTrailingSubstatement__BreakStatement_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(2320, 0, "BreakStatement", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__BreakStatement_StatementWithoutTrailingSubstatement__BreakStatement_);
      return tmp;
	}
  }
	
  private static class BlockStatement {
    public final static AbstractStackNode[] prod__Statement_BlockStatement__Statement_ = _init_prod__Statement_BlockStatement__Statement_();
    private static final AbstractStackNode[] _init_prod__Statement_BlockStatement__Statement_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(2346, 0, "Statement", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__Statement_BlockStatement__Statement_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__LocalVariableDeclarationStatement_BlockStatement__iter_star_seps__Modifier__layouts_LAYOUTLIST_layouts_LAYOUTLIST_LocalVariableDeclarationStatement_ = _init_prod__LocalVariableDeclarationStatement_BlockStatement__iter_star_seps__Modifier__layouts_LAYOUTLIST_layouts_LAYOUTLIST_LocalVariableDeclarationStatement_();
    private static final AbstractStackNode[] _init_prod__LocalVariableDeclarationStatement_BlockStatement__iter_star_seps__Modifier__layouts_LAYOUTLIST_layouts_LAYOUTLIST_LocalVariableDeclarationStatement_() {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new NonTerminalStackNode(2356, 2, "LocalVariableDeclarationStatement", null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(2354, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new SeparatedListStackNode(2348, 0, regular__iter_star_seps__Modifier__layouts_LAYOUTLIST, new NonTerminalStackNode(2350, 0, "Modifier", null, null), new AbstractStackNode[]{new NonTerminalStackNode(2352, 1, "layouts_LAYOUTLIST", null, null)}, false, null, null);
      tmp[0].setProduction(tmp);
      tmp[2].setParentProduction(Generator.prod__LocalVariableDeclarationStatement_BlockStatement__iter_star_seps__Modifier__layouts_LAYOUTLIST_layouts_LAYOUTLIST_LocalVariableDeclarationStatement_);
      return tmp;
	}
  }
	
  private static class CharacterLiteral {
    public final static AbstractStackNode[] prod__CharacterLiteral__lit___39_EscapeSequence_lit___39_ = _init_prod__CharacterLiteral__lit___39_EscapeSequence_lit___39_();
    private static final AbstractStackNode[] _init_prod__CharacterLiteral__lit___39_EscapeSequence_lit___39_() {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new LiteralStackNode(2362, 2, prod__lit___39__char_class___range__39_39_, new char[] {39}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(2360, 1, "EscapeSequence", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(2358, 0, prod__lit___39__char_class___range__39_39_, new char[] {39}, null, null);
      tmp[0].setProduction(tmp);
      tmp[2].setParentProduction(Generator.prod__CharacterLiteral__lit___39_EscapeSequence_lit___39_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__CharacterLiteral__lit___39_SingleCharacter_lit___39_ = _init_prod__CharacterLiteral__lit___39_SingleCharacter_lit___39_();
    private static final AbstractStackNode[] _init_prod__CharacterLiteral__lit___39_SingleCharacter_lit___39_() {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new LiteralStackNode(2368, 2, prod__lit___39__char_class___range__39_39_, new char[] {39}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(2366, 1, "SingleCharacter", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(2364, 0, prod__lit___39__char_class___range__39_39_, new char[] {39}, null, null);
      tmp[0].setProduction(tmp);
      tmp[2].setParentProduction(Generator.prod__CharacterLiteral__lit___39_SingleCharacter_lit___39_);
      return tmp;
	}
  }
	
  private static class ANTLR {
    public final static AbstractStackNode[] prod__ANTLR__lit_grammar_layouts_LAYOUTLIST_Identifier_layouts_LAYOUTLIST_lit___59_layouts_LAYOUTLIST_iter_seps__Thing__layouts_LAYOUTLIST_ = _init_prod__ANTLR__lit_grammar_layouts_LAYOUTLIST_Identifier_layouts_LAYOUTLIST_lit___59_layouts_LAYOUTLIST_iter_seps__Thing__layouts_LAYOUTLIST_();
    private static final AbstractStackNode[] _init_prod__ANTLR__lit_grammar_layouts_LAYOUTLIST_Identifier_layouts_LAYOUTLIST_lit___59_layouts_LAYOUTLIST_iter_seps__Thing__layouts_LAYOUTLIST_() {
      AbstractStackNode[] tmp = new AbstractStackNode[7];
      
      tmp[6] = new SeparatedListStackNode(2382, 6, regular__iter_seps__Thing__layouts_LAYOUTLIST, new NonTerminalStackNode(2384, 0, "Thing", null, null), new AbstractStackNode[]{new NonTerminalStackNode(2386, 1, "layouts_LAYOUTLIST", null, null)}, true, null, null);
      tmp[6].setProduction(tmp);
      tmp[5] = new NonTerminalStackNode(2380, 5, "layouts_LAYOUTLIST", null, null);
      tmp[5].setProduction(tmp);
      tmp[4] = new LiteralStackNode(2378, 4, prod__lit___59__char_class___range__59_59_, new char[] {59}, null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(2376, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new NonTerminalStackNode(2374, 2, "Identifier", null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(2372, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(2370, 0, prod__lit_grammar__char_class___range__103_103_char_class___range__114_114_char_class___range__97_97_char_class___range__109_109_char_class___range__109_109_char_class___range__97_97_char_class___range__114_114_, new char[] {103,114,97,109,109,97,114}, null, null);
      tmp[0].setProduction(tmp);
      tmp[6].setParentProduction(Generator.prod__ANTLR__lit_grammar_layouts_LAYOUTLIST_Identifier_layouts_LAYOUTLIST_lit___59_layouts_LAYOUTLIST_iter_seps__Thing__layouts_LAYOUTLIST_);
      return tmp;
	}
  }
	
  private static class DoubleLiteral {
    public final static AbstractStackNode[] prod__DoubleLiteral__iter__char_class___range__48_57_opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_char_class___range__68_68_range__100_100_ = _init_prod__DoubleLiteral__iter__char_class___range__48_57_opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_char_class___range__68_68_range__100_100_();
    private static final AbstractStackNode[] _init_prod__DoubleLiteral__iter__char_class___range__48_57_opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_char_class___range__68_68_range__100_100_() {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new CharStackNode(2410, 2, new char[][]{{68,68},{100,100}}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new OptionalStackNode(2396, 1, regular__opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57, new SequenceStackNode(2398, 0, regular__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57, new AbstractStackNode[]{new CharStackNode(2400, 0, new char[][]{{69,69},{101,101}}, null, null), new OptionalStackNode(2402, 1, regular__opt__char_class___range__43_43_range__45_45, new CharStackNode(2404, 0, new char[][]{{43,43},{45,45}}, null, null), null, null), new ListStackNode(2406, 2, regular__iter__char_class___range__48_57, new CharStackNode(2408, 0, new char[][]{{48,57}}, null, null), true, null, null)}, null, null), null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new ListStackNode(2392, 0, regular__iter__char_class___range__48_57, new CharStackNode(2394, 0, new char[][]{{48,57}}, null, null), true, null, null);
      tmp[0].setProduction(tmp);
      tmp[2].setParentProduction(Generator.prod__DoubleLiteral__iter__char_class___range__48_57_opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_char_class___range__68_68_range__100_100_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__DoubleLiteral__iter__char_class___range__48_57_lit___46_iter_star__char_class___range__48_57_opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_opt__char_class___range__68_68_range__100_100_ = _init_prod__DoubleLiteral__iter__char_class___range__48_57_lit___46_iter_star__char_class___range__48_57_opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_opt__char_class___range__68_68_range__100_100_();
    private static final AbstractStackNode[] _init_prod__DoubleLiteral__iter__char_class___range__48_57_lit___46_iter_star__char_class___range__48_57_opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_opt__char_class___range__68_68_range__100_100_() {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new OptionalStackNode(2436, 4, regular__opt__char_class___range__68_68_range__100_100, new CharStackNode(2438, 0, new char[][]{{68,68},{100,100}}, null, null), null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new OptionalStackNode(2422, 3, regular__opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57, new SequenceStackNode(2424, 0, regular__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57, new AbstractStackNode[]{new CharStackNode(2426, 0, new char[][]{{69,69},{101,101}}, null, null), new OptionalStackNode(2428, 1, regular__opt__char_class___range__43_43_range__45_45, new CharStackNode(2430, 0, new char[][]{{43,43},{45,45}}, null, null), null, null), new ListStackNode(2432, 2, regular__iter__char_class___range__48_57, new CharStackNode(2434, 0, new char[][]{{48,57}}, null, null), true, null, null)}, null, null), null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new ListStackNode(2418, 2, regular__iter_star__char_class___range__48_57, new CharStackNode(2420, 0, new char[][]{{48,57}}, null, null), false, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new LiteralStackNode(2416, 1, prod__lit___46__char_class___range__46_46_, new char[] {46}, null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new ListStackNode(2412, 0, regular__iter__char_class___range__48_57, new CharStackNode(2414, 0, new char[][]{{48,57}}, null, null), true, null, null);
      tmp[0].setProduction(tmp);
      tmp[4].setParentProduction(Generator.prod__DoubleLiteral__iter__char_class___range__48_57_lit___46_iter_star__char_class___range__48_57_opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_opt__char_class___range__68_68_range__100_100_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__DoubleLiteral__iter__char_class___range__48_57_char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_opt__char_class___range__68_68_range__100_100_ = _init_prod__DoubleLiteral__iter__char_class___range__48_57_char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_opt__char_class___range__68_68_range__100_100_();
    private static final AbstractStackNode[] _init_prod__DoubleLiteral__iter__char_class___range__48_57_char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_opt__char_class___range__68_68_range__100_100_() {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new OptionalStackNode(2454, 4, regular__opt__char_class___range__68_68_range__100_100, new CharStackNode(2456, 0, new char[][]{{68,68},{100,100}}, null, null), null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new ListStackNode(2450, 3, regular__iter__char_class___range__48_57, new CharStackNode(2452, 0, new char[][]{{48,57}}, null, null), true, null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new OptionalStackNode(2446, 2, regular__opt__char_class___range__43_43_range__45_45, new CharStackNode(2448, 0, new char[][]{{43,43},{45,45}}, null, null), null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new CharStackNode(2444, 1, new char[][]{{69,69},{101,101}}, null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new ListStackNode(2440, 0, regular__iter__char_class___range__48_57, new CharStackNode(2442, 0, new char[][]{{48,57}}, null, null), true, null, null);
      tmp[0].setProduction(tmp);
      tmp[4].setParentProduction(Generator.prod__DoubleLiteral__iter__char_class___range__48_57_char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_opt__char_class___range__68_68_range__100_100_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__DoubleLiteral__lit___46_iter__char_class___range__48_57_opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_opt__char_class___range__68_68_range__100_100_ = _init_prod__DoubleLiteral__lit___46_iter__char_class___range__48_57_opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_opt__char_class___range__68_68_range__100_100_();
    private static final AbstractStackNode[] _init_prod__DoubleLiteral__lit___46_iter__char_class___range__48_57_opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_opt__char_class___range__68_68_range__100_100_() {
      AbstractStackNode[] tmp = new AbstractStackNode[4];
      
      tmp[3] = new OptionalStackNode(2478, 3, regular__opt__char_class___range__68_68_range__100_100, new CharStackNode(2480, 0, new char[][]{{68,68},{100,100}}, null, null), null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new OptionalStackNode(2464, 2, regular__opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57, new SequenceStackNode(2466, 0, regular__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57, new AbstractStackNode[]{new CharStackNode(2468, 0, new char[][]{{69,69},{101,101}}, null, null), new OptionalStackNode(2470, 1, regular__opt__char_class___range__43_43_range__45_45, new CharStackNode(2472, 0, new char[][]{{43,43},{45,45}}, null, null), null, null), new ListStackNode(2474, 2, regular__iter__char_class___range__48_57, new CharStackNode(2476, 0, new char[][]{{48,57}}, null, null), true, null, null)}, null, null), null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new ListStackNode(2460, 1, regular__iter__char_class___range__48_57, new CharStackNode(2462, 0, new char[][]{{48,57}}, null, null), true, null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(2458, 0, prod__lit___46__char_class___range__46_46_, new char[] {46}, null, null);
      tmp[0].setProduction(tmp);
      tmp[3].setParentProduction(Generator.prod__DoubleLiteral__lit___46_iter__char_class___range__48_57_opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_opt__char_class___range__68_68_range__100_100_);
      return tmp;
	}
  }
	
  private static class ExpressionStatement {
    public final static AbstractStackNode[] prod__semicolon2_ExpressionStatement__StatementExpression_layouts_LAYOUTLIST_lit___59_ = _init_prod__semicolon2_ExpressionStatement__StatementExpression_layouts_LAYOUTLIST_lit___59_();
    private static final AbstractStackNode[] _init_prod__semicolon2_ExpressionStatement__StatementExpression_layouts_LAYOUTLIST_lit___59_() {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new LiteralStackNode(2500, 2, prod__lit___59__char_class___range__59_59_, new char[] {59}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(2498, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new NonTerminalStackNode(2496, 0, "StatementExpression", null, null);
      tmp[0].setProduction(tmp);
      tmp[2].setParentProduction(Generator.prod__semicolon2_ExpressionStatement__StatementExpression_layouts_LAYOUTLIST_lit___59_);
      return tmp;
	}
  }
	
  private static class IfThenStatement {
    public final static AbstractStackNode[] prod__if_IfThenStatement__lit_if_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_Statement_ = _init_prod__if_IfThenStatement__lit_if_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_Statement_();
    private static final AbstractStackNode[] _init_prod__if_IfThenStatement__lit_if_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_Statement_() {
      AbstractStackNode[] tmp = new AbstractStackNode[9];
      
      tmp[8] = new NonTerminalStackNode(2522, 8, "Statement", null, null);
      tmp[8].setProduction(tmp);
      tmp[7] = new NonTerminalStackNode(2520, 7, "layouts_LAYOUTLIST", null, null);
      tmp[7].setProduction(tmp);
      tmp[6] = new LiteralStackNode(2518, 6, prod__lit___41__char_class___range__41_41_, new char[] {41}, null, null);
      tmp[6].setProduction(tmp);
      tmp[5] = new NonTerminalStackNode(2516, 5, "layouts_LAYOUTLIST", null, null);
      tmp[5].setProduction(tmp);
      tmp[4] = new NonTerminalStackNode(2514, 4, "Expression", null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(2512, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new LiteralStackNode(2510, 2, prod__lit___40__char_class___range__40_40_, new char[] {40}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(2508, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(2506, 0, prod__lit_if__char_class___range__105_105_char_class___range__102_102_, new char[] {105,102}, null, null);
      tmp[0].setProduction(tmp);
      tmp[8].setParentProduction(Generator.prod__if_IfThenStatement__lit_if_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_Statement_);
      return tmp;
	}
  }
	
  private static class ForStatementNoShortIf {
    public final static AbstractStackNode[] prod__for_semicolon_semicolon_ForStatementNoShortIf__lit_for_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_opt__ForInit_layouts_LAYOUTLIST_lit___59_layouts_LAYOUTLIST_opt__Expression_layouts_LAYOUTLIST_lit___59_layouts_LAYOUTLIST_opt__ForUpdate_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_StatementNoShortIf_ = _init_prod__for_semicolon_semicolon_ForStatementNoShortIf__lit_for_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_opt__ForInit_layouts_LAYOUTLIST_lit___59_layouts_LAYOUTLIST_opt__Expression_layouts_LAYOUTLIST_lit___59_layouts_LAYOUTLIST_opt__ForUpdate_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_StatementNoShortIf_();
    private static final AbstractStackNode[] _init_prod__for_semicolon_semicolon_ForStatementNoShortIf__lit_for_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_opt__ForInit_layouts_LAYOUTLIST_lit___59_layouts_LAYOUTLIST_opt__Expression_layouts_LAYOUTLIST_lit___59_layouts_LAYOUTLIST_opt__ForUpdate_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_StatementNoShortIf_() {
      AbstractStackNode[] tmp = new AbstractStackNode[17];
      
      tmp[16] = new NonTerminalStackNode(2578, 16, "StatementNoShortIf", null, null);
      tmp[16].setProduction(tmp);
      tmp[15] = new NonTerminalStackNode(2576, 15, "layouts_LAYOUTLIST", null, null);
      tmp[15].setProduction(tmp);
      tmp[14] = new LiteralStackNode(2574, 14, prod__lit___41__char_class___range__41_41_, new char[] {41}, null, null);
      tmp[14].setProduction(tmp);
      tmp[13] = new NonTerminalStackNode(2572, 13, "layouts_LAYOUTLIST", null, null);
      tmp[13].setProduction(tmp);
      tmp[12] = new OptionalStackNode(2568, 12, regular__opt__ForUpdate, new NonTerminalStackNode(2570, 0, "ForUpdate", null, null), null, null);
      tmp[12].setProduction(tmp);
      tmp[11] = new NonTerminalStackNode(2566, 11, "layouts_LAYOUTLIST", null, null);
      tmp[11].setProduction(tmp);
      tmp[10] = new LiteralStackNode(2564, 10, prod__lit___59__char_class___range__59_59_, new char[] {59}, null, null);
      tmp[10].setProduction(tmp);
      tmp[9] = new NonTerminalStackNode(2562, 9, "layouts_LAYOUTLIST", null, null);
      tmp[9].setProduction(tmp);
      tmp[8] = new OptionalStackNode(2558, 8, regular__opt__Expression, new NonTerminalStackNode(2560, 0, "Expression", null, null), null, null);
      tmp[8].setProduction(tmp);
      tmp[7] = new NonTerminalStackNode(2556, 7, "layouts_LAYOUTLIST", null, null);
      tmp[7].setProduction(tmp);
      tmp[6] = new LiteralStackNode(2554, 6, prod__lit___59__char_class___range__59_59_, new char[] {59}, null, null);
      tmp[6].setProduction(tmp);
      tmp[5] = new NonTerminalStackNode(2552, 5, "layouts_LAYOUTLIST", null, null);
      tmp[5].setProduction(tmp);
      tmp[4] = new OptionalStackNode(2548, 4, regular__opt__ForInit, new NonTerminalStackNode(2550, 0, "ForInit", null, null), null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(2546, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new LiteralStackNode(2544, 2, prod__lit___40__char_class___range__40_40_, new char[] {40}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(2542, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(2540, 0, prod__lit_for__char_class___range__102_102_char_class___range__111_111_char_class___range__114_114_, new char[] {102,111,114}, null, null);
      tmp[0].setProduction(tmp);
      tmp[16].setParentProduction(Generator.prod__for_semicolon_semicolon_ForStatementNoShortIf__lit_for_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_opt__ForInit_layouts_LAYOUTLIST_lit___59_layouts_LAYOUTLIST_opt__Expression_layouts_LAYOUTLIST_lit___59_layouts_LAYOUTLIST_opt__ForUpdate_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_StatementNoShortIf_);
      return tmp;
	}
  }
	
  private static class File {
    public final static AbstractStackNode[] prod__file_with_header_File__FileHeader_layouts_LAYOUTLIST_CompilationUnit_ = _init_prod__file_with_header_File__FileHeader_layouts_LAYOUTLIST_CompilationUnit_();
    private static final AbstractStackNode[] _init_prod__file_with_header_File__FileHeader_layouts_LAYOUTLIST_CompilationUnit_() {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new NonTerminalStackNode(2614, 2, "CompilationUnit", null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(2612, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new NonTerminalStackNode(2610, 0, "FileHeader", null, null);
      tmp[0].setProduction(tmp);
      tmp[2].setParentProduction(Generator.prod__file_with_header_File__FileHeader_layouts_LAYOUTLIST_CompilationUnit_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__File__opt__lit___47_layouts_LAYOUTLIST_iter_seps__Identifier__layouts_LAYOUTLIST_lit___47_layouts_LAYOUTLIST_layouts_LAYOUTLIST_opt__seq___lit___46_layouts_LAYOUTLIST_Identifier_ = _init_prod__File__opt__lit___47_layouts_LAYOUTLIST_iter_seps__Identifier__layouts_LAYOUTLIST_lit___47_layouts_LAYOUTLIST_layouts_LAYOUTLIST_opt__seq___lit___46_layouts_LAYOUTLIST_Identifier_();
    private static final AbstractStackNode[] _init_prod__File__opt__lit___47_layouts_LAYOUTLIST_iter_seps__Identifier__layouts_LAYOUTLIST_lit___47_layouts_LAYOUTLIST_layouts_LAYOUTLIST_opt__seq___lit___46_layouts_LAYOUTLIST_Identifier_() {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new OptionalStackNode(2634, 4, regular__opt__seq___lit___46_layouts_LAYOUTLIST_Identifier, new SequenceStackNode(2636, 0, regular__seq___lit___46_layouts_LAYOUTLIST_Identifier, new AbstractStackNode[]{new LiteralStackNode(2638, 0, prod__lit___46__char_class___range__46_46_, new char[] {46}, null, null), new NonTerminalStackNode(2640, 1, "layouts_LAYOUTLIST", null, null), new NonTerminalStackNode(2642, 2, "Identifier", null, null)}, null, null), null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(2632, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new SeparatedListStackNode(2622, 2, regular__iter_seps__Identifier__layouts_LAYOUTLIST_lit___47_layouts_LAYOUTLIST, new NonTerminalStackNode(2624, 0, "Identifier", null, null), new AbstractStackNode[]{new NonTerminalStackNode(2626, 1, "layouts_LAYOUTLIST", null, null), new LiteralStackNode(2628, 2, prod__lit___47__char_class___range__47_47_, new char[] {47}, null, null), new NonTerminalStackNode(2630, 3, "layouts_LAYOUTLIST", null, null)}, true, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(2620, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new OptionalStackNode(2616, 0, regular__opt__lit___47, new LiteralStackNode(2618, 0, prod__lit___47__char_class___range__47_47_, new char[] {47}, null, null), null, null);
      tmp[0].setProduction(tmp);
      tmp[4].setParentProduction(Generator.prod__File__opt__lit___47_layouts_LAYOUTLIST_iter_seps__Identifier__layouts_LAYOUTLIST_lit___47_layouts_LAYOUTLIST_layouts_LAYOUTLIST_opt__seq___lit___46_layouts_LAYOUTLIST_Identifier_);
      return tmp;
	}
  }
	
  private static class SwitchBlock {
    public final static AbstractStackNode[] prod__SwitchBlockStatementGroup_s_SwitchLabel_s_SwitchBlock__lit___123_layouts_LAYOUTLIST_iter_star_seps__SwitchBlockStatementGroup__layouts_LAYOUTLIST_layouts_LAYOUTLIST_iter_star_seps__SwitchLabel__layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___125_ = _init_prod__SwitchBlockStatementGroup_s_SwitchLabel_s_SwitchBlock__lit___123_layouts_LAYOUTLIST_iter_star_seps__SwitchBlockStatementGroup__layouts_LAYOUTLIST_layouts_LAYOUTLIST_iter_star_seps__SwitchLabel__layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___125_();
    private static final AbstractStackNode[] _init_prod__SwitchBlockStatementGroup_s_SwitchLabel_s_SwitchBlock__lit___123_layouts_LAYOUTLIST_iter_star_seps__SwitchBlockStatementGroup__layouts_LAYOUTLIST_layouts_LAYOUTLIST_iter_star_seps__SwitchLabel__layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___125_() {
      AbstractStackNode[] tmp = new AbstractStackNode[7];
      
      tmp[6] = new LiteralStackNode(2666, 6, prod__lit___125__char_class___range__125_125_, new char[] {125}, null, null);
      tmp[6].setProduction(tmp);
      tmp[5] = new NonTerminalStackNode(2664, 5, "layouts_LAYOUTLIST", null, null);
      tmp[5].setProduction(tmp);
      tmp[4] = new SeparatedListStackNode(2658, 4, regular__iter_star_seps__SwitchLabel__layouts_LAYOUTLIST, new NonTerminalStackNode(2660, 0, "SwitchLabel", null, null), new AbstractStackNode[]{new NonTerminalStackNode(2662, 1, "layouts_LAYOUTLIST", null, null)}, false, null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(2656, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new SeparatedListStackNode(2650, 2, regular__iter_star_seps__SwitchBlockStatementGroup__layouts_LAYOUTLIST, new NonTerminalStackNode(2652, 0, "SwitchBlockStatementGroup", null, null), new AbstractStackNode[]{new NonTerminalStackNode(2654, 1, "layouts_LAYOUTLIST", null, null)}, false, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(2648, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(2646, 0, prod__lit___123__char_class___range__123_123_, new char[] {123}, null, null);
      tmp[0].setProduction(tmp);
      tmp[6].setParentProduction(Generator.prod__SwitchBlockStatementGroup_s_SwitchLabel_s_SwitchBlock__lit___123_layouts_LAYOUTLIST_iter_star_seps__SwitchBlockStatementGroup__layouts_LAYOUTLIST_layouts_LAYOUTLIST_iter_star_seps__SwitchLabel__layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___125_);
      return tmp;
	}
  }
	
  private static class FileHeader {
    public final static AbstractStackNode[] prod__FileHeader__lit___70_73_76_69_58_iter_star__char_class___range__0_9_range__11_65535_lit___10_ = _init_prod__FileHeader__lit___70_73_76_69_58_iter_star__char_class___range__0_9_range__11_65535_lit___10_();
    private static final AbstractStackNode[] _init_prod__FileHeader__lit___70_73_76_69_58_iter_star__char_class___range__0_9_range__11_65535_lit___10_() {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new LiteralStackNode(2700, 2, prod__lit___10__char_class___range__10_10_, new char[] {10}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new ListStackNode(2696, 1, regular__iter_star__char_class___range__0_9_range__11_65535, new CharStackNode(2698, 0, new char[][]{{0,9},{11,65535}}, null, null), false, null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(2694, 0, prod__lit___70_73_76_69_58__char_class___range__70_70_char_class___range__73_73_char_class___range__76_76_char_class___range__69_69_char_class___range__58_58_, new char[] {70,73,76,69,58}, null, null);
      tmp[0].setProduction(tmp);
      tmp[2].setParentProduction(Generator.prod__FileHeader__lit___70_73_76_69_58_iter_star__char_class___range__0_9_range__11_65535_lit___10_);
      return tmp;
	}
  }
	
  private static class LeftHandSide {
    public final static AbstractStackNode[] prod__FieldAccess1_LeftHandSide__FieldAccess_ = _init_prod__FieldAccess1_LeftHandSide__FieldAccess_();
    private static final AbstractStackNode[] _init_prod__FieldAccess1_LeftHandSide__FieldAccess_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(2732, 0, "FieldAccess", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__FieldAccess1_LeftHandSide__FieldAccess_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__ArrayAccess1_LeftHandSide__ArrayAccess_ = _init_prod__ArrayAccess1_LeftHandSide__ArrayAccess_();
    private static final AbstractStackNode[] _init_prod__ArrayAccess1_LeftHandSide__ArrayAccess_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(2734, 0, "ArrayAccess", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__ArrayAccess1_LeftHandSide__ArrayAccess_);
      return tmp;
	}
  }
	
  private static class ConstructorDeclarator {
    public final static AbstractStackNode[] prod__comma5_ConstructorDeclarator__SimpleName_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_iter_star_seps__FormalParameter__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41_ = _init_prod__comma5_ConstructorDeclarator__SimpleName_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_iter_star_seps__FormalParameter__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41_();
    private static final AbstractStackNode[] _init_prod__comma5_ConstructorDeclarator__SimpleName_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_iter_star_seps__FormalParameter__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41_() {
      AbstractStackNode[] tmp = new AbstractStackNode[7];
      
      tmp[6] = new LiteralStackNode(2764, 6, prod__lit___41__char_class___range__41_41_, new char[] {41}, null, null);
      tmp[6].setProduction(tmp);
      tmp[5] = new NonTerminalStackNode(2762, 5, "layouts_LAYOUTLIST", null, null);
      tmp[5].setProduction(tmp);
      tmp[4] = new SeparatedListStackNode(2752, 4, regular__iter_star_seps__FormalParameter__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST, new NonTerminalStackNode(2754, 0, "FormalParameter", null, null), new AbstractStackNode[]{new NonTerminalStackNode(2756, 1, "layouts_LAYOUTLIST", null, null), new LiteralStackNode(2758, 2, prod__lit___44__char_class___range__44_44_, new char[] {44}, null, null), new NonTerminalStackNode(2760, 3, "layouts_LAYOUTLIST", null, null)}, false, null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(2750, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new LiteralStackNode(2748, 2, prod__lit___40__char_class___range__40_40_, new char[] {40}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(2746, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new NonTerminalStackNode(2744, 0, "SimpleName", null, null);
      tmp[0].setProduction(tmp);
      tmp[6].setParentProduction(Generator.prod__comma5_ConstructorDeclarator__SimpleName_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_iter_star_seps__FormalParameter__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41_);
      return tmp;
	}
  }
	
  private static class AbstractMethodDeclaration {
    public final static AbstractStackNode[] prod__semicolon4_AbstractMethodDeclaration__MethodHeader_layouts_LAYOUTLIST_lit___59_ = _init_prod__semicolon4_AbstractMethodDeclaration__MethodHeader_layouts_LAYOUTLIST_lit___59_();
    private static final AbstractStackNode[] _init_prod__semicolon4_AbstractMethodDeclaration__MethodHeader_layouts_LAYOUTLIST_lit___59_() {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new LiteralStackNode(2774, 2, prod__lit___59__char_class___range__59_59_, new char[] {59}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(2772, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new NonTerminalStackNode(2770, 0, "MethodHeader", null, null);
      tmp[0].setProduction(tmp);
      tmp[2].setParentProduction(Generator.prod__semicolon4_AbstractMethodDeclaration__MethodHeader_layouts_LAYOUTLIST_lit___59_);
      return tmp;
	}
  }
	
  private static class ExtendsInterfaces {
    public final static AbstractStackNode[] prod__extends_comma_ExtendsInterfaces__conditional__lit_extends__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_iter_seps__InterfaceType__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_ = _init_prod__extends_comma_ExtendsInterfaces__conditional__lit_extends__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_iter_seps__InterfaceType__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_();
    private static final AbstractStackNode[] _init_prod__extends_comma_ExtendsInterfaces__conditional__lit_extends__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_iter_seps__InterfaceType__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_() {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new SeparatedListStackNode(2788, 2, regular__iter_seps__InterfaceType__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST, new NonTerminalStackNode(2790, 0, "InterfaceType", null, null), new AbstractStackNode[]{new NonTerminalStackNode(2792, 1, "layouts_LAYOUTLIST", null, null), new LiteralStackNode(2794, 2, prod__lit___44__char_class___range__44_44_, new char[] {44}, null, null), new NonTerminalStackNode(2796, 3, "layouts_LAYOUTLIST", null, null)}, true, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(2786, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(2784, 0, prod__lit_extends__char_class___range__101_101_char_class___range__120_120_char_class___range__116_116_char_class___range__101_101_char_class___range__110_110_char_class___range__100_100_char_class___range__115_115_, new char[] {101,120,116,101,110,100,115}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[2].setParentProduction(Generator.prod__extends_comma_ExtendsInterfaces__conditional__lit_extends__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_iter_seps__InterfaceType__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_);
      return tmp;
	}
  }
	
  private static class IntegerLiteral {
    public final static AbstractStackNode[] prod__DecimalIntegerLiteral_IntegerLiteral__conditional__DecimalIntegerLiteral__not_follow__char_class___range__46_46_range__48_57_range__65_90_range__95_95_range__97_122__tag__NotSupported___112_114_101_102_101_114 = _init_prod__DecimalIntegerLiteral_IntegerLiteral__conditional__DecimalIntegerLiteral__not_follow__char_class___range__46_46_range__48_57_range__65_90_range__95_95_range__97_122__tag__NotSupported___112_114_101_102_101_114();
    private static final AbstractStackNode[] _init_prod__DecimalIntegerLiteral_IntegerLiteral__conditional__DecimalIntegerLiteral__not_follow__char_class___range__46_46_range__48_57_range__65_90_range__95_95_range__97_122__tag__NotSupported___112_114_101_102_101_114() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(2798, 0, "DecimalIntegerLiteral", null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{46,46},{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__DecimalIntegerLiteral_IntegerLiteral__conditional__DecimalIntegerLiteral__not_follow__char_class___range__46_46_range__48_57_range__65_90_range__95_95_range__97_122__tag__NotSupported___112_114_101_102_101_114);
      return tmp;
	}
    public final static AbstractStackNode[] prod__OctalIntegerLiteral_IntegerLiteral__conditional__OctalIntegerLiteral__not_follow__char_class___range__46_46_range__48_57_range__65_90_range__95_95_range__97_122__tag__NotSupported___112_114_101_102_101_114 = _init_prod__OctalIntegerLiteral_IntegerLiteral__conditional__OctalIntegerLiteral__not_follow__char_class___range__46_46_range__48_57_range__65_90_range__95_95_range__97_122__tag__NotSupported___112_114_101_102_101_114();
    private static final AbstractStackNode[] _init_prod__OctalIntegerLiteral_IntegerLiteral__conditional__OctalIntegerLiteral__not_follow__char_class___range__46_46_range__48_57_range__65_90_range__95_95_range__97_122__tag__NotSupported___112_114_101_102_101_114() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(2800, 0, "OctalIntegerLiteral", null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{46,46},{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__OctalIntegerLiteral_IntegerLiteral__conditional__OctalIntegerLiteral__not_follow__char_class___range__46_46_range__48_57_range__65_90_range__95_95_range__97_122__tag__NotSupported___112_114_101_102_101_114);
      return tmp;
	}
    public final static AbstractStackNode[] prod__HexIntegerLiteral_IntegerLiteral__conditional__HexIntegerLiteral__not_follow__char_class___range__46_46_range__48_57_range__65_90_range__95_95_range__97_122__tag__NotSupported___112_114_101_102_101_114 = _init_prod__HexIntegerLiteral_IntegerLiteral__conditional__HexIntegerLiteral__not_follow__char_class___range__46_46_range__48_57_range__65_90_range__95_95_range__97_122__tag__NotSupported___112_114_101_102_101_114();
    private static final AbstractStackNode[] _init_prod__HexIntegerLiteral_IntegerLiteral__conditional__HexIntegerLiteral__not_follow__char_class___range__46_46_range__48_57_range__65_90_range__95_95_range__97_122__tag__NotSupported___112_114_101_102_101_114() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(2802, 0, "HexIntegerLiteral", null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{46,46},{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__HexIntegerLiteral_IntegerLiteral__conditional__HexIntegerLiteral__not_follow__char_class___range__46_46_range__48_57_range__65_90_range__95_95_range__97_122__tag__NotSupported___112_114_101_102_101_114);
      return tmp;
	}
  }
	
  private static class IfThenElseStatementNoShortIf {
    public final static AbstractStackNode[] prod__if_else_IfThenElseStatementNoShortIf__lit_if_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_StatementNoShortIf_layouts_LAYOUTLIST_conditional__lit_else__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_StatementNoShortIf_ = _init_prod__if_else_IfThenElseStatementNoShortIf__lit_if_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_StatementNoShortIf_layouts_LAYOUTLIST_conditional__lit_else__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_StatementNoShortIf_();
    private static final AbstractStackNode[] _init_prod__if_else_IfThenElseStatementNoShortIf__lit_if_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_StatementNoShortIf_layouts_LAYOUTLIST_conditional__lit_else__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_StatementNoShortIf_() {
      AbstractStackNode[] tmp = new AbstractStackNode[13];
      
      tmp[12] = new NonTerminalStackNode(2836, 12, "StatementNoShortIf", null, null);
      tmp[12].setProduction(tmp);
      tmp[11] = new NonTerminalStackNode(2834, 11, "layouts_LAYOUTLIST", null, null);
      tmp[11].setProduction(tmp);
      tmp[10] = new LiteralStackNode(2832, 10, prod__lit_else__char_class___range__101_101_char_class___range__108_108_char_class___range__115_115_char_class___range__101_101_, new char[] {101,108,115,101}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[10].setProduction(tmp);
      tmp[9] = new NonTerminalStackNode(2830, 9, "layouts_LAYOUTLIST", null, null);
      tmp[9].setProduction(tmp);
      tmp[8] = new NonTerminalStackNode(2828, 8, "StatementNoShortIf", null, null);
      tmp[8].setProduction(tmp);
      tmp[7] = new NonTerminalStackNode(2826, 7, "layouts_LAYOUTLIST", null, null);
      tmp[7].setProduction(tmp);
      tmp[6] = new LiteralStackNode(2824, 6, prod__lit___41__char_class___range__41_41_, new char[] {41}, null, null);
      tmp[6].setProduction(tmp);
      tmp[5] = new NonTerminalStackNode(2822, 5, "layouts_LAYOUTLIST", null, null);
      tmp[5].setProduction(tmp);
      tmp[4] = new NonTerminalStackNode(2820, 4, "Expression", null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(2818, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new LiteralStackNode(2816, 2, prod__lit___40__char_class___range__40_40_, new char[] {40}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(2814, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(2812, 0, prod__lit_if__char_class___range__105_105_char_class___range__102_102_, new char[] {105,102}, null, null);
      tmp[0].setProduction(tmp);
      tmp[12].setParentProduction(Generator.prod__if_else_IfThenElseStatementNoShortIf__lit_if_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_StatementNoShortIf_layouts_LAYOUTLIST_conditional__lit_else__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_StatementNoShortIf_);
      return tmp;
	}
  }
	
  private static class MethodDeclaration {
    public final static AbstractStackNode[] prod__MethodHeader_MethodBody_MethodDeclaration__MethodHeader_layouts_LAYOUTLIST_MethodBody_ = _init_prod__MethodHeader_MethodBody_MethodDeclaration__MethodHeader_layouts_LAYOUTLIST_MethodBody_();
    private static final AbstractStackNode[] _init_prod__MethodHeader_MethodBody_MethodDeclaration__MethodHeader_layouts_LAYOUTLIST_MethodBody_() {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new NonTerminalStackNode(2846, 2, "MethodBody", null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(2844, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new NonTerminalStackNode(2842, 0, "MethodHeader", null, null);
      tmp[0].setProduction(tmp);
      tmp[2].setParentProduction(Generator.prod__MethodHeader_MethodBody_MethodDeclaration__MethodHeader_layouts_LAYOUTLIST_MethodBody_);
      return tmp;
	}
  }
	
  private static class NumericType {
    public final static AbstractStackNode[] prod__IntegralType_NumericType__IntegralType_ = _init_prod__IntegralType_NumericType__IntegralType_();
    private static final AbstractStackNode[] _init_prod__IntegralType_NumericType__IntegralType_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(2872, 0, "IntegralType", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__IntegralType_NumericType__IntegralType_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__FloatingPointType_NumericType__FloatingPointType_ = _init_prod__FloatingPointType_NumericType__FloatingPointType_();
    private static final AbstractStackNode[] _init_prod__FloatingPointType_NumericType__FloatingPointType_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(2874, 0, "FloatingPointType", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__FloatingPointType_NumericType__FloatingPointType_);
      return tmp;
	}
  }
	
  private static class CompilationUnit {
    public final static AbstractStackNode[] prod__PackageDeclaration_opt_ImportDeclaration_s_TypeDeclaration_s_CompilationUnit__opt__PackageDeclaration_layouts_LAYOUTLIST_iter_star_seps__ImportDeclaration__layouts_LAYOUTLIST_layouts_LAYOUTLIST_iter_seps__TypeDeclaration__layouts_LAYOUTLIST__tag__NotSupported___112_114_101_102_101_114 = _init_prod__PackageDeclaration_opt_ImportDeclaration_s_TypeDeclaration_s_CompilationUnit__opt__PackageDeclaration_layouts_LAYOUTLIST_iter_star_seps__ImportDeclaration__layouts_LAYOUTLIST_layouts_LAYOUTLIST_iter_seps__TypeDeclaration__layouts_LAYOUTLIST__tag__NotSupported___112_114_101_102_101_114();
    private static final AbstractStackNode[] _init_prod__PackageDeclaration_opt_ImportDeclaration_s_TypeDeclaration_s_CompilationUnit__opt__PackageDeclaration_layouts_LAYOUTLIST_iter_star_seps__ImportDeclaration__layouts_LAYOUTLIST_layouts_LAYOUTLIST_iter_seps__TypeDeclaration__layouts_LAYOUTLIST__tag__NotSupported___112_114_101_102_101_114() {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new SeparatedListStackNode(2864, 4, regular__iter_seps__TypeDeclaration__layouts_LAYOUTLIST, new NonTerminalStackNode(2866, 0, "TypeDeclaration", null, null), new AbstractStackNode[]{new NonTerminalStackNode(2868, 1, "layouts_LAYOUTLIST", null, null)}, true, null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(2862, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new SeparatedListStackNode(2856, 2, regular__iter_star_seps__ImportDeclaration__layouts_LAYOUTLIST, new NonTerminalStackNode(2858, 0, "ImportDeclaration", null, null), new AbstractStackNode[]{new NonTerminalStackNode(2860, 1, "layouts_LAYOUTLIST", null, null)}, false, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(2854, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new OptionalStackNode(2850, 0, regular__opt__PackageDeclaration, new NonTerminalStackNode(2852, 0, "PackageDeclaration", null, null), null, null);
      tmp[0].setProduction(tmp);
      tmp[4].setParentProduction(Generator.prod__PackageDeclaration_opt_ImportDeclaration_s_TypeDeclaration_s_CompilationUnit__opt__PackageDeclaration_layouts_LAYOUTLIST_iter_star_seps__ImportDeclaration__layouts_LAYOUTLIST_layouts_LAYOUTLIST_iter_seps__TypeDeclaration__layouts_LAYOUTLIST__tag__NotSupported___112_114_101_102_101_114);
      return tmp;
	}
    public final static AbstractStackNode[] prod__field_CompilationUnit__FieldDeclaration_ = _init_prod__field_CompilationUnit__FieldDeclaration_();
    private static final AbstractStackNode[] _init_prod__field_CompilationUnit__FieldDeclaration_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(2870, 0, "FieldDeclaration", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__field_CompilationUnit__FieldDeclaration_);
      return tmp;
	}
  }
	
  private static class ClassInstanceCreationExpression {
    public final static AbstractStackNode[] prod__new_comma1_ClassInstanceCreationExpression__conditional__lit_new__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_ClassType_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_iter_star_seps__Expression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_ClassBody_ = _init_prod__new_comma1_ClassInstanceCreationExpression__conditional__lit_new__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_ClassType_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_iter_star_seps__Expression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_ClassBody_();
    private static final AbstractStackNode[] _init_prod__new_comma1_ClassInstanceCreationExpression__conditional__lit_new__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_ClassType_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_iter_star_seps__Expression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_ClassBody_() {
      AbstractStackNode[] tmp = new AbstractStackNode[11];
      
      tmp[10] = new NonTerminalStackNode(2904, 10, "ClassBody", null, null);
      tmp[10].setProduction(tmp);
      tmp[9] = new NonTerminalStackNode(2902, 9, "layouts_LAYOUTLIST", null, null);
      tmp[9].setProduction(tmp);
      tmp[8] = new LiteralStackNode(2900, 8, prod__lit___41__char_class___range__41_41_, new char[] {41}, null, null);
      tmp[8].setProduction(tmp);
      tmp[7] = new NonTerminalStackNode(2898, 7, "layouts_LAYOUTLIST", null, null);
      tmp[7].setProduction(tmp);
      tmp[6] = new SeparatedListStackNode(2888, 6, regular__iter_star_seps__Expression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST, new NonTerminalStackNode(2890, 0, "Expression", null, null), new AbstractStackNode[]{new NonTerminalStackNode(2892, 1, "layouts_LAYOUTLIST", null, null), new LiteralStackNode(2894, 2, prod__lit___44__char_class___range__44_44_, new char[] {44}, null, null), new NonTerminalStackNode(2896, 3, "layouts_LAYOUTLIST", null, null)}, false, null, null);
      tmp[6].setProduction(tmp);
      tmp[5] = new NonTerminalStackNode(2886, 5, "layouts_LAYOUTLIST", null, null);
      tmp[5].setProduction(tmp);
      tmp[4] = new LiteralStackNode(2884, 4, prod__lit___40__char_class___range__40_40_, new char[] {40}, null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(2882, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new NonTerminalStackNode(2880, 2, "ClassType", null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(2878, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(2876, 0, prod__lit_new__char_class___range__110_110_char_class___range__101_101_char_class___range__119_119_, new char[] {110,101,119}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[10].setParentProduction(Generator.prod__new_comma1_ClassInstanceCreationExpression__conditional__lit_new__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_ClassType_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_iter_star_seps__Expression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_ClassBody_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__new_comma_ClassInstanceCreationExpression__conditional__lit_new__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_ClassType_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_iter_star_seps__Expression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41_ = _init_prod__new_comma_ClassInstanceCreationExpression__conditional__lit_new__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_ClassType_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_iter_star_seps__Expression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41_();
    private static final AbstractStackNode[] _init_prod__new_comma_ClassInstanceCreationExpression__conditional__lit_new__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_ClassType_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_iter_star_seps__Expression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41_() {
      AbstractStackNode[] tmp = new AbstractStackNode[9];
      
      tmp[8] = new LiteralStackNode(2930, 8, prod__lit___41__char_class___range__41_41_, new char[] {41}, null, null);
      tmp[8].setProduction(tmp);
      tmp[7] = new NonTerminalStackNode(2928, 7, "layouts_LAYOUTLIST", null, null);
      tmp[7].setProduction(tmp);
      tmp[6] = new SeparatedListStackNode(2918, 6, regular__iter_star_seps__Expression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST, new NonTerminalStackNode(2920, 0, "Expression", null, null), new AbstractStackNode[]{new NonTerminalStackNode(2922, 1, "layouts_LAYOUTLIST", null, null), new LiteralStackNode(2924, 2, prod__lit___44__char_class___range__44_44_, new char[] {44}, null, null), new NonTerminalStackNode(2926, 3, "layouts_LAYOUTLIST", null, null)}, false, null, null);
      tmp[6].setProduction(tmp);
      tmp[5] = new NonTerminalStackNode(2916, 5, "layouts_LAYOUTLIST", null, null);
      tmp[5].setProduction(tmp);
      tmp[4] = new LiteralStackNode(2914, 4, prod__lit___40__char_class___range__40_40_, new char[] {40}, null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(2912, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new NonTerminalStackNode(2910, 2, "ClassType", null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(2908, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(2906, 0, prod__lit_new__char_class___range__110_110_char_class___range__101_101_char_class___range__119_119_, new char[] {110,101,119}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[8].setParentProduction(Generator.prod__new_comma_ClassInstanceCreationExpression__conditional__lit_new__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_ClassType_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_iter_star_seps__Expression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41_);
      return tmp;
	}
  }
	
  private static class Word {
    public final static AbstractStackNode[] prod__Word__conditional__iter__char_class___range__0_8_range__11_12_range__14_31_range__33_65535__not_follow__char_class___range__0_8_range__11_12_range__14_31_range__33_65535_ = _init_prod__Word__conditional__iter__char_class___range__0_8_range__11_12_range__14_31_range__33_65535__not_follow__char_class___range__0_8_range__11_12_range__14_31_range__33_65535_();
    private static final AbstractStackNode[] _init_prod__Word__conditional__iter__char_class___range__0_8_range__11_12_range__14_31_range__33_65535__not_follow__char_class___range__0_8_range__11_12_range__14_31_range__33_65535_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new ListStackNode(2932, 0, regular__iter__char_class___range__0_8_range__11_12_range__14_31_range__33_65535, new CharStackNode(2934, 0, new char[][]{{0,8},{11,12},{14,31},{33,65535}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{0,8},{11,12},{14,31},{33,65535}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__Word__conditional__iter__char_class___range__0_8_range__11_12_range__14_31_range__33_65535__not_follow__char_class___range__0_8_range__11_12_range__14_31_range__33_65535_);
      return tmp;
	}
  }
	
  private static class TypeDeclaration {
    public final static AbstractStackNode[] prod__InterfaceDeclaration_TypeDeclaration__InterfaceDeclaration_ = _init_prod__InterfaceDeclaration_TypeDeclaration__InterfaceDeclaration_();
    private static final AbstractStackNode[] _init_prod__InterfaceDeclaration_TypeDeclaration__InterfaceDeclaration_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(2968, 0, "InterfaceDeclaration", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__InterfaceDeclaration_TypeDeclaration__InterfaceDeclaration_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__semicolon5_TypeDeclaration__lit___59_ = _init_prod__semicolon5_TypeDeclaration__lit___59_();
    private static final AbstractStackNode[] _init_prod__semicolon5_TypeDeclaration__lit___59_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(2970, 0, prod__lit___59__char_class___range__59_59_, new char[] {59}, null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__semicolon5_TypeDeclaration__lit___59_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__ClassDeclaration11_TypeDeclaration__ClassDeclaration_ = _init_prod__ClassDeclaration11_TypeDeclaration__ClassDeclaration_();
    private static final AbstractStackNode[] _init_prod__ClassDeclaration11_TypeDeclaration__ClassDeclaration_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(2972, 0, "ClassDeclaration", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__ClassDeclaration11_TypeDeclaration__ClassDeclaration_);
      return tmp;
	}
  }
	
  private static class DecimalIntegerLiteral {
    public final static AbstractStackNode[] prod__DecimalIntegerLiteral__lit_0_ = _init_prod__DecimalIntegerLiteral__lit_0_();
    private static final AbstractStackNode[] _init_prod__DecimalIntegerLiteral__lit_0_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(2976, 0, prod__lit_0__char_class___range__48_48_, new char[] {48}, null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__DecimalIntegerLiteral__lit_0_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__DecimalIntegerLiteral__char_class___range__49_57_iter_star__char_class___range__48_57_ = _init_prod__DecimalIntegerLiteral__char_class___range__49_57_iter_star__char_class___range__48_57_();
    private static final AbstractStackNode[] _init_prod__DecimalIntegerLiteral__char_class___range__49_57_iter_star__char_class___range__48_57_() {
      AbstractStackNode[] tmp = new AbstractStackNode[2];
      
      tmp[1] = new ListStackNode(2980, 1, regular__iter_star__char_class___range__48_57, new CharStackNode(2982, 0, new char[][]{{48,57}}, null, null), false, null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new CharStackNode(2978, 0, new char[][]{{49,57}}, null, null);
      tmp[0].setProduction(tmp);
      tmp[1].setParentProduction(Generator.prod__DecimalIntegerLiteral__char_class___range__49_57_iter_star__char_class___range__48_57_);
      return tmp;
	}
  }
	
  private static class StringLiteral {
    public final static AbstractStackNode[] prod__StringCharacter_s_StringLiteral__lit___34_iter_star__StringCharacter_lit___34_ = _init_prod__StringCharacter_s_StringLiteral__lit___34_iter_star__StringCharacter_lit___34_();
    private static final AbstractStackNode[] _init_prod__StringCharacter_s_StringLiteral__lit___34_iter_star__StringCharacter_lit___34_() {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new LiteralStackNode(2994, 2, prod__lit___34__char_class___range__34_34_, new char[] {34}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new ListStackNode(2990, 1, regular__iter_star__StringCharacter, new NonTerminalStackNode(2992, 0, "StringCharacter", null, null), false, null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(2988, 0, prod__lit___34__char_class___range__34_34_, new char[] {34}, null, null);
      tmp[0].setProduction(tmp);
      tmp[2].setParentProduction(Generator.prod__StringCharacter_s_StringLiteral__lit___34_iter_star__StringCharacter_lit___34_);
      return tmp;
	}
  }
	
  private static class MethodRes {
    public final static AbstractStackNode[] prod__type_MethodRes__Type_ = _init_prod__type_MethodRes__Type_();
    private static final AbstractStackNode[] _init_prod__type_MethodRes__Type_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(3030, 0, "Type", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__type_MethodRes__Type_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__void_MethodRes__conditional__lit_void__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__void_MethodRes__conditional__lit_void__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__void_MethodRes__conditional__lit_void__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3032, 0, prod__lit_void__char_class___range__118_118_char_class___range__111_111_char_class___range__105_105_char_class___range__100_100_, new char[] {118,111,105,100}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__void_MethodRes__conditional__lit_void__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
  }
	
  private static class Primary {
    public final static AbstractStackNode[] prod__ArrayCreationExpression_Primary__ArrayCreationExpression_ = _init_prod__ArrayCreationExpression_Primary__ArrayCreationExpression_();
    private static final AbstractStackNode[] _init_prod__ArrayCreationExpression_Primary__ArrayCreationExpression_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(3072, 0, "ArrayCreationExpression", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__ArrayCreationExpression_Primary__ArrayCreationExpression_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__PrimaryNoNewArray_Primary__PrimaryNoNewArray_ = _init_prod__PrimaryNoNewArray_Primary__PrimaryNoNewArray_();
    private static final AbstractStackNode[] _init_prod__PrimaryNoNewArray_Primary__PrimaryNoNewArray_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(3074, 0, "PrimaryNoNewArray", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__PrimaryNoNewArray_Primary__PrimaryNoNewArray_);
      return tmp;
	}
  }
	
  private static class NullLiteral {
    public final static AbstractStackNode[] prod__NullLiteral__conditional__lit_null__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__NullLiteral__conditional__lit_null__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__NullLiteral__conditional__lit_null__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3088, 0, prod__lit_null__char_class___range__110_110_char_class___range__117_117_char_class___range__108_108_char_class___range__108_108_, new char[] {110,117,108,108}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__NullLiteral__conditional__lit_null__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
  }
	
  private static class VariableDeclarator {
    public final static AbstractStackNode[] prod__VariableDeclaratorId_VariableDeclarator__VariableDeclaratorId_ = _init_prod__VariableDeclaratorId_VariableDeclarator__VariableDeclaratorId_();
    private static final AbstractStackNode[] _init_prod__VariableDeclaratorId_VariableDeclarator__VariableDeclaratorId_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(3116, 0, "VariableDeclaratorId", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__VariableDeclaratorId_VariableDeclarator__VariableDeclaratorId_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__equal2_VariableDeclarator__VariableDeclaratorId_layouts_LAYOUTLIST_lit___61_layouts_LAYOUTLIST_VariableInitializer_ = _init_prod__equal2_VariableDeclarator__VariableDeclaratorId_layouts_LAYOUTLIST_lit___61_layouts_LAYOUTLIST_VariableInitializer_();
    private static final AbstractStackNode[] _init_prod__equal2_VariableDeclarator__VariableDeclaratorId_layouts_LAYOUTLIST_lit___61_layouts_LAYOUTLIST_VariableInitializer_() {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new NonTerminalStackNode(3126, 4, "VariableInitializer", null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(3124, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new LiteralStackNode(3122, 2, prod__lit___61__char_class___range__61_61_, new char[] {61}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(3120, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new NonTerminalStackNode(3118, 0, "VariableDeclaratorId", null, null);
      tmp[0].setProduction(tmp);
      tmp[4].setParentProduction(Generator.prod__equal2_VariableDeclarator__VariableDeclaratorId_layouts_LAYOUTLIST_lit___61_layouts_LAYOUTLIST_VariableInitializer_);
      return tmp;
	}
  }
	
  private static class CatchClause {
    public final static AbstractStackNode[] prod__catch_CatchClause__conditional__lit_catch__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_FormalParameter_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_Block_ = _init_prod__catch_CatchClause__conditional__lit_catch__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_FormalParameter_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_Block_();
    private static final AbstractStackNode[] _init_prod__catch_CatchClause__conditional__lit_catch__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_FormalParameter_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_Block_() {
      AbstractStackNode[] tmp = new AbstractStackNode[9];
      
      tmp[8] = new NonTerminalStackNode(3148, 8, "Block", null, null);
      tmp[8].setProduction(tmp);
      tmp[7] = new NonTerminalStackNode(3146, 7, "layouts_LAYOUTLIST", null, null);
      tmp[7].setProduction(tmp);
      tmp[6] = new LiteralStackNode(3144, 6, prod__lit___41__char_class___range__41_41_, new char[] {41}, null, null);
      tmp[6].setProduction(tmp);
      tmp[5] = new NonTerminalStackNode(3142, 5, "layouts_LAYOUTLIST", null, null);
      tmp[5].setProduction(tmp);
      tmp[4] = new NonTerminalStackNode(3140, 4, "FormalParameter", null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(3138, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new LiteralStackNode(3136, 2, prod__lit___40__char_class___range__40_40_, new char[] {40}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(3134, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(3132, 0, prod__lit_catch__char_class___range__99_99_char_class___range__97_97_char_class___range__116_116_char_class___range__99_99_char_class___range__104_104_, new char[] {99,97,116,99,104}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[8].setParentProduction(Generator.prod__catch_CatchClause__conditional__lit_catch__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_FormalParameter_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_Block_);
      return tmp;
	}
  }
	
  private static class VariableDeclaratorId {
    public final static AbstractStackNode[] prod__VariableDeclaratorId1_VariableDeclaratorId__VariableDeclaratorId_layouts_LAYOUTLIST_lit___91_layouts_LAYOUTLIST_lit___93_ = _init_prod__VariableDeclaratorId1_VariableDeclaratorId__VariableDeclaratorId_layouts_LAYOUTLIST_lit___91_layouts_LAYOUTLIST_lit___93_();
    private static final AbstractStackNode[] _init_prod__VariableDeclaratorId1_VariableDeclaratorId__VariableDeclaratorId_layouts_LAYOUTLIST_lit___91_layouts_LAYOUTLIST_lit___93_() {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new LiteralStackNode(3158, 4, prod__lit___93__char_class___range__93_93_, new char[] {93}, null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(3156, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new LiteralStackNode(3154, 2, prod__lit___91__char_class___range__91_91_, new char[] {91}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(3152, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new NonTerminalStackNode(3150, 0, "VariableDeclaratorId", null, null);
      tmp[0].setProduction(tmp);
      tmp[4].setParentProduction(Generator.prod__VariableDeclaratorId1_VariableDeclaratorId__VariableDeclaratorId_layouts_LAYOUTLIST_lit___91_layouts_LAYOUTLIST_lit___93_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__Identifier1_VariableDeclaratorId__conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__Identifier1_VariableDeclaratorId__conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__Identifier1_VariableDeclaratorId__conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(3160, 0, "Identifier", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__Identifier1_VariableDeclaratorId__conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
  }
	
  private static class layouts_$BACKTICKS {
    public final static AbstractStackNode[] prod__layouts_$BACKTICKS__ = _init_prod__layouts_$BACKTICKS__();
    private static final AbstractStackNode[] _init_prod__layouts_$BACKTICKS__() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new EpsilonStackNode(3172, 0);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__layouts_$BACKTICKS__);
      return tmp;
	}
  }
	
  private static class InterfaceType {
    public final static AbstractStackNode[] prod__ClassOrInterfaceType2_InterfaceType__ClassOrInterfaceType_ = _init_prod__ClassOrInterfaceType2_InterfaceType__ClassOrInterfaceType_();
    private static final AbstractStackNode[] _init_prod__ClassOrInterfaceType2_InterfaceType__ClassOrInterfaceType_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(3174, 0, "ClassOrInterfaceType", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__ClassOrInterfaceType2_InterfaceType__ClassOrInterfaceType_);
      return tmp;
	}
  }
	
  private static class TypeImportOnDemandDeclaration {
    public final static AbstractStackNode[] prod__import_times_semicolon_TypeImportOnDemandDeclaration__conditional__lit_import__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Name_layouts_LAYOUTLIST_lit___46_layouts_LAYOUTLIST_lit___42_layouts_LAYOUTLIST_lit___59_ = _init_prod__import_times_semicolon_TypeImportOnDemandDeclaration__conditional__lit_import__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Name_layouts_LAYOUTLIST_lit___46_layouts_LAYOUTLIST_lit___42_layouts_LAYOUTLIST_lit___59_();
    private static final AbstractStackNode[] _init_prod__import_times_semicolon_TypeImportOnDemandDeclaration__conditional__lit_import__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Name_layouts_LAYOUTLIST_lit___46_layouts_LAYOUTLIST_lit___42_layouts_LAYOUTLIST_lit___59_() {
      AbstractStackNode[] tmp = new AbstractStackNode[9];
      
      tmp[8] = new LiteralStackNode(3192, 8, prod__lit___59__char_class___range__59_59_, new char[] {59}, null, null);
      tmp[8].setProduction(tmp);
      tmp[7] = new NonTerminalStackNode(3190, 7, "layouts_LAYOUTLIST", null, null);
      tmp[7].setProduction(tmp);
      tmp[6] = new LiteralStackNode(3188, 6, prod__lit___42__char_class___range__42_42_, new char[] {42}, null, null);
      tmp[6].setProduction(tmp);
      tmp[5] = new NonTerminalStackNode(3186, 5, "layouts_LAYOUTLIST", null, null);
      tmp[5].setProduction(tmp);
      tmp[4] = new LiteralStackNode(3184, 4, prod__lit___46__char_class___range__46_46_, new char[] {46}, null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(3182, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new NonTerminalStackNode(3180, 2, "Name", null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(3178, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(3176, 0, prod__lit_import__char_class___range__105_105_char_class___range__109_109_char_class___range__112_112_char_class___range__111_111_char_class___range__114_114_char_class___range__116_116_, new char[] {105,109,112,111,114,116}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[8].setParentProduction(Generator.prod__import_times_semicolon_TypeImportOnDemandDeclaration__conditional__lit_import__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Name_layouts_LAYOUTLIST_lit___46_layouts_LAYOUTLIST_lit___42_layouts_LAYOUTLIST_lit___59_);
      return tmp;
	}
  }
	
  private static class ReturnStatement {
    public final static AbstractStackNode[] prod__return_semicolon_ReturnStatement__conditional__lit_return__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_opt__Expression_layouts_LAYOUTLIST_lit___59_ = _init_prod__return_semicolon_ReturnStatement__conditional__lit_return__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_opt__Expression_layouts_LAYOUTLIST_lit___59_();
    private static final AbstractStackNode[] _init_prod__return_semicolon_ReturnStatement__conditional__lit_return__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_opt__Expression_layouts_LAYOUTLIST_lit___59_() {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new LiteralStackNode(3204, 4, prod__lit___59__char_class___range__59_59_, new char[] {59}, null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(3202, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new OptionalStackNode(3198, 2, regular__opt__Expression, new NonTerminalStackNode(3200, 0, "Expression", null, null), null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(3196, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(3194, 0, prod__lit_return__char_class___range__114_114_char_class___range__101_101_char_class___range__116_116_char_class___range__117_117_char_class___range__114_114_char_class___range__110_110_, new char[] {114,101,116,117,114,110}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[4].setParentProduction(Generator.prod__return_semicolon_ReturnStatement__conditional__lit_return__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_opt__Expression_layouts_LAYOUTLIST_lit___59_);
      return tmp;
	}
  }
	
  private static class WhileStatementNoShortIf {
    public final static AbstractStackNode[] prod__while1_WhileStatementNoShortIf__lit_while_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_StatementNoShortIf_ = _init_prod__while1_WhileStatementNoShortIf__lit_while_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_StatementNoShortIf_();
    private static final AbstractStackNode[] _init_prod__while1_WhileStatementNoShortIf__lit_while_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_StatementNoShortIf_() {
      AbstractStackNode[] tmp = new AbstractStackNode[9];
      
      tmp[8] = new NonTerminalStackNode(3226, 8, "StatementNoShortIf", null, null);
      tmp[8].setProduction(tmp);
      tmp[7] = new NonTerminalStackNode(3224, 7, "layouts_LAYOUTLIST", null, null);
      tmp[7].setProduction(tmp);
      tmp[6] = new LiteralStackNode(3222, 6, prod__lit___41__char_class___range__41_41_, new char[] {41}, null, null);
      tmp[6].setProduction(tmp);
      tmp[5] = new NonTerminalStackNode(3220, 5, "layouts_LAYOUTLIST", null, null);
      tmp[5].setProduction(tmp);
      tmp[4] = new NonTerminalStackNode(3218, 4, "Expression", null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(3216, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new LiteralStackNode(3214, 2, prod__lit___40__char_class___range__40_40_, new char[] {40}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(3212, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(3210, 0, prod__lit_while__char_class___range__119_119_char_class___range__104_104_char_class___range__105_105_char_class___range__108_108_char_class___range__101_101_, new char[] {119,104,105,108,101}, null, null);
      tmp[0].setProduction(tmp);
      tmp[8].setParentProduction(Generator.prod__while1_WhileStatementNoShortIf__lit_while_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_StatementNoShortIf_);
      return tmp;
	}
  }
	
  private static class layouts_$default$ {
    public final static AbstractStackNode[] prod__layouts_$default$__ = _init_prod__layouts_$default$__();
    private static final AbstractStackNode[] _init_prod__layouts_$default$__() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new EpsilonStackNode(3248, 0);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__layouts_$default$__);
      return tmp;
	}
  }
	
  private static class DoStatement {
    public final static AbstractStackNode[] prod__do_while_semicolon_DoStatement__conditional__lit_do__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Statement_layouts_LAYOUTLIST_conditional__lit_while__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_lit___59_ = _init_prod__do_while_semicolon_DoStatement__conditional__lit_do__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Statement_layouts_LAYOUTLIST_conditional__lit_while__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_lit___59_();
    private static final AbstractStackNode[] _init_prod__do_while_semicolon_DoStatement__conditional__lit_do__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Statement_layouts_LAYOUTLIST_conditional__lit_while__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_lit___59_() {
      AbstractStackNode[] tmp = new AbstractStackNode[13];
      
      tmp[12] = new LiteralStackNode(3274, 12, prod__lit___59__char_class___range__59_59_, new char[] {59}, null, null);
      tmp[12].setProduction(tmp);
      tmp[11] = new NonTerminalStackNode(3272, 11, "layouts_LAYOUTLIST", null, null);
      tmp[11].setProduction(tmp);
      tmp[10] = new LiteralStackNode(3270, 10, prod__lit___41__char_class___range__41_41_, new char[] {41}, null, null);
      tmp[10].setProduction(tmp);
      tmp[9] = new NonTerminalStackNode(3268, 9, "layouts_LAYOUTLIST", null, null);
      tmp[9].setProduction(tmp);
      tmp[8] = new NonTerminalStackNode(3266, 8, "Expression", null, null);
      tmp[8].setProduction(tmp);
      tmp[7] = new NonTerminalStackNode(3264, 7, "layouts_LAYOUTLIST", null, null);
      tmp[7].setProduction(tmp);
      tmp[6] = new LiteralStackNode(3262, 6, prod__lit___40__char_class___range__40_40_, new char[] {40}, null, null);
      tmp[6].setProduction(tmp);
      tmp[5] = new NonTerminalStackNode(3260, 5, "layouts_LAYOUTLIST", null, null);
      tmp[5].setProduction(tmp);
      tmp[4] = new LiteralStackNode(3258, 4, prod__lit_while__char_class___range__119_119_char_class___range__104_104_char_class___range__105_105_char_class___range__108_108_char_class___range__101_101_, new char[] {119,104,105,108,101}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(3256, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new NonTerminalStackNode(3254, 2, "Statement", null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(3252, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(3250, 0, prod__lit_do__char_class___range__100_100_char_class___range__111_111_, new char[] {100,111}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[12].setParentProduction(Generator.prod__do_while_semicolon_DoStatement__conditional__lit_do__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Statement_layouts_LAYOUTLIST_conditional__lit_while__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_lit___59_);
      return tmp;
	}
  }
	
  private static class ReferenceType {
    public final static AbstractStackNode[] prod__ArrayType_ReferenceType__ArrayType_ = _init_prod__ArrayType_ReferenceType__ArrayType_();
    private static final AbstractStackNode[] _init_prod__ArrayType_ReferenceType__ArrayType_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(3290, 0, "ArrayType", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__ArrayType_ReferenceType__ArrayType_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__ClassOrInterfaceType_ReferenceType__ClassOrInterfaceType_ = _init_prod__ClassOrInterfaceType_ReferenceType__ClassOrInterfaceType_();
    private static final AbstractStackNode[] _init_prod__ClassOrInterfaceType_ReferenceType__ClassOrInterfaceType_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(3292, 0, "ClassOrInterfaceType", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__ClassOrInterfaceType_ReferenceType__ClassOrInterfaceType_);
      return tmp;
	}
  }
	
  private static class ClassDeclaration {
    public final static AbstractStackNode[] prod__class1_ClassDeclaration__iter_star_seps__Modifier__layouts_LAYOUTLIST_layouts_LAYOUTLIST_conditional__lit_class__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_opt__Super_layouts_LAYOUTLIST_opt__Interfaces_layouts_LAYOUTLIST_ClassBody_ = _init_prod__class1_ClassDeclaration__iter_star_seps__Modifier__layouts_LAYOUTLIST_layouts_LAYOUTLIST_conditional__lit_class__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_opt__Super_layouts_LAYOUTLIST_opt__Interfaces_layouts_LAYOUTLIST_ClassBody_();
    private static final AbstractStackNode[] _init_prod__class1_ClassDeclaration__iter_star_seps__Modifier__layouts_LAYOUTLIST_layouts_LAYOUTLIST_conditional__lit_class__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_opt__Super_layouts_LAYOUTLIST_opt__Interfaces_layouts_LAYOUTLIST_ClassBody_() {
      AbstractStackNode[] tmp = new AbstractStackNode[11];
      
      tmp[10] = new NonTerminalStackNode(3322, 10, "ClassBody", null, null);
      tmp[10].setProduction(tmp);
      tmp[9] = new NonTerminalStackNode(3320, 9, "layouts_LAYOUTLIST", null, null);
      tmp[9].setProduction(tmp);
      tmp[8] = new OptionalStackNode(3316, 8, regular__opt__Interfaces, new NonTerminalStackNode(3318, 0, "Interfaces", null, null), null, null);
      tmp[8].setProduction(tmp);
      tmp[7] = new NonTerminalStackNode(3314, 7, "layouts_LAYOUTLIST", null, null);
      tmp[7].setProduction(tmp);
      tmp[6] = new OptionalStackNode(3310, 6, regular__opt__Super, new NonTerminalStackNode(3312, 0, "Super", null, null), null, null);
      tmp[6].setProduction(tmp);
      tmp[5] = new NonTerminalStackNode(3308, 5, "layouts_LAYOUTLIST", null, null);
      tmp[5].setProduction(tmp);
      tmp[4] = new NonTerminalStackNode(3306, 4, "Identifier", null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(3304, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new LiteralStackNode(3302, 2, prod__lit_class__char_class___range__99_99_char_class___range__108_108_char_class___range__97_97_char_class___range__115_115_char_class___range__115_115_, new char[] {99,108,97,115,115}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(3300, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new SeparatedListStackNode(3294, 0, regular__iter_star_seps__Modifier__layouts_LAYOUTLIST, new NonTerminalStackNode(3296, 0, "Modifier", null, null), new AbstractStackNode[]{new NonTerminalStackNode(3298, 1, "layouts_LAYOUTLIST", null, null)}, false, null, null);
      tmp[0].setProduction(tmp);
      tmp[10].setParentProduction(Generator.prod__class1_ClassDeclaration__iter_star_seps__Modifier__layouts_LAYOUTLIST_layouts_LAYOUTLIST_conditional__lit_class__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_opt__Super_layouts_LAYOUTLIST_opt__Interfaces_layouts_LAYOUTLIST_ClassBody_);
      return tmp;
	}
  }
	
  private static class ConstantDeclaration {
    public final static AbstractStackNode[] prod__FieldDeclaration_ConstantDeclaration__FieldDeclaration_ = _init_prod__FieldDeclaration_ConstantDeclaration__FieldDeclaration_();
    private static final AbstractStackNode[] _init_prod__FieldDeclaration_ConstantDeclaration__FieldDeclaration_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(3336, 0, "FieldDeclaration", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__FieldDeclaration_ConstantDeclaration__FieldDeclaration_);
      return tmp;
	}
  }
	
  private static class layouts_LAYOUTLIST {
    public final static AbstractStackNode[] prod__layouts_LAYOUTLIST__conditional__iter_star__LAYOUT__not_follow__char_class___range__9_10_range__12_13_range__32_32_not_follow__lit___47_47_not_follow__lit___47_42_ = _init_prod__layouts_LAYOUTLIST__conditional__iter_star__LAYOUT__not_follow__char_class___range__9_10_range__12_13_range__32_32_not_follow__lit___47_47_not_follow__lit___47_42_();
    private static final AbstractStackNode[] _init_prod__layouts_LAYOUTLIST__conditional__iter_star__LAYOUT__not_follow__char_class___range__9_10_range__12_13_range__32_32_not_follow__lit___47_47_not_follow__lit___47_42_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new ListStackNode(3346, 0, regular__iter_star__LAYOUT, new NonTerminalStackNode(3348, 0, "LAYOUT", null, null), false, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{9,10},{12,13},{32,32}}), new StringFollowRestriction(new char[] {47,47}), new StringFollowRestriction(new char[] {47,42})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__layouts_LAYOUTLIST__conditional__iter_star__LAYOUT__not_follow__char_class___range__9_10_range__12_13_range__32_32_not_follow__lit___47_47_not_follow__lit___47_42_);
      return tmp;
	}
  }
	
  private static class ArrayType {
    public final static AbstractStackNode[] prod__Name1_ArrayType__Name_layouts_LAYOUTLIST_lit___91_layouts_LAYOUTLIST_lit___93_ = _init_prod__Name1_ArrayType__Name_layouts_LAYOUTLIST_lit___91_layouts_LAYOUTLIST_lit___93_();
    private static final AbstractStackNode[] _init_prod__Name1_ArrayType__Name_layouts_LAYOUTLIST_lit___91_layouts_LAYOUTLIST_lit___93_() {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new LiteralStackNode(3364, 4, prod__lit___93__char_class___range__93_93_, new char[] {93}, null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(3362, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new LiteralStackNode(3360, 2, prod__lit___91__char_class___range__91_91_, new char[] {91}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(3358, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new NonTerminalStackNode(3356, 0, "Name", null, null);
      tmp[0].setProduction(tmp);
      tmp[4].setParentProduction(Generator.prod__Name1_ArrayType__Name_layouts_LAYOUTLIST_lit___91_layouts_LAYOUTLIST_lit___93_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__PrimitiveType1_ArrayType__PrimitiveType_layouts_LAYOUTLIST_lit___91_layouts_LAYOUTLIST_lit___93_ = _init_prod__PrimitiveType1_ArrayType__PrimitiveType_layouts_LAYOUTLIST_lit___91_layouts_LAYOUTLIST_lit___93_();
    private static final AbstractStackNode[] _init_prod__PrimitiveType1_ArrayType__PrimitiveType_layouts_LAYOUTLIST_lit___91_layouts_LAYOUTLIST_lit___93_() {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new LiteralStackNode(3374, 4, prod__lit___93__char_class___range__93_93_, new char[] {93}, null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(3372, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new LiteralStackNode(3370, 2, prod__lit___91__char_class___range__91_91_, new char[] {91}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(3368, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new NonTerminalStackNode(3366, 0, "PrimitiveType", null, null);
      tmp[0].setProduction(tmp);
      tmp[4].setParentProduction(Generator.prod__PrimitiveType1_ArrayType__PrimitiveType_layouts_LAYOUTLIST_lit___91_layouts_LAYOUTLIST_lit___93_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__ArrayType1_ArrayType__ArrayType_layouts_LAYOUTLIST_lit___91_layouts_LAYOUTLIST_lit___93_ = _init_prod__ArrayType1_ArrayType__ArrayType_layouts_LAYOUTLIST_lit___91_layouts_LAYOUTLIST_lit___93_();
    private static final AbstractStackNode[] _init_prod__ArrayType1_ArrayType__ArrayType_layouts_LAYOUTLIST_lit___91_layouts_LAYOUTLIST_lit___93_() {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new LiteralStackNode(3384, 4, prod__lit___93__char_class___range__93_93_, new char[] {93}, null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(3382, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new LiteralStackNode(3380, 2, prod__lit___91__char_class___range__91_91_, new char[] {91}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(3378, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new NonTerminalStackNode(3376, 0, "ArrayType", null, null);
      tmp[0].setProduction(tmp);
      tmp[4].setParentProduction(Generator.prod__ArrayType1_ArrayType__ArrayType_layouts_LAYOUTLIST_lit___91_layouts_LAYOUTLIST_lit___93_);
      return tmp;
	}
  }
	
  private static class IdentifierKeywords {
    public final static AbstractStackNode[] prod__IdentifierKeywords__conditional__lit_while__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__IdentifierKeywords__conditional__lit_while__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__IdentifierKeywords__conditional__lit_while__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3386, 0, prod__lit_while__char_class___range__119_119_char_class___range__104_104_char_class___range__105_105_char_class___range__108_108_char_class___range__101_101_, new char[] {119,104,105,108,101}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__IdentifierKeywords__conditional__lit_while__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__IdentifierKeywords__conditional__lit_case__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__IdentifierKeywords__conditional__lit_case__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__IdentifierKeywords__conditional__lit_case__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3388, 0, prod__lit_case__char_class___range__99_99_char_class___range__97_97_char_class___range__115_115_char_class___range__101_101_, new char[] {99,97,115,101}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__IdentifierKeywords__conditional__lit_case__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__IdentifierKeywords__conditional__lit_char__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__IdentifierKeywords__conditional__lit_char__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__IdentifierKeywords__conditional__lit_char__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3390, 0, prod__lit_char__char_class___range__99_99_char_class___range__104_104_char_class___range__97_97_char_class___range__114_114_, new char[] {99,104,97,114}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__IdentifierKeywords__conditional__lit_char__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__IdentifierKeywords__conditional__lit_import__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__IdentifierKeywords__conditional__lit_import__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__IdentifierKeywords__conditional__lit_import__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3392, 0, prod__lit_import__char_class___range__105_105_char_class___range__109_109_char_class___range__112_112_char_class___range__111_111_char_class___range__114_114_char_class___range__116_116_, new char[] {105,109,112,111,114,116}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__IdentifierKeywords__conditional__lit_import__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__IdentifierKeywords__conditional__lit_protected__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__IdentifierKeywords__conditional__lit_protected__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__IdentifierKeywords__conditional__lit_protected__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3394, 0, prod__lit_protected__char_class___range__112_112_char_class___range__114_114_char_class___range__111_111_char_class___range__116_116_char_class___range__101_101_char_class___range__99_99_char_class___range__116_116_char_class___range__101_101_char_class___range__100_100_, new char[] {112,114,111,116,101,99,116,101,100}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__IdentifierKeywords__conditional__lit_protected__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__IdentifierKeywords__conditional__lit_double__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__IdentifierKeywords__conditional__lit_double__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__IdentifierKeywords__conditional__lit_double__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3396, 0, prod__lit_double__char_class___range__100_100_char_class___range__111_111_char_class___range__117_117_char_class___range__98_98_char_class___range__108_108_char_class___range__101_101_, new char[] {100,111,117,98,108,101}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__IdentifierKeywords__conditional__lit_double__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__IdentifierKeywords__conditional__lit_public__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__IdentifierKeywords__conditional__lit_public__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__IdentifierKeywords__conditional__lit_public__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3398, 0, prod__lit_public__char_class___range__112_112_char_class___range__117_117_char_class___range__98_98_char_class___range__108_108_char_class___range__105_105_char_class___range__99_99_, new char[] {112,117,98,108,105,99}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__IdentifierKeywords__conditional__lit_public__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__IdentifierKeywords__conditional__lit_float__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__IdentifierKeywords__conditional__lit_float__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__IdentifierKeywords__conditional__lit_float__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3400, 0, prod__lit_float__char_class___range__102_102_char_class___range__108_108_char_class___range__111_111_char_class___range__97_97_char_class___range__116_116_, new char[] {102,108,111,97,116}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__IdentifierKeywords__conditional__lit_float__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__IdentifierKeywords__conditional__lit_transient__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__IdentifierKeywords__conditional__lit_transient__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__IdentifierKeywords__conditional__lit_transient__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3402, 0, prod__lit_transient__char_class___range__116_116_char_class___range__114_114_char_class___range__97_97_char_class___range__110_110_char_class___range__115_115_char_class___range__105_105_char_class___range__101_101_char_class___range__110_110_char_class___range__116_116_, new char[] {116,114,97,110,115,105,101,110,116}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__IdentifierKeywords__conditional__lit_transient__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__IdentifierKeywords__conditional__lit_instanceof__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__IdentifierKeywords__conditional__lit_instanceof__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__IdentifierKeywords__conditional__lit_instanceof__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3404, 0, prod__lit_instanceof__char_class___range__105_105_char_class___range__110_110_char_class___range__115_115_char_class___range__116_116_char_class___range__97_97_char_class___range__110_110_char_class___range__99_99_char_class___range__101_101_char_class___range__111_111_char_class___range__102_102_, new char[] {105,110,115,116,97,110,99,101,111,102}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__IdentifierKeywords__conditional__lit_instanceof__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__IdentifierKeywords__conditional__lit_false__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__IdentifierKeywords__conditional__lit_false__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__IdentifierKeywords__conditional__lit_false__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3406, 0, prod__lit_false__char_class___range__102_102_char_class___range__97_97_char_class___range__108_108_char_class___range__115_115_char_class___range__101_101_, new char[] {102,97,108,115,101}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__IdentifierKeywords__conditional__lit_false__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__IdentifierKeywords__conditional__lit_byte__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__IdentifierKeywords__conditional__lit_byte__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__IdentifierKeywords__conditional__lit_byte__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3408, 0, prod__lit_byte__char_class___range__98_98_char_class___range__121_121_char_class___range__116_116_char_class___range__101_101_, new char[] {98,121,116,101}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__IdentifierKeywords__conditional__lit_byte__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__IdentifierKeywords__conditional__lit_final__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__IdentifierKeywords__conditional__lit_final__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__IdentifierKeywords__conditional__lit_final__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3410, 0, prod__lit_final__char_class___range__102_102_char_class___range__105_105_char_class___range__110_110_char_class___range__97_97_char_class___range__108_108_, new char[] {102,105,110,97,108}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__IdentifierKeywords__conditional__lit_final__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__IdentifierKeywords__conditional__lit_class__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__IdentifierKeywords__conditional__lit_class__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__IdentifierKeywords__conditional__lit_class__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3412, 0, prod__lit_class__char_class___range__99_99_char_class___range__108_108_char_class___range__97_97_char_class___range__115_115_char_class___range__115_115_, new char[] {99,108,97,115,115}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__IdentifierKeywords__conditional__lit_class__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__IdentifierKeywords__conditional__lit_try__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__IdentifierKeywords__conditional__lit_try__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__IdentifierKeywords__conditional__lit_try__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3414, 0, prod__lit_try__char_class___range__116_116_char_class___range__114_114_char_class___range__121_121_, new char[] {116,114,121}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__IdentifierKeywords__conditional__lit_try__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__IdentifierKeywords__conditional__lit_new__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__IdentifierKeywords__conditional__lit_new__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__IdentifierKeywords__conditional__lit_new__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3416, 0, prod__lit_new__char_class___range__110_110_char_class___range__101_101_char_class___range__119_119_, new char[] {110,101,119}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__IdentifierKeywords__conditional__lit_new__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__IdentifierKeywords__conditional__lit_finally__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__IdentifierKeywords__conditional__lit_finally__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__IdentifierKeywords__conditional__lit_finally__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3418, 0, prod__lit_finally__char_class___range__102_102_char_class___range__105_105_char_class___range__110_110_char_class___range__97_97_char_class___range__108_108_char_class___range__108_108_char_class___range__121_121_, new char[] {102,105,110,97,108,108,121}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__IdentifierKeywords__conditional__lit_finally__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__IdentifierKeywords__conditional__lit_void__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__IdentifierKeywords__conditional__lit_void__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__IdentifierKeywords__conditional__lit_void__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3420, 0, prod__lit_void__char_class___range__118_118_char_class___range__111_111_char_class___range__105_105_char_class___range__100_100_, new char[] {118,111,105,100}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__IdentifierKeywords__conditional__lit_void__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__IdentifierKeywords__conditional__lit_abstract__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__IdentifierKeywords__conditional__lit_abstract__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__IdentifierKeywords__conditional__lit_abstract__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3422, 0, prod__lit_abstract__char_class___range__97_97_char_class___range__98_98_char_class___range__115_115_char_class___range__116_116_char_class___range__114_114_char_class___range__97_97_char_class___range__99_99_char_class___range__116_116_, new char[] {97,98,115,116,114,97,99,116}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__IdentifierKeywords__conditional__lit_abstract__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__IdentifierKeywords__conditional__lit_native__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__IdentifierKeywords__conditional__lit_native__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__IdentifierKeywords__conditional__lit_native__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3424, 0, prod__lit_native__char_class___range__110_110_char_class___range__97_97_char_class___range__116_116_char_class___range__105_105_char_class___range__118_118_char_class___range__101_101_, new char[] {110,97,116,105,118,101}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__IdentifierKeywords__conditional__lit_native__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__IdentifierKeywords__conditional__lit_break__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__IdentifierKeywords__conditional__lit_break__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__IdentifierKeywords__conditional__lit_break__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3426, 0, prod__lit_break__char_class___range__98_98_char_class___range__114_114_char_class___range__101_101_char_class___range__97_97_char_class___range__107_107_, new char[] {98,114,101,97,107}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__IdentifierKeywords__conditional__lit_break__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__IdentifierKeywords__conditional__lit_switch__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__IdentifierKeywords__conditional__lit_switch__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__IdentifierKeywords__conditional__lit_switch__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3428, 0, prod__lit_switch__char_class___range__115_115_char_class___range__119_119_char_class___range__105_105_char_class___range__116_116_char_class___range__99_99_char_class___range__104_104_, new char[] {115,119,105,116,99,104}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__IdentifierKeywords__conditional__lit_switch__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__IdentifierKeywords__conditional__lit_super__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__IdentifierKeywords__conditional__lit_super__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__IdentifierKeywords__conditional__lit_super__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3430, 0, prod__lit_super__char_class___range__115_115_char_class___range__117_117_char_class___range__112_112_char_class___range__101_101_char_class___range__114_114_, new char[] {115,117,112,101,114}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__IdentifierKeywords__conditional__lit_super__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__IdentifierKeywords__conditional__lit_implements__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__IdentifierKeywords__conditional__lit_implements__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__IdentifierKeywords__conditional__lit_implements__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3432, 0, prod__lit_implements__char_class___range__105_105_char_class___range__109_109_char_class___range__112_112_char_class___range__108_108_char_class___range__101_101_char_class___range__109_109_char_class___range__101_101_char_class___range__110_110_char_class___range__116_116_char_class___range__115_115_, new char[] {105,109,112,108,101,109,101,110,116,115}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__IdentifierKeywords__conditional__lit_implements__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__IdentifierKeywords__conditional__lit_int__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__IdentifierKeywords__conditional__lit_int__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__IdentifierKeywords__conditional__lit_int__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3434, 0, prod__lit_int__char_class___range__105_105_char_class___range__110_110_char_class___range__116_116_, new char[] {105,110,116}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__IdentifierKeywords__conditional__lit_int__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__IdentifierKeywords__conditional__lit_static__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__IdentifierKeywords__conditional__lit_static__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__IdentifierKeywords__conditional__lit_static__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3436, 0, prod__lit_static__char_class___range__115_115_char_class___range__116_116_char_class___range__97_97_char_class___range__116_116_char_class___range__105_105_char_class___range__99_99_, new char[] {115,116,97,116,105,99}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__IdentifierKeywords__conditional__lit_static__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__IdentifierKeywords__conditional__lit_long__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__IdentifierKeywords__conditional__lit_long__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__IdentifierKeywords__conditional__lit_long__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3438, 0, prod__lit_long__char_class___range__108_108_char_class___range__111_111_char_class___range__110_110_char_class___range__103_103_, new char[] {108,111,110,103}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__IdentifierKeywords__conditional__lit_long__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__IdentifierKeywords__conditional__lit_throws__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__IdentifierKeywords__conditional__lit_throws__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__IdentifierKeywords__conditional__lit_throws__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3440, 0, prod__lit_throws__char_class___range__116_116_char_class___range__104_104_char_class___range__114_114_char_class___range__111_111_char_class___range__119_119_char_class___range__115_115_, new char[] {116,104,114,111,119,115}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__IdentifierKeywords__conditional__lit_throws__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__IdentifierKeywords__conditional__lit_default__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__IdentifierKeywords__conditional__lit_default__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__IdentifierKeywords__conditional__lit_default__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3442, 0, prod__lit_default__char_class___range__100_100_char_class___range__101_101_char_class___range__102_102_char_class___range__97_97_char_class___range__117_117_char_class___range__108_108_char_class___range__116_116_, new char[] {100,101,102,97,117,108,116}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__IdentifierKeywords__conditional__lit_default__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__IdentifierKeywords__conditional__lit_catch__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__IdentifierKeywords__conditional__lit_catch__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__IdentifierKeywords__conditional__lit_catch__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3444, 0, prod__lit_catch__char_class___range__99_99_char_class___range__97_97_char_class___range__116_116_char_class___range__99_99_char_class___range__104_104_, new char[] {99,97,116,99,104}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__IdentifierKeywords__conditional__lit_catch__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__IdentifierKeywords__conditional__lit_this__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__IdentifierKeywords__conditional__lit_this__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__IdentifierKeywords__conditional__lit_this__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3446, 0, prod__lit_this__char_class___range__116_116_char_class___range__104_104_char_class___range__105_105_char_class___range__115_115_, new char[] {116,104,105,115}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__IdentifierKeywords__conditional__lit_this__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__IdentifierKeywords__conditional__lit_throw__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__IdentifierKeywords__conditional__lit_throw__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__IdentifierKeywords__conditional__lit_throw__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3448, 0, prod__lit_throw__char_class___range__116_116_char_class___range__104_104_char_class___range__114_114_char_class___range__111_111_char_class___range__119_119_, new char[] {116,104,114,111,119}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__IdentifierKeywords__conditional__lit_throw__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__IdentifierKeywords__conditional__lit_interface__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__IdentifierKeywords__conditional__lit_interface__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__IdentifierKeywords__conditional__lit_interface__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3450, 0, prod__lit_interface__char_class___range__105_105_char_class___range__110_110_char_class___range__116_116_char_class___range__101_101_char_class___range__114_114_char_class___range__102_102_char_class___range__97_97_char_class___range__99_99_char_class___range__101_101_, new char[] {105,110,116,101,114,102,97,99,101}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__IdentifierKeywords__conditional__lit_interface__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__IdentifierKeywords__conditional__lit_return__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__IdentifierKeywords__conditional__lit_return__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__IdentifierKeywords__conditional__lit_return__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3452, 0, prod__lit_return__char_class___range__114_114_char_class___range__101_101_char_class___range__116_116_char_class___range__117_117_char_class___range__114_114_char_class___range__110_110_, new char[] {114,101,116,117,114,110}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__IdentifierKeywords__conditional__lit_return__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__IdentifierKeywords__conditional__lit_else__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__IdentifierKeywords__conditional__lit_else__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__IdentifierKeywords__conditional__lit_else__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3454, 0, prod__lit_else__char_class___range__101_101_char_class___range__108_108_char_class___range__115_115_char_class___range__101_101_, new char[] {101,108,115,101}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__IdentifierKeywords__conditional__lit_else__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__IdentifierKeywords__conditional__lit_synchronized__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__IdentifierKeywords__conditional__lit_synchronized__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__IdentifierKeywords__conditional__lit_synchronized__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3456, 0, prod__lit_synchronized__char_class___range__115_115_char_class___range__121_121_char_class___range__110_110_char_class___range__99_99_char_class___range__104_104_char_class___range__114_114_char_class___range__111_111_char_class___range__110_110_char_class___range__105_105_char_class___range__122_122_char_class___range__101_101_char_class___range__100_100_, new char[] {115,121,110,99,104,114,111,110,105,122,101,100}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__IdentifierKeywords__conditional__lit_synchronized__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__IdentifierKeywords__conditional__lit_if__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__IdentifierKeywords__conditional__lit_if__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__IdentifierKeywords__conditional__lit_if__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3458, 0, prod__lit_if__char_class___range__105_105_char_class___range__102_102_, new char[] {105,102}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__IdentifierKeywords__conditional__lit_if__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__IdentifierKeywords__conditional__lit_volatile__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__IdentifierKeywords__conditional__lit_volatile__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__IdentifierKeywords__conditional__lit_volatile__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3460, 0, prod__lit_volatile__char_class___range__118_118_char_class___range__111_111_char_class___range__108_108_char_class___range__97_97_char_class___range__116_116_char_class___range__105_105_char_class___range__108_108_char_class___range__101_101_, new char[] {118,111,108,97,116,105,108,101}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__IdentifierKeywords__conditional__lit_volatile__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__IdentifierKeywords__conditional__lit_null__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__IdentifierKeywords__conditional__lit_null__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__IdentifierKeywords__conditional__lit_null__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3462, 0, prod__lit_null__char_class___range__110_110_char_class___range__117_117_char_class___range__108_108_char_class___range__108_108_, new char[] {110,117,108,108}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__IdentifierKeywords__conditional__lit_null__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__IdentifierKeywords__conditional__lit_private__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__IdentifierKeywords__conditional__lit_private__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__IdentifierKeywords__conditional__lit_private__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3464, 0, prod__lit_private__char_class___range__112_112_char_class___range__114_114_char_class___range__105_105_char_class___range__118_118_char_class___range__97_97_char_class___range__116_116_char_class___range__101_101_, new char[] {112,114,105,118,97,116,101}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__IdentifierKeywords__conditional__lit_private__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__IdentifierKeywords__conditional__lit_true__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__IdentifierKeywords__conditional__lit_true__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__IdentifierKeywords__conditional__lit_true__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3466, 0, prod__lit_true__char_class___range__116_116_char_class___range__114_114_char_class___range__117_117_char_class___range__101_101_, new char[] {116,114,117,101}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__IdentifierKeywords__conditional__lit_true__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__IdentifierKeywords__conditional__lit_boolean__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__IdentifierKeywords__conditional__lit_boolean__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__IdentifierKeywords__conditional__lit_boolean__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3468, 0, prod__lit_boolean__char_class___range__98_98_char_class___range__111_111_char_class___range__111_111_char_class___range__108_108_char_class___range__101_101_char_class___range__97_97_char_class___range__110_110_, new char[] {98,111,111,108,101,97,110}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__IdentifierKeywords__conditional__lit_boolean__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__IdentifierKeywords__conditional__lit_short__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__IdentifierKeywords__conditional__lit_short__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__IdentifierKeywords__conditional__lit_short__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3470, 0, prod__lit_short__char_class___range__115_115_char_class___range__104_104_char_class___range__111_111_char_class___range__114_114_char_class___range__116_116_, new char[] {115,104,111,114,116}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__IdentifierKeywords__conditional__lit_short__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__IdentifierKeywords__conditional__lit_package__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__IdentifierKeywords__conditional__lit_package__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__IdentifierKeywords__conditional__lit_package__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3472, 0, prod__lit_package__char_class___range__112_112_char_class___range__97_97_char_class___range__99_99_char_class___range__107_107_char_class___range__97_97_char_class___range__103_103_char_class___range__101_101_, new char[] {112,97,99,107,97,103,101}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__IdentifierKeywords__conditional__lit_package__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__IdentifierKeywords__conditional__lit_continue__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__IdentifierKeywords__conditional__lit_continue__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__IdentifierKeywords__conditional__lit_continue__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3474, 0, prod__lit_continue__char_class___range__99_99_char_class___range__111_111_char_class___range__110_110_char_class___range__116_116_char_class___range__105_105_char_class___range__110_110_char_class___range__117_117_char_class___range__101_101_, new char[] {99,111,110,116,105,110,117,101}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__IdentifierKeywords__conditional__lit_continue__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__IdentifierKeywords__conditional__lit_do__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__IdentifierKeywords__conditional__lit_do__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__IdentifierKeywords__conditional__lit_do__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3476, 0, prod__lit_do__char_class___range__100_100_char_class___range__111_111_, new char[] {100,111}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__IdentifierKeywords__conditional__lit_do__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__IdentifierKeywords__conditional__lit_extends__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__IdentifierKeywords__conditional__lit_extends__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__IdentifierKeywords__conditional__lit_extends__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3478, 0, prod__lit_extends__char_class___range__101_101_char_class___range__120_120_char_class___range__116_116_char_class___range__101_101_char_class___range__110_110_char_class___range__100_100_char_class___range__115_115_, new char[] {101,120,116,101,110,100,115}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__IdentifierKeywords__conditional__lit_extends__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__IdentifierKeywords__conditional__lit_for__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__IdentifierKeywords__conditional__lit_for__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__IdentifierKeywords__conditional__lit_for__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3480, 0, prod__lit_for__char_class___range__102_102_char_class___range__111_111_char_class___range__114_114_, new char[] {102,111,114}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__IdentifierKeywords__conditional__lit_for__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
  }
	
  private static class StringCharacter {
    public final static AbstractStackNode[] prod__StringCharacter__UnicodeEscape_ = _init_prod__StringCharacter__UnicodeEscape_();
    private static final AbstractStackNode[] _init_prod__StringCharacter__UnicodeEscape_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(3482, 0, "UnicodeEscape", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__StringCharacter__UnicodeEscape_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__StringCharacter__EscapeSequence_ = _init_prod__StringCharacter__EscapeSequence_();
    private static final AbstractStackNode[] _init_prod__StringCharacter__EscapeSequence_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(3484, 0, "EscapeSequence", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__StringCharacter__EscapeSequence_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__StringCharacter__char_class___range__0_33_range__35_91_range__93_65535_ = _init_prod__StringCharacter__char_class___range__0_33_range__35_91_range__93_65535_();
    private static final AbstractStackNode[] _init_prod__StringCharacter__char_class___range__0_33_range__35_91_range__93_65535_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new CharStackNode(3486, 0, new char[][]{{0,33},{35,91},{93,65535}}, null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__StringCharacter__char_class___range__0_33_range__35_91_range__93_65535_);
      return tmp;
	}
  }
	
  private static class ClassBody {
    public final static AbstractStackNode[] prod__ClassBodyDeclaration_s_ClassBody__lit___123_layouts_LAYOUTLIST_iter_star_seps__ClassBodyDeclaration__layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___125_ = _init_prod__ClassBodyDeclaration_s_ClassBody__lit___123_layouts_LAYOUTLIST_iter_star_seps__ClassBodyDeclaration__layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___125_();
    private static final AbstractStackNode[] _init_prod__ClassBodyDeclaration_s_ClassBody__lit___123_layouts_LAYOUTLIST_iter_star_seps__ClassBodyDeclaration__layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___125_() {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new LiteralStackNode(3500, 4, prod__lit___125__char_class___range__125_125_, new char[] {125}, null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(3498, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new SeparatedListStackNode(3492, 2, regular__iter_star_seps__ClassBodyDeclaration__layouts_LAYOUTLIST, new NonTerminalStackNode(3494, 0, "ClassBodyDeclaration", null, null), new AbstractStackNode[]{new NonTerminalStackNode(3496, 1, "layouts_LAYOUTLIST", null, null)}, false, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(3490, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(3488, 0, prod__lit___123__char_class___range__123_123_, new char[] {123}, null, null);
      tmp[0].setProduction(tmp);
      tmp[4].setParentProduction(Generator.prod__ClassBodyDeclaration_s_ClassBody__lit___123_layouts_LAYOUTLIST_iter_star_seps__ClassBodyDeclaration__layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___125_);
      return tmp;
	}
  }
	
  private static class start__ANTLR {
    public final static AbstractStackNode[] prod__start__ANTLR__layouts_LAYOUTLIST_top_ANTLR_layouts_LAYOUTLIST_ = _init_prod__start__ANTLR__layouts_LAYOUTLIST_top_ANTLR_layouts_LAYOUTLIST_();
    private static final AbstractStackNode[] _init_prod__start__ANTLR__layouts_LAYOUTLIST_top_ANTLR_layouts_LAYOUTLIST_() {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new NonTerminalStackNode(3506, 2, "layouts_LAYOUTLIST", null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(3504, 1, "ANTLR", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new NonTerminalStackNode(3502, 0, "layouts_LAYOUTLIST", null, null);
      tmp[0].setProduction(tmp);
      tmp[2].setParentProduction(Generator.prod__start__ANTLR__layouts_LAYOUTLIST_top_ANTLR_layouts_LAYOUTLIST_);
      return tmp;
	}
  }
	
  private static class IntegralType {
    public final static AbstractStackNode[] prod__int_IntegralType__conditional__lit_int__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__int_IntegralType__conditional__lit_int__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__int_IntegralType__conditional__lit_int__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3508, 0, prod__lit_int__char_class___range__105_105_char_class___range__110_110_char_class___range__116_116_, new char[] {105,110,116}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__int_IntegralType__conditional__lit_int__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__byte_IntegralType__conditional__lit_byte__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__byte_IntegralType__conditional__lit_byte__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__byte_IntegralType__conditional__lit_byte__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3510, 0, prod__lit_byte__char_class___range__98_98_char_class___range__121_121_char_class___range__116_116_char_class___range__101_101_, new char[] {98,121,116,101}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__byte_IntegralType__conditional__lit_byte__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__short_IntegralType__conditional__lit_short__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__short_IntegralType__conditional__lit_short__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__short_IntegralType__conditional__lit_short__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3512, 0, prod__lit_short__char_class___range__115_115_char_class___range__104_104_char_class___range__111_111_char_class___range__114_114_char_class___range__116_116_, new char[] {115,104,111,114,116}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__short_IntegralType__conditional__lit_short__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__long_IntegralType__conditional__lit_long__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__long_IntegralType__conditional__lit_long__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__long_IntegralType__conditional__lit_long__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3514, 0, prod__lit_long__char_class___range__108_108_char_class___range__111_111_char_class___range__110_110_char_class___range__103_103_, new char[] {108,111,110,103}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__long_IntegralType__conditional__lit_long__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__char_IntegralType__conditional__lit_char__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__char_IntegralType__conditional__lit_char__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__char_IntegralType__conditional__lit_char__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3516, 0, prod__lit_char__char_class___range__99_99_char_class___range__104_104_char_class___range__97_97_char_class___range__114_114_, new char[] {99,104,97,114}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__char_IntegralType__conditional__lit_char__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
  }
	
  private static class LAYOUT {
    public final static AbstractStackNode[] prod__LAYOUT__Comment_ = _init_prod__LAYOUT__Comment_();
    private static final AbstractStackNode[] _init_prod__LAYOUT__Comment_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(3518, 0, "Comment", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__LAYOUT__Comment_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__LAYOUT__char_class___range__9_10_range__13_13_range__32_32_ = _init_prod__LAYOUT__char_class___range__9_10_range__13_13_range__32_32_();
    private static final AbstractStackNode[] _init_prod__LAYOUT__char_class___range__9_10_range__13_13_range__32_32_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new CharStackNode(3520, 0, new char[][]{{9,10},{13,13},{32,32}}, null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__LAYOUT__char_class___range__9_10_range__13_13_range__32_32_);
      return tmp;
	}
  }
	
  private static class StatementNoShortIf {
    public final static AbstractStackNode[] prod__IfThenElseStatementNoShortIf_StatementNoShortIf__IfThenElseStatementNoShortIf_ = _init_prod__IfThenElseStatementNoShortIf_StatementNoShortIf__IfThenElseStatementNoShortIf_();
    private static final AbstractStackNode[] _init_prod__IfThenElseStatementNoShortIf_StatementNoShortIf__IfThenElseStatementNoShortIf_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(3528, 0, "IfThenElseStatementNoShortIf", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__IfThenElseStatementNoShortIf_StatementNoShortIf__IfThenElseStatementNoShortIf_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__StatementWithoutTrailingSubstatement1_StatementNoShortIf__StatementWithoutTrailingSubstatement_ = _init_prod__StatementWithoutTrailingSubstatement1_StatementNoShortIf__StatementWithoutTrailingSubstatement_();
    private static final AbstractStackNode[] _init_prod__StatementWithoutTrailingSubstatement1_StatementNoShortIf__StatementWithoutTrailingSubstatement_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(3530, 0, "StatementWithoutTrailingSubstatement", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__StatementWithoutTrailingSubstatement1_StatementNoShortIf__StatementWithoutTrailingSubstatement_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__WhileStatementNoShortIf_StatementNoShortIf__WhileStatementNoShortIf_ = _init_prod__WhileStatementNoShortIf_StatementNoShortIf__WhileStatementNoShortIf_();
    private static final AbstractStackNode[] _init_prod__WhileStatementNoShortIf_StatementNoShortIf__WhileStatementNoShortIf_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(3532, 0, "WhileStatementNoShortIf", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__WhileStatementNoShortIf_StatementNoShortIf__WhileStatementNoShortIf_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__LabeledStatementNoShortIf_StatementNoShortIf__LabeledStatementNoShortIf_ = _init_prod__LabeledStatementNoShortIf_StatementNoShortIf__LabeledStatementNoShortIf_();
    private static final AbstractStackNode[] _init_prod__LabeledStatementNoShortIf_StatementNoShortIf__LabeledStatementNoShortIf_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(3534, 0, "LabeledStatementNoShortIf", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__LabeledStatementNoShortIf_StatementNoShortIf__LabeledStatementNoShortIf_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__ForStatementNoShortIf_StatementNoShortIf__ForStatementNoShortIf_ = _init_prod__ForStatementNoShortIf_StatementNoShortIf__ForStatementNoShortIf_();
    private static final AbstractStackNode[] _init_prod__ForStatementNoShortIf_StatementNoShortIf__ForStatementNoShortIf_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(3536, 0, "ForStatementNoShortIf", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__ForStatementNoShortIf_StatementNoShortIf__ForStatementNoShortIf_);
      return tmp;
	}
  }
	
  private static class StatementExpression {
    public final static AbstractStackNode[] prod__MethodInvocation_StatementExpression__MethodInvocation_ = _init_prod__MethodInvocation_StatementExpression__MethodInvocation_();
    private static final AbstractStackNode[] _init_prod__MethodInvocation_StatementExpression__MethodInvocation_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(3570, 0, "MethodInvocation", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__MethodInvocation_StatementExpression__MethodInvocation_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__incr21_StatementExpression__Expression_layouts_LAYOUTLIST_lit___43_43__tag__NotSupported___112_114_101_102_101_114 = _init_prod__incr21_StatementExpression__Expression_layouts_LAYOUTLIST_lit___43_43__tag__NotSupported___112_114_101_102_101_114();
    private static final AbstractStackNode[] _init_prod__incr21_StatementExpression__Expression_layouts_LAYOUTLIST_lit___43_43__tag__NotSupported___112_114_101_102_101_114() {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new LiteralStackNode(3576, 2, prod__lit___43_43__char_class___range__43_43_char_class___range__43_43_, new char[] {43,43}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(3574, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new NonTerminalStackNode(3572, 0, "Expression", null, null);
      tmp[0].setProduction(tmp);
      tmp[2].setParentProduction(Generator.prod__incr21_StatementExpression__Expression_layouts_LAYOUTLIST_lit___43_43__tag__NotSupported___112_114_101_102_101_114);
      return tmp;
	}
    public final static AbstractStackNode[] prod__decr21_StatementExpression__Expression_layouts_LAYOUTLIST_lit_____tag__NotSupported___112_114_101_102_101_114 = _init_prod__decr21_StatementExpression__Expression_layouts_LAYOUTLIST_lit_____tag__NotSupported___112_114_101_102_101_114();
    private static final AbstractStackNode[] _init_prod__decr21_StatementExpression__Expression_layouts_LAYOUTLIST_lit_____tag__NotSupported___112_114_101_102_101_114() {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new LiteralStackNode(3582, 2, prod__lit_____char_class___range__45_45_char_class___range__45_45_, new char[] {45,45}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(3580, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new NonTerminalStackNode(3578, 0, "Expression", null, null);
      tmp[0].setProduction(tmp);
      tmp[2].setParentProduction(Generator.prod__decr21_StatementExpression__Expression_layouts_LAYOUTLIST_lit_____tag__NotSupported___112_114_101_102_101_114);
      return tmp;
	}
    public final static AbstractStackNode[] prod__Assignment_StatementExpression__Assignment_ = _init_prod__Assignment_StatementExpression__Assignment_();
    private static final AbstractStackNode[] _init_prod__Assignment_StatementExpression__Assignment_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(3584, 0, "Assignment", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__Assignment_StatementExpression__Assignment_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__ClassInstanceCreationExpression_StatementExpression__ClassInstanceCreationExpression_ = _init_prod__ClassInstanceCreationExpression_StatementExpression__ClassInstanceCreationExpression_();
    private static final AbstractStackNode[] _init_prod__ClassInstanceCreationExpression_StatementExpression__ClassInstanceCreationExpression_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(3586, 0, "ClassInstanceCreationExpression", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__ClassInstanceCreationExpression_StatementExpression__ClassInstanceCreationExpression_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__incr31_StatementExpression__lit___43_43_layouts_LAYOUTLIST_Expression__tag__NotSupported___112_114_101_102_101_114 = _init_prod__incr31_StatementExpression__lit___43_43_layouts_LAYOUTLIST_Expression__tag__NotSupported___112_114_101_102_101_114();
    private static final AbstractStackNode[] _init_prod__incr31_StatementExpression__lit___43_43_layouts_LAYOUTLIST_Expression__tag__NotSupported___112_114_101_102_101_114() {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new NonTerminalStackNode(3592, 2, "Expression", null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(3590, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(3588, 0, prod__lit___43_43__char_class___range__43_43_char_class___range__43_43_, new char[] {43,43}, null, null);
      tmp[0].setProduction(tmp);
      tmp[2].setParentProduction(Generator.prod__incr31_StatementExpression__lit___43_43_layouts_LAYOUTLIST_Expression__tag__NotSupported___112_114_101_102_101_114);
      return tmp;
	}
    public final static AbstractStackNode[] prod__decr31_StatementExpression__lit____layouts_LAYOUTLIST_Expression__tag__NotSupported___112_114_101_102_101_114 = _init_prod__decr31_StatementExpression__lit____layouts_LAYOUTLIST_Expression__tag__NotSupported___112_114_101_102_101_114();
    private static final AbstractStackNode[] _init_prod__decr31_StatementExpression__lit____layouts_LAYOUTLIST_Expression__tag__NotSupported___112_114_101_102_101_114() {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new NonTerminalStackNode(3598, 2, "Expression", null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(3596, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(3594, 0, prod__lit_____char_class___range__45_45_char_class___range__45_45_, new char[] {45,45}, null, null);
      tmp[0].setProduction(tmp);
      tmp[2].setParentProduction(Generator.prod__decr31_StatementExpression__lit____layouts_LAYOUTLIST_Expression__tag__NotSupported___112_114_101_102_101_114);
      return tmp;
	}
  }
	
  private static class layouts_$QUOTES {
    public final static AbstractStackNode[] prod__layouts_$QUOTES__conditional__iter_star__char_class___range__9_10_range__13_13_range__32_32__not_follow__char_class___range__9_10_range__13_13_range__32_32_ = _init_prod__layouts_$QUOTES__conditional__iter_star__char_class___range__9_10_range__13_13_range__32_32__not_follow__char_class___range__9_10_range__13_13_range__32_32_();
    private static final AbstractStackNode[] _init_prod__layouts_$QUOTES__conditional__iter_star__char_class___range__9_10_range__13_13_range__32_32__not_follow__char_class___range__9_10_range__13_13_range__32_32_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new ListStackNode(3600, 0, regular__iter_star__char_class___range__9_10_range__13_13_range__32_32, new CharStackNode(3602, 0, new char[][]{{9,10},{13,13},{32,32}}, null, null), false, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{9,10},{13,13},{32,32}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__layouts_$QUOTES__conditional__iter_star__char_class___range__9_10_range__13_13_range__32_32__not_follow__char_class___range__9_10_range__13_13_range__32_32_);
      return tmp;
	}
  }
	
  private static class ConstructorDeclaration {
    public final static AbstractStackNode[] prod__Modifier_s_ConstructorDeclarator_Throws_opt_ConstructorBody_ConstructorDeclaration__iter_star_seps__Modifier__layouts_LAYOUTLIST_layouts_LAYOUTLIST_ConstructorDeclarator_layouts_LAYOUTLIST_opt__Throws_layouts_LAYOUTLIST_ConstructorBody_ = _init_prod__Modifier_s_ConstructorDeclarator_Throws_opt_ConstructorBody_ConstructorDeclaration__iter_star_seps__Modifier__layouts_LAYOUTLIST_layouts_LAYOUTLIST_ConstructorDeclarator_layouts_LAYOUTLIST_opt__Throws_layouts_LAYOUTLIST_ConstructorBody_();
    private static final AbstractStackNode[] _init_prod__Modifier_s_ConstructorDeclarator_Throws_opt_ConstructorBody_ConstructorDeclaration__iter_star_seps__Modifier__layouts_LAYOUTLIST_layouts_LAYOUTLIST_ConstructorDeclarator_layouts_LAYOUTLIST_opt__Throws_layouts_LAYOUTLIST_ConstructorBody_() {
      AbstractStackNode[] tmp = new AbstractStackNode[7];
      
      tmp[6] = new NonTerminalStackNode(3630, 6, "ConstructorBody", null, null);
      tmp[6].setProduction(tmp);
      tmp[5] = new NonTerminalStackNode(3628, 5, "layouts_LAYOUTLIST", null, null);
      tmp[5].setProduction(tmp);
      tmp[4] = new OptionalStackNode(3624, 4, regular__opt__Throws, new NonTerminalStackNode(3626, 0, "Throws", null, null), null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(3622, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new NonTerminalStackNode(3620, 2, "ConstructorDeclarator", null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(3618, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new SeparatedListStackNode(3612, 0, regular__iter_star_seps__Modifier__layouts_LAYOUTLIST, new NonTerminalStackNode(3614, 0, "Modifier", null, null), new AbstractStackNode[]{new NonTerminalStackNode(3616, 1, "layouts_LAYOUTLIST", null, null)}, false, null, null);
      tmp[0].setProduction(tmp);
      tmp[6].setParentProduction(Generator.prod__Modifier_s_ConstructorDeclarator_Throws_opt_ConstructorBody_ConstructorDeclaration__iter_star_seps__Modifier__layouts_LAYOUTLIST_layouts_LAYOUTLIST_ConstructorDeclarator_layouts_LAYOUTLIST_opt__Throws_layouts_LAYOUTLIST_ConstructorBody_);
      return tmp;
	}
  }
	
  private static class Statement {
    public final static AbstractStackNode[] prod__ForStatement_Statement__ForStatement_ = _init_prod__ForStatement_Statement__ForStatement_();
    private static final AbstractStackNode[] _init_prod__ForStatement_Statement__ForStatement_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(3632, 0, "ForStatement", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__ForStatement_Statement__ForStatement_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__IfThenElseStatement_Statement__IfThenElseStatement_ = _init_prod__IfThenElseStatement_Statement__IfThenElseStatement_();
    private static final AbstractStackNode[] _init_prod__IfThenElseStatement_Statement__IfThenElseStatement_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(3634, 0, "IfThenElseStatement", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__IfThenElseStatement_Statement__IfThenElseStatement_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__WhileStatement_Statement__WhileStatement_ = _init_prod__WhileStatement_Statement__WhileStatement_();
    private static final AbstractStackNode[] _init_prod__WhileStatement_Statement__WhileStatement_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(3636, 0, "WhileStatement", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__WhileStatement_Statement__WhileStatement_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__ClassDeclaration_Statement__ClassDeclaration_ = _init_prod__ClassDeclaration_Statement__ClassDeclaration_();
    private static final AbstractStackNode[] _init_prod__ClassDeclaration_Statement__ClassDeclaration_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(3638, 0, "ClassDeclaration", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__ClassDeclaration_Statement__ClassDeclaration_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__IfThenStatement_Statement__IfThenStatement_ = _init_prod__IfThenStatement_Statement__IfThenStatement_();
    private static final AbstractStackNode[] _init_prod__IfThenStatement_Statement__IfThenStatement_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(3640, 0, "IfThenStatement", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__IfThenStatement_Statement__IfThenStatement_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__StatementWithoutTrailingSubstatement_Statement__StatementWithoutTrailingSubstatement_ = _init_prod__StatementWithoutTrailingSubstatement_Statement__StatementWithoutTrailingSubstatement_();
    private static final AbstractStackNode[] _init_prod__StatementWithoutTrailingSubstatement_Statement__StatementWithoutTrailingSubstatement_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(3642, 0, "StatementWithoutTrailingSubstatement", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__StatementWithoutTrailingSubstatement_Statement__StatementWithoutTrailingSubstatement_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__LabeledStatement_Statement__LabeledStatement_ = _init_prod__LabeledStatement_Statement__LabeledStatement_();
    private static final AbstractStackNode[] _init_prod__LabeledStatement_Statement__LabeledStatement_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(3644, 0, "LabeledStatement", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__LabeledStatement_Statement__LabeledStatement_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__AssertStatement_Statement__AssertStatement_ = _init_prod__AssertStatement_Statement__AssertStatement_();
    private static final AbstractStackNode[] _init_prod__AssertStatement_Statement__AssertStatement_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(3646, 0, "AssertStatement", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__AssertStatement_Statement__AssertStatement_);
      return tmp;
	}
  }
	
  private static class ThrowStatement {
    public final static AbstractStackNode[] prod__throw_semicolon_ThrowStatement__conditional__lit_throw__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___59_ = _init_prod__throw_semicolon_ThrowStatement__conditional__lit_throw__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___59_();
    private static final AbstractStackNode[] _init_prod__throw_semicolon_ThrowStatement__conditional__lit_throw__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___59_() {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new LiteralStackNode(3688, 4, prod__lit___59__char_class___range__59_59_, new char[] {59}, null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(3686, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new NonTerminalStackNode(3684, 2, "Expression", null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(3682, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(3680, 0, prod__lit_throw__char_class___range__116_116_char_class___range__104_104_char_class___range__114_114_char_class___range__111_111_char_class___range__119_119_, new char[] {116,104,114,111,119}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[4].setParentProduction(Generator.prod__throw_semicolon_ThrowStatement__conditional__lit_throw__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___59_);
      return tmp;
	}
  }
	
  private static class SingleCharacter {
    public final static AbstractStackNode[] prod__SingleCharacter__char_class___range__0_38_range__40_91_range__93_65535_ = _init_prod__SingleCharacter__char_class___range__0_38_range__40_91_range__93_65535_();
    private static final AbstractStackNode[] _init_prod__SingleCharacter__char_class___range__0_38_range__40_91_range__93_65535_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new CharStackNode(3676, 0, new char[][]{{0,38},{40,91},{93,65535}}, null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__SingleCharacter__char_class___range__0_38_range__40_91_range__93_65535_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__SingleCharacter__UnicodeEscape_ = _init_prod__SingleCharacter__UnicodeEscape_();
    private static final AbstractStackNode[] _init_prod__SingleCharacter__UnicodeEscape_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(3678, 0, "UnicodeEscape", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__SingleCharacter__UnicodeEscape_);
      return tmp;
	}
  }
	
  private static class BreakStatement {
    public final static AbstractStackNode[] prod__break_semicolon_BreakStatement__conditional__lit_break__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_opt__Identifier_layouts_LAYOUTLIST_lit___59_ = _init_prod__break_semicolon_BreakStatement__conditional__lit_break__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_opt__Identifier_layouts_LAYOUTLIST_lit___59_();
    private static final AbstractStackNode[] _init_prod__break_semicolon_BreakStatement__conditional__lit_break__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_opt__Identifier_layouts_LAYOUTLIST_lit___59_() {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new LiteralStackNode(3758, 4, prod__lit___59__char_class___range__59_59_, new char[] {59}, null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(3756, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new OptionalStackNode(3752, 2, regular__opt__Identifier, new NonTerminalStackNode(3754, 0, "Identifier", null, null), null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(3750, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(3748, 0, prod__lit_break__char_class___range__98_98_char_class___range__114_114_char_class___range__101_101_char_class___range__97_97_char_class___range__107_107_, new char[] {98,114,101,97,107}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[4].setParentProduction(Generator.prod__break_semicolon_BreakStatement__conditional__lit_break__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_opt__Identifier_layouts_LAYOUTLIST_lit___59_);
      return tmp;
	}
  }
	
  private static class start__CompilationUnit {
    public final static AbstractStackNode[] prod__start__CompilationUnit__layouts_LAYOUTLIST_top_CompilationUnit_layouts_LAYOUTLIST_ = _init_prod__start__CompilationUnit__layouts_LAYOUTLIST_top_CompilationUnit_layouts_LAYOUTLIST_();
    private static final AbstractStackNode[] _init_prod__start__CompilationUnit__layouts_LAYOUTLIST_top_CompilationUnit_layouts_LAYOUTLIST_() {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new NonTerminalStackNode(3764, 2, "layouts_LAYOUTLIST", null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(3762, 1, "CompilationUnit", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new NonTerminalStackNode(3760, 0, "layouts_LAYOUTLIST", null, null);
      tmp[0].setProduction(tmp);
      tmp[2].setParentProduction(Generator.prod__start__CompilationUnit__layouts_LAYOUTLIST_top_CompilationUnit_layouts_LAYOUTLIST_);
      return tmp;
	}
  }
	
  private static class WhileStatement {
    public final static AbstractStackNode[] prod__while_WhileStatement__conditional__lit_while__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_Statement_ = _init_prod__while_WhileStatement__conditional__lit_while__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_Statement_();
    private static final AbstractStackNode[] _init_prod__while_WhileStatement__conditional__lit_while__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_Statement_() {
      AbstractStackNode[] tmp = new AbstractStackNode[9];
      
      tmp[8] = new NonTerminalStackNode(3786, 8, "Statement", null, null);
      tmp[8].setProduction(tmp);
      tmp[7] = new NonTerminalStackNode(3784, 7, "layouts_LAYOUTLIST", null, null);
      tmp[7].setProduction(tmp);
      tmp[6] = new LiteralStackNode(3782, 6, prod__lit___41__char_class___range__41_41_, new char[] {41}, null, null);
      tmp[6].setProduction(tmp);
      tmp[5] = new NonTerminalStackNode(3780, 5, "layouts_LAYOUTLIST", null, null);
      tmp[5].setProduction(tmp);
      tmp[4] = new NonTerminalStackNode(3778, 4, "Expression", null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(3776, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new LiteralStackNode(3774, 2, prod__lit___40__char_class___range__40_40_, new char[] {40}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(3772, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(3770, 0, prod__lit_while__char_class___range__119_119_char_class___range__104_104_char_class___range__105_105_char_class___range__108_108_char_class___range__101_101_, new char[] {119,104,105,108,101}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[8].setParentProduction(Generator.prod__while_WhileStatement__conditional__lit_while__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_Statement_);
      return tmp;
	}
  }
	
  private static class IfThenElseStatement {
    public final static AbstractStackNode[] prod__if_else_IfThenElseStatement__conditional__lit_if__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_StatementNoShortIf_layouts_LAYOUTLIST_conditional__lit_else__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Statement_ = _init_prod__if_else_IfThenElseStatement__conditional__lit_if__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_StatementNoShortIf_layouts_LAYOUTLIST_conditional__lit_else__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Statement_();
    private static final AbstractStackNode[] _init_prod__if_else_IfThenElseStatement__conditional__lit_if__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_StatementNoShortIf_layouts_LAYOUTLIST_conditional__lit_else__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Statement_() {
      AbstractStackNode[] tmp = new AbstractStackNode[13];
      
      tmp[12] = new NonTerminalStackNode(3812, 12, "Statement", null, null);
      tmp[12].setProduction(tmp);
      tmp[11] = new NonTerminalStackNode(3810, 11, "layouts_LAYOUTLIST", null, null);
      tmp[11].setProduction(tmp);
      tmp[10] = new LiteralStackNode(3808, 10, prod__lit_else__char_class___range__101_101_char_class___range__108_108_char_class___range__115_115_char_class___range__101_101_, new char[] {101,108,115,101}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[10].setProduction(tmp);
      tmp[9] = new NonTerminalStackNode(3806, 9, "layouts_LAYOUTLIST", null, null);
      tmp[9].setProduction(tmp);
      tmp[8] = new NonTerminalStackNode(3804, 8, "StatementNoShortIf", null, null);
      tmp[8].setProduction(tmp);
      tmp[7] = new NonTerminalStackNode(3802, 7, "layouts_LAYOUTLIST", null, null);
      tmp[7].setProduction(tmp);
      tmp[6] = new LiteralStackNode(3800, 6, prod__lit___41__char_class___range__41_41_, new char[] {41}, null, null);
      tmp[6].setProduction(tmp);
      tmp[5] = new NonTerminalStackNode(3798, 5, "layouts_LAYOUTLIST", null, null);
      tmp[5].setProduction(tmp);
      tmp[4] = new NonTerminalStackNode(3796, 4, "Expression", null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(3794, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new LiteralStackNode(3792, 2, prod__lit___40__char_class___range__40_40_, new char[] {40}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(3790, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(3788, 0, prod__lit_if__char_class___range__105_105_char_class___range__102_102_, new char[] {105,102}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[12].setParentProduction(Generator.prod__if_else_IfThenElseStatement__conditional__lit_if__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_StatementNoShortIf_layouts_LAYOUTLIST_conditional__lit_else__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Statement_);
      return tmp;
	}
  }
	
  private static class Type {
    public final static AbstractStackNode[] prod__Type__Identifier_layouts_LAYOUTLIST_lit___60_layouts_LAYOUTLIST_iter_seps__Type__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___62_ = _init_prod__Type__Identifier_layouts_LAYOUTLIST_lit___60_layouts_LAYOUTLIST_iter_seps__Type__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___62_();
    private static final AbstractStackNode[] _init_prod__Type__Identifier_layouts_LAYOUTLIST_lit___60_layouts_LAYOUTLIST_iter_seps__Type__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___62_() {
      AbstractStackNode[] tmp = new AbstractStackNode[7];
      
      tmp[6] = new LiteralStackNode(3842, 6, prod__lit___62__char_class___range__62_62_, new char[] {62}, null, null);
      tmp[6].setProduction(tmp);
      tmp[5] = new NonTerminalStackNode(3840, 5, "layouts_LAYOUTLIST", null, null);
      tmp[5].setProduction(tmp);
      tmp[4] = new SeparatedListStackNode(3830, 4, regular__iter_seps__Type__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST, new NonTerminalStackNode(3832, 0, "Type", null, null), new AbstractStackNode[]{new NonTerminalStackNode(3834, 1, "layouts_LAYOUTLIST", null, null), new LiteralStackNode(3836, 2, prod__lit___44__char_class___range__44_44_, new char[] {44}, null, null), new NonTerminalStackNode(3838, 3, "layouts_LAYOUTLIST", null, null)}, true, null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(3828, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new LiteralStackNode(3826, 2, prod__lit___60__char_class___range__60_60_, new char[] {60}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(3824, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new NonTerminalStackNode(3822, 0, "Identifier", null, null);
      tmp[0].setProduction(tmp);
      tmp[6].setParentProduction(Generator.prod__Type__Identifier_layouts_LAYOUTLIST_lit___60_layouts_LAYOUTLIST_iter_seps__Type__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___62_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__PrimitiveType_Type__PrimitiveType_ = _init_prod__PrimitiveType_Type__PrimitiveType_();
    private static final AbstractStackNode[] _init_prod__PrimitiveType_Type__PrimitiveType_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(3844, 0, "PrimitiveType", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__PrimitiveType_Type__PrimitiveType_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__ReferenceType_Type__ReferenceType_ = _init_prod__ReferenceType_Type__ReferenceType_();
    private static final AbstractStackNode[] _init_prod__ReferenceType_Type__ReferenceType_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(3846, 0, "ReferenceType", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__ReferenceType_Type__ReferenceType_);
      return tmp;
	}
  }
	
  private static class Super {
    public final static AbstractStackNode[] prod__extends_Super__conditional__lit_extends__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_ClassType_ = _init_prod__extends_Super__conditional__lit_extends__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_ClassType_();
    private static final AbstractStackNode[] _init_prod__extends_Super__conditional__lit_extends__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_ClassType_() {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new NonTerminalStackNode(3852, 2, "ClassType", null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(3850, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(3848, 0, prod__lit_extends__char_class___range__101_101_char_class___range__120_120_char_class___range__116_116_char_class___range__101_101_char_class___range__110_110_char_class___range__100_100_char_class___range__115_115_, new char[] {101,120,116,101,110,100,115}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[2].setParentProduction(Generator.prod__extends_Super__conditional__lit_extends__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_ClassType_);
      return tmp;
	}
  }
	
  private static class ForInit {
    public final static AbstractStackNode[] prod__LocalVariableDeclaration_ForInit__LocalVariableDeclaration_ = _init_prod__LocalVariableDeclaration_ForInit__LocalVariableDeclaration_();
    private static final AbstractStackNode[] _init_prod__LocalVariableDeclaration_ForInit__LocalVariableDeclaration_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(3854, 0, "LocalVariableDeclaration", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__LocalVariableDeclaration_ForInit__LocalVariableDeclaration_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__StatementExpressionList_ForInit__StatementExpressionList_ = _init_prod__StatementExpressionList_ForInit__StatementExpressionList_();
    private static final AbstractStackNode[] _init_prod__StatementExpressionList_ForInit__StatementExpressionList_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(3856, 0, "StatementExpressionList", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__StatementExpressionList_ForInit__StatementExpressionList_);
      return tmp;
	}
  }
	
  private static class FloatingPointType {
    public final static AbstractStackNode[] prod__float_FloatingPointType__conditional__lit_float__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__float_FloatingPointType__conditional__lit_float__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__float_FloatingPointType__conditional__lit_float__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3882, 0, prod__lit_float__char_class___range__102_102_char_class___range__108_108_char_class___range__111_111_char_class___range__97_97_char_class___range__116_116_, new char[] {102,108,111,97,116}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__float_FloatingPointType__conditional__lit_float__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__double_FloatingPointType__conditional__lit_double__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__double_FloatingPointType__conditional__lit_double__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__double_FloatingPointType__conditional__lit_double__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3884, 0, prod__lit_double__char_class___range__100_100_char_class___range__111_111_char_class___range__117_117_char_class___range__98_98_char_class___range__108_108_char_class___range__101_101_, new char[] {100,111,117,98,108,101}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__double_FloatingPointType__conditional__lit_double__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
  }
	
  private static class Finally {
    public final static AbstractStackNode[] prod__finally_Finally__conditional__lit_finally__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Block_ = _init_prod__finally_Finally__conditional__lit_finally__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Block_();
    private static final AbstractStackNode[] _init_prod__finally_Finally__conditional__lit_finally__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Block_() {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new NonTerminalStackNode(3890, 2, "Block", null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(3888, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(3886, 0, prod__lit_finally__char_class___range__102_102_char_class___range__105_105_char_class___range__110_110_char_class___range__97_97_char_class___range__108_108_char_class___range__108_108_char_class___range__121_121_, new char[] {102,105,110,97,108,108,121}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[2].setParentProduction(Generator.prod__finally_Finally__conditional__lit_finally__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Block_);
      return tmp;
	}
  }
	
  private static class BooleanLiteral {
    public final static AbstractStackNode[] prod__BooleanLiteral__conditional__lit_true__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__BooleanLiteral__conditional__lit_true__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__BooleanLiteral__conditional__lit_true__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3898, 0, prod__lit_true__char_class___range__116_116_char_class___range__114_114_char_class___range__117_117_char_class___range__101_101_, new char[] {116,114,117,101}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__BooleanLiteral__conditional__lit_true__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__BooleanLiteral__conditional__lit_false__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__BooleanLiteral__conditional__lit_false__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__BooleanLiteral__conditional__lit_false__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(3900, 0, prod__lit_false__char_class___range__102_102_char_class___range__97_97_char_class___range__108_108_char_class___range__115_115_char_class___range__101_101_, new char[] {102,97,108,115,101}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__BooleanLiteral__conditional__lit_false__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
  }
	
  private static class TokenDef {
    public final static AbstractStackNode[] prod__TokenDef__Identifier_layouts_LAYOUTLIST_Identifier_ = _init_prod__TokenDef__Identifier_layouts_LAYOUTLIST_Identifier_();
    private static final AbstractStackNode[] _init_prod__TokenDef__Identifier_layouts_LAYOUTLIST_Identifier_() {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new NonTerminalStackNode(3908, 2, "Identifier", null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(3906, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new NonTerminalStackNode(3904, 0, "Identifier", null, null);
      tmp[0].setProduction(tmp);
      tmp[2].setParentProduction(Generator.prod__TokenDef__Identifier_layouts_LAYOUTLIST_Identifier_);
      return tmp;
	}
  }
	
  private static class EscapeSequence {
    public final static AbstractStackNode[] prod__EscapeSequence__lit___92_char_class___range__48_51_char_class___range__48_55_char_class___range__48_55_ = _init_prod__EscapeSequence__lit___92_char_class___range__48_51_char_class___range__48_55_char_class___range__48_55_();
    private static final AbstractStackNode[] _init_prod__EscapeSequence__lit___92_char_class___range__48_51_char_class___range__48_55_char_class___range__48_55_() {
      AbstractStackNode[] tmp = new AbstractStackNode[4];
      
      tmp[3] = new CharStackNode(3916, 3, new char[][]{{48,55}}, null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new CharStackNode(3914, 2, new char[][]{{48,55}}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new CharStackNode(3912, 1, new char[][]{{48,51}}, null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(3910, 0, prod__lit___92__char_class___range__92_92_, new char[] {92}, null, null);
      tmp[0].setProduction(tmp);
      tmp[3].setParentProduction(Generator.prod__EscapeSequence__lit___92_char_class___range__48_51_char_class___range__48_55_char_class___range__48_55_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__EscapeSequence__lit___92_char_class___range__48_55_ = _init_prod__EscapeSequence__lit___92_char_class___range__48_55_();
    private static final AbstractStackNode[] _init_prod__EscapeSequence__lit___92_char_class___range__48_55_() {
      AbstractStackNode[] tmp = new AbstractStackNode[2];
      
      tmp[1] = new CharStackNode(3920, 1, new char[][]{{48,55}}, null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(3918, 0, prod__lit___92__char_class___range__92_92_, new char[] {92}, null, null);
      tmp[0].setProduction(tmp);
      tmp[1].setParentProduction(Generator.prod__EscapeSequence__lit___92_char_class___range__48_55_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__EscapeSequence__lit___92_char_class___range__34_34_range__39_39_range__92_92_range__98_98_range__102_102_range__110_110_range__114_114_range__116_116_ = _init_prod__EscapeSequence__lit___92_char_class___range__34_34_range__39_39_range__92_92_range__98_98_range__102_102_range__110_110_range__114_114_range__116_116_();
    private static final AbstractStackNode[] _init_prod__EscapeSequence__lit___92_char_class___range__34_34_range__39_39_range__92_92_range__98_98_range__102_102_range__110_110_range__114_114_range__116_116_() {
      AbstractStackNode[] tmp = new AbstractStackNode[2];
      
      tmp[1] = new CharStackNode(3924, 1, new char[][]{{34,34},{39,39},{92,92},{98,98},{102,102},{110,110},{114,114},{116,116}}, null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(3922, 0, prod__lit___92__char_class___range__92_92_, new char[] {92}, null, null);
      tmp[0].setProduction(tmp);
      tmp[1].setParentProduction(Generator.prod__EscapeSequence__lit___92_char_class___range__34_34_range__39_39_range__92_92_range__98_98_range__102_102_range__110_110_range__114_114_range__116_116_);
      return tmp;
	}
    public final static AbstractStackNode[] prod__EscapeSequence__lit___92_char_class___range__48_55_char_class___range__48_55_ = _init_prod__EscapeSequence__lit___92_char_class___range__48_55_char_class___range__48_55_();
    private static final AbstractStackNode[] _init_prod__EscapeSequence__lit___92_char_class___range__48_55_char_class___range__48_55_() {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new CharStackNode(3930, 2, new char[][]{{48,55}}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new CharStackNode(3928, 1, new char[][]{{48,55}}, null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(3926, 0, prod__lit___92__char_class___range__92_92_, new char[] {92}, null, null);
      tmp[0].setProduction(tmp);
      tmp[2].setParentProduction(Generator.prod__EscapeSequence__lit___92_char_class___range__48_55_char_class___range__48_55_);
      return tmp;
	}
  }
	
  private static class UnicodeEscape {
    public final static AbstractStackNode[] prod__UnicodeEscape__lit___92_iter__char_class___range__117_117_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_ = _init_prod__UnicodeEscape__lit___92_iter__char_class___range__117_117_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_();
    private static final AbstractStackNode[] _init_prod__UnicodeEscape__lit___92_iter__char_class___range__117_117_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_() {
      AbstractStackNode[] tmp = new AbstractStackNode[6];
      
      tmp[5] = new CharStackNode(3948, 5, new char[][]{{48,57},{65,70},{97,102}}, null, null);
      tmp[5].setProduction(tmp);
      tmp[4] = new CharStackNode(3946, 4, new char[][]{{48,57},{65,70},{97,102}}, null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new CharStackNode(3944, 3, new char[][]{{48,57},{65,70},{97,102}}, null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new CharStackNode(3942, 2, new char[][]{{48,57},{65,70},{97,102}}, null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new ListStackNode(3938, 1, regular__iter__char_class___range__117_117, new CharStackNode(3940, 0, new char[][]{{117,117}}, null, null), true, null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(3936, 0, prod__lit___92__char_class___range__92_92_, new char[] {92}, null, null);
      tmp[0].setProduction(tmp);
      tmp[5].setParentProduction(Generator.prod__UnicodeEscape__lit___92_iter__char_class___range__117_117_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_);
      return tmp;
	}
  }
	
  private static class PackageDeclaration {
    public final static AbstractStackNode[] prod__package_semicolon_PackageDeclaration__conditional__lit_package__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Name_layouts_LAYOUTLIST_lit___59_ = _init_prod__package_semicolon_PackageDeclaration__conditional__lit_package__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Name_layouts_LAYOUTLIST_lit___59_();
    private static final AbstractStackNode[] _init_prod__package_semicolon_PackageDeclaration__conditional__lit_package__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Name_layouts_LAYOUTLIST_lit___59_() {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new LiteralStackNode(3986, 4, prod__lit___59__char_class___range__59_59_, new char[] {59}, null, null);
      tmp[4].setProduction(tmp);
      tmp[3] = new NonTerminalStackNode(3984, 3, "layouts_LAYOUTLIST", null, null);
      tmp[3].setProduction(tmp);
      tmp[2] = new NonTerminalStackNode(3982, 2, "Name", null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(3980, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(3978, 0, prod__lit_package__char_class___range__112_112_char_class___range__97_97_char_class___range__99_99_char_class___range__107_107_char_class___range__97_97_char_class___range__103_103_char_class___range__101_101_, new char[] {112,97,99,107,97,103,101}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[4].setParentProduction(Generator.prod__package_semicolon_PackageDeclaration__conditional__lit_package__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Name_layouts_LAYOUTLIST_lit___59_);
      return tmp;
	}
  }
	
  private static class OctalIntegerLiteral {
    public final static AbstractStackNode[] prod__OctalIntegerLiteral__char_class___range__48_48_iter__char_class___range__48_55_ = _init_prod__OctalIntegerLiteral__char_class___range__48_48_iter__char_class___range__48_55_();
    private static final AbstractStackNode[] _init_prod__OctalIntegerLiteral__char_class___range__48_48_iter__char_class___range__48_55_() {
      AbstractStackNode[] tmp = new AbstractStackNode[2];
      
      tmp[1] = new ListStackNode(3974, 1, regular__iter__char_class___range__48_55, new CharStackNode(3976, 0, new char[][]{{48,55}}, null, null), true, null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new CharStackNode(3972, 0, new char[][]{{48,48}}, null, null);
      tmp[0].setProduction(tmp);
      tmp[1].setParentProduction(Generator.prod__OctalIntegerLiteral__char_class___range__48_48_iter__char_class___range__48_55_);
      return tmp;
	}
  }
	
  private static class StaticInitializer {
    public final static AbstractStackNode[] prod__static1_StaticInitializer__conditional__lit_static__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Block_ = _init_prod__static1_StaticInitializer__conditional__lit_static__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Block_();
    private static final AbstractStackNode[] _init_prod__static1_StaticInitializer__conditional__lit_static__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Block_() {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new NonTerminalStackNode(3970, 2, "Block", null, null);
      tmp[2].setProduction(tmp);
      tmp[1] = new NonTerminalStackNode(3968, 1, "layouts_LAYOUTLIST", null, null);
      tmp[1].setProduction(tmp);
      tmp[0] = new LiteralStackNode(3966, 0, prod__lit_static__char_class___range__115_115_char_class___range__116_116_char_class___range__97_97_char_class___range__116_116_char_class___range__105_105_char_class___range__99_99_, new char[] {115,116,97,116,105,99}, null, new ICompletionFilter[] {new CharFollowRestriction(new char[][]{{48,57},{65,90},{95,95},{97,122}})});
      tmp[0].setProduction(tmp);
      tmp[2].setParentProduction(Generator.prod__static1_StaticInitializer__conditional__lit_static__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Block_);
      return tmp;
	}
  }
	
  private static class SimpleName {
    public final static AbstractStackNode[] prod__Identifier_SimpleName__conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_ = _init_prod__Identifier_SimpleName__conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_();
    private static final AbstractStackNode[] _init_prod__Identifier_SimpleName__conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(4016, 0, "Identifier", null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__Identifier_SimpleName__conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_);
      return tmp;
	}
  }
	
  private static class Asterisk {
    public final static AbstractStackNode[] prod__Asterisk__char_class___range__42_42_ = _init_prod__Asterisk__char_class___range__42_42_();
    private static final AbstractStackNode[] _init_prod__Asterisk__char_class___range__42_42_() {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new CharStackNode(4036, 0, new char[][]{{42,42}}, null, null);
      tmp[0].setProduction(tmp);
      tmp[0].setParentProduction(Generator.prod__Asterisk__char_class___range__42_42_);
      return tmp;
	}
  }
	
  public Generator() {
    super();
  }

  // Parse methods    
  
  public void StatementExpressionList() {
    
    
    // prod(label("comma1",sort("StatementExpressionList")),[\iter-seps(sort("StatementExpression"),[layouts("LAYOUTLIST"),lit(","),layouts("LAYOUTLIST")])],{})
    expect(StatementExpressionList.prod__comma1_StatementExpressionList__iter_seps__StatementExpression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_);
  }
  public void OctalLongLiteral() {
    
    
    // prod(lex("OctalLongLiteral"),[\char-class([range(48,48)]),iter(\char-class([range(48,55)])),\char-class([range(76,76),range(108,108)])],{})
    expect(OctalLongLiteral.prod__OctalLongLiteral__char_class___range__48_48_iter__char_class___range__48_55_char_class___range__76_76_range__108_108_);
  }
  public void Literal() {
    
    
    // prod(label("IntegerLiteral",sort("Literal")),[sort("IntegerLiteral")],{tag(NotSupported("prefer"))})
    expect(Literal.prod__IntegerLiteral_Literal__IntegerLiteral__tag__NotSupported___112_114_101_102_101_114);
    // prod(label("BooleanLiteral",sort("Literal")),[lex("BooleanLiteral")],{tag(NotSupported("prefer"))})
    expect(Literal.prod__BooleanLiteral_Literal__BooleanLiteral__tag__NotSupported___112_114_101_102_101_114);
    // prod(label("FloatingPointLiteral",sort("Literal")),[conditional(lex("FloatingPointLiteral"),{\not-follow(\char-class([range(46,46),range(48,57),range(65,90),range(95,95),range(97,122)]))})],{tag(NotSupported("prefer"))})
    expect(Literal.prod__FloatingPointLiteral_Literal__conditional__FloatingPointLiteral__not_follow__char_class___range__46_46_range__48_57_range__65_90_range__95_95_range__97_122__tag__NotSupported___112_114_101_102_101_114);
    // prod(label("DoubleLiteral",sort("Literal")),[conditional(lex("DoubleLiteral"),{\not-follow(\char-class([range(46,46),range(48,57),range(65,90),range(95,95),range(97,122)]))})],{tag(NotSupported("prefer"))})
    expect(Literal.prod__DoubleLiteral_Literal__conditional__DoubleLiteral__not_follow__char_class___range__46_46_range__48_57_range__65_90_range__95_95_range__97_122__tag__NotSupported___112_114_101_102_101_114);
    // prod(label("CharacterLiteral",sort("Literal")),[lex("CharacterLiteral")],{tag(NotSupported("prefer"))})
    expect(Literal.prod__CharacterLiteral_Literal__CharacterLiteral__tag__NotSupported___112_114_101_102_101_114);
    // prod(label("NullLiteral",sort("Literal")),[lex("NullLiteral")],{tag(NotSupported("prefer"))})
    expect(Literal.prod__NullLiteral_Literal__NullLiteral__tag__NotSupported___112_114_101_102_101_114);
    // prod(label("StringLiteral",sort("Literal")),[lex("StringLiteral")],{tag(NotSupported("prefer"))})
    expect(Literal.prod__StringLiteral_Literal__StringLiteral__tag__NotSupported___112_114_101_102_101_114);
    // prod(label("LongLiteral",sort("Literal")),[sort("LongLiteral")],{tag(NotSupported("prefer"))})
    expect(Literal.prod__LongLiteral_Literal__LongLiteral__tag__NotSupported___112_114_101_102_101_114);
  }
  public void LocalVariableDeclarationStatement() {
    
    
    // prod(label("semicolon",sort("LocalVariableDeclarationStatement")),[sort("LocalVariableDeclaration"),layouts("LAYOUTLIST"),lit(";")],{})
    expect(LocalVariableDeclarationStatement.prod__semicolon_LocalVariableDeclarationStatement__LocalVariableDeclaration_layouts_LAYOUTLIST_lit___59_);
  }
  public void ConstructorBody() {
    
    
    // prod(label("ExplicitConstructorInvocation-opt-BlockStatement-s",sort("ConstructorBody")),[lit("{"),layouts("LAYOUTLIST"),opt(sort("ExplicitConstructorInvocation")),layouts("LAYOUTLIST"),\iter-star-seps(sort("BlockStatement"),[layouts("LAYOUTLIST")]),layouts("LAYOUTLIST"),lit("}")],{})
    expect(ConstructorBody.prod__ExplicitConstructorInvocation_opt_BlockStatement_s_ConstructorBody__lit___123_layouts_LAYOUTLIST_opt__ExplicitConstructorInvocation_layouts_LAYOUTLIST_iter_star_seps__BlockStatement__layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___125_);
  }
  public void SynchronizedStatement() {
    
    
    // prod(label("synchronized",sort("SynchronizedStatement")),[conditional(lit("synchronized"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts("LAYOUTLIST"),lit("("),layouts("LAYOUTLIST"),sort("Expression"),layouts("LAYOUTLIST"),lit(")"),layouts("LAYOUTLIST"),sort("Block")],{})
    expect(SynchronizedStatement.prod__synchronized_SynchronizedStatement__conditional__lit_synchronized__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_Block_);
  }
  public void VariableInitializer() {
    
    
    // prod(label("Expression",sort("VariableInitializer")),[sort("Expression")],{})
    expect(VariableInitializer.prod__Expression_VariableInitializer__Expression_);
    // prod(label("ArrayInitializer",sort("VariableInitializer")),[sort("ArrayInitializer")],{})
    expect(VariableInitializer.prod__ArrayInitializer_VariableInitializer__ArrayInitializer_);
  }
  public void PrimitiveType() {
    
    
    // prod(label("boolean",sort("PrimitiveType")),[conditional(lit("boolean"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(PrimitiveType.prod__boolean_PrimitiveType__conditional__lit_boolean__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(label("NumericType",sort("PrimitiveType")),[sort("NumericType")],{})
    expect(PrimitiveType.prod__NumericType_PrimitiveType__NumericType_);
  }
  public void InterfaceDeclaration() {
    
    
    // prod(label("interface",sort("InterfaceDeclaration")),[\iter-star-seps(sort("Modifier"),[layouts("LAYOUTLIST")]),layouts("LAYOUTLIST"),conditional(lit("interface"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts("LAYOUTLIST"),conditional(lex("Identifier"),{delete(conditional(keywords("IdentifierKeywords"),{\not-follow(\char-class([range(36,36),range(48,57),range(65,90),range(95,95),range(97,122)]))}))}),layouts("LAYOUTLIST"),opt(sort("ExtendsInterfaces")),layouts("LAYOUTLIST"),sort("InterfaceBody")],{})
    expect(InterfaceDeclaration.prod__interface_InterfaceDeclaration__iter_star_seps__Modifier__layouts_LAYOUTLIST_layouts_LAYOUTLIST_conditional__lit_interface__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_opt__ExtendsInterfaces_layouts_LAYOUTLIST_InterfaceBody_);
  }
  public void FloatingPointLiteral() {
    
    
    // prod(lex("FloatingPointLiteral"),[iter(\char-class([range(48,57)])),lit("."),\iter-star(\char-class([range(48,57)])),opt(seq([\char-class([range(69,69),range(101,101)]),opt(\char-class([range(43,43),range(45,45)])),iter(\char-class([range(48,57)]))])),\char-class([range(70,70),range(102,102)])],{})
    expect(FloatingPointLiteral.prod__FloatingPointLiteral__iter__char_class___range__48_57_lit___46_iter_star__char_class___range__48_57_opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_char_class___range__70_70_range__102_102_);
    // prod(lex("FloatingPointLiteral"),[iter(\char-class([range(48,57)])),\char-class([range(69,69),range(101,101)]),opt(\char-class([range(43,43),range(45,45)])),iter(\char-class([range(48,57)])),\char-class([range(70,70),range(102,102)])],{})
    expect(FloatingPointLiteral.prod__FloatingPointLiteral__iter__char_class___range__48_57_char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_char_class___range__70_70_range__102_102_);
    // prod(lex("FloatingPointLiteral"),[lit("."),iter(\char-class([range(48,57)])),opt(seq([\char-class([range(69,69),range(101,101)]),opt(\char-class([range(43,43),range(45,45)])),iter(\char-class([range(48,57)]))])),\char-class([range(70,70),range(102,102)])],{})
    expect(FloatingPointLiteral.prod__FloatingPointLiteral__lit___46_iter__char_class___range__48_57_opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_char_class___range__70_70_range__102_102_);
    // prod(lex("FloatingPointLiteral"),[iter(\char-class([range(48,57)])),opt(seq([\char-class([range(69,69),range(101,101)]),opt(\char-class([range(43,43),range(45,45)])),iter(\char-class([range(48,57)]))])),\char-class([range(70,70),range(102,102)])],{})
    expect(FloatingPointLiteral.prod__FloatingPointLiteral__iter__char_class___range__48_57_opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_char_class___range__70_70_range__102_102_);
  }
  public void Name() {
    
    
    // prod(label("Identifier-p",sort("Name")),[\iter-seps(lex("Identifier"),[layouts("LAYOUTLIST"),lit("."),layouts("LAYOUTLIST")])],{tag(NotSupported("avoid"))})
    expect(Name.prod__Identifier_p_Name__iter_seps__Identifier__layouts_LAYOUTLIST_lit___46_layouts_LAYOUTLIST__tag__NotSupported___97_118_111_105_100);
    // prod(label("class",sort("Name")),[sort("Type"),layouts("LAYOUTLIST"),lit("."),layouts("LAYOUTLIST"),conditional(lit("class"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(Name.prod__class_Name__Type_layouts_LAYOUTLIST_lit___46_layouts_LAYOUTLIST_conditional__lit_class__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
  }
  public void AssertStatement() {
    
    
    // prod(label("assertWithExpression",sort("AssertStatement")),[lit("assert"),layouts("LAYOUTLIST"),sort("Expression"),layouts("LAYOUTLIST"),lit(";")],{tag(NotSupported("prefer"))})
    expect(AssertStatement.prod__assertWithExpression_AssertStatement__lit_assert_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___59__tag__NotSupported___112_114_101_102_101_114);
  }
  public void ClassType() {
    
    
    // prod(sort("ClassType"),[lex("Identifier"),layouts("LAYOUTLIST"),lit("\<"),layouts("LAYOUTLIST"),\iter-seps(sort("ClassType"),[layouts("LAYOUTLIST"),lit(","),layouts("LAYOUTLIST")]),layouts("LAYOUTLIST"),lit("\>")],{})
    expect(ClassType.prod__ClassType__Identifier_layouts_LAYOUTLIST_lit___60_layouts_LAYOUTLIST_iter_seps__ClassType__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___62_);
    // prod(label("ClassOrInterfaceType1",sort("ClassType")),[sort("ClassOrInterfaceType")],{})
    expect(ClassType.prod__ClassOrInterfaceType1_ClassType__ClassOrInterfaceType_);
  }
  public void AssignmentOperator() {
    
    
    // prod(label("assignOr",sort("AssignmentOperator")),[lit("|=")],{})
    expect(AssignmentOperator.prod__assignOr_AssignmentOperator__lit___124_61_);
    // prod(label("assignMin",sort("AssignmentOperator")),[lit("-=")],{})
    expect(AssignmentOperator.prod__assignMin_AssignmentOperator__lit___45_61_);
    // prod(label("assignAnd",sort("AssignmentOperator")),[lit("&=")],{})
    expect(AssignmentOperator.prod__assignAnd_AssignmentOperator__lit___38_61_);
    // prod(label("assignMul",sort("AssignmentOperator")),[lit("*=")],{})
    expect(AssignmentOperator.prod__assignMul_AssignmentOperator__lit___42_61_);
    // prod(label("equal1",sort("AssignmentOperator")),[lit("=")],{})
    expect(AssignmentOperator.prod__equal1_AssignmentOperator__lit___61_);
    // prod(label("assignSR",sort("AssignmentOperator")),[lit("\>\>=")],{})
    expect(AssignmentOperator.prod__assignSR_AssignmentOperator__lit___62_62_61_);
    // prod(label("assignDiv",sort("AssignmentOperator")),[lit("/=")],{})
    expect(AssignmentOperator.prod__assignDiv_AssignmentOperator__lit___47_61_);
    // prod(label("assignSL",sort("AssignmentOperator")),[lit("\<\<=")],{})
    expect(AssignmentOperator.prod__assignSL_AssignmentOperator__lit___60_60_61_);
    // prod(label("assignPlus",sort("AssignmentOperator")),[lit("+=")],{})
    expect(AssignmentOperator.prod__assignPlus_AssignmentOperator__lit___43_61_);
    // prod(label("assignExp",sort("AssignmentOperator")),[lit("^=")],{})
    expect(AssignmentOperator.prod__assignExp_AssignmentOperator__lit___94_61_);
    // prod(label("AssignmentOperator-dunno-b_0",sort("AssignmentOperator")),[lit("\>\>\>=")],{})
    expect(AssignmentOperator.prod__AssignmentOperator_dunno_b_0_AssignmentOperator__lit___62_62_62_61_);
    // prod(label("assignMod",sort("AssignmentOperator")),[lit("%=")],{})
    expect(AssignmentOperator.prod__assignMod_AssignmentOperator__lit___37_61_);
  }
  public void Expression() {
    
    
    
    // prod(label("PrimitiveType-Dim-s-Expression",sort("Expression")),[lit("("),layouts("LAYOUTLIST"),sort("PrimitiveType"),layouts("LAYOUTLIST"),\iter-star-seps(sort("Dim"),[layouts("LAYOUTLIST")]),layouts("LAYOUTLIST"),lit(")"),layouts("LAYOUTLIST"),sort("Expression")],{})
    expect(Expression.prod__PrimitiveType_Dim_s_Expression_Expression__lit___40_layouts_LAYOUTLIST_PrimitiveType_layouts_LAYOUTLIST_iter_star_seps__Dim__layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_Expression_);
    // prod(label("gt1",sort("Expression")),[sort("Expression"),layouts("LAYOUTLIST"),lit("\>"),layouts("LAYOUTLIST"),sort("Expression")],{assoc(left())})
    expect(Expression.prod__gt1_Expression__Expression_layouts_LAYOUTLIST_lit___62_layouts_LAYOUTLIST_Expression__assoc__left);
    // prod(label("ge1",sort("Expression")),[sort("Expression"),layouts("LAYOUTLIST"),lit("\>="),layouts("LAYOUTLIST"),sort("Expression")],{assoc(left())})
    expect(Expression.prod__ge1_Expression__Expression_layouts_LAYOUTLIST_lit___62_61_layouts_LAYOUTLIST_Expression__assoc__left);
    // prod(label("le1",sort("Expression")),[sort("Expression"),layouts("LAYOUTLIST"),lit("\<="),layouts("LAYOUTLIST"),sort("Expression")],{assoc(left())})
    expect(Expression.prod__le1_Expression__Expression_layouts_LAYOUTLIST_lit___60_61_layouts_LAYOUTLIST_Expression__assoc__left);
    // prod(label("incr21",sort("Expression")),[sort("Expression"),layouts("LAYOUTLIST"),lit("++")],{tag(NotSupported("prefer"))})
    expect(Expression.prod__incr21_Expression__Expression_layouts_LAYOUTLIST_lit___43_43__tag__NotSupported___112_114_101_102_101_114);
    // prod(label("and11",sort("Expression")),[sort("Expression"),layouts("LAYOUTLIST"),lit("&&"),layouts("LAYOUTLIST"),sort("Expression")],{assoc(left())})
    expect(Expression.prod__and11_Expression__Expression_layouts_LAYOUTLIST_lit___38_38_layouts_LAYOUTLIST_Expression__assoc__left);
    // prod(label("times1",sort("Expression")),[sort("Expression"),layouts("LAYOUTLIST"),lit("*"),layouts("LAYOUTLIST"),sort("Expression")],{assoc(left())})
    expect(Expression.prod__times1_Expression__Expression_layouts_LAYOUTLIST_lit___42_layouts_LAYOUTLIST_Expression__assoc__left);
    // prod(label("plus-Expression11",sort("Expression")),[sort("Expression"),layouts("LAYOUTLIST"),lit("+"),layouts("LAYOUTLIST"),sort("Expression")],{assoc(left())})
    expect(Expression.prod__plus_Expression11_Expression__Expression_layouts_LAYOUTLIST_lit___43_layouts_LAYOUTLIST_Expression__assoc__left);
    // prod(label("lt1",sort("Expression")),[sort("Expression"),layouts("LAYOUTLIST"),lit("\<"),layouts("LAYOUTLIST"),sort("Expression")],{assoc(left())})
    expect(Expression.prod__lt1_Expression__Expression_layouts_LAYOUTLIST_lit___60_layouts_LAYOUTLIST_Expression__assoc__left);
    // prod(label("minus",sort("Expression")),[lit("-"),layouts("LAYOUTLIST"),sort("Expression")],{})
    expect(Expression.prod__minus_Expression__lit___layouts_LAYOUTLIST_Expression_);
    // prod(label("not-equal1",sort("Expression")),[sort("Expression"),layouts("LAYOUTLIST"),lit("!="),layouts("LAYOUTLIST"),sort("Expression")],{assoc(left())})
    expect(Expression.prod__not_equal1_Expression__Expression_layouts_LAYOUTLIST_lit___33_61_layouts_LAYOUTLIST_Expression__assoc__left);
    // prod(label("StatementExpression",sort("Expression")),[sort("StatementExpression")],{})
    expect(Expression.prod__StatementExpression_Expression__StatementExpression_);
    // prod(label("or11",sort("Expression")),[sort("Expression"),layouts("LAYOUTLIST"),lit("||"),layouts("LAYOUTLIST"),sort("Expression")],{assoc(left())})
    expect(Expression.prod__or11_Expression__Expression_layouts_LAYOUTLIST_lit___124_124_layouts_LAYOUTLIST_Expression__assoc__left);
    // prod(label("incr31",sort("Expression")),[lit("++"),layouts("LAYOUTLIST"),sort("Expression")],{tag(NotSupported("prefer"))})
    expect(Expression.prod__incr31_Expression__lit___43_43_layouts_LAYOUTLIST_Expression__tag__NotSupported___112_114_101_102_101_114);
    // prod(label("instanceof",sort("Expression")),[sort("Expression"),layouts("LAYOUTLIST"),conditional(lit("instanceof"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts("LAYOUTLIST"),sort("ReferenceType")],{})
    expect(Expression.prod__instanceof_Expression__Expression_layouts_LAYOUTLIST_conditional__lit_instanceof__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_ReferenceType_);
    // prod(label("Name-Dim-p-Expression",sort("Expression")),[lit("("),layouts("LAYOUTLIST"),sort("Name"),layouts("LAYOUTLIST"),\iter-seps(sort("Dim"),[layouts("LAYOUTLIST")]),layouts("LAYOUTLIST"),lit(")"),layouts("LAYOUTLIST"),sort("Expression")],{})
    expect(Expression.prod__Name_Dim_p_Expression_Expression__lit___40_layouts_LAYOUTLIST_Name_layouts_LAYOUTLIST_iter_seps__Dim__layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_Expression_);
    // prod(label("shift-right1",sort("Expression")),[sort("Expression"),layouts("LAYOUTLIST"),lit("\>\>"),layouts("LAYOUTLIST"),sort("Expression")],{assoc(left())})
    expect(Expression.prod__shift_right1_Expression__Expression_layouts_LAYOUTLIST_lit___62_62_layouts_LAYOUTLIST_Expression__assoc__left);
    // prod(label("bar11",sort("Expression")),[sort("Expression"),layouts("LAYOUTLIST"),lit("|"),layouts("LAYOUTLIST"),sort("Expression")],{assoc(left())})
    expect(Expression.prod__bar11_Expression__Expression_layouts_LAYOUTLIST_lit___124_layouts_LAYOUTLIST_Expression__assoc__left);
    // prod(label("Expression-Expression31",sort("Expression")),[sort("Expression"),layouts("LAYOUTLIST"),lit("^"),layouts("LAYOUTLIST"),sort("Expression")],{assoc(left())})
    expect(Expression.prod__Expression_Expression31_Expression__Expression_layouts_LAYOUTLIST_lit___94_layouts_LAYOUTLIST_Expression__assoc__left);
    // prod(label("Primary",sort("Expression")),[sort("Primary")],{tag(NotSupported("prefer"))})
    expect(Expression.prod__Primary_Expression__Primary__tag__NotSupported___112_114_101_102_101_114);
    // prod(label("div1",sort("Expression")),[sort("Expression"),layouts("LAYOUTLIST"),lit("/"),layouts("LAYOUTLIST"),sort("Expression")],{assoc(left())})
    expect(Expression.prod__div1_Expression__Expression_layouts_LAYOUTLIST_lit___47_layouts_LAYOUTLIST_Expression__assoc__left);
    // prod(label("plus",sort("Expression")),[lit("+"),layouts("LAYOUTLIST"),sort("Expression")],{})
    expect(Expression.prod__plus_Expression__lit___43_layouts_LAYOUTLIST_Expression_);
    // prod(label("mod-Expression11",sort("Expression")),[sort("Expression"),layouts("LAYOUTLIST"),lit("%"),layouts("LAYOUTLIST"),sort("Expression")],{assoc(left())})
    expect(Expression.prod__mod_Expression11_Expression__Expression_layouts_LAYOUTLIST_lit___37_layouts_LAYOUTLIST_Expression__assoc__left);
    // prod(label("equal1",sort("Expression")),[sort("Expression"),layouts("LAYOUTLIST"),lit("=="),layouts("LAYOUTLIST"),sort("Expression")],{assoc(left())})
    expect(Expression.prod__equal1_Expression__Expression_layouts_LAYOUTLIST_lit___61_61_layouts_LAYOUTLIST_Expression__assoc__left);
    // prod(label("tilde",sort("Expression")),[lit("~"),layouts("LAYOUTLIST"),sort("Expression")],{})
    expect(Expression.prod__tilde_Expression__lit___126_layouts_LAYOUTLIST_Expression_);
    // prod(label("not",sort("Expression")),[lit("!"),layouts("LAYOUTLIST"),sort("Expression")],{})
    expect(Expression.prod__not_Expression__lit___33_layouts_LAYOUTLIST_Expression_);
    // prod(label("shift-left1",sort("Expression")),[sort("Expression"),layouts("LAYOUTLIST"),lit("\<\<"),layouts("LAYOUTLIST"),sort("Expression")],{assoc(left())})
    expect(Expression.prod__shift_left1_Expression__Expression_layouts_LAYOUTLIST_lit___60_60_layouts_LAYOUTLIST_Expression__assoc__left);
    // prod(label("Assignment1",sort("Expression")),[sort("Assignment")],{})
    expect(Expression.prod__Assignment1_Expression__Assignment_);
    // prod(label("decr31",sort("Expression")),[lit("--"),layouts("LAYOUTLIST"),sort("Expression")],{tag(NotSupported("prefer"))})
    expect(Expression.prod__decr31_Expression__lit____layouts_LAYOUTLIST_Expression__tag__NotSupported___112_114_101_102_101_114);
    // prod(label("minus-Expression11",sort("Expression")),[sort("Expression"),layouts("LAYOUTLIST"),lit("-"),layouts("LAYOUTLIST"),sort("Expression")],{assoc(left())})
    expect(Expression.prod__minus_Expression11_Expression__Expression_layouts_LAYOUTLIST_lit___layouts_LAYOUTLIST_Expression__assoc__left);
    // prod(label("address11",sort("Expression")),[sort("Expression"),layouts("LAYOUTLIST"),lit("&"),layouts("LAYOUTLIST"),sort("Expression")],{assoc(left())})
    expect(Expression.prod__address11_Expression__Expression_layouts_LAYOUTLIST_lit___38_layouts_LAYOUTLIST_Expression__assoc__left);
    // prod(label("decr21",sort("Expression")),[sort("Expression"),layouts("LAYOUTLIST"),lit("--")],{tag(NotSupported("prefer"))})
    expect(Expression.prod__decr21_Expression__Expression_layouts_LAYOUTLIST_lit_____tag__NotSupported___112_114_101_102_101_114);
    // prod(label("Expression12",sort("Expression")),[sort("Expression"),layouts("LAYOUTLIST"),lit("\>\>\>"),layouts("LAYOUTLIST"),sort("Expression")],{assoc(left())})
    expect(Expression.prod__Expression12_Expression__Expression_layouts_LAYOUTLIST_lit___62_62_62_layouts_LAYOUTLIST_Expression__assoc__left);
    // prod(label("Cast-Expression",sort("Expression")),[lit("("),layouts("LAYOUTLIST"),sort("Type"),layouts("LAYOUTLIST"),lit(")"),layouts("LAYOUTLIST"),sort("Expression")],{})
    expect(Expression.prod__Cast_Expression_Expression__lit___40_layouts_LAYOUTLIST_Type_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_Expression_);
    // prod(label("colon2",sort("Expression")),[sort("Expression"),layouts("LAYOUTLIST"),lit("?"),layouts("LAYOUTLIST"),sort("Expression"),layouts("LAYOUTLIST"),lit(":"),layouts("LAYOUTLIST"),sort("Expression")],{tag(NotSupported("prefer"))})
    expect(Expression.prod__colon2_Expression__Expression_layouts_LAYOUTLIST_lit___63_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___58_layouts_LAYOUTLIST_Expression__tag__NotSupported___112_114_101_102_101_114);
  }
  public void ForStatement() {
    
    
    // prod(label("for-semicolon-semicolon",sort("ForStatement")),[conditional(lit("for"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts("LAYOUTLIST"),lit("("),layouts("LAYOUTLIST"),opt(sort("ForInit")),layouts("LAYOUTLIST"),lit(";"),layouts("LAYOUTLIST"),opt(sort("Expression")),layouts("LAYOUTLIST"),lit(";"),layouts("LAYOUTLIST"),opt(sort("ForUpdate")),layouts("LAYOUTLIST"),lit(")"),layouts("LAYOUTLIST"),sort("Statement")],{})
    expect(ForStatement.prod__for_semicolon_semicolon_ForStatement__conditional__lit_for__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_opt__ForInit_layouts_LAYOUTLIST_lit___59_layouts_LAYOUTLIST_opt__Expression_layouts_LAYOUTLIST_lit___59_layouts_LAYOUTLIST_opt__ForUpdate_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_Statement_);
  }
  public void View() {
    
    
    // prod(sort("View"),[lit("view"),layouts("LAYOUTLIST"),lex("Identifier"),layouts("LAYOUTLIST"),lit("grammar"),layouts("LAYOUTLIST"),sort("File"),layouts("LAYOUTLIST"),lit("{"),layouts("LAYOUTLIST"),\iter-star-seps(sort("TokenDef"),[layouts("LAYOUTLIST"),lit(","),layouts("LAYOUTLIST")]),layouts("LAYOUTLIST"),lit("}")],{})
    expect(View.prod__View__lit_view_layouts_LAYOUTLIST_Identifier_layouts_LAYOUTLIST_lit_grammar_layouts_LAYOUTLIST_File_layouts_LAYOUTLIST_lit___123_layouts_LAYOUTLIST_iter_star_seps__TokenDef__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___125_);
  }
  public void EmptyStatement() {
    
    
    // prod(label("semicolon1",sort("EmptyStatement")),[lit(";")],{})
    expect(EmptyStatement.prod__semicolon1_EmptyStatement__lit___59_);
  }
  public void Thing() {
    
    
    // prod(sort("Thing"),[conditional(lex("Word"),{delete(lit("start"))})],{})
    expect(Thing.prod__Thing__conditional__Word__delete__lit_start_);
    // prod(sort("Thing"),[lit("start"),layouts("LAYOUTLIST"),conditional(empty(),{\not-follow(lit("returns"))})],{})
    expect(Thing.prod__Thing__lit_start_layouts_LAYOUTLIST_conditional__empty__not_follow__lit_returns_);
    // prod(sort("Thing"),[lit("start"),layouts("LAYOUTLIST"),lit("returns"),layouts("LAYOUTLIST"),lit("["),layouts("LAYOUTLIST"),\iter-star-seps(sort("FormalParameter"),[layouts("LAYOUTLIST"),lit(","),layouts("LAYOUTLIST")]),layouts("LAYOUTLIST"),lit("]")],{})
    expect(Thing.prod__Thing__lit_start_layouts_LAYOUTLIST_lit_returns_layouts_LAYOUTLIST_lit___91_layouts_LAYOUTLIST_iter_star_seps__FormalParameter__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___93_);
  }
  public void Identifier() {
    
    
    // prod(sort("Identifier"),[conditional(lit("\<init\>"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(Identifier.prod__Identifier__conditional__lit___60_105_110_105_116_62__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(sort("Identifier"),[\char-class([range(36,36),range(65,90),range(95,95),range(97,122)]),layouts("LAYOUTLIST"),conditional(\iter-star-seps(\char-class([range(36,36),range(48,57),range(65,90),range(95,95),range(97,122)]),[layouts("LAYOUTLIST")]),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(Identifier.prod__Identifier__char_class___range__36_36_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_conditional__iter_star_seps__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122__layouts_LAYOUTLIST__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(sort("Identifier"),[\char-class([range(36,36),range(65,90),range(95,95),range(97,122)]),layouts("$default$"),conditional(\iter-star-seps(\char-class([range(36,36),range(48,57),range(65,90),range(95,95),range(97,122)]),[layouts("$default$")]),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(Identifier.prod__Identifier__char_class___range__36_36_range__65_90_range__95_95_range__97_122_layouts_$default$_conditional__iter_star_seps__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122__layouts_$default$__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(sort("Identifier"),[conditional(lit("\<static-init\>"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(Identifier.prod__Identifier__conditional__lit___60_115_116_97_116_105_99_45_105_110_105_116_62__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(sort("Identifier"),[conditional(lit("\<default-package\>"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(Identifier.prod__Identifier__conditional__lit___60_100_101_102_97_117_108_116_45_112_97_99_107_97_103_101_62__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
  }
  public void Comment() {
    
    
    // prod(lex("Comment"),[lit("//"),\iter-star(\char-class([range(0,9),range(11,65535)])),\char-class([range(10,10)])],{})
    expect(Comment.prod__Comment__lit___47_47_iter_star__char_class___range__0_9_range__11_65535_char_class___range__10_10_);
    // prod(lex("Comment"),[lit("/*"),\iter-star(lex("CommentChar")),lit("*/")],{tag(category("Comment"))})
    expect(Comment.prod__Comment__lit___47_42_iter_star__CommentChar_lit___42_47__tag__category___67_111_109_109_101_110_116);
    // prod(lex("Comment"),[lit("/*"),\iter-star(alt({conditional(\char-class([range(42,42)]),{\not-follow(\char-class([range(47,47)]))}),\char-class([range(0,41),range(43,65535)])})),lit("*/")],{})
    expect(Comment.prod__Comment__lit___47_42_iter_star__alt___conditional__char_class___range__42_42__not_follow__char_class___range__47_47_char_class___range__0_41_range__43_65535_lit___42_47_);
    // prod(lex("Comment"),[lit("//"),conditional(\iter-star(\char-class([range(0,9),range(11,65535)])),{\end-of-line()})],{})
    expect(Comment.prod__Comment__lit___47_47_conditional__iter_star__char_class___range__0_9_range__11_65535__end_of_line_);
    // prod(lex("Comment"),[lit("//"),\iter-star(\char-class([range(0,9),range(11,65535)])),\char-class([range(10,10)])],{tag(category("Comment"))})
    expect(Comment.prod__Comment__lit___47_47_iter_star__char_class___range__0_9_range__11_65535_char_class___range__10_10__tag__category___67_111_109_109_101_110_116);
  }
  public void ForUpdate() {
    
    
    // prod(label("StatementExpressionList1",sort("ForUpdate")),[sort("StatementExpressionList")],{})
    expect(ForUpdate.prod__StatementExpressionList1_ForUpdate__StatementExpressionList_);
  }
  public void FieldAccess() {
    
    
    // prod(label("Name11",sort("FieldAccess")),[sort("Name")],{tag(NotSupported("avoid"))})
    expect(FieldAccess.prod__Name11_FieldAccess__Name__tag__NotSupported___97_118_111_105_100);
    // prod(label("super",sort("FieldAccess")),[conditional(lit("super"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts("LAYOUTLIST"),lit("."),layouts("LAYOUTLIST"),conditional(lex("Identifier"),{delete(conditional(keywords("IdentifierKeywords"),{\not-follow(\char-class([range(36,36),range(48,57),range(65,90),range(95,95),range(97,122)]))}))})],{tag(NotSupported("prefer"))})
    expect(FieldAccess.prod__super_FieldAccess__conditional__lit_super__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___46_layouts_LAYOUTLIST_conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122__tag__NotSupported___112_114_101_102_101_114);
    // prod(label("Primary-Identifier",sort("FieldAccess")),[sort("Primary"),layouts("LAYOUTLIST"),lit("."),layouts("LAYOUTLIST"),conditional(lex("Identifier"),{delete(conditional(keywords("IdentifierKeywords"),{\not-follow(\char-class([range(36,36),range(48,57),range(65,90),range(95,95),range(97,122)]))}))})],{})
    expect(FieldAccess.prod__Primary_Identifier_FieldAccess__Primary_layouts_LAYOUTLIST_lit___46_layouts_LAYOUTLIST_conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_);
  }
  public void LabeledStatementNoShortIf() {
    
    
    // prod(label("colon1",sort("LabeledStatementNoShortIf")),[conditional(lex("Identifier"),{delete(conditional(keywords("IdentifierKeywords"),{\not-follow(\char-class([range(36,36),range(48,57),range(65,90),range(95,95),range(97,122)]))}))}),layouts("LAYOUTLIST"),lit(":"),layouts("LAYOUTLIST"),sort("StatementNoShortIf")],{})
    expect(LabeledStatementNoShortIf.prod__colon1_LabeledStatementNoShortIf__conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___58_layouts_LAYOUTLIST_StatementNoShortIf_);
  }
  public void CommentChar() {
    
    
    // prod(lex("CommentChar"),[\char-class([range(0,41),range(43,65535)])],{})
    expect(CommentChar.prod__CommentChar__char_class___range__0_41_range__43_65535_);
    // prod(lex("CommentChar"),[conditional(lex("Asterisk"),{\not-follow(\char-class([range(47,47)]))})],{})
    expect(CommentChar.prod__CommentChar__conditional__Asterisk__not_follow__char_class___range__47_47_);
  }
  public void MethodHeader() {
    
    
    // prod(label("MethodHeader",sort("MethodHeader")),[\iter-star-seps(sort("Modifier"),[layouts("LAYOUTLIST")]),layouts("LAYOUTLIST"),sort("MethodRes"),layouts("LAYOUTLIST"),sort("MethodDeclarator"),layouts("LAYOUTLIST"),opt(sort("Throws"))],{})
    expect(MethodHeader.prod__MethodHeader_MethodHeader__iter_star_seps__Modifier__layouts_LAYOUTLIST_layouts_LAYOUTLIST_MethodRes_layouts_LAYOUTLIST_MethodDeclarator_layouts_LAYOUTLIST_opt__Throws_);
  }
  public void Assignment() {
    
    
    // prod(label("LeftHandSide-AssignmentOperator-Expression",sort("Assignment")),[sort("LeftHandSide"),layouts("LAYOUTLIST"),sort("AssignmentOperator"),layouts("LAYOUTLIST"),sort("Expression")],{})
    expect(Assignment.prod__LeftHandSide_AssignmentOperator_Expression_Assignment__LeftHandSide_layouts_LAYOUTLIST_AssignmentOperator_layouts_LAYOUTLIST_Expression_);
  }
  public void ArrayInitializer() {
    
    
    // prod(label("comma-comma",sort("ArrayInitializer")),[lit("{"),layouts("LAYOUTLIST"),\iter-star-seps(sort("VariableInitializer"),[layouts("LAYOUTLIST"),lit(","),layouts("LAYOUTLIST")]),layouts("LAYOUTLIST"),opt(lit(",")),layouts("LAYOUTLIST"),lit("}")],{})
    expect(ArrayInitializer.prod__comma_comma_ArrayInitializer__lit___123_layouts_LAYOUTLIST_iter_star_seps__VariableInitializer__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_opt__lit___44_layouts_LAYOUTLIST_lit___125_);
  }
  public void Modifier() {
    
    
    // prod(label("public",sort("Modifier")),[conditional(lit("public"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(Modifier.prod__public_Modifier__conditional__lit_public__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(label("static",sort("Modifier")),[conditional(lit("static"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(Modifier.prod__static_Modifier__conditional__lit_static__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(label("final",sort("Modifier")),[conditional(lit("final"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(Modifier.prod__final_Modifier__conditional__lit_final__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(label("transient",sort("Modifier")),[conditional(lit("transient"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(Modifier.prod__transient_Modifier__conditional__lit_transient__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(label("private",sort("Modifier")),[conditional(lit("private"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(Modifier.prod__private_Modifier__conditional__lit_private__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(label("volatile",sort("Modifier")),[conditional(lit("volatile"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(Modifier.prod__volatile_Modifier__conditional__lit_volatile__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(label("abstract",sort("Modifier")),[conditional(lit("abstract"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(Modifier.prod__abstract_Modifier__conditional__lit_abstract__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(label("protected",sort("Modifier")),[conditional(lit("protected"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(Modifier.prod__protected_Modifier__conditional__lit_protected__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(label("synchronized1",sort("Modifier")),[conditional(lit("synchronized"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(Modifier.prod__synchronized1_Modifier__conditional__lit_synchronized__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(label("native",sort("Modifier")),[conditional(lit("native"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(Modifier.prod__native_Modifier__conditional__lit_native__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
  }
  public void SingleTypeImportDeclaration() {
    
    
    // prod(label("import-semicolon",sort("SingleTypeImportDeclaration")),[conditional(lit("import"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts("LAYOUTLIST"),sort("Name"),layouts("LAYOUTLIST"),lit(";")],{})
    expect(SingleTypeImportDeclaration.prod__import_semicolon_SingleTypeImportDeclaration__conditional__lit_import__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Name_layouts_LAYOUTLIST_lit___59_);
  }
  public void ArrayCreationExpression() {
    
    
    // prod(label("new2",sort("ArrayCreationExpression")),[conditional(lit("new"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts("LAYOUTLIST"),sort("PrimitiveType"),layouts("LAYOUTLIST"),\iter-seps(sort("DimExprInitialized"),[layouts("LAYOUTLIST")]),layouts("LAYOUTLIST"),sort("ArrayInitializer")],{})
    expect(ArrayCreationExpression.prod__new2_ArrayCreationExpression__conditional__lit_new__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_PrimitiveType_layouts_LAYOUTLIST_iter_seps__DimExprInitialized__layouts_LAYOUTLIST_layouts_LAYOUTLIST_ArrayInitializer_);
    // prod(label("new",sort("ArrayCreationExpression")),[conditional(lit("new"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts("LAYOUTLIST"),sort("PrimitiveType"),layouts("LAYOUTLIST"),\iter-seps(sort("DimExpr"),[layouts("LAYOUTLIST")]),layouts("LAYOUTLIST"),\iter-star-seps(sort("Dim"),[layouts("LAYOUTLIST")])],{})
    expect(ArrayCreationExpression.prod__new_ArrayCreationExpression__conditional__lit_new__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_PrimitiveType_layouts_LAYOUTLIST_iter_seps__DimExpr__layouts_LAYOUTLIST_layouts_LAYOUTLIST_iter_star_seps__Dim__layouts_LAYOUTLIST_);
    // prod(label("new1",sort("ArrayCreationExpression")),[conditional(lit("new"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts("LAYOUTLIST"),sort("ClassOrInterfaceType"),layouts("LAYOUTLIST"),\iter-seps(sort("DimExpr"),[layouts("LAYOUTLIST")]),layouts("LAYOUTLIST"),\iter-star-seps(sort("Dim"),[layouts("LAYOUTLIST")])],{})
    expect(ArrayCreationExpression.prod__new1_ArrayCreationExpression__conditional__lit_new__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_ClassOrInterfaceType_layouts_LAYOUTLIST_iter_seps__DimExpr__layouts_LAYOUTLIST_layouts_LAYOUTLIST_iter_star_seps__Dim__layouts_LAYOUTLIST_);
    // prod(label("new3",sort("ArrayCreationExpression")),[conditional(lit("new"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts("LAYOUTLIST"),sort("ClassOrInterfaceType"),layouts("LAYOUTLIST"),\iter-seps(sort("DimExprInitialized"),[layouts("LAYOUTLIST")]),layouts("LAYOUTLIST"),sort("ArrayInitializer")],{})
    expect(ArrayCreationExpression.prod__new3_ArrayCreationExpression__conditional__lit_new__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_ClassOrInterfaceType_layouts_LAYOUTLIST_iter_seps__DimExprInitialized__layouts_LAYOUTLIST_layouts_LAYOUTLIST_ArrayInitializer_);
  }
  public void PrimaryNoNewArray() {
    
    
    // prod(label("ArrayAccess",sort("PrimaryNoNewArray")),[sort("ArrayAccess")],{})
    expect(PrimaryNoNewArray.prod__ArrayAccess_PrimaryNoNewArray__ArrayAccess_);
    // prod(label("FieldAccess",sort("PrimaryNoNewArray")),[sort("FieldAccess")],{})
    expect(PrimaryNoNewArray.prod__FieldAccess_PrimaryNoNewArray__FieldAccess_);
    // prod(label("Expression1",sort("PrimaryNoNewArray")),[lit("("),layouts("LAYOUTLIST"),sort("Expression"),layouts("LAYOUTLIST"),lit(")")],{})
    expect(PrimaryNoNewArray.prod__Expression1_PrimaryNoNewArray__lit___40_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___41_);
    // prod(label("Literal",sort("PrimaryNoNewArray")),[sort("Literal")],{tag(NotSupported("avoid"))})
    expect(PrimaryNoNewArray.prod__Literal_PrimaryNoNewArray__Literal__tag__NotSupported___97_118_111_105_100);
    // prod(label("this1",sort("PrimaryNoNewArray")),[sort("Name"),layouts("LAYOUTLIST"),lit("."),layouts("LAYOUTLIST"),conditional(lit("this"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(PrimaryNoNewArray.prod__this1_PrimaryNoNewArray__Name_layouts_LAYOUTLIST_lit___46_layouts_LAYOUTLIST_conditional__lit_this__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(label("MethodInvocation1",sort("PrimaryNoNewArray")),[sort("MethodInvocation")],{})
    expect(PrimaryNoNewArray.prod__MethodInvocation1_PrimaryNoNewArray__MethodInvocation_);
    // prod(label("ClassInstanceCreationExpression1",sort("PrimaryNoNewArray")),[sort("ClassInstanceCreationExpression")],{})
    expect(PrimaryNoNewArray.prod__ClassInstanceCreationExpression1_PrimaryNoNewArray__ClassInstanceCreationExpression_);
    // prod(label("this0",sort("PrimaryNoNewArray")),[conditional(lit("this"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(PrimaryNoNewArray.prod__this0_PrimaryNoNewArray__conditional__lit_this__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
  }
  public void ArrayAccess() {
    
    
    // prod(label("Name-Expression",sort("ArrayAccess")),[sort("Name"),layouts("LAYOUTLIST"),lit("["),layouts("LAYOUTLIST"),sort("Expression"),layouts("LAYOUTLIST"),lit("]")],{})
    expect(ArrayAccess.prod__Name_Expression_ArrayAccess__Name_layouts_LAYOUTLIST_lit___91_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___93_);
    // prod(label("PrimaryNoNewArray-Expression",sort("ArrayAccess")),[sort("PrimaryNoNewArray"),layouts("LAYOUTLIST"),lit("["),layouts("LAYOUTLIST"),sort("Expression"),layouts("LAYOUTLIST"),lit("]")],{tag(NotSupported("prefer"))})
    expect(ArrayAccess.prod__PrimaryNoNewArray_Expression_ArrayAccess__PrimaryNoNewArray_layouts_LAYOUTLIST_lit___91_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___93__tag__NotSupported___112_114_101_102_101_114);
  }
  public void SwitchLabel() {
    
    
    // prod(label("case-colon",sort("SwitchLabel")),[conditional(lit("case"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts("LAYOUTLIST"),sort("Expression"),layouts("LAYOUTLIST"),lit(":")],{})
    expect(SwitchLabel.prod__case_colon_SwitchLabel__conditional__lit_case__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___58_);
    // prod(label("default-colon",sort("SwitchLabel")),[conditional(lit("default"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts("LAYOUTLIST"),lit(":")],{})
    expect(SwitchLabel.prod__default_colon_SwitchLabel__conditional__lit_default__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___58_);
  }
  public void ClassBodyDeclaration() {
    
    
    // prod(label("ClassMemberDeclaration",sort("ClassBodyDeclaration")),[sort("ClassMemberDeclaration")],{})
    expect(ClassBodyDeclaration.prod__ClassMemberDeclaration_ClassBodyDeclaration__ClassMemberDeclaration_);
    // prod(label("ConstructorDeclaration",sort("ClassBodyDeclaration")),[sort("ConstructorDeclaration")],{})
    expect(ClassBodyDeclaration.prod__ConstructorDeclaration_ClassBodyDeclaration__ConstructorDeclaration_);
    // prod(label("StaticInitializer",sort("ClassBodyDeclaration")),[sort("StaticInitializer")],{})
    expect(ClassBodyDeclaration.prod__StaticInitializer_ClassBodyDeclaration__StaticInitializer_);
    // prod(label("ClassDeclaration2",sort("ClassBodyDeclaration")),[sort("InterfaceDeclaration")],{})
    expect(ClassBodyDeclaration.prod__ClassDeclaration2_ClassBodyDeclaration__InterfaceDeclaration_);
    // prod(label("ClassDeclaration1",sort("ClassBodyDeclaration")),[sort("ClassDeclaration")],{})
    expect(ClassBodyDeclaration.prod__ClassDeclaration1_ClassBodyDeclaration__ClassDeclaration_);
    // prod(label("semicolon11",sort("ClassBodyDeclaration")),[lit(";")],{})
    expect(ClassBodyDeclaration.prod__semicolon11_ClassBodyDeclaration__lit___59_);
  }
  public void ClassMemberDeclaration() {
    
    
    // prod(label("FieldDeclaration1",sort("ClassMemberDeclaration")),[sort("FieldDeclaration")],{})
    expect(ClassMemberDeclaration.prod__FieldDeclaration1_ClassMemberDeclaration__FieldDeclaration_);
    // prod(label("MethodDeclaration",sort("ClassMemberDeclaration")),[sort("MethodDeclaration")],{})
    expect(ClassMemberDeclaration.prod__MethodDeclaration_ClassMemberDeclaration__MethodDeclaration_);
    // prod(label("BlockClassMember",sort("ClassMemberDeclaration")),[sort("Block")],{})
    expect(ClassMemberDeclaration.prod__BlockClassMember_ClassMemberDeclaration__Block_);
  }
  public void DimExprInitialized() {
    
    
    // prod(label("Expression-opt",sort("DimExprInitialized")),[lit("["),layouts("LAYOUTLIST"),opt(sort("Expression")),layouts("LAYOUTLIST"),lit("]")],{})
    expect(DimExprInitialized.prod__Expression_opt_DimExprInitialized__lit___91_layouts_LAYOUTLIST_opt__Expression_layouts_LAYOUTLIST_lit___93_);
  }
  public void TryStatement() {
    
    
    // prod(label("try1",sort("TryStatement")),[conditional(lit("try"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts("LAYOUTLIST"),sort("Block"),layouts("LAYOUTLIST"),\iter-star-seps(sort("CatchClause"),[layouts("LAYOUTLIST")]),layouts("LAYOUTLIST"),sort("Finally")],{})
    expect(TryStatement.prod__try1_TryStatement__conditional__lit_try__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Block_layouts_LAYOUTLIST_iter_star_seps__CatchClause__layouts_LAYOUTLIST_layouts_LAYOUTLIST_Finally_);
    // prod(label("try",sort("TryStatement")),[conditional(lit("try"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts("LAYOUTLIST"),sort("Block"),layouts("LAYOUTLIST"),\iter-seps(sort("CatchClause"),[layouts("LAYOUTLIST")])],{})
    expect(TryStatement.prod__try_TryStatement__conditional__lit_try__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Block_layouts_LAYOUTLIST_iter_seps__CatchClause__layouts_LAYOUTLIST_);
  }
  public void MethodDeclarator() {
    
    
    // prod(label("MethodDeclarator",sort("MethodDeclarator")),[sort("MethodDeclarator"),layouts("LAYOUTLIST"),lit("["),layouts("LAYOUTLIST"),lit("]")],{})
    expect(MethodDeclarator.prod__MethodDeclarator_MethodDeclarator__MethodDeclarator_layouts_LAYOUTLIST_lit___91_layouts_LAYOUTLIST_lit___93_);
    // prod(label("comma2",sort("MethodDeclarator")),[conditional(lex("Identifier"),{delete(conditional(keywords("IdentifierKeywords"),{\not-follow(\char-class([range(36,36),range(48,57),range(65,90),range(95,95),range(97,122)]))}))}),layouts("LAYOUTLIST"),lit("("),layouts("LAYOUTLIST"),\iter-star-seps(sort("FormalParameter"),[layouts("LAYOUTLIST"),lit(","),layouts("LAYOUTLIST")]),layouts("LAYOUTLIST"),lit(")")],{})
    expect(MethodDeclarator.prod__comma2_MethodDeclarator__conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_iter_star_seps__FormalParameter__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41_);
  }
  public void LocalVariableDeclaration() {
    
    
    // prod(label("comma",sort("LocalVariableDeclaration")),[sort("Type"),layouts("LAYOUTLIST"),\iter-seps(sort("VariableDeclarator"),[layouts("LAYOUTLIST"),lit(","),layouts("LAYOUTLIST")])],{})
    expect(LocalVariableDeclaration.prod__comma_LocalVariableDeclaration__Type_layouts_LAYOUTLIST_iter_seps__VariableDeclarator__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_);
  }
  public void Identifier() {
    
    
    // prod(lex("Identifier"),[conditional(lit("\<static-init\>"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(Identifier.prod__Identifier__conditional__lit___60_115_116_97_116_105_99_45_105_110_105_116_62__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(lex("Identifier"),[conditional(lit("\<default-package\>"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(Identifier.prod__Identifier__conditional__lit___60_100_101_102_97_117_108_116_45_112_97_99_107_97_103_101_62__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(lex("Identifier"),[conditional(lit("\<init\>"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(Identifier.prod__Identifier__conditional__lit___60_105_110_105_116_62__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(lex("Identifier"),[\char-class([range(36,36),range(65,90),range(95,95),range(97,122)]),conditional(\iter-star(\char-class([range(36,36),range(48,57),range(65,90),range(95,95),range(97,122)])),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(Identifier.prod__Identifier__char_class___range__36_36_range__65_90_range__95_95_range__97_122_conditional__iter_star__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
  }
  public void NatCon() {
    
    
    // prod(label("digits",lex("NatCon")),[iter(\char-class([range(48,57)]))],{})
    expect(NatCon.prod__digits_NatCon__iter__char_class___range__48_57_);
  }
  public void ExplicitConstructorInvocation() {
    
    
    // prod(label("super-comma-semicolon",sort("ExplicitConstructorInvocation")),[conditional(lit("super"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts("LAYOUTLIST"),lit("("),layouts("LAYOUTLIST"),\iter-star-seps(sort("Expression"),[layouts("LAYOUTLIST"),lit(","),layouts("LAYOUTLIST")]),layouts("LAYOUTLIST"),lit(")"),layouts("LAYOUTLIST"),lit(";")],{})
    expect(ExplicitConstructorInvocation.prod__super_comma_semicolon_ExplicitConstructorInvocation__conditional__lit_super__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_iter_star_seps__Expression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_lit___59_);
    // prod(label("this-comma-semicolon",sort("ExplicitConstructorInvocation")),[conditional(lit("this"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts("LAYOUTLIST"),lit("("),layouts("LAYOUTLIST"),\iter-star-seps(sort("Expression"),[layouts("LAYOUTLIST"),lit(","),layouts("LAYOUTLIST")]),layouts("LAYOUTLIST"),lit(")"),layouts("LAYOUTLIST"),lit(";")],{})
    expect(ExplicitConstructorInvocation.prod__this_comma_semicolon_ExplicitConstructorInvocation__conditional__lit_this__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_iter_star_seps__Expression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_lit___59_);
  }
  public void LabeledStatement() {
    
    
    // prod(label("colon",sort("LabeledStatement")),[conditional(lex("Identifier"),{delete(conditional(keywords("IdentifierKeywords"),{\not-follow(\char-class([range(36,36),range(48,57),range(65,90),range(95,95),range(97,122)]))}))}),layouts("LAYOUTLIST"),lit(":"),layouts("LAYOUTLIST"),sort("Statement")],{})
    expect(LabeledStatement.prod__colon_LabeledStatement__conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___58_layouts_LAYOUTLIST_Statement_);
  }
  public void MethodBody() {
    
    
    // prod(label("Block1",sort("MethodBody")),[sort("Block")],{})
    expect(MethodBody.prod__Block1_MethodBody__Block_);
    // prod(label("semicolon3",sort("MethodBody")),[lit(";")],{})
    expect(MethodBody.prod__semicolon3_MethodBody__lit___59_);
  }
  public void FieldDeclaration() {
    
    
    // prod(label("comma-semicolon",sort("FieldDeclaration")),[\iter-star-seps(sort("Modifier"),[layouts("LAYOUTLIST")]),layouts("LAYOUTLIST"),sort("Type"),layouts("LAYOUTLIST"),\iter-seps(sort("VariableDeclarator"),[layouts("LAYOUTLIST"),lit(","),layouts("LAYOUTLIST")]),layouts("LAYOUTLIST"),lit(";")],{})
    expect(FieldDeclaration.prod__comma_semicolon_FieldDeclaration__iter_star_seps__Modifier__layouts_LAYOUTLIST_layouts_LAYOUTLIST_Type_layouts_LAYOUTLIST_iter_seps__VariableDeclarator__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___59_);
  }
  public void DecimalLongLiteral() {
    
    
    // prod(lex("DecimalLongLiteral"),[lit("0"),\char-class([range(76,76),range(108,108)])],{})
    expect(DecimalLongLiteral.prod__DecimalLongLiteral__lit_0_char_class___range__76_76_range__108_108_);
    // prod(lex("DecimalLongLiteral"),[\char-class([range(49,57)]),\iter-star(\char-class([range(48,57)])),\char-class([range(76,76),range(108,108)])],{})
    expect(DecimalLongLiteral.prod__DecimalLongLiteral__char_class___range__49_57_iter_star__char_class___range__48_57_char_class___range__76_76_range__108_108_);
  }
  public void SwitchBlockStatementGroup() {
    
    
    // prod(label("SwitchLabel-p-BlockStatement-p",sort("SwitchBlockStatementGroup")),[\iter-seps(sort("SwitchLabel"),[layouts("LAYOUTLIST")]),layouts("LAYOUTLIST"),\iter-seps(sort("BlockStatement"),[layouts("LAYOUTLIST")])],{})
    expect(SwitchBlockStatementGroup.prod__SwitchLabel_p_BlockStatement_p_SwitchBlockStatementGroup__iter_seps__SwitchLabel__layouts_LAYOUTLIST_layouts_LAYOUTLIST_iter_seps__BlockStatement__layouts_LAYOUTLIST_);
  }
  public void start__View() {
    
    
    // prod(start(sort("View")),[layouts("LAYOUTLIST"),label("top",sort("View")),layouts("LAYOUTLIST")],{})
    expect(start__View.prod__start__View__layouts_LAYOUTLIST_top_View_layouts_LAYOUTLIST_);
  }
  public void FormalParameter() {
    
    
    // prod(label("Type-VariableDeclaratorId",sort("FormalParameter")),[\iter-star-seps(sort("Modifier"),[layouts("LAYOUTLIST")]),layouts("LAYOUTLIST"),sort("Type"),layouts("LAYOUTLIST"),sort("VariableDeclaratorId")],{})
    expect(FormalParameter.prod__Type_VariableDeclaratorId_FormalParameter__iter_star_seps__Modifier__layouts_LAYOUTLIST_layouts_LAYOUTLIST_Type_layouts_LAYOUTLIST_VariableDeclaratorId_);
  }
  public void InterfaceBody() {
    
    
    // prod(label("InterfaceMemberDeclaration-s",sort("InterfaceBody")),[lit("{"),layouts("LAYOUTLIST"),\iter-star-seps(sort("InterfaceMemberDeclaration"),[layouts("LAYOUTLIST")]),layouts("LAYOUTLIST"),lit("}")],{})
    expect(InterfaceBody.prod__InterfaceMemberDeclaration_s_InterfaceBody__lit___123_layouts_LAYOUTLIST_iter_star_seps__InterfaceMemberDeclaration__layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___125_);
  }
  public void InterfaceMemberDeclaration() {
    
    
    // prod(label("AbstractMethodDeclaration",sort("InterfaceMemberDeclaration")),[sort("AbstractMethodDeclaration")],{})
    expect(InterfaceMemberDeclaration.prod__AbstractMethodDeclaration_InterfaceMemberDeclaration__AbstractMethodDeclaration_);
    // prod(label("ConstantDeclaration",sort("InterfaceMemberDeclaration")),[sort("ConstantDeclaration")],{})
    expect(InterfaceMemberDeclaration.prod__ConstantDeclaration_InterfaceMemberDeclaration__ConstantDeclaration_);
    // prod(label("InnerInterfaceDeclaration",sort("InterfaceMemberDeclaration")),[sort("InterfaceDeclaration")],{})
    expect(InterfaceMemberDeclaration.prod__InnerInterfaceDeclaration_InterfaceMemberDeclaration__InterfaceDeclaration_);
    // prod(label("InnerClassDeclaration",sort("InterfaceMemberDeclaration")),[sort("ClassDeclaration")],{})
    expect(InterfaceMemberDeclaration.prod__InnerClassDeclaration_InterfaceMemberDeclaration__ClassDeclaration_);
  }
  public void Block() {
    
    
    // prod(label("BlockStatement-s",sort("Block")),[lit("{"),layouts("LAYOUTLIST"),\iter-star-seps(sort("BlockStatement"),[layouts("LAYOUTLIST")]),layouts("LAYOUTLIST"),lit("}")],{})
    expect(Block.prod__BlockStatement_s_Block__lit___123_layouts_LAYOUTLIST_iter_star_seps__BlockStatement__layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___125_);
  }
  public void Throws() {
    
    
    // prod(label("throws-comma",sort("Throws")),[conditional(lit("throws"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts("LAYOUTLIST"),\iter-seps(sort("ClassType"),[layouts("LAYOUTLIST"),lit(","),layouts("LAYOUTLIST")])],{})
    expect(Throws.prod__throws_comma_Throws__conditional__lit_throws__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_iter_seps__ClassType__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_);
  }
  public void Dim() {
    
    
    // prod(label("Dim-dunno-a_0",sort("Dim")),[lit("["),layouts("LAYOUTLIST"),lit("]")],{})
    expect(Dim.prod__Dim_dunno_a_0_Dim__lit___91_layouts_LAYOUTLIST_lit___93_);
  }
  public void ContinueStatement() {
    
    
    // prod(label("continue-semicolon",sort("ContinueStatement")),[conditional(lit("continue"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts("LAYOUTLIST"),opt(lex("Identifier")),layouts("LAYOUTLIST"),lit(";")],{})
    expect(ContinueStatement.prod__continue_semicolon_ContinueStatement__conditional__lit_continue__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_opt__Identifier_layouts_LAYOUTLIST_lit___59_);
  }
  public void ImportDeclaration() {
    
    
    // prod(label("TypeImportOnDemandDeclaration",sort("ImportDeclaration")),[sort("TypeImportOnDemandDeclaration")],{})
    expect(ImportDeclaration.prod__TypeImportOnDemandDeclaration_ImportDeclaration__TypeImportOnDemandDeclaration_);
    // prod(label("SingleTypeImportDeclaration",sort("ImportDeclaration")),[sort("SingleTypeImportDeclaration")],{})
    expect(ImportDeclaration.prod__SingleTypeImportDeclaration_ImportDeclaration__SingleTypeImportDeclaration_);
  }
  public void Whitespace() {
    
    
    // prod(lex("Whitespace"),[\char-class([range(9,10),range(12,13),range(32,32)])],{})
    expect(Whitespace.prod__Whitespace__char_class___range__9_10_range__12_13_range__32_32_);
  }
  public void LongLiteral() {
    
    
    // prod(label("DecimalLongLiteral",sort("LongLiteral")),[conditional(lex("DecimalLongLiteral"),{\not-follow(\char-class([range(46,46),range(48,57),range(65,90),range(95,95),range(97,122)]))})],{tag(NotSupported("prefer"))})
    expect(LongLiteral.prod__DecimalLongLiteral_LongLiteral__conditional__DecimalLongLiteral__not_follow__char_class___range__46_46_range__48_57_range__65_90_range__95_95_range__97_122__tag__NotSupported___112_114_101_102_101_114);
    // prod(label("HexLongLiteral",sort("LongLiteral")),[conditional(lex("HexLongLiteral"),{\not-follow(\char-class([range(46,46),range(48,57),range(65,90),range(95,95),range(97,122)]))})],{tag(NotSupported("prefer"))})
    expect(LongLiteral.prod__HexLongLiteral_LongLiteral__conditional__HexLongLiteral__not_follow__char_class___range__46_46_range__48_57_range__65_90_range__95_95_range__97_122__tag__NotSupported___112_114_101_102_101_114);
    // prod(label("OctalLongLiteral",sort("LongLiteral")),[conditional(lex("OctalLongLiteral"),{\not-follow(\char-class([range(46,46),range(48,57),range(65,90),range(95,95),range(97,122)]))})],{tag(NotSupported("prefer"))})
    expect(LongLiteral.prod__OctalLongLiteral_LongLiteral__conditional__OctalLongLiteral__not_follow__char_class___range__46_46_range__48_57_range__65_90_range__95_95_range__97_122__tag__NotSupported___112_114_101_102_101_114);
  }
  public void HexLongLiteral() {
    
    
    // prod(lex("HexLongLiteral"),[\char-class([range(48,48)]),\char-class([range(88,88),range(120,120)]),iter(\char-class([range(48,57),range(65,70),range(97,102)])),\char-class([range(76,76),range(108,108)])],{})
    expect(HexLongLiteral.prod__HexLongLiteral__char_class___range__48_48_char_class___range__88_88_range__120_120_iter__char_class___range__48_57_range__65_70_range__97_102_char_class___range__76_76_range__108_108_);
  }
  public void MethodInvocation() {
    
    
    // prod(label("comma11",sort("MethodInvocation")),[sort("Name"),layouts("LAYOUTLIST"),lit("("),layouts("LAYOUTLIST"),\iter-star-seps(sort("Expression"),[layouts("LAYOUTLIST"),lit(","),layouts("LAYOUTLIST")]),layouts("LAYOUTLIST"),lit(")")],{tag(NotSupported("avoid"))})
    expect(MethodInvocation.prod__comma11_MethodInvocation__Name_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_iter_star_seps__Expression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41__tag__NotSupported___97_118_111_105_100);
    // prod(label("comma21",sort("MethodInvocation")),[sort("Primary"),layouts("LAYOUTLIST"),lit("."),layouts("LAYOUTLIST"),conditional(lex("Identifier"),{delete(conditional(keywords("IdentifierKeywords"),{\not-follow(\char-class([range(36,36),range(48,57),range(65,90),range(95,95),range(97,122)]))}))}),layouts("LAYOUTLIST"),lit("("),layouts("LAYOUTLIST"),\iter-star-seps(sort("Expression"),[layouts("LAYOUTLIST"),lit(","),layouts("LAYOUTLIST")]),layouts("LAYOUTLIST"),lit(")")],{})
    expect(MethodInvocation.prod__comma21_MethodInvocation__Primary_layouts_LAYOUTLIST_lit___46_layouts_LAYOUTLIST_conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_iter_star_seps__Expression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41_);
    // prod(label("super-comma",sort("MethodInvocation")),[conditional(lit("super"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts("LAYOUTLIST"),lit("."),layouts("LAYOUTLIST"),conditional(lex("Identifier"),{delete(conditional(keywords("IdentifierKeywords"),{\not-follow(\char-class([range(36,36),range(48,57),range(65,90),range(95,95),range(97,122)]))}))}),layouts("LAYOUTLIST"),lit("("),layouts("LAYOUTLIST"),\iter-star-seps(sort("Expression"),[layouts("LAYOUTLIST"),lit(","),layouts("LAYOUTLIST")]),layouts("LAYOUTLIST"),lit(")")],{tag(NotSupported("prefer"))})
    expect(MethodInvocation.prod__super_comma_MethodInvocation__conditional__lit_super__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___46_layouts_LAYOUTLIST_conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_iter_star_seps__Expression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41__tag__NotSupported___112_114_101_102_101_114);
    // prod(label("MethodInvocationConstructor",sort("MethodInvocation")),[sort("Primary"),layouts("LAYOUTLIST"),lit("."),layouts("LAYOUTLIST"),sort("ClassInstanceCreationExpression")],{tag(NotSupported("prefer"))})
    expect(MethodInvocation.prod__MethodInvocationConstructor_MethodInvocation__Primary_layouts_LAYOUTLIST_lit___46_layouts_LAYOUTLIST_ClassInstanceCreationExpression__tag__NotSupported___112_114_101_102_101_114);
  }
  public void DimExpr() {
    
    
    // prod(label("Expression2",sort("DimExpr")),[lit("["),layouts("LAYOUTLIST"),sort("Expression"),layouts("LAYOUTLIST"),lit("]")],{})
    expect(DimExpr.prod__Expression2_DimExpr__lit___91_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___93_);
  }
  public void Interfaces() {
    
    
    // prod(label("implements-comma",sort("Interfaces")),[conditional(lit("implements"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts("LAYOUTLIST"),\iter-seps(sort("InterfaceType"),[layouts("LAYOUTLIST"),lit(","),layouts("LAYOUTLIST")])],{})
    expect(Interfaces.prod__implements_comma_Interfaces__conditional__lit_implements__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_iter_seps__InterfaceType__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_);
  }
  public void SwitchStatement() {
    
    
    // prod(label("switch",sort("SwitchStatement")),[lit("switch"),layouts("LAYOUTLIST"),lit("("),layouts("LAYOUTLIST"),sort("Expression"),layouts("LAYOUTLIST"),lit(")"),layouts("LAYOUTLIST"),sort("SwitchBlock")],{})
    expect(SwitchStatement.prod__switch_SwitchStatement__lit_switch_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_SwitchBlock_);
  }
  public void ClassOrInterfaceType() {
    
    
    // prod(label("Name",sort("ClassOrInterfaceType")),[sort("Name")],{})
    expect(ClassOrInterfaceType.prod__Name_ClassOrInterfaceType__Name_);
  }
  public void StatementWithoutTrailingSubstatement() {
    
    
    // prod(label("EmptyStatement",sort("StatementWithoutTrailingSubstatement")),[sort("EmptyStatement")],{})
    expect(StatementWithoutTrailingSubstatement.prod__EmptyStatement_StatementWithoutTrailingSubstatement__EmptyStatement_);
    // prod(label("TryStatement",sort("StatementWithoutTrailingSubstatement")),[sort("TryStatement")],{})
    expect(StatementWithoutTrailingSubstatement.prod__TryStatement_StatementWithoutTrailingSubstatement__TryStatement_);
    // prod(label("ReturnStatement",sort("StatementWithoutTrailingSubstatement")),[sort("ReturnStatement")],{})
    expect(StatementWithoutTrailingSubstatement.prod__ReturnStatement_StatementWithoutTrailingSubstatement__ReturnStatement_);
    // prod(label("ThrowStatement",sort("StatementWithoutTrailingSubstatement")),[sort("ThrowStatement")],{})
    expect(StatementWithoutTrailingSubstatement.prod__ThrowStatement_StatementWithoutTrailingSubstatement__ThrowStatement_);
    // prod(label("DoStatement",sort("StatementWithoutTrailingSubstatement")),[sort("DoStatement")],{})
    expect(StatementWithoutTrailingSubstatement.prod__DoStatement_StatementWithoutTrailingSubstatement__DoStatement_);
    // prod(label("SynchronizedStatement",sort("StatementWithoutTrailingSubstatement")),[sort("SynchronizedStatement")],{})
    expect(StatementWithoutTrailingSubstatement.prod__SynchronizedStatement_StatementWithoutTrailingSubstatement__SynchronizedStatement_);
    // prod(label("Block",sort("StatementWithoutTrailingSubstatement")),[sort("Block")],{})
    expect(StatementWithoutTrailingSubstatement.prod__Block_StatementWithoutTrailingSubstatement__Block_);
    // prod(label("SwitchStatement",sort("StatementWithoutTrailingSubstatement")),[sort("SwitchStatement")],{})
    expect(StatementWithoutTrailingSubstatement.prod__SwitchStatement_StatementWithoutTrailingSubstatement__SwitchStatement_);
    // prod(label("ContinueStatement",sort("StatementWithoutTrailingSubstatement")),[sort("ContinueStatement")],{})
    expect(StatementWithoutTrailingSubstatement.prod__ContinueStatement_StatementWithoutTrailingSubstatement__ContinueStatement_);
    // prod(label("ExpressionStatement",sort("StatementWithoutTrailingSubstatement")),[sort("ExpressionStatement")],{})
    expect(StatementWithoutTrailingSubstatement.prod__ExpressionStatement_StatementWithoutTrailingSubstatement__ExpressionStatement_);
    // prod(label("BreakStatement",sort("StatementWithoutTrailingSubstatement")),[sort("BreakStatement")],{})
    expect(StatementWithoutTrailingSubstatement.prod__BreakStatement_StatementWithoutTrailingSubstatement__BreakStatement_);
  }
  public void HexIntegerLiteral() {
    
    
    // prod(lex("HexIntegerLiteral"),[\char-class([range(48,48)]),\char-class([range(88,88),range(120,120)]),iter(\char-class([range(48,57),range(65,70),range(97,102)]))],{})
    expect(HexIntegerLiteral.prod__HexIntegerLiteral__char_class___range__48_48_char_class___range__88_88_range__120_120_iter__char_class___range__48_57_range__65_70_range__97_102_);
  }
  public void BlockStatement() {
    
    
    // prod(label("Statement",sort("BlockStatement")),[sort("Statement")],{})
    expect(BlockStatement.prod__Statement_BlockStatement__Statement_);
    // prod(label("LocalVariableDeclarationStatement",sort("BlockStatement")),[\iter-star-seps(sort("Modifier"),[layouts("LAYOUTLIST")]),layouts("LAYOUTLIST"),sort("LocalVariableDeclarationStatement")],{})
    expect(BlockStatement.prod__LocalVariableDeclarationStatement_BlockStatement__iter_star_seps__Modifier__layouts_LAYOUTLIST_layouts_LAYOUTLIST_LocalVariableDeclarationStatement_);
  }
  public void CharacterLiteral() {
    
    
    // prod(lex("CharacterLiteral"),[lit("\'\\"),lex("EscapeSequence"),lit("\'\\")],{})
    expect(CharacterLiteral.prod__CharacterLiteral__lit___39_EscapeSequence_lit___39_);
    // prod(lex("CharacterLiteral"),[lit("\'\\"),lex("SingleCharacter"),lit("\'\\")],{})
    expect(CharacterLiteral.prod__CharacterLiteral__lit___39_SingleCharacter_lit___39_);
  }
  public void ANTLR() {
    
    
    // prod(sort("ANTLR"),[lit("grammar"),layouts("LAYOUTLIST"),lex("Identifier"),layouts("LAYOUTLIST"),lit(";"),layouts("LAYOUTLIST"),\iter-seps(sort("Thing"),[layouts("LAYOUTLIST")])],{})
    expect(ANTLR.prod__ANTLR__lit_grammar_layouts_LAYOUTLIST_Identifier_layouts_LAYOUTLIST_lit___59_layouts_LAYOUTLIST_iter_seps__Thing__layouts_LAYOUTLIST_);
  }
  public void DoubleLiteral() {
    
    
    // prod(lex("DoubleLiteral"),[iter(\char-class([range(48,57)])),opt(seq([\char-class([range(69,69),range(101,101)]),opt(\char-class([range(43,43),range(45,45)])),iter(\char-class([range(48,57)]))])),\char-class([range(68,68),range(100,100)])],{})
    expect(DoubleLiteral.prod__DoubleLiteral__iter__char_class___range__48_57_opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_char_class___range__68_68_range__100_100_);
    // prod(lex("DoubleLiteral"),[iter(\char-class([range(48,57)])),lit("."),\iter-star(\char-class([range(48,57)])),opt(seq([\char-class([range(69,69),range(101,101)]),opt(\char-class([range(43,43),range(45,45)])),iter(\char-class([range(48,57)]))])),opt(\char-class([range(68,68),range(100,100)]))],{})
    expect(DoubleLiteral.prod__DoubleLiteral__iter__char_class___range__48_57_lit___46_iter_star__char_class___range__48_57_opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_opt__char_class___range__68_68_range__100_100_);
    // prod(lex("DoubleLiteral"),[iter(\char-class([range(48,57)])),\char-class([range(69,69),range(101,101)]),opt(\char-class([range(43,43),range(45,45)])),iter(\char-class([range(48,57)])),opt(\char-class([range(68,68),range(100,100)]))],{})
    expect(DoubleLiteral.prod__DoubleLiteral__iter__char_class___range__48_57_char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_opt__char_class___range__68_68_range__100_100_);
    // prod(lex("DoubleLiteral"),[lit("."),iter(\char-class([range(48,57)])),opt(seq([\char-class([range(69,69),range(101,101)]),opt(\char-class([range(43,43),range(45,45)])),iter(\char-class([range(48,57)]))])),opt(\char-class([range(68,68),range(100,100)]))],{})
    expect(DoubleLiteral.prod__DoubleLiteral__lit___46_iter__char_class___range__48_57_opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_opt__char_class___range__68_68_range__100_100_);
  }
  public void ExpressionStatement() {
    
    
    // prod(label("semicolon2",sort("ExpressionStatement")),[sort("StatementExpression"),layouts("LAYOUTLIST"),lit(";")],{})
    expect(ExpressionStatement.prod__semicolon2_ExpressionStatement__StatementExpression_layouts_LAYOUTLIST_lit___59_);
  }
  public void IfThenStatement() {
    
    
    // prod(label("if",sort("IfThenStatement")),[lit("if"),layouts("LAYOUTLIST"),lit("("),layouts("LAYOUTLIST"),sort("Expression"),layouts("LAYOUTLIST"),lit(")"),layouts("LAYOUTLIST"),sort("Statement")],{})
    expect(IfThenStatement.prod__if_IfThenStatement__lit_if_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_Statement_);
  }
  public void ForStatementNoShortIf() {
    
    
    // prod(label("for-semicolon-semicolon",sort("ForStatementNoShortIf")),[lit("for"),layouts("LAYOUTLIST"),lit("("),layouts("LAYOUTLIST"),opt(sort("ForInit")),layouts("LAYOUTLIST"),lit(";"),layouts("LAYOUTLIST"),opt(sort("Expression")),layouts("LAYOUTLIST"),lit(";"),layouts("LAYOUTLIST"),opt(sort("ForUpdate")),layouts("LAYOUTLIST"),lit(")"),layouts("LAYOUTLIST"),sort("StatementNoShortIf")],{})
    expect(ForStatementNoShortIf.prod__for_semicolon_semicolon_ForStatementNoShortIf__lit_for_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_opt__ForInit_layouts_LAYOUTLIST_lit___59_layouts_LAYOUTLIST_opt__Expression_layouts_LAYOUTLIST_lit___59_layouts_LAYOUTLIST_opt__ForUpdate_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_StatementNoShortIf_);
  }
  public void File() {
    
    
    // prod(label("file-with-header",sort("File")),[lex("FileHeader"),layouts("LAYOUTLIST"),sort("CompilationUnit")],{})
    expect(File.prod__file_with_header_File__FileHeader_layouts_LAYOUTLIST_CompilationUnit_);
    // prod(sort("File"),[opt(lit("/")),layouts("LAYOUTLIST"),\iter-seps(lex("Identifier"),[layouts("LAYOUTLIST"),lit("/"),layouts("LAYOUTLIST")]),layouts("LAYOUTLIST"),opt(seq([lit("."),layouts("LAYOUTLIST"),lex("Identifier")]))],{})
    expect(File.prod__File__opt__lit___47_layouts_LAYOUTLIST_iter_seps__Identifier__layouts_LAYOUTLIST_lit___47_layouts_LAYOUTLIST_layouts_LAYOUTLIST_opt__seq___lit___46_layouts_LAYOUTLIST_Identifier_);
  }
  public void SwitchBlock() {
    
    
    // prod(label("SwitchBlockStatementGroup-s-SwitchLabel-s",sort("SwitchBlock")),[lit("{"),layouts("LAYOUTLIST"),\iter-star-seps(sort("SwitchBlockStatementGroup"),[layouts("LAYOUTLIST")]),layouts("LAYOUTLIST"),\iter-star-seps(sort("SwitchLabel"),[layouts("LAYOUTLIST")]),layouts("LAYOUTLIST"),lit("}")],{})
    expect(SwitchBlock.prod__SwitchBlockStatementGroup_s_SwitchLabel_s_SwitchBlock__lit___123_layouts_LAYOUTLIST_iter_star_seps__SwitchBlockStatementGroup__layouts_LAYOUTLIST_layouts_LAYOUTLIST_iter_star_seps__SwitchLabel__layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___125_);
  }
  public void FileHeader() {
    
    
    // prod(lex("FileHeader"),[lit("FILE:"),\iter-star(\char-class([range(0,9),range(11,65535)])),lit("\n")],{})
    expect(FileHeader.prod__FileHeader__lit___70_73_76_69_58_iter_star__char_class___range__0_9_range__11_65535_lit___10_);
  }
  public void LeftHandSide() {
    
    
    // prod(label("FieldAccess1",sort("LeftHandSide")),[sort("FieldAccess")],{})
    expect(LeftHandSide.prod__FieldAccess1_LeftHandSide__FieldAccess_);
    // prod(label("ArrayAccess1",sort("LeftHandSide")),[sort("ArrayAccess")],{})
    expect(LeftHandSide.prod__ArrayAccess1_LeftHandSide__ArrayAccess_);
  }
  public void ConstructorDeclarator() {
    
    
    // prod(label("comma5",sort("ConstructorDeclarator")),[sort("SimpleName"),layouts("LAYOUTLIST"),lit("("),layouts("LAYOUTLIST"),\iter-star-seps(sort("FormalParameter"),[layouts("LAYOUTLIST"),lit(","),layouts("LAYOUTLIST")]),layouts("LAYOUTLIST"),lit(")")],{})
    expect(ConstructorDeclarator.prod__comma5_ConstructorDeclarator__SimpleName_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_iter_star_seps__FormalParameter__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41_);
  }
  public void AbstractMethodDeclaration() {
    
    
    // prod(label("semicolon4",sort("AbstractMethodDeclaration")),[sort("MethodHeader"),layouts("LAYOUTLIST"),lit(";")],{})
    expect(AbstractMethodDeclaration.prod__semicolon4_AbstractMethodDeclaration__MethodHeader_layouts_LAYOUTLIST_lit___59_);
  }
  public void ExtendsInterfaces() {
    
    
    // prod(label("extends-comma",sort("ExtendsInterfaces")),[conditional(lit("extends"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts("LAYOUTLIST"),\iter-seps(sort("InterfaceType"),[layouts("LAYOUTLIST"),lit(","),layouts("LAYOUTLIST")])],{})
    expect(ExtendsInterfaces.prod__extends_comma_ExtendsInterfaces__conditional__lit_extends__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_iter_seps__InterfaceType__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_);
  }
  public void IntegerLiteral() {
    
    
    // prod(label("DecimalIntegerLiteral",sort("IntegerLiteral")),[conditional(lex("DecimalIntegerLiteral"),{\not-follow(\char-class([range(46,46),range(48,57),range(65,90),range(95,95),range(97,122)]))})],{tag(NotSupported("prefer"))})
    expect(IntegerLiteral.prod__DecimalIntegerLiteral_IntegerLiteral__conditional__DecimalIntegerLiteral__not_follow__char_class___range__46_46_range__48_57_range__65_90_range__95_95_range__97_122__tag__NotSupported___112_114_101_102_101_114);
    // prod(label("OctalIntegerLiteral",sort("IntegerLiteral")),[conditional(lex("OctalIntegerLiteral"),{\not-follow(\char-class([range(46,46),range(48,57),range(65,90),range(95,95),range(97,122)]))})],{tag(NotSupported("prefer"))})
    expect(IntegerLiteral.prod__OctalIntegerLiteral_IntegerLiteral__conditional__OctalIntegerLiteral__not_follow__char_class___range__46_46_range__48_57_range__65_90_range__95_95_range__97_122__tag__NotSupported___112_114_101_102_101_114);
    // prod(label("HexIntegerLiteral",sort("IntegerLiteral")),[conditional(lex("HexIntegerLiteral"),{\not-follow(\char-class([range(46,46),range(48,57),range(65,90),range(95,95),range(97,122)]))})],{tag(NotSupported("prefer"))})
    expect(IntegerLiteral.prod__HexIntegerLiteral_IntegerLiteral__conditional__HexIntegerLiteral__not_follow__char_class___range__46_46_range__48_57_range__65_90_range__95_95_range__97_122__tag__NotSupported___112_114_101_102_101_114);
  }
  public void IfThenElseStatementNoShortIf() {
    
    
    // prod(label("if-else",sort("IfThenElseStatementNoShortIf")),[lit("if"),layouts("LAYOUTLIST"),lit("("),layouts("LAYOUTLIST"),sort("Expression"),layouts("LAYOUTLIST"),lit(")"),layouts("LAYOUTLIST"),sort("StatementNoShortIf"),layouts("LAYOUTLIST"),conditional(lit("else"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts("LAYOUTLIST"),sort("StatementNoShortIf")],{})
    expect(IfThenElseStatementNoShortIf.prod__if_else_IfThenElseStatementNoShortIf__lit_if_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_StatementNoShortIf_layouts_LAYOUTLIST_conditional__lit_else__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_StatementNoShortIf_);
  }
  public void MethodDeclaration() {
    
    
    // prod(label("MethodHeader-MethodBody",sort("MethodDeclaration")),[sort("MethodHeader"),layouts("LAYOUTLIST"),sort("MethodBody")],{})
    expect(MethodDeclaration.prod__MethodHeader_MethodBody_MethodDeclaration__MethodHeader_layouts_LAYOUTLIST_MethodBody_);
  }
  public void CompilationUnit() {
    
    
    // prod(label("PackageDeclaration-opt-ImportDeclaration-s-TypeDeclaration-s",sort("CompilationUnit")),[opt(sort("PackageDeclaration")),layouts("LAYOUTLIST"),\iter-star-seps(sort("ImportDeclaration"),[layouts("LAYOUTLIST")]),layouts("LAYOUTLIST"),\iter-seps(sort("TypeDeclaration"),[layouts("LAYOUTLIST")])],{tag(NotSupported("prefer"))})
    expect(CompilationUnit.prod__PackageDeclaration_opt_ImportDeclaration_s_TypeDeclaration_s_CompilationUnit__opt__PackageDeclaration_layouts_LAYOUTLIST_iter_star_seps__ImportDeclaration__layouts_LAYOUTLIST_layouts_LAYOUTLIST_iter_seps__TypeDeclaration__layouts_LAYOUTLIST__tag__NotSupported___112_114_101_102_101_114);
    // prod(label("field",sort("CompilationUnit")),[sort("FieldDeclaration")],{})
    expect(CompilationUnit.prod__field_CompilationUnit__FieldDeclaration_);
  }
  public void NumericType() {
    
    
    // prod(label("IntegralType",sort("NumericType")),[sort("IntegralType")],{})
    expect(NumericType.prod__IntegralType_NumericType__IntegralType_);
    // prod(label("FloatingPointType",sort("NumericType")),[sort("FloatingPointType")],{})
    expect(NumericType.prod__FloatingPointType_NumericType__FloatingPointType_);
  }
  public void ClassInstanceCreationExpression() {
    
    
    // prod(label("new-comma1",sort("ClassInstanceCreationExpression")),[conditional(lit("new"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts("LAYOUTLIST"),sort("ClassType"),layouts("LAYOUTLIST"),lit("("),layouts("LAYOUTLIST"),\iter-star-seps(sort("Expression"),[layouts("LAYOUTLIST"),lit(","),layouts("LAYOUTLIST")]),layouts("LAYOUTLIST"),lit(")"),layouts("LAYOUTLIST"),sort("ClassBody")],{})
    expect(ClassInstanceCreationExpression.prod__new_comma1_ClassInstanceCreationExpression__conditional__lit_new__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_ClassType_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_iter_star_seps__Expression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_ClassBody_);
    // prod(label("new-comma",sort("ClassInstanceCreationExpression")),[conditional(lit("new"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts("LAYOUTLIST"),sort("ClassType"),layouts("LAYOUTLIST"),lit("("),layouts("LAYOUTLIST"),\iter-star-seps(sort("Expression"),[layouts("LAYOUTLIST"),lit(","),layouts("LAYOUTLIST")]),layouts("LAYOUTLIST"),lit(")")],{})
    expect(ClassInstanceCreationExpression.prod__new_comma_ClassInstanceCreationExpression__conditional__lit_new__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_ClassType_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_iter_star_seps__Expression__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___41_);
  }
  public void Word() {
    
    
    // prod(lex("Word"),[conditional(iter(\char-class([range(0,8),range(11,12),range(14,31),range(33,65535)])),{\not-follow(\char-class([range(0,8),range(11,12),range(14,31),range(33,65535)]))})],{})
    expect(Word.prod__Word__conditional__iter__char_class___range__0_8_range__11_12_range__14_31_range__33_65535__not_follow__char_class___range__0_8_range__11_12_range__14_31_range__33_65535_);
  }
  public void TypeDeclaration() {
    
    
    // prod(label("InterfaceDeclaration",sort("TypeDeclaration")),[sort("InterfaceDeclaration")],{})
    expect(TypeDeclaration.prod__InterfaceDeclaration_TypeDeclaration__InterfaceDeclaration_);
    // prod(label("semicolon5",sort("TypeDeclaration")),[lit(";")],{})
    expect(TypeDeclaration.prod__semicolon5_TypeDeclaration__lit___59_);
    // prod(label("ClassDeclaration11",sort("TypeDeclaration")),[sort("ClassDeclaration")],{})
    expect(TypeDeclaration.prod__ClassDeclaration11_TypeDeclaration__ClassDeclaration_);
  }
  public void DecimalIntegerLiteral() {
    
    
    // prod(lex("DecimalIntegerLiteral"),[lit("0")],{})
    expect(DecimalIntegerLiteral.prod__DecimalIntegerLiteral__lit_0_);
    // prod(lex("DecimalIntegerLiteral"),[\char-class([range(49,57)]),\iter-star(\char-class([range(48,57)]))],{})
    expect(DecimalIntegerLiteral.prod__DecimalIntegerLiteral__char_class___range__49_57_iter_star__char_class___range__48_57_);
  }
  public void StringLiteral() {
    
    
    // prod(label("StringCharacter-s",lex("StringLiteral")),[lit("\""),\iter-star(lex("StringCharacter")),lit("\"")],{})
    expect(StringLiteral.prod__StringCharacter_s_StringLiteral__lit___34_iter_star__StringCharacter_lit___34_);
  }
  public void MethodRes() {
    
    
    // prod(label("type",sort("MethodRes")),[sort("Type")],{})
    expect(MethodRes.prod__type_MethodRes__Type_);
    // prod(label("void",sort("MethodRes")),[conditional(lit("void"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(MethodRes.prod__void_MethodRes__conditional__lit_void__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
  }
  public void Primary() {
    
    
    // prod(label("ArrayCreationExpression",sort("Primary")),[sort("ArrayCreationExpression")],{})
    expect(Primary.prod__ArrayCreationExpression_Primary__ArrayCreationExpression_);
    // prod(label("PrimaryNoNewArray",sort("Primary")),[sort("PrimaryNoNewArray")],{})
    expect(Primary.prod__PrimaryNoNewArray_Primary__PrimaryNoNewArray_);
  }
  public void NullLiteral() {
    
    
    // prod(lex("NullLiteral"),[conditional(lit("null"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(NullLiteral.prod__NullLiteral__conditional__lit_null__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
  }
  public void VariableDeclarator() {
    
    
    // prod(label("VariableDeclaratorId",sort("VariableDeclarator")),[sort("VariableDeclaratorId")],{})
    expect(VariableDeclarator.prod__VariableDeclaratorId_VariableDeclarator__VariableDeclaratorId_);
    // prod(label("equal2",sort("VariableDeclarator")),[sort("VariableDeclaratorId"),layouts("LAYOUTLIST"),lit("="),layouts("LAYOUTLIST"),sort("VariableInitializer")],{})
    expect(VariableDeclarator.prod__equal2_VariableDeclarator__VariableDeclaratorId_layouts_LAYOUTLIST_lit___61_layouts_LAYOUTLIST_VariableInitializer_);
  }
  public void CatchClause() {
    
    
    // prod(label("catch",sort("CatchClause")),[conditional(lit("catch"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts("LAYOUTLIST"),lit("("),layouts("LAYOUTLIST"),sort("FormalParameter"),layouts("LAYOUTLIST"),lit(")"),layouts("LAYOUTLIST"),sort("Block")],{})
    expect(CatchClause.prod__catch_CatchClause__conditional__lit_catch__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_FormalParameter_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_Block_);
  }
  public void VariableDeclaratorId() {
    
    
    // prod(label("VariableDeclaratorId1",sort("VariableDeclaratorId")),[sort("VariableDeclaratorId"),layouts("LAYOUTLIST"),lit("["),layouts("LAYOUTLIST"),lit("]")],{})
    expect(VariableDeclaratorId.prod__VariableDeclaratorId1_VariableDeclaratorId__VariableDeclaratorId_layouts_LAYOUTLIST_lit___91_layouts_LAYOUTLIST_lit___93_);
    // prod(label("Identifier1",sort("VariableDeclaratorId")),[conditional(lex("Identifier"),{delete(conditional(keywords("IdentifierKeywords"),{\not-follow(\char-class([range(36,36),range(48,57),range(65,90),range(95,95),range(97,122)]))}))})],{})
    expect(VariableDeclaratorId.prod__Identifier1_VariableDeclaratorId__conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_);
  }
  public void layouts_$BACKTICKS() {
    
    
    // prod(layouts("$BACKTICKS"),[],{})
    expect(layouts_$BACKTICKS.prod__layouts_$BACKTICKS__);
  }
  public void InterfaceType() {
    
    
    // prod(label("ClassOrInterfaceType2",sort("InterfaceType")),[sort("ClassOrInterfaceType")],{})
    expect(InterfaceType.prod__ClassOrInterfaceType2_InterfaceType__ClassOrInterfaceType_);
  }
  public void TypeImportOnDemandDeclaration() {
    
    
    // prod(label("import-times-semicolon",sort("TypeImportOnDemandDeclaration")),[conditional(lit("import"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts("LAYOUTLIST"),sort("Name"),layouts("LAYOUTLIST"),lit("."),layouts("LAYOUTLIST"),lit("*"),layouts("LAYOUTLIST"),lit(";")],{})
    expect(TypeImportOnDemandDeclaration.prod__import_times_semicolon_TypeImportOnDemandDeclaration__conditional__lit_import__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Name_layouts_LAYOUTLIST_lit___46_layouts_LAYOUTLIST_lit___42_layouts_LAYOUTLIST_lit___59_);
  }
  public void ReturnStatement() {
    
    
    // prod(label("return-semicolon",sort("ReturnStatement")),[conditional(lit("return"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts("LAYOUTLIST"),opt(sort("Expression")),layouts("LAYOUTLIST"),lit(";")],{})
    expect(ReturnStatement.prod__return_semicolon_ReturnStatement__conditional__lit_return__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_opt__Expression_layouts_LAYOUTLIST_lit___59_);
  }
  public void WhileStatementNoShortIf() {
    
    
    // prod(label("while1",sort("WhileStatementNoShortIf")),[lit("while"),layouts("LAYOUTLIST"),lit("("),layouts("LAYOUTLIST"),sort("Expression"),layouts("LAYOUTLIST"),lit(")"),layouts("LAYOUTLIST"),sort("StatementNoShortIf")],{})
    expect(WhileStatementNoShortIf.prod__while1_WhileStatementNoShortIf__lit_while_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_StatementNoShortIf_);
  }
  public void layouts_$default$() {
    
    
    // prod(layouts("$default$"),[],{})
    expect(layouts_$default$.prod__layouts_$default$__);
  }
  public void DoStatement() {
    
    
    // prod(label("do-while-semicolon",sort("DoStatement")),[conditional(lit("do"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts("LAYOUTLIST"),sort("Statement"),layouts("LAYOUTLIST"),conditional(lit("while"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts("LAYOUTLIST"),lit("("),layouts("LAYOUTLIST"),sort("Expression"),layouts("LAYOUTLIST"),lit(")"),layouts("LAYOUTLIST"),lit(";")],{})
    expect(DoStatement.prod__do_while_semicolon_DoStatement__conditional__lit_do__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Statement_layouts_LAYOUTLIST_conditional__lit_while__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_lit___59_);
  }
  public void ReferenceType() {
    
    
    // prod(label("ArrayType",sort("ReferenceType")),[sort("ArrayType")],{})
    expect(ReferenceType.prod__ArrayType_ReferenceType__ArrayType_);
    // prod(label("ClassOrInterfaceType",sort("ReferenceType")),[sort("ClassOrInterfaceType")],{})
    expect(ReferenceType.prod__ClassOrInterfaceType_ReferenceType__ClassOrInterfaceType_);
  }
  public void ClassDeclaration() {
    
    
    // prod(label("class1",sort("ClassDeclaration")),[\iter-star-seps(sort("Modifier"),[layouts("LAYOUTLIST")]),layouts("LAYOUTLIST"),conditional(lit("class"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts("LAYOUTLIST"),conditional(lex("Identifier"),{delete(conditional(keywords("IdentifierKeywords"),{\not-follow(\char-class([range(36,36),range(48,57),range(65,90),range(95,95),range(97,122)]))}))}),layouts("LAYOUTLIST"),opt(sort("Super")),layouts("LAYOUTLIST"),opt(sort("Interfaces")),layouts("LAYOUTLIST"),sort("ClassBody")],{})
    expect(ClassDeclaration.prod__class1_ClassDeclaration__iter_star_seps__Modifier__layouts_LAYOUTLIST_layouts_LAYOUTLIST_conditional__lit_class__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_opt__Super_layouts_LAYOUTLIST_opt__Interfaces_layouts_LAYOUTLIST_ClassBody_);
  }
  public void ConstantDeclaration() {
    
    
    // prod(label("FieldDeclaration",sort("ConstantDeclaration")),[sort("FieldDeclaration")],{})
    expect(ConstantDeclaration.prod__FieldDeclaration_ConstantDeclaration__FieldDeclaration_);
  }
  public void layouts_LAYOUTLIST() {
    
    
    // prod(layouts("LAYOUTLIST"),[conditional(\iter-star(sort("LAYOUT")),{\not-follow(\char-class([range(9,10),range(12,13),range(32,32)])),\not-follow(lit("//")),\not-follow(lit("/*"))})],{})
    expect(layouts_LAYOUTLIST.prod__layouts_LAYOUTLIST__conditional__iter_star__LAYOUT__not_follow__char_class___range__9_10_range__12_13_range__32_32_not_follow__lit___47_47_not_follow__lit___47_42_);
  }
  public void ArrayType() {
    
    
    // prod(label("Name1",sort("ArrayType")),[sort("Name"),layouts("LAYOUTLIST"),lit("["),layouts("LAYOUTLIST"),lit("]")],{})
    expect(ArrayType.prod__Name1_ArrayType__Name_layouts_LAYOUTLIST_lit___91_layouts_LAYOUTLIST_lit___93_);
    // prod(label("PrimitiveType1",sort("ArrayType")),[sort("PrimitiveType"),layouts("LAYOUTLIST"),lit("["),layouts("LAYOUTLIST"),lit("]")],{})
    expect(ArrayType.prod__PrimitiveType1_ArrayType__PrimitiveType_layouts_LAYOUTLIST_lit___91_layouts_LAYOUTLIST_lit___93_);
    // prod(label("ArrayType1",sort("ArrayType")),[sort("ArrayType"),layouts("LAYOUTLIST"),lit("["),layouts("LAYOUTLIST"),lit("]")],{})
    expect(ArrayType.prod__ArrayType1_ArrayType__ArrayType_layouts_LAYOUTLIST_lit___91_layouts_LAYOUTLIST_lit___93_);
  }
  public void IdentifierKeywords() {
    
    
    // prod(keywords("IdentifierKeywords"),[conditional(lit("while"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(IdentifierKeywords.prod__IdentifierKeywords__conditional__lit_while__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(keywords("IdentifierKeywords"),[conditional(lit("case"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(IdentifierKeywords.prod__IdentifierKeywords__conditional__lit_case__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(keywords("IdentifierKeywords"),[conditional(lit("char"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(IdentifierKeywords.prod__IdentifierKeywords__conditional__lit_char__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(keywords("IdentifierKeywords"),[conditional(lit("import"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(IdentifierKeywords.prod__IdentifierKeywords__conditional__lit_import__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(keywords("IdentifierKeywords"),[conditional(lit("protected"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(IdentifierKeywords.prod__IdentifierKeywords__conditional__lit_protected__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(keywords("IdentifierKeywords"),[conditional(lit("double"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(IdentifierKeywords.prod__IdentifierKeywords__conditional__lit_double__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(keywords("IdentifierKeywords"),[conditional(lit("public"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(IdentifierKeywords.prod__IdentifierKeywords__conditional__lit_public__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(keywords("IdentifierKeywords"),[conditional(lit("float"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(IdentifierKeywords.prod__IdentifierKeywords__conditional__lit_float__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(keywords("IdentifierKeywords"),[conditional(lit("transient"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(IdentifierKeywords.prod__IdentifierKeywords__conditional__lit_transient__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(keywords("IdentifierKeywords"),[conditional(lit("instanceof"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(IdentifierKeywords.prod__IdentifierKeywords__conditional__lit_instanceof__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(keywords("IdentifierKeywords"),[conditional(lit("false"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(IdentifierKeywords.prod__IdentifierKeywords__conditional__lit_false__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(keywords("IdentifierKeywords"),[conditional(lit("byte"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(IdentifierKeywords.prod__IdentifierKeywords__conditional__lit_byte__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(keywords("IdentifierKeywords"),[conditional(lit("final"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(IdentifierKeywords.prod__IdentifierKeywords__conditional__lit_final__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(keywords("IdentifierKeywords"),[conditional(lit("class"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(IdentifierKeywords.prod__IdentifierKeywords__conditional__lit_class__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(keywords("IdentifierKeywords"),[conditional(lit("try"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(IdentifierKeywords.prod__IdentifierKeywords__conditional__lit_try__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(keywords("IdentifierKeywords"),[conditional(lit("new"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(IdentifierKeywords.prod__IdentifierKeywords__conditional__lit_new__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(keywords("IdentifierKeywords"),[conditional(lit("finally"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(IdentifierKeywords.prod__IdentifierKeywords__conditional__lit_finally__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(keywords("IdentifierKeywords"),[conditional(lit("void"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(IdentifierKeywords.prod__IdentifierKeywords__conditional__lit_void__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(keywords("IdentifierKeywords"),[conditional(lit("abstract"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(IdentifierKeywords.prod__IdentifierKeywords__conditional__lit_abstract__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(keywords("IdentifierKeywords"),[conditional(lit("native"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(IdentifierKeywords.prod__IdentifierKeywords__conditional__lit_native__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(keywords("IdentifierKeywords"),[conditional(lit("break"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(IdentifierKeywords.prod__IdentifierKeywords__conditional__lit_break__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(keywords("IdentifierKeywords"),[conditional(lit("switch"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(IdentifierKeywords.prod__IdentifierKeywords__conditional__lit_switch__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(keywords("IdentifierKeywords"),[conditional(lit("super"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(IdentifierKeywords.prod__IdentifierKeywords__conditional__lit_super__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(keywords("IdentifierKeywords"),[conditional(lit("implements"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(IdentifierKeywords.prod__IdentifierKeywords__conditional__lit_implements__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(keywords("IdentifierKeywords"),[conditional(lit("int"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(IdentifierKeywords.prod__IdentifierKeywords__conditional__lit_int__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(keywords("IdentifierKeywords"),[conditional(lit("static"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(IdentifierKeywords.prod__IdentifierKeywords__conditional__lit_static__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(keywords("IdentifierKeywords"),[conditional(lit("long"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(IdentifierKeywords.prod__IdentifierKeywords__conditional__lit_long__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(keywords("IdentifierKeywords"),[conditional(lit("throws"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(IdentifierKeywords.prod__IdentifierKeywords__conditional__lit_throws__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(keywords("IdentifierKeywords"),[conditional(lit("default"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(IdentifierKeywords.prod__IdentifierKeywords__conditional__lit_default__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(keywords("IdentifierKeywords"),[conditional(lit("catch"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(IdentifierKeywords.prod__IdentifierKeywords__conditional__lit_catch__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(keywords("IdentifierKeywords"),[conditional(lit("this"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(IdentifierKeywords.prod__IdentifierKeywords__conditional__lit_this__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(keywords("IdentifierKeywords"),[conditional(lit("throw"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(IdentifierKeywords.prod__IdentifierKeywords__conditional__lit_throw__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(keywords("IdentifierKeywords"),[conditional(lit("interface"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(IdentifierKeywords.prod__IdentifierKeywords__conditional__lit_interface__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(keywords("IdentifierKeywords"),[conditional(lit("return"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(IdentifierKeywords.prod__IdentifierKeywords__conditional__lit_return__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(keywords("IdentifierKeywords"),[conditional(lit("else"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(IdentifierKeywords.prod__IdentifierKeywords__conditional__lit_else__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(keywords("IdentifierKeywords"),[conditional(lit("synchronized"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(IdentifierKeywords.prod__IdentifierKeywords__conditional__lit_synchronized__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(keywords("IdentifierKeywords"),[conditional(lit("if"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(IdentifierKeywords.prod__IdentifierKeywords__conditional__lit_if__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(keywords("IdentifierKeywords"),[conditional(lit("volatile"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(IdentifierKeywords.prod__IdentifierKeywords__conditional__lit_volatile__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(keywords("IdentifierKeywords"),[conditional(lit("null"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(IdentifierKeywords.prod__IdentifierKeywords__conditional__lit_null__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(keywords("IdentifierKeywords"),[conditional(lit("private"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(IdentifierKeywords.prod__IdentifierKeywords__conditional__lit_private__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(keywords("IdentifierKeywords"),[conditional(lit("true"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(IdentifierKeywords.prod__IdentifierKeywords__conditional__lit_true__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(keywords("IdentifierKeywords"),[conditional(lit("boolean"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(IdentifierKeywords.prod__IdentifierKeywords__conditional__lit_boolean__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(keywords("IdentifierKeywords"),[conditional(lit("short"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(IdentifierKeywords.prod__IdentifierKeywords__conditional__lit_short__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(keywords("IdentifierKeywords"),[conditional(lit("package"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(IdentifierKeywords.prod__IdentifierKeywords__conditional__lit_package__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(keywords("IdentifierKeywords"),[conditional(lit("continue"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(IdentifierKeywords.prod__IdentifierKeywords__conditional__lit_continue__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(keywords("IdentifierKeywords"),[conditional(lit("do"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(IdentifierKeywords.prod__IdentifierKeywords__conditional__lit_do__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(keywords("IdentifierKeywords"),[conditional(lit("extends"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(IdentifierKeywords.prod__IdentifierKeywords__conditional__lit_extends__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(keywords("IdentifierKeywords"),[conditional(lit("for"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(IdentifierKeywords.prod__IdentifierKeywords__conditional__lit_for__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
  }
  public void StringCharacter() {
    
    
    // prod(lex("StringCharacter"),[lex("UnicodeEscape")],{})
    expect(StringCharacter.prod__StringCharacter__UnicodeEscape_);
    // prod(lex("StringCharacter"),[lex("EscapeSequence")],{})
    expect(StringCharacter.prod__StringCharacter__EscapeSequence_);
    // prod(lex("StringCharacter"),[\char-class([range(0,33),range(35,91),range(93,65535)])],{})
    expect(StringCharacter.prod__StringCharacter__char_class___range__0_33_range__35_91_range__93_65535_);
  }
  public void ClassBody() {
    
    
    // prod(label("ClassBodyDeclaration-s",sort("ClassBody")),[lit("{"),layouts("LAYOUTLIST"),\iter-star-seps(sort("ClassBodyDeclaration"),[layouts("LAYOUTLIST")]),layouts("LAYOUTLIST"),lit("}")],{})
    expect(ClassBody.prod__ClassBodyDeclaration_s_ClassBody__lit___123_layouts_LAYOUTLIST_iter_star_seps__ClassBodyDeclaration__layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___125_);
  }
  public void start__ANTLR() {
    
    
    // prod(start(sort("ANTLR")),[layouts("LAYOUTLIST"),label("top",sort("ANTLR")),layouts("LAYOUTLIST")],{})
    expect(start__ANTLR.prod__start__ANTLR__layouts_LAYOUTLIST_top_ANTLR_layouts_LAYOUTLIST_);
  }
  public void IntegralType() {
    
    
    // prod(label("int",sort("IntegralType")),[conditional(lit("int"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(IntegralType.prod__int_IntegralType__conditional__lit_int__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(label("byte",sort("IntegralType")),[conditional(lit("byte"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(IntegralType.prod__byte_IntegralType__conditional__lit_byte__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(label("short",sort("IntegralType")),[conditional(lit("short"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(IntegralType.prod__short_IntegralType__conditional__lit_short__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(label("long",sort("IntegralType")),[conditional(lit("long"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(IntegralType.prod__long_IntegralType__conditional__lit_long__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(label("char",sort("IntegralType")),[conditional(lit("char"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(IntegralType.prod__char_IntegralType__conditional__lit_char__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
  }
  public void LAYOUT() {
    
    
    // prod(sort("LAYOUT"),[lex("Comment")],{})
    expect(LAYOUT.prod__LAYOUT__Comment_);
    // prod(sort("LAYOUT"),[\char-class([range(9,10),range(13,13),range(32,32)])],{})
    expect(LAYOUT.prod__LAYOUT__char_class___range__9_10_range__13_13_range__32_32_);
  }
  public void StatementNoShortIf() {
    
    
    // prod(label("IfThenElseStatementNoShortIf",sort("StatementNoShortIf")),[sort("IfThenElseStatementNoShortIf")],{})
    expect(StatementNoShortIf.prod__IfThenElseStatementNoShortIf_StatementNoShortIf__IfThenElseStatementNoShortIf_);
    // prod(label("StatementWithoutTrailingSubstatement1",sort("StatementNoShortIf")),[sort("StatementWithoutTrailingSubstatement")],{})
    expect(StatementNoShortIf.prod__StatementWithoutTrailingSubstatement1_StatementNoShortIf__StatementWithoutTrailingSubstatement_);
    // prod(label("WhileStatementNoShortIf",sort("StatementNoShortIf")),[sort("WhileStatementNoShortIf")],{})
    expect(StatementNoShortIf.prod__WhileStatementNoShortIf_StatementNoShortIf__WhileStatementNoShortIf_);
    // prod(label("LabeledStatementNoShortIf",sort("StatementNoShortIf")),[sort("LabeledStatementNoShortIf")],{})
    expect(StatementNoShortIf.prod__LabeledStatementNoShortIf_StatementNoShortIf__LabeledStatementNoShortIf_);
    // prod(label("ForStatementNoShortIf",sort("StatementNoShortIf")),[sort("ForStatementNoShortIf")],{})
    expect(StatementNoShortIf.prod__ForStatementNoShortIf_StatementNoShortIf__ForStatementNoShortIf_);
  }
  public void StatementExpression() {
    
    
    // prod(label("MethodInvocation",sort("StatementExpression")),[sort("MethodInvocation")],{})
    expect(StatementExpression.prod__MethodInvocation_StatementExpression__MethodInvocation_);
    // prod(label("incr21",sort("StatementExpression")),[sort("Expression"),layouts("LAYOUTLIST"),lit("++")],{tag(NotSupported("prefer"))})
    expect(StatementExpression.prod__incr21_StatementExpression__Expression_layouts_LAYOUTLIST_lit___43_43__tag__NotSupported___112_114_101_102_101_114);
    // prod(label("decr21",sort("StatementExpression")),[sort("Expression"),layouts("LAYOUTLIST"),lit("--")],{tag(NotSupported("prefer"))})
    expect(StatementExpression.prod__decr21_StatementExpression__Expression_layouts_LAYOUTLIST_lit_____tag__NotSupported___112_114_101_102_101_114);
    // prod(label("Assignment",sort("StatementExpression")),[sort("Assignment")],{})
    expect(StatementExpression.prod__Assignment_StatementExpression__Assignment_);
    // prod(label("ClassInstanceCreationExpression",sort("StatementExpression")),[sort("ClassInstanceCreationExpression")],{})
    expect(StatementExpression.prod__ClassInstanceCreationExpression_StatementExpression__ClassInstanceCreationExpression_);
    // prod(label("incr31",sort("StatementExpression")),[lit("++"),layouts("LAYOUTLIST"),sort("Expression")],{tag(NotSupported("prefer"))})
    expect(StatementExpression.prod__incr31_StatementExpression__lit___43_43_layouts_LAYOUTLIST_Expression__tag__NotSupported___112_114_101_102_101_114);
    // prod(label("decr31",sort("StatementExpression")),[lit("--"),layouts("LAYOUTLIST"),sort("Expression")],{tag(NotSupported("prefer"))})
    expect(StatementExpression.prod__decr31_StatementExpression__lit____layouts_LAYOUTLIST_Expression__tag__NotSupported___112_114_101_102_101_114);
  }
  public void layouts_$QUOTES() {
    
    
    // prod(layouts("$QUOTES"),[conditional(\iter-star(\char-class([range(9,10),range(13,13),range(32,32)])),{\not-follow(\char-class([range(9,10),range(13,13),range(32,32)]))})],{})
    expect(layouts_$QUOTES.prod__layouts_$QUOTES__conditional__iter_star__char_class___range__9_10_range__13_13_range__32_32__not_follow__char_class___range__9_10_range__13_13_range__32_32_);
  }
  public void ConstructorDeclaration() {
    
    
    // prod(label("Modifier-s-ConstructorDeclarator-Throws-opt-ConstructorBody",sort("ConstructorDeclaration")),[\iter-star-seps(sort("Modifier"),[layouts("LAYOUTLIST")]),layouts("LAYOUTLIST"),sort("ConstructorDeclarator"),layouts("LAYOUTLIST"),opt(sort("Throws")),layouts("LAYOUTLIST"),sort("ConstructorBody")],{})
    expect(ConstructorDeclaration.prod__Modifier_s_ConstructorDeclarator_Throws_opt_ConstructorBody_ConstructorDeclaration__iter_star_seps__Modifier__layouts_LAYOUTLIST_layouts_LAYOUTLIST_ConstructorDeclarator_layouts_LAYOUTLIST_opt__Throws_layouts_LAYOUTLIST_ConstructorBody_);
  }
  public void Statement() {
    
    
    // prod(label("ForStatement",sort("Statement")),[sort("ForStatement")],{})
    expect(Statement.prod__ForStatement_Statement__ForStatement_);
    // prod(label("IfThenElseStatement",sort("Statement")),[sort("IfThenElseStatement")],{})
    expect(Statement.prod__IfThenElseStatement_Statement__IfThenElseStatement_);
    // prod(label("WhileStatement",sort("Statement")),[sort("WhileStatement")],{})
    expect(Statement.prod__WhileStatement_Statement__WhileStatement_);
    // prod(label("ClassDeclaration",sort("Statement")),[sort("ClassDeclaration")],{})
    expect(Statement.prod__ClassDeclaration_Statement__ClassDeclaration_);
    // prod(label("IfThenStatement",sort("Statement")),[sort("IfThenStatement")],{})
    expect(Statement.prod__IfThenStatement_Statement__IfThenStatement_);
    // prod(label("StatementWithoutTrailingSubstatement",sort("Statement")),[sort("StatementWithoutTrailingSubstatement")],{})
    expect(Statement.prod__StatementWithoutTrailingSubstatement_Statement__StatementWithoutTrailingSubstatement_);
    // prod(label("LabeledStatement",sort("Statement")),[sort("LabeledStatement")],{})
    expect(Statement.prod__LabeledStatement_Statement__LabeledStatement_);
    // prod(label("AssertStatement",sort("Statement")),[sort("AssertStatement")],{})
    expect(Statement.prod__AssertStatement_Statement__AssertStatement_);
  }
  public void SingleCharacter() {
    
    
    // prod(lex("SingleCharacter"),[\char-class([range(0,38),range(40,91),range(93,65535)])],{})
    expect(SingleCharacter.prod__SingleCharacter__char_class___range__0_38_range__40_91_range__93_65535_);
    // prod(lex("SingleCharacter"),[lex("UnicodeEscape")],{})
    expect(SingleCharacter.prod__SingleCharacter__UnicodeEscape_);
  }
  public void ThrowStatement() {
    
    
    // prod(label("throw-semicolon",sort("ThrowStatement")),[conditional(lit("throw"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts("LAYOUTLIST"),sort("Expression"),layouts("LAYOUTLIST"),lit(";")],{})
    expect(ThrowStatement.prod__throw_semicolon_ThrowStatement__conditional__lit_throw__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___59_);
  }
  public void BreakStatement() {
    
    
    // prod(label("break-semicolon",sort("BreakStatement")),[conditional(lit("break"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts("LAYOUTLIST"),opt(lex("Identifier")),layouts("LAYOUTLIST"),lit(";")],{})
    expect(BreakStatement.prod__break_semicolon_BreakStatement__conditional__lit_break__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_opt__Identifier_layouts_LAYOUTLIST_lit___59_);
  }
  public void start__CompilationUnit() {
    
    
    // prod(start(sort("CompilationUnit")),[layouts("LAYOUTLIST"),label("top",sort("CompilationUnit")),layouts("LAYOUTLIST")],{})
    expect(start__CompilationUnit.prod__start__CompilationUnit__layouts_LAYOUTLIST_top_CompilationUnit_layouts_LAYOUTLIST_);
  }
  public void WhileStatement() {
    
    
    // prod(label("while",sort("WhileStatement")),[conditional(lit("while"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts("LAYOUTLIST"),lit("("),layouts("LAYOUTLIST"),sort("Expression"),layouts("LAYOUTLIST"),lit(")"),layouts("LAYOUTLIST"),sort("Statement")],{})
    expect(WhileStatement.prod__while_WhileStatement__conditional__lit_while__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_Statement_);
  }
  public void IfThenElseStatement() {
    
    
    // prod(label("if-else",sort("IfThenElseStatement")),[conditional(lit("if"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts("LAYOUTLIST"),lit("("),layouts("LAYOUTLIST"),sort("Expression"),layouts("LAYOUTLIST"),lit(")"),layouts("LAYOUTLIST"),sort("StatementNoShortIf"),layouts("LAYOUTLIST"),conditional(lit("else"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts("LAYOUTLIST"),sort("Statement")],{})
    expect(IfThenElseStatement.prod__if_else_IfThenElseStatement__conditional__lit_if__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_lit___40_layouts_LAYOUTLIST_Expression_layouts_LAYOUTLIST_lit___41_layouts_LAYOUTLIST_StatementNoShortIf_layouts_LAYOUTLIST_conditional__lit_else__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Statement_);
  }
  public void Type() {
    
    
    // prod(sort("Type"),[lex("Identifier"),layouts("LAYOUTLIST"),lit("\<"),layouts("LAYOUTLIST"),\iter-seps(sort("Type"),[layouts("LAYOUTLIST"),lit(","),layouts("LAYOUTLIST")]),layouts("LAYOUTLIST"),lit("\>")],{})
    expect(Type.prod__Type__Identifier_layouts_LAYOUTLIST_lit___60_layouts_LAYOUTLIST_iter_seps__Type__layouts_LAYOUTLIST_lit___44_layouts_LAYOUTLIST_layouts_LAYOUTLIST_lit___62_);
    // prod(label("PrimitiveType",sort("Type")),[sort("PrimitiveType")],{})
    expect(Type.prod__PrimitiveType_Type__PrimitiveType_);
    // prod(label("ReferenceType",sort("Type")),[sort("ReferenceType")],{})
    expect(Type.prod__ReferenceType_Type__ReferenceType_);
  }
  public void Super() {
    
    
    // prod(label("extends",sort("Super")),[conditional(lit("extends"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts("LAYOUTLIST"),sort("ClassType")],{})
    expect(Super.prod__extends_Super__conditional__lit_extends__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_ClassType_);
  }
  public void ForInit() {
    
    
    // prod(label("LocalVariableDeclaration",sort("ForInit")),[sort("LocalVariableDeclaration")],{})
    expect(ForInit.prod__LocalVariableDeclaration_ForInit__LocalVariableDeclaration_);
    // prod(label("StatementExpressionList",sort("ForInit")),[sort("StatementExpressionList")],{})
    expect(ForInit.prod__StatementExpressionList_ForInit__StatementExpressionList_);
  }
  public void FloatingPointType() {
    
    
    // prod(label("float",sort("FloatingPointType")),[conditional(lit("float"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(FloatingPointType.prod__float_FloatingPointType__conditional__lit_float__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(label("double",sort("FloatingPointType")),[conditional(lit("double"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(FloatingPointType.prod__double_FloatingPointType__conditional__lit_double__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
  }
  public void Finally() {
    
    
    // prod(label("finally",sort("Finally")),[conditional(lit("finally"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts("LAYOUTLIST"),sort("Block")],{})
    expect(Finally.prod__finally_Finally__conditional__lit_finally__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Block_);
  }
  public void BooleanLiteral() {
    
    
    // prod(lex("BooleanLiteral"),[conditional(lit("true"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(BooleanLiteral.prod__BooleanLiteral__conditional__lit_true__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
    // prod(lex("BooleanLiteral"),[conditional(lit("false"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))})],{})
    expect(BooleanLiteral.prod__BooleanLiteral__conditional__lit_false__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_);
  }
  public void TokenDef() {
    
    
    // prod(sort("TokenDef"),[lex("Identifier"),layouts("LAYOUTLIST"),lex("Identifier")],{})
    expect(TokenDef.prod__TokenDef__Identifier_layouts_LAYOUTLIST_Identifier_);
  }
  public void EscapeSequence() {
    
    
    // prod(lex("EscapeSequence"),[lit("\\"),\char-class([range(48,51)]),\char-class([range(48,55)]),\char-class([range(48,55)])],{})
    expect(EscapeSequence.prod__EscapeSequence__lit___92_char_class___range__48_51_char_class___range__48_55_char_class___range__48_55_);
    // prod(lex("EscapeSequence"),[lit("\\"),\char-class([range(48,55)])],{})
    expect(EscapeSequence.prod__EscapeSequence__lit___92_char_class___range__48_55_);
    // prod(lex("EscapeSequence"),[lit("\\"),\char-class([range(34,34),range(39,39),range(92,92),range(98,98),range(102,102),range(110,110),range(114,114),range(116,116)])],{})
    expect(EscapeSequence.prod__EscapeSequence__lit___92_char_class___range__34_34_range__39_39_range__92_92_range__98_98_range__102_102_range__110_110_range__114_114_range__116_116_);
    // prod(lex("EscapeSequence"),[lit("\\"),\char-class([range(48,55)]),\char-class([range(48,55)])],{})
    expect(EscapeSequence.prod__EscapeSequence__lit___92_char_class___range__48_55_char_class___range__48_55_);
  }
  public void UnicodeEscape() {
    
    
    // prod(lex("UnicodeEscape"),[lit("\\"),iter(\char-class([range(117,117)])),\char-class([range(48,57),range(65,70),range(97,102)]),\char-class([range(48,57),range(65,70),range(97,102)]),\char-class([range(48,57),range(65,70),range(97,102)]),\char-class([range(48,57),range(65,70),range(97,102)])],{})
    expect(UnicodeEscape.prod__UnicodeEscape__lit___92_iter__char_class___range__117_117_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_);
  }
  public void StaticInitializer() {
    
    
    // prod(label("static1",sort("StaticInitializer")),[conditional(lit("static"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts("LAYOUTLIST"),sort("Block")],{})
    expect(StaticInitializer.prod__static1_StaticInitializer__conditional__lit_static__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Block_);
  }
  public void OctalIntegerLiteral() {
    
    
    // prod(lex("OctalIntegerLiteral"),[\char-class([range(48,48)]),iter(\char-class([range(48,55)]))],{})
    expect(OctalIntegerLiteral.prod__OctalIntegerLiteral__char_class___range__48_48_iter__char_class___range__48_55_);
  }
  public void PackageDeclaration() {
    
    
    // prod(label("package-semicolon",sort("PackageDeclaration")),[conditional(lit("package"),{\not-follow(\char-class([range(48,57),range(65,90),range(95,95),range(97,122)]))}),layouts("LAYOUTLIST"),sort("Name"),layouts("LAYOUTLIST"),lit(";")],{})
    expect(PackageDeclaration.prod__package_semicolon_PackageDeclaration__conditional__lit_package__not_follow__char_class___range__48_57_range__65_90_range__95_95_range__97_122_layouts_LAYOUTLIST_Name_layouts_LAYOUTLIST_lit___59_);
  }
  public void SimpleName() {
    
    
    // prod(label("Identifier",sort("SimpleName")),[conditional(lex("Identifier"),{delete(conditional(keywords("IdentifierKeywords"),{\not-follow(\char-class([range(36,36),range(48,57),range(65,90),range(95,95),range(97,122)]))}))})],{})
    expect(SimpleName.prod__Identifier_SimpleName__conditional__Identifier__delete__conditional__IdentifierKeywords__not_follow__char_class___range__36_36_range__48_57_range__65_90_range__95_95_range__97_122_);
  }
  public void Asterisk() {
    
    
    // prod(lex("Asterisk"),[\char-class([range(42,42)])],{})
    expect(Asterisk.prod__Asterisk__char_class___range__42_42_);
  }
}