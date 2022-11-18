import SwiftUI
import shared

struct ContentView: View {
	let greet = Greeting().greeting()
    
	var body: some View {
		Text(greet)
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
    
    func test() async {
        /*Suspending().testReturnsSealedResult { (result: SealedInterfaceResult?, e: Error?) in
            switch result {
            case SomeDataClass: print(result)
            }
        }*/

        Suspending()
        
        /*Suspending().testReturnsSomeEnum { (result: SomeEnum?, e: Error?) in
            switch result {
            case .some(.firstValue): print(result!)
                break
            case .none: print("was none")
                break
            default: print("was default")
                break
            }
        }*/
    }
}
